
public class JobScheduler
{
    private int nJobs;
    private Job[]  jobs;




    public JobScheduler( int[] joblength, int[] deadline, int[] profit)
    {
        nJobs = joblength.length;
        jobs = new Job[nJobs];
        for(int i =0; i < nJobs; i++)
        {
            jobs[i] = new Job(i, joblength[i], deadline[i], profit[i]);
        }
    }

    public void printJobs()  //prints the array jobs
    {

        String str = null;

        for(int i = 0; i < nJobs; i++)
        {
             //#0:(7,7,10,-1,-1)
            str += "#" + jobs[i].jobNumber+":("+jobs[i].length+","+jobs[i].deadline+",";
            str += jobs[i].profit + "," + jobs[i].start +","+ jobs[i].finish+")\n";
        }

        System.out.println(str);
    }

    //Brute force. Try all n! orderings. Return the schedule with the most profit
    public Schedule bruteForceSolution()
    {
        

        return null;
    }


    public Schedule makeScheduleEDF()
//earliest deadline first schedule. Schedule items contributing 0 to total profit last
    {


        Sorts.mergesort(jobs, Sorts.EARILIEST_DEADLINE_FIRST);

        Schedule schedule = new Schedule();
        int [] arr = new int[nJobs];
        for (int i = 0; i < nJobs; i++)
        {
            if(i == 0){
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
                if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                    arr[jobs[i].jobNumber] = 1;
                    Job temp = jobs[nJobs-1];
                    jobs[nJobs-1] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }
            }
        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(arr[jobs[i].jobNumber] == 1)
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
        for (int i = 0; i < nJobs; i++)
        {
            if(i == 0){
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
                if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                    arr[jobs[i].jobNumber] = 1;
                    Job temp = jobs[nJobs-1];
                    jobs[nJobs-1] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }
            }
        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(arr[jobs[i].jobNumber] == 1)
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
        for (int i = 0; i < nJobs; i++)
        {
            if(i == 0){
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].length;
            }else {
                jobs[i].start = jobs[i - 1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
                if (jobs[i].finish > jobs[i].deadline && arr[jobs[i].jobNumber]!=1) {
                    arr[jobs[i].jobNumber] = 1;
                    Job temp = jobs[nJobs-1];
                    jobs[nJobs-1] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }
            }
        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
            if(arr[jobs[i].jobNumber] == 1)
            {
                schedule.profit -= jobs[i].profit;
            }
        }

        return schedule;
    }


    public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
    {
        return null;
    }

}//end of JobScheduler class