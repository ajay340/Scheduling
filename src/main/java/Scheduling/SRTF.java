package Scheduling;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;

public class SRTF extends SchedulingAbs{
    private Queue q = new LinkedList<>();
    public SRTF(Process[] processes){
        super(processes);
        System.out.println("SHORTEST REMAINING TIME FIRST (SRTF)");
        System.out.println("------------------------------\n");

        Arrays.sort(this.processes, (a, b) -> ((a.arrivalTime == b.arrivalTime) && (a.burstTime < b.burstTime)) ? -1 : ((a.arrivalTime == b.arrivalTime) && (a.burstTime == b.burstTime)) ? 0 : 1); 
        
        for(int i = 0; i < this.processes.length; i++){
            while(this.processes[i].burstTime != 0){
                this.processes[i].burstTime = this.processes[i].burstTime - 1;
                this.processes[i].completionTime = this.processes[i].completionTime + 1;
                q.add(this.processes[i].ProcessName);

                // Arrays.sort(this.processes, new Comparator<Process>() {
                //     public int compare(Process u1, Process u2) {
                //         if((u1.arrivalTime == current_progress) && (u1.burstTime < u2.burstTime)){
                //             return -1;  
                //         }
                //         else if((u1.completionTime == u2.arrivalTime) && (u1.burstTime == u2.burstTime)){
                //             return 0;
                //         }
                //         else{
                //             return 1;
                //         }     
                //     }
                //   });
                
                //(a, b) -> ((a.completionTime == b.arrivalTime) && (a.burstTime > b.burstTime)) ? -1 : ((a.completionTime == b.arrivalTime) && (a.burstTime == b.burstTime)) ? 0 : 1); 
            }               
        }
        System.out.println(q.toString());
    }
    public void sortProcesses(){
        
    }
}