import java.util.Random;

public class main {


    /**
     * -----------------------------------------------------------------------------
     * Maximum Subarray Problem:
     *
     * Let A[1..n] be an array of integers. The maximum subarray problem consists of
     * finding the subarray A[i..j] for 1<=i <=j <= n that maximizes the sum of the
     * elements from index i to index j.
     * -----------------------------------------------------------------------------
     *
     *
     **/
    static int INT_MIN = Integer.MIN_VALUE;

    /* max sub snapshot properties */
    static int theI = 0; // starting point of an array inclusive
    static int theJ = 0; // ending point of an array exclusive
    static int theMax = INT_MIN; // the maximum sub array value


    /**
     * @task A utility funtion to find maximum of two integers
     */
    static int max(int a, int b) { return (a > b)? a : b; }

    /**
     *
     * @task A utility funtion to find maximum of three integers
     */
    static int max(int a, int b, int c) { return max(max(a, b), c); }

    /**
     * @task Find the maximum possible sum in arr[] including arr[m]
     * @param arr an array of positive and negative integers
     * @param l starting point of the left hand side of the array
     * @param m midpoint of the array
     * @param h ending point of the right hand side of the array
     * @return sum of elements on left and right of mid
     */
    static int maxCrossingSum(int arr[], int l, int m, int h)
    {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = INT_MIN;
        for (int i = m; i >= l; i--)
        {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = INT_MIN;
        for (int i = m+1; i <= h; i++)
        {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        return left_sum + right_sum;
    }

    /**
     * @task  a.) Implement a divide and conquer solution to the Maximum
     * Subarray Problem. This should be an O(n log(n))  algorithm.  Hint: Recall
     * the crossing array example done in class.
     *
     * @param A and array of positive and negative integers
     * @param l starting point inclusive
     * @param h ending point exclusive
     *
     * @return maximum of following three possible cases
    1.) Maximum subarray sum in left half
    2.) Maximum subarray sum in right half
    3.) Maximum subarray sum such that the subarray crosses the midpoint
     */
    static int maxSubFast(int arr[], int l, int h)
    {
        // Base Case: Only one element
        if (l == h)
            return arr[l];

        // Find middle point
        int m = (l + h)/2;

        return max(maxSubFast(arr, l, m),
                maxSubFast(arr, m+1, h),
                maxCrossingSum(arr, l, m, h));
    }

    /**
     * @task  b.) Implement the slow algorithm that simply computes the sums of
     * all of the subarrays , A[i..j], stores them and then finds the subarray
     * with the largest sum?              (This should be an O(n3) algorithm)
     *
     * @param A and array of positive and negative integers
     */
    public static void maxSubSlow(int[] A) {
        int n = A.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += A[k];
                    if (sum > max) {
                        max = sum;
                        theMax = max;
                        theI = i;
                        theJ = j;
                    }
                }
            }
        }
    }

    /**
     * @task prints theMax and the start and end points in the array.
     * @param algorithm the name of algorithm doing the printing.
     */
    public static void print(String algorithm) {
        System.out.println("Algorithm: "+algorithm+"\nmax: "+theMax+
                "\nstart position(inclusive): "+theI+
                "\nend position(exclusive): "+theJ+"\n");
    }

    /**
     * @task  c.) Compare both algorithms on random arrays of size 50, 100, 200.
     * Compare for accuracy (both must yield a maximum subarray with the same
     * sum) and for actual runtime. Write a one page report on your findings.
     *
     * @param n size of array to be generated
     * @return an array of random integers
     */
    public static int [] generateArray(int n) {
        Random rand = new Random();
        int [] a = new int [n];

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(2000000) - 1000000;//[-1000000,1000000]
        }

        return a;
    }


    public static void maxSubMain() {
        int[] testSizes = {50, 100, 200};

        for (int i = 0; i < testSizes.length; i++) {
            int[] test = generateArray(testSizes[i]);
            int n = test.length - 1;
            maxSubSlow(test);
            System.out.println("\n-------------------------------------------");
            System.out.println("For "+testSizes[i]+" entries: \n\n");
            print("maxSubSlow("+testSizes[i]+")");
            theMax = maxSubFast(test,0,n);
            print("maxSubFast("+testSizes[i]+")");
        }
    }
    /**
     * -----------------------------------------------------------------------------
     * END OF Maximum Subarray Problem.
     * -----------------------------------------------------------------------------
     **/



    /**
     * -----------------------------------------------------------------------------
     * 0-1 Knapsack Problem:
     *
     *  Implement a brute force method to solve the 0-1 Knapsack Problem when the
     *  capacity of the knapsack is W and there are n items to select from. Here you
     *  will try all possible subsets of the items to find the subset with weight
     *  sum <=W and with the largest total benefit.  This should be an O(n*2^n)
     *  algorithm.
     * -----------------------------------------------------------------------------
     *
     * Test your method on random sets of size 25.  How do you know your answer is
     * correct?  Discuss.
     *
     * Test your problem on the following knapsack problem. Turn in the result.
     * Printout item numbers (indexed from 1) in the knapsack, and the total weight
     * and total benefit of the optimally filled knapsack.
     *
     * int W = 100;
     * int[] weights = {9,16,12,8,7, 16,7,8,9,14, 15,19,22,2,4,  5,10,11,3,17 ,15,18,15,9,7 };
     * int[] benefits = {1,7,3,4,5,  5,3,4,6,2,   6,6,4,2,1,  3,12,2,4,5,   4,3,2,1,3};
     */



    static String optimalSet = "";

    static void knapsack(int W, int[] weights, int[] benefits)
    {
        int n = weights.length;
        int total_weight = 0;
        int total_benefit = 0;

        // Loop for checking all 2^n subsets one by one
        for (int i = 0; i < (1<<n); i++)
        {

            int sub_total_weight = 0;
            int sub_total_benefit = 0;

            String set = "{ ";
            // current subset
            for (int j = 0; j < n; j++) {
 
                /* (1<<j) is a number with jth bit 1 so when we 'and' them with 
                 * the subset number we get which numbers are present in the 
                 * subset and which are not
                 **/
                if ((i & (1 << j)) > 0) {
                    sub_total_weight += weights[j];
                    sub_total_benefit += benefits[j];
                    set = (j < n - 1) ? (set += j+", ") : (set += j);

                }
            }
            set += " }";

            // snapshot
            if (sub_total_weight <= W) {
                // check for the benefit
                if (sub_total_benefit >= total_benefit) {
                    total_benefit = sub_total_benefit;
                    total_weight  = sub_total_weight;
                    //System.out.println("wt: "+total_weight+", b: "+total_benefit);
                    optimalSet = set+("\nwt: "+total_weight+", b: "+total_benefit+"\n");
                } else if (sub_total_benefit >= total_benefit
                        && sub_total_weight < total_weight) {
                    // lighter weights for the same benefit are ideal
                    total_benefit = sub_total_benefit;
                    total_weight  = sub_total_weight;
                    //System.out.println("wt: "+total_weight+", b: "+total_benefit);
                    optimalSet = set+("\nwt: "+total_weight+", b: "+total_benefit+"\n");

                }
            }
        }

        System.out.println("The optimal knapsack set is: \n"+optimalSet);
    }

    static void knapsackMain() {
        int W = 100;
        int[] weights = {9,16,12,8,7, 16,7,8,9,14, 15,19,22,2,4,  5,10,11,3,17 ,15,18,15,9,7 };
        int[] benefits = {1,7,3,4,5,  5,3,4,6,2,   6,6,4,2,1,  3,12,2,4,5,   4,3,2,1,3};
        knapsack(W, weights, benefits);
    }

    public static void main(String[] args)
    {
        knapsackMain();
        maxSubMain();

    }

}
