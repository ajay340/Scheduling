package Scheduling;

import java.util.Arrays;

public class SJF extends SchedulingAbs{

    public SJF(Process[] processes) {
        super(processes);
        for(Process process : processes){
            System.out.println(process.ProcessName);
        }
    }
}
