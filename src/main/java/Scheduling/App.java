package Scheduling;

import java.util.Scanner;

public final class App {
    // User input
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);   
        System.out.println("How many proccess do you have?");
        int numOfProc = input.nextInt();
        Process[] p = new Process[numOfProc];
        for(int i = 0; i < numOfProc; i++){
            System.out.println("\nProcess #" + (i + 1));
            System.out.println("What is the process' arrival time?");
            int arrivalTime = input.nextInt();
            System.out.println("What is the process' CPU time?");
            int CPUtime = input.nextInt();
            p[i] = new Process(arrivalTime, CPUtime, "P" + (i + 1));
        }
        input.close();
        for (int i = 0; i < p.length; i++){
            System.out.println(p[i].getCPUBurst());
        }

        FCFS fcfs = new FCFS(p);
        fcfs.printGannttChart();

    }
}
