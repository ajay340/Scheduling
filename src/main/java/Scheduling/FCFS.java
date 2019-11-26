package Scheduling;

public class FCFS extends SchedulingAbs{

    //Initalizes FCFS scheduler
    public FCFS(Process[] processes){

        super(processes);
        System.out.println("FIRST COME FIRST SERVE (FCFS)");
        System.out.println("------------------------------\n");

        for (int i = 0 ; i < processes.length; i++){
            try{
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
