//Ajay Shah and Eric Gargiulo
//Date: 11/30/2019

package Scheduling;

import java.util.Scanner;

public final class App {
    public static void main(String[] args){
        //User input for number of processes and each arrival and burst times
        Scanner input = new Scanner(System.in);   
        System.out.println("How many proccess do you have?");
        int numOfProc = input.nextInt();
        Process[] p = new Process[numOfProc];
        for(int i = 0; i < numOfProc; i++){
            System.out.println("\nProcess #" + (i + 1));
            System.out.println("What is the process' arrival time?");
            int arrivalTime = input.nextInt();
            System.out.println("What is the process' burst time?");
            int CPUtime = input.nextInt();
            p[i] = new Process(arrivalTime, CPUtime, "P" + (i + 1));
            System.out.println("\n");
        }

        // Scheduling algorithm for FCFS
        //Prints out Gantt Chart
        //Prints out table with Turnaround and Waiting Times
        FCFS fcfs = new FCFS(p);
        fcfs.printGannttChart();
        fcfs.printTable();

        // Scheduling algorithm for SJF
        //Prints out Gantt Chart
        //Prints out table with Turnaround and Waiting Times
        SJF sjf = new SJF(p);
        sjf.printGannttChart();
        sjf.printTable();

        // Scheduling algorithm for SRTF
        //Prints out Gantt Chart
        //Prints out table with Turnaround and Waiting Times
        SRTF srtf = new SRTF(p);
        srtf.printGannttChart();
        srtf.printTable();

    }
}
