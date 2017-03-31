import java.util.PriorityQueue;

public class JobScheduler
{
    private int nJobs;
    private Job[]  jobs;
    private Schedule bestForBruteForce;




    public JobScheduler( int[] joblength, int[] deadline, int[] profit)
    {
        nJobs = joblength.length;
        jobs = new Job[nJobs];
        bestForBruteForce = new Schedule();
        for(int i =0; i < nJobs; i++)
        {
            jobs[i] = new Job(i, joblength[i], deadline[i], profit[i]);
        }
    }

    public void printJobs()  //prints the array jobs
    {

        String str = "";

        for(int i = 0; i < nJobs; i++)
        {
             //#0:(7,7,10,-1,-1)
            str += "#" + jobs[i].jobNumber+":("+jobs[i].length+","+jobs[i].deadline+",";
            str += jobs[i].profit + "," + jobs[i].start +","+ jobs[i].finish+")\n";
        }

        System.out.println(str);
    }


    public void bruteForceUtility(int k)
    {
        for(int i = k;i < nJobs; i++)
        {
            Job temp = jobs[k];
            jobs[k] = jobs[i];
            jobs[i] = temp;
            bruteForceUtility(k+1);
            temp = jobs[k];
            jobs[k] = jobs[i];
            jobs[i] = temp;
        }

        if(k == nJobs-1) {
            Schedule schedule = new Schedule();

            int [] arr = new int[nJobs];

            for(int i = 0; i < nJobs; i ++)
            {
                if(i == 0) {
                    jobs[i].start = 0;
                    jobs[i].finish = jobs[i].start + jobs[i].length;
                }else {
                    jobs[i].start = jobs[i - 1].finish;
                    jobs[i].finish = jobs[i].start + jobs[i].length;
                }

                if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                    arr[jobs[i].jobNumber] = 1;
                    int index = nJobs-1;
                    Job temp = jobs[index];
                    jobs[index] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }

                if(i >= 1)
                {
                    jobs[i].start = jobs[i - 1].finish;
                    jobs[i].finish = jobs[i].start + jobs[i].length;
                }

            }

            for(int i =0; i < nJobs; i++)
            {
                schedule.add(jobs[i]);
                if(jobs[i].finish > jobs[i].deadline)
                {
                    schedule.profit -= jobs[i].profit;
                }
            }


            if(schedule.profit > bestForBruteForce.profit)
            {
                bestForBruteForce = schedule;
            }
        }
    }
    //Brute force. Try all n! orderings. Return the schedule with the most profit
    public Schedule bruteForceSolution()
    {
        bruteForceUtility(0);
        for (int i = 0; i < nJobs; i++)
        {
            if(i == 0){
                bestForBruteForce.schedule.get(i).start = 0;
                bestForBruteForce.schedule.get(i).finish = bestForBruteForce.schedule.get(i).length;
            }else {
                bestForBruteForce.schedule.get(i).start = bestForBruteForce.schedule.get(i-1).finish;
                bestForBruteForce.schedule.get(i).finish = bestForBruteForce.schedule.get(i).length + bestForBruteForce.schedule.get(i).start;
            }
        }
        return bestForBruteForce;
    }


    public Schedule makeScheduleEDF()
//earliest deadline first schedule. Schedule items contributing 0 to total profit last
    {


        Sorts.mergesort(jobs, Sorts.EARILIEST_DEADLINE_FIRST);


        Schedule schedule = new Schedule();

        int [] arr = new int[nJobs];

        for(int i = 0; i < nJobs; i ++)
        {
            if(i == 0) {
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

            if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                arr[jobs[i].jobNumber] = 1;
                int index = nJobs-1;
                Job temp = jobs[index];
                jobs[index] = jobs[i];
                jobs[i] = temp;
                i--;
            }

            if(i >= 1)
            {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(jobs[i].finish > jobs[i].deadline)
            {
                schedule.profit -= jobs[i].profit;
            }
        }

        return schedule;
    }

    public Schedule makeScheduleSJF()
//shortest job first schedule. Schedule items contributing 0 to total profit last
    {

        Sorts.mergesort(jobs, Sorts.SHORTEST_JOB_FIRST);

        Schedule schedule = new Schedule();

        int [] arr = new int[nJobs];

        for(int i = 0; i < nJobs; i ++)
        {
            if(i == 0) {
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

            if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                arr[jobs[i].jobNumber] = 1;
                int index = nJobs-1;
                Job temp = jobs[index];
                jobs[index] = jobs[i];
                jobs[i] = temp;
                i--;
            }

            if(i >= 1)
            {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(jobs[i].finish > jobs[i].deadline)
            {
                schedule.profit -= jobs[i].profit;
            }
        }

        return schedule;
    }

    public Schedule makeScheduleHPF()
//highest profit first schedule. Schedule items contributing 0 to total profit last
    {


        Sorts.mergesort(jobs, Sorts.HIGHEST_PROFIT_FIRST);

        Schedule schedule = new Schedule();

        int [] arr = new int[nJobs];

        for(int i = 0; i < nJobs; i ++)
        {
            if(i == 0) {
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

            if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                arr[jobs[i].jobNumber] = 1;
                int index = nJobs-1;
                Job temp = jobs[index];
                jobs[index] = jobs[i];
                jobs[i] = temp;
                i--;
            }

            if(i >= 1)
            {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(jobs[i].finish > jobs[i].deadline)
            {
                schedule.profit -= jobs[i].profit;
            }
        }

        return schedule;
    }


    public int getNextMax(int [] arr)
    {
        float max = 0.0f;
        int index = -1;
        for(int i =0; i < nJobs; i++)
        {
            float temp = ((float)jobs[i].profit/jobs[i].deadline);
            if(arr[jobs[i].jobNumber] != 1 && temp >= max)
            {
                max = temp;
                index = i;
            }
        }



        return index;
    }

    public Schedule newApproxSchedule() //Your own creation. Must be <= O(n^3)
    {

        Sorts.mergesort(jobs, Sorts.NEW_APPROXIMATE_SCHEDULE);

        printJobs();

        Schedule schedule = new Schedule();

        int [] arr = new int[nJobs];


        int [] visited = new int[nJobs];

        for(int i = 0; i < nJobs; i ++)
        {
            if(i == 0) {
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

            if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                arr[jobs[i].jobNumber] = 1;
                int index = 0;
                index = getNextMax(arr);
                System.out.println(index);
                if(index > -1) {
                    Job temp = jobs[index];
                    jobs[index] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }
            }else if(arr[jobs[i].jobNumber] == 0){
                arr[jobs[i].jobNumber] = 1;
                System.out.println(jobs[i].jobNumber + "," + jobs[i].finish);
            }

            if(i >= 1)
            {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }

        }

        for(int i = 0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(jobs[i].finish > jobs[i].deadline)
            {
                schedule.profit -= jobs[i].profit;
            }
        }

        return schedule;
    }



}//end of JobScheduler class