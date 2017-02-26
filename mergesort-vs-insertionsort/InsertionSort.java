/**
 * 
 * @author michael
 ******************************************************************************
 *
 * @report Loop invariants and the correctness of insertion sort
 * 
 * At the beginning of each iteration of the "outer" for loop, which is indexed
 * by j, indicates the "key value" to be inserted into the left hand side
 * of the sorted portion of the array which is the sub-array consisting of 
 * elements A[1..j-1].  
 * 
 * A loop invariant is a condition [among program variables] that is necessarily
 * true immediately before and immediately after each iteration of a loop.
 * We use loop invariants to help us understand why an algorithm is correct.  We 
 * must show three things about a loop invariant:
 * 
 * 
 * 	Initialization: It is true prior to the first iteration of the loop.
 * 
 * 	Maintenance:    If it is true before an iteration of the loop, it remains 
 * 					true before the next iteration.
 * 
 * 	Termination:	When the loop terminates, the invariant gives us a useful 
 * 					property that helps show that the algorithm is correct.
 * 
 * 
 * 	When the first two properties hold, the loop invariant is true prior to every
 *  iteration of the loop.  Note this similarity to mathematical induction, where 
 *  you prove a base case and an inductive step.  Here, showing that the invariant 
 *  holds before the first iteration is like the base case, and showing that the 
 *  invariant holds from iteration to iteration is like the inductive step.
 * 
 * 	The third property is most important, since we are using the loop invariant
 * 	to show correctness.  It also differers from the usual use of mathematical 
 *  induction, in which the inductive step is used infinitely; here, we stop the
 *  "induction" when the loop terminates.
 *  
 *  Let us see how these properties hold for insertion sort.
 *  
 * 	Initialization: We start by showing that the loop invariant holds before the
 * 		first loop iteration, when j = 2.  The sub-array A[1.. j-1], therefore,
 * 		consists of just the single element A[1], which is in fact the original
 * 		element in A[1].  Moreover, this sub-array is sorted (trivially, of course),
 * 		which shows that the loop invariant holds prior to the first iteration of the loop.
 * 
 * 	Maintenance: Next, we tackle the second property: showing that each iteration maintains
 * 		the loop invariant.  Informally, the body of the outer for loop works by moving A[j-1],
 * 		A[j-2], A[j-3], and so on by one position to the right until the proper position for A[j]
 * 		is inserted.  At this point however, we prefer not to get bogged down in such formalism,
 * 		and so we rely on our informal analysis to show that the second property holds
 * 		for the outer loop.
 * 
 * 	Termination: Finally, we examine what happens when the loop terminates.  For insertion sort,
 * 		the outer for loop ends when j exceeds n, i.e., when j = n + 1.  Substituting n + 1 for j
 * 		in the wording of loop invariant, we have that the sub-array A[1..n] consists of the 
 * 		elements originally in A[1..n], but in sorted order.  But the sub-array A[1..n] is the
 * 		entire array!  Hence, the entire array is sorted, which means the algorithm is correct.
 * 
 ******************************************************************************
 *	@Analysis of insertion sort
 *
 *Insertion sort can take different amounts of time to sort two input sequences
 *of the same size depending on how nearly sorted they already are. 
 *
 *
 *Best case is having a array of size n in ascending order:
 *	Suppose that the key value being inserted is greater than every element in
 *	the sub-array to its left.  This means that no elements need to slide
 *	over if the key being inserted is greater than every element to its left.
 *	Therefore, the total time spent inserting into the sorted sub-array is:
 *
 *	c*(n-1) which is big-theta(n)
 *
 *Average best case is having an array of size n that is "almost sorted":
 *	Suppose every element starts out at most some constant number of positions
 * 	from where it's supposed to be when sorted.  Then each insert takes at most
 *  takes the number of positions, say p, elements, and the time for the inner
 *  loop to complete on a sub-array of k elements would be at most p*c.  Over
 *  all n - 1 cycles in the inner loop, would give a running time of:
 *  
 *  p*c*(n - 1) which is big-theta(n)
 *
 *
 *Average worst case is having an array of size n that is in random order:
 * Suppose that, on average we'd expect that each element is less than half the
 * elements to its left.  In this case, on average, the inner loop on a sub-array
 * of k elements would slide k/2 of them.  The running time would be half of the
 * worst-case running time:
 * 
 * big-theta(n^2).
 *	
 *
 *
 *Worst case is having an array of size n in descending order:
 *	Suppose that the key value being inserted is less than every element in the
 * 	sub-array to its left.  This means that every element to its left needs to
 * 	slide over since the key being inserted is less than every element to its left.
 * 	Therefore, the total time spent inserting into the 
 *  sorted sub-array is:
 *  
 *  c*1 + c * 2 + c * 3 + ... + c * (n-1) = c * (1 + 2 + 3 + ... + (n-1))
 *  
 *	That sum is an arithmetic series, except that it goes up to n-1 rather than n. 
 *	Using our formula for arithmetic series, we get that the total time spent 
 *	inserting into the sorted sub-array is:
 *
 *	c* (n - 1 + 1)( (n - 1)/2 ) = (cn^2- cn)/2
 *
 *	big-theta(n^2) since best and worst case.
 */
public class InsertionSort {

	
	public static void print(int[] A) {
		System.out.print("[");
		for (int i = 0; i < A.length - 1; i++) {
			System.out.print(A[i]+", ");
		}
		System.out.println(A[A.length-1]+"]");
	}
	
	
	/**
	 * The input numbers are sorted in place: the numbers are rearranged within
	 * the array A, with at most a constant number of them stored outside the
	 * array at any time.  The input array A contains the sorted output sequence
	 * when insertionSort is finished.
	 * 
	 * @param A an array of n elements
	 */
	public static void insertionSort(int[] A) {
		for (int j = 1; j < A.length; j++) {
			int key = A[j]; // The key contains the value taken from A[j] in 
							// the outer loop.
			
			int i = j - 1; // Length of the left hand side of the array that 
						   // contains the already sorted portion of the array.
			
			while (i > -1 && A[i] > key) {
			/* One by one the key is compared to the already sorted left hand 
			 * side of the array.  If the key is less than one of the elements
			 * in the sorted portion of the array shift that element up where
			 * the key was initially the first time.  It does this in this 
			 * manner until the condition in the while loop is not held.
			*/	A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key; //an adjustment is made to place the key since the inner loop
						  // decrements until a position is found where the key isn't smaller.
			
			
		}
	}
	
/*	public static void main(String[] args) {
		int [] singleA 			 = {1};				   //
		int [] A 				 = {5, 2, 4, 6, 1, 3};
		int [] averageWorstCaseA = {1, 2, 4, 6, 5, 4}; // random half sorted half not big-theta(n^2);
		int [] averageBestCaseA  = {1, 2, 3, 6, 4, 5}; // almost sorted big-theta(n)
		int [] bestCaseA 		 = {1, 2, 3, 4, 5, 6}; // big-theta(n)
		int [] worstCaseA		 = {6, 5, 4, 3, 2, 1}; // big-theta(n^2)
		
		//print(A);
		insertionSort(singleA);
		//print(A);


	}
*/

}
