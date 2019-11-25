package Scheduling;

import java.util.Arrays;
import java.util.LinkedList; 
import java.util.Queue; 

public class SJF extends SchedulingAbs{

    public SJF(Process[] processes) {
        super(processes);
        System.out.println("SHORTEST JOB FIRST (SJF)");
        System.out.println("------------------------------\n");
        Arrays.sort(this.processes, (a, b) -> ((a.arrivalTime == b.arrivalTime) && (a.burstTime < b.burstTime)) ? -1 : ((a.arrivalTime == b.arrivalTime) && (a.burstTime == b.burstTime)) ? 0 : 1);     

        for (int i = 0 ; i < this.processes.length; i++){
            try{
                Arrays.sort(this.processes, (a, b) -> ((a.completionTime < b.arrivalTime) && (a.burstTime < b.burstTime)) ? -1 : ((a.completionTime == b.arrivalTime) && (a.burstTime == b.burstTime)) ? 0 : 1);
                this.processes[i].startTime = this.processes[i-1].completionTime;
                this.processes[i].completionTime = this.processes[i - 1].completionTime + this.processes[i].burstTime;
                this.processes[i].turnAroundTime = this.processes[i].completionTime - this.processes[i].arrivalTime;
                this.processes[i].waitingTime = this.processes[i].turnAroundTime - this.processes[i].burstTime;
            }
            catch(Exception e){
                this.processes[i].completionTime = this.processes[i].arrivalTime + this.processes[i].burstTime;
                this.processes[i].turnAroundTime = this.processes[i].completionTime - this.processes[i].arrivalTime;
                this.processes[i].waitingTime = this.processes[i].turnAroundTime - this.processes[i].burstTime;
            }
        }
    }
}
