package Scheduling;

import java.util.Scanner;

public final class App {

    // User input
    public static void main(String[] args){
        // Scanner input = new Scanner(System.in);   
        // System.out.println("How many proccess do you have?");
        // int numOfProc = input.nextInt();
        // Process[] p = new Process[numOfProc];
        // for(int i = 0; i < numOfProc; i++){
        //     System.out.println("\nProcess #" + (i + 1));
        //     System.out.println("What is the process' arrival time?");
        //     int arrivalTime = input.nextInt();
        //     System.out.println("What is the process' burst time?");
        //     int CPUtime = input.nextInt();
        //     p[i] = new Process(arrivalTime, CPUtime, "P" + (i + 1));
        // }

        Process p1 = new Process(0, 1, "P1");
        Process p2 = new Process(1, 3, "P2");
        Process p3 = new Process(1, 1, "P3");
        Process p4 = new Process(1, 2, "P4");
        Process p5 = new Process(2, 2, "P5");
        Process[] p = { p1, p2, p3, p4, p5 };


        FCFS fcfs = new FCFS(p);
        fcfs.printGannttChart();
        fcfs.printTable();

        SJF sjf = new SJF(p);
        sjf.printGannttChart();
        sjf.printTable();

    }
}
