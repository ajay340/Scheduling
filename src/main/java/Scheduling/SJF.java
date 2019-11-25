package Scheduling;


public class SJF extends SchedulingAbs{

    public SJF(Process[] processes) {
        super(processes);
        System.out.println("SHORTEST JOB FIRST (SJF)");
        System.out.println("------------------------------\n");
        System.out.println("PN : PaT");
        for(Process process : this.processes){
            System.out.println(process.ProcessName + " : " + process.arrivalTime);
        }
    }
}
