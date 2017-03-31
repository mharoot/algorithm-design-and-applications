//Comp 496ALG  Project 2  TestCase A with solutions
import java.util.*;

public class SchedulerDriver2
{

    public static void main (String[] args)
    {




        int[] length = { 2,3,1,10,7,  4,6,9,3,2,  5,2,5,7,7,  6,3,7,8,4,  5,2,9,10,5};

        int[] deadline = { 10,12,15,8,10,  9,22,12,15,35,  29,32,45,41,13,
                16,10,20,10,4,  18,15,5,9, 30};

        int[] profit = { 2,5,13,28,8, 7,6,5,3,4,  9,7,6,9,14,  2,7,11,3,10,
                8,5,9,10,3 };

        JobScheduler js = new JobScheduler(length,deadline, profit);
        System.out.println("Jobs to be scheduled");
        System.out.println("Job format is " +
                "(length, deadline, profit, start, finish)" );
        js.printJobs();


        //--------------------------------------------
        //System.out.println("\nOptimal Solution Using Brute Force O(n!)");
        //Schedule bestSchedule = js.bruteForceSolution();
        //System.out.println( bestSchedule);


        //---------------------------------------
        System.out.println("\nEDF with unprofitable jobs last ");
        Schedule EDFPSchedule = js.makeScheduleEDF();
        System.out.println(EDFPSchedule);


        //-------------------------------------
        System.out.println("\nSJF with unprofitable jobs last");
        Schedule SJFPSchedule = js.makeScheduleSJF();
        System.out.println(SJFPSchedule);

        //--------------------------------------------
        System.out.println("\nHPF with unprofitable jobs last");
        Schedule HPFSchedule = js.makeScheduleHPF();
        System.out.println(HPFSchedule);

        // ------------------------------
        System.out.println("\nYour own creative solution");
        Schedule NASSchedule = js.newApproxSchedule();
        System.out.println(NASSchedule);


    }
}