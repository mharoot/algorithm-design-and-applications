
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

    }

    //Brute force. Try all n! orderings. Return the schedule with the most profit
    public Schedule bruteForceSolution()
    {
        return null;
    }


    public Schedule makeScheduleEDF()
//earliest deadline first schedule. Schedule items contributing 0 to total profit last
    {


        Schedule schedule = new Schedule();

        for (int i = 0; i < jobs.length; i++) {
            schedule.add(jobs[i]);
        }
        return schedule;
    }

    public Schedule makeScheduleSJF()
//shortest job first schedule. Schedule items contributing 0 to total profit last
    {
        return null;
    }

    public Schedule makeScheduleHPF()
//highest profit first schedule. Schedule items contributing 0 to total profit last
    {

        return null;
    }


    public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
    {
        return null;
    }

}//end of JobScheduler class