
public class JobScheduler
{
    private int nJobs;
    private Job[]  jobs;

    static final int SORT_DEADLINE = 0;
    static final int SORT_PROFIT = 1;
    static final int SORT_LENGTH = 2;


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

        String str = "Input: Jobs to be scheduled\n";
        str += "Job format is (length, deadline, profit, start, finish)\n";

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

        for(int i= 0; i < nJobs; i++)
        {
            Sorts.mergesort(jobs, SORT_DEADLINE);
        }
        Schedule schedule = new Schedule();
        for (int i = 0; i < nJobs; i++)
        {
            if(i == 0){
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].length;
            }else {
                if(jobs[i-1].finish > jobs[i].deadline)
                {
                    jobs[i].profit = 0;
                    Job temp = jobs[nJobs-1];
                    jobs[nJobs-1] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }else {
                    jobs[i].start = jobs[i - 1].finish;
                    jobs[i].finish = jobs[i].start + jobs[i].length;
                }
            }
        }

        for(int i =0; i < nJobs; i++)
        {
            schedule.add(jobs[i]);
        }
        return schedule;
    }

    public Schedule makeScheduleSJF()
//shortest job first schedule. Schedule items contributing 0 to total profit last
    {
        for(int i= 0; i < nJobs; i++)
        {
            Sorts.mergesort(jobs, SORT_LENGTH);
        }
        Schedule schedule = new Schedule();
        for (int i = 0; i < nJobs; i++)
        {
            if(i == 0){
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].length;
            }else {
                if(jobs[i-1].finish > jobs[i].deadline)
                {
                    jobs[i].profit = 0;
                    Job temp = jobs[nJobs-1];
                    jobs[nJobs-1] = jobs[i];
                    jobs[i] = temp;
                    i--;
                }else {
                    jobs[i].start = jobs[i - 1].finish;
                    jobs[i].finish = jobs[i].start + jobs[i].length;
                }
            }
        }

        return schedule;
    }

    public Schedule makeScheduleHPF()
//highest profit first schedule. Schedule items contributing 0 to total profit last
    {

        for(int i= 0; i < nJobs; i++)
        {
            Sorts.mergesort(jobs, SORT_PROFIT);
        }
        Schedule schedule = new Schedule();
        for (int i = nJobs - 1; i >= 0; i--)
        {
            if(i == 0){
                jobs[i].start = 0;
                jobs[i].finish = jobs[i].length;
            }else{
                jobs[i].start = jobs[i-1].finish;
                jobs[i].finish = jobs[i].start + jobs[i].length;
            }
            schedule.add(jobs[i]);
        }

        return schedule;
    }


    public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
    {
        return null;
    }

}//end of JobScheduler class