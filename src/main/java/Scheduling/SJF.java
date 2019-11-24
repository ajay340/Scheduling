package Scheduling;

import java.util.Arrays;

public class SJF extends SchedulingAbs{

    public SJF(Process[] processes) {
        super(processes);
        Arrays.sort(processes, (a, b) -> a.getArrivalTime() < b.getArrivalTime() ? -1 : a.getArrivalTime() == b.getArrivalTime() ? 0 : 1);
        for(Process process : processes){
            System.out.println(process.ProcessName);
        }
    }
}
