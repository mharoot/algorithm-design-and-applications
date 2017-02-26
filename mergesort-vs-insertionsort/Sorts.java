/**
 * 
 * @author michael harootoonyan
 * @date   February 28, 2016
 * @project #1
 *
 */

public class Sorts {
	
   private static int INFINITY = 10000000;
/*--------------Insertion Sort -----------------------*/
   public static long insertionsort( int[] a)
   {
	long comparisonsCount = 0;
	for (int j = 1; j < a.length; j++) {
		int key = a[j];
		int i = j - 1;
		
		while (i > -1 && a[i] > key) {
			comparisonsCount++; // checking loop condition when true
			a[i+1] = a[i];
			i = i - 1;
		}
		comparisonsCount++; // checking loop condition when false
		a[i+1] = key; 
	}
	return comparisonsCount;
   
   }



/* --------------------Merge Sort --------------------*/
  //merges sorted slices a[i.. j] and a[j + 1 …  k] for 0<=  i <=j < k < a.length

   public static long merge ( int[] a,  int i, int m , int k)
   {
	   long comparisonsCount = 0;
	   int nL = m - i + 1;
	   int nR = k - m;
	   int[] L = new int [nL+1];
	   int[] R = new int [nR+1];
	   L[nL] = INFINITY;
	   R[nR] = INFINITY;
	   
	   // divide left hand side from 
	   for (int  l = 0; l < nL; l++) {
		   comparisonsCount++;
		   L[l] = a[l+i];
	   }
	   
	   // divide right hand side from
	   for (int  r = 0; r < nR; r++) {
		   comparisonsCount++;
		   R[r] = a[r+m+1];
	   }
	   
	   // merge left and right side in sorted order
	   int l = 0, r = 0;
	   for (int j = i; j <= k; j++) {
		   if (L[l] <= R[r]) {
			   comparisonsCount++;// if true
			   a[j] = L[l];
			   l++;
		   } else {
			   comparisonsCount++;// if false
			   a[j] = R[r];
			   r++;
		   }
	   }

	   
	   return comparisonsCount;
   }


   //sorts  a[ i .. k]  for 0<=i <= k < a.length
   private  static  long mergesort(int[] a,  int i ,  int k)
   {
	   int comparisonsCount = 0;
	   if( i < k) {
		   comparisonsCount++; // if true
		  int m = (i+k)/2;
		  comparisonsCount += mergesort(a,i,m);
		  comparisonsCount += mergesort(a,m+1,k);
		  comparisonsCount += merge(a,i,m,k);
	   }
	   comparisonsCount++; // if false
	   return comparisonsCount;
   }


    //Sorts the array using mergesort 
   public static  long mergesort(int[] a )
   {
	   return mergesort(a, 0, a.length - 1);   
   }


   public static boolean isSorted( int[] a)
   {
	   boolean sorted = false;
	   int n = a.length;
	   if (n == 1)
		   return true;
	   else if (n > 1) 
	   {
			for (int j = 0; j < n - 1; j++) {
				int key = a[j];
				int i = j + 1;
				
				if (a[i] >= key) {
					sorted = true;
				} else {
					return false;
				}
			}
	   }
	return sorted;
   }  



}
