//Ajay Shah and Eric Gargiulo
//Date: 11/30/2019

package Scheduling;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;

public class SRTF extends SchedulingAbs implements SchedulingInt{
    //Queue for Processes being inputed every time unit
    Queue<Process> q = new LinkedList<Process>();

    //Initalizer for SRTF with inputted processes
    //Sorts Procesess based on burst time with respective arrival times
    //Pushes all processes into a queue and decreases the burst time by 1 each time
    //to check for other shorter remaining times
    public SRTF(Process[] processes){
        super(processes);
        System.out.println("SHORTEST REMAINING TIME FIRST (SRTF)");
        System.out.println("------------------------------\n");

        Arrays.sort(this.processes, (a, b) -> ((a.arrivalTime == b.arrivalTime) && (a.burstTime < b.burstTime)) ? -1 : ((a.arrivalTime == b.arrivalTime) && (a.burstTime == b.burstTime)) ? 0 : 1); 
        for(int i = 0; i < this.processes.length; i++){
            this.processes[i].startTime = this.processes[i].burstTime;
        }
        for(int i = 0; i < this.processes.length; i++){
            while(this.processes[i].burstTime != 0){
                this.processes[i].burstTime = this.processes[i].burstTime - 1;
                this.processes[i].current_progress += 1;
                this.processes[i].completionTime = this.processes[i].current_progress;
                q.add(this.processes[i]);
                Arrays.sort(this.processes, new Comparator<Process>() {
                    public int compare(Process u1, Process u2) {
                        u1.current_progress = u2.current_progress;
                        if((u1.arrivalTime == u2.current_progress) && (u1.burstTime < u2.burstTime)){
                            return -1;  
                        }
                        else if((u1.completionTime == u2.arrivalTime) && (u1.burstTime == u2.burstTime)){
                            return 0;
                        }
                        else{
                            return 1;
                        }     
                    }
                  });
            }               
        }
        Process[] p = new Process[q.size()];
        q.toArray(p);
        for(int i = 0; i < this.processes.length; i++){
            for(int j = i; j < p.length; j++){
                if(this.processes[i].ProcessName == p[j].ProcessName){
                    this.processes[i].completionTime = j + 1;
                }
            }
        }

        for(int i = 0; i < this.processes.length; i++){
            this.processes[i].turnAroundTime = this.processes[i].completionTime - this.processes[i].arrivalTime;
            this.processes[i].waitingTime = this.processes[i].turnAroundTime - this.processes[i].startTime;
        }   

    }

    //Prints out Gantt Chart using queue
    @Override
    public void printGannttChart(){
        String ArrivalLine = "        Time  : ";
        String chart =       "                ";
        String processLine = "                ";
        ArrivalLine += "";
        int aTime = q.peek().arrivalTime;
        while(q.size() != 0){
            chart +="+-------";
            ArrivalLine += aTime + "       ";
            aTime += 1;
            processLine += this.q.peek().ProcessName + "      ";
            q.poll();
        }
        chart += "+";
        ArrivalLine += aTime;
        System.out.println(ArrivalLine);
        System.out.println(chart);
        System.out.println(processLine);
    }

    //Prints out Table using temporary variable for bursttime
    @Override
    public void printTable(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s %20s %20s", "Process", "Arrival Time", "Completion Time", "Burst Time", "Turnaround Time", "Waiting Time");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for(Process process: this.processes){
            System.out.format("%5s %20s %20s %20s %20s %20s",
                    process.ProcessName, process.arrivalTime, process.completionTime, process.startTime, process.turnAroundTime, process.waitingTime);
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n\n");
    }
}