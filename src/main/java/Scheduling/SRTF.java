package Scheduling;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Comparator;

public class SRTF extends SchedulingAbs{
    Queue<Process> q = new LinkedList<Process>();
    public SRTF(Process[] processes){
        super(processes);
        System.out.println("SHORTEST REMAINING TIME FIRST (SRTF)");
        System.out.println("------------------------------\n");

        Arrays.sort(this.processes, (a, b) -> ((a.arrivalTime == b.arrivalTime) && (a.burstTime < b.burstTime)) ? -1 : ((a.arrivalTime == b.arrivalTime) && (a.burstTime == b.burstTime)) ? 0 : 1); 
        for(int i = 0; i < this.processes.length; i++){
            while(this.processes[i].burstTime != 0){
                this.processes[i].burstTime = this.processes[i].burstTime - 1;
                this.processes[i].completionTime = this.processes[i].completionTime + 1;
                this.processes[i].current_progress += 1;
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
        // Process[] p = new Process[q.size()];
        // q.toArray(p);
        // for(int i = 0; i < p.length; i++){
        //     for(int j = i; j < p.length; j++){
        //         if(p[i].ProcessName == p[j].ProcessName){
        //             p[i].completionTime += 1;
        //         }
        //     }
        // }
        // for(int i = 0; i < p.length; i++){
        //     System.out.println(p[i].ProcessName + " " + p[i].completionTime);
        // }
    }

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
}