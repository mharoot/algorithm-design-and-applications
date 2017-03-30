
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
            schedule.add(jobs[i]);
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
            schedule.add(jobs[i]);
        }

        return schedule;
    }


    public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
    {
        return null;
    }

}//end of JobScheduler class