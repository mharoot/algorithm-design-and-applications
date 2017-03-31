

public class Sorts {

    private static int INFINITY = 10000000;
    static int EARILIEST_DEADLINE_FIRST = 0;
    static int HIGHEST_PROFIT_FIRST = 1;
    static int SHORTEST_JOB_FIRST = 2;
    static int NEW_APPROXIMATE_SCHEDULE = 3;



/* --------------------Merge Sort --------------------*/
    //merges sorted slices a[i.. j] and a[j + 1 …  k] for 0<=  i <=j < k < a.length

    public static Job[] merge ( Job [] a,  int i, int m , int k, int SORT_BY)
    {
        int nL = m - i + 1;
        int nR = k - m;
        Job [] L = new Job[nL+1];
        Job [] R = new Job[nR+1];

        boolean leftSideLessThanOrEqualToRight = false;

        L[nL] = getJobInifinity(SORT_BY);
        R[nR] = L[nL];

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

            if (leftSideLessThanOrEqualToRight(SORT_BY, L[l], R[r]) ) {
                a[j] = L[l];
                l++;
            } else {
                a[j] = R[r];
                r++;
            }
        }


        return a;
    }

    private static Job getJobInifinity(int SORT_BY) {

        // keep this format until brute force and dynamic programming confirms we can use the job(-1, INFINITY, INIFINITY, -1) as a constant call INFINITY_JOB.
        if (SORT_BY == EARILIEST_DEADLINE_FIRST) {
            return new Job(-1, -1, INFINITY, -1);
        } else if (SORT_BY == HIGHEST_PROFIT_FIRST) {
            return new Job(-1, -1, -1, -INFINITY);
        } else if (SORT_BY == SHORTEST_JOB_FIRST) {
            return new Job(-1, INFINITY, -1, -1);
        }else if (SORT_BY == NEW_APPROXIMATE_SCHEDULE){
            return new Job(-1, -1 ,1, -INFINITY);
        }

        return new Job(-1, INFINITY, INFINITY, -1);
    }

    private static boolean leftSideLessThanOrEqualToRight (int SORT_BY, Job l, Job r) {
        boolean status = false;
        if (SORT_BY == EARILIEST_DEADLINE_FIRST ) {
            status = l.deadline <= r.deadline;
        } else if (SORT_BY == SHORTEST_JOB_FIRST) {
            status = l.length <= r.length;
        } else if (SORT_BY == HIGHEST_PROFIT_FIRST) {
            // note the difference
            status = r.profit <= l.profit;
        }
        else if(SORT_BY == NEW_APPROXIMATE_SCHEDULE)
        {
            status = ((float)r.profit/r.deadline) <= ((float)l.profit/l.deadline) ;
        }

        return status;
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
