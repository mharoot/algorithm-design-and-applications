import javax.jws.soap.SOAPBinding;

public class Sorts {

    private static int INFINITY = 10000000;
    private static int EARILIEST_DEADLINE_FIRST = 0;
    private static int HIGHEST_PROFIT_FIRST = 1;
    private static int SHORTEST_JOB_FIRST = 2;


/* --------------------Merge Sort --------------------*/
    //merges sorted slices a[i.. j] and a[j + 1 …  k] for 0<=  i <=j < k < a.length

    public static Job[] merge ( Job [] a,  int i, int m , int k, int SORT_BY)
    {
        int nL = m - i + 1;
        int nR = k - m;
        Job [] L = new Job[nL+1];
        Job [] R = new Job[nR+1];

        boolean leftSideLessThanOrEqualToRight = false;
        
        // keep this format until brute force and dynamic programming confirms we can use the job(-1, INFINITY, INIFINITY, -1) as a constant call INFINITY_JOB.
        if (SORT_BY == EARILIEST_DEADLINE_FIRST) {
            leftSideLessThanOrEqualToRight = L[l].deadline <= R[r].deadline;
            // Job( int jn , int len, int d, int p)
            L[nL] = new Job(-1, -1, INFINITY, -1);
            R[nR] = L[nL];
        } else if (SORT_BY == HIGHEST_PROFIT_FIRST) {
            // note the difference
            leftSideLessThanOrEqualToRight = R[r].profit <= L[l].profit;
            // Job( int jn , int len, int d, int p)
            L[nL] = new Job(-1, -1, INFINITY, -1);
            R[nR] = L[nL];
        } else if (SORT_BY == SHORTEST_JOB_FIRST) {
            leftSideLessThanOrEqualToRight = L[l].length <= R[r].length;
            // Job( int jn , int len, int d, int p)
            L[nL] = new Job(-1, INFINITY, INFINITY, -1);
            R[nR] = L[nL];
        }

        // divide left hand side from
        for (int  l = 0; l < nL; l++) {
            L[l] = a[l+i];
        }

        // divide right hand side from
        for (int  r = 0; r < nR; r++) {
            R[r] = a[r+m+1];
        }

        // merge left and right side in sorted order
        int l = 0, r = 0;

        for (int j = i; j <= k; j++) {
            if (leftSideLessThanOrEqualToRight) {
                a[j] = L[l];
                l++;
            } else {
                a[j] = R[r];
                r++;
            }
        }


        return a;
    }


    //sorts  a[ i .. k]  for 0<=i <= k < a.length
    private static Job[] mergesort(Job[] a,  int i ,  int k, int SORT_BY)
    {
        if( i < k) {
            int m = (i+k)/2;
            a = mergesort(a,i,m,SORT_BY);
            a = mergesort(a,m+1,k,SORT_BY);
            a = merge(a,i,m,k,SORT_BY);
        }
        return a;
    }


    //Sorts the array using mergesort
    public static Job[] mergesort(Job[] a , int SORT_BY)
    {
        return mergesort(a, 0, a.length - 1,SORT_BY);
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
