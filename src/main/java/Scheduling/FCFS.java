package Scheduling;

public class FCFS extends SchedulingAbs{


    public FCFS(Process[] processes){

        super(processes);

        System.out.println("FIRST COME FIRST SERVER (FCFS)");
        System.out.println("------------------------------\n");
        
        for(Process process : this.processes){
            process.cTime = process.getArrivalTime() + process.getBurstTime();
            process.tTime = process.cTime - process.getArrivalTime();
            process.wTime = process.tTime - process.getBurstTime();
        }
    }

}
