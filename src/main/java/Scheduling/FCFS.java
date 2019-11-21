package Scheduling;

import java.util.Queue;
import java.util.LinkedList;

public class FCFS implements SchedulingInt{

    private Process[] processes;

    public FCFS(Process[] processes){
        this.processes = processes.clone();
    }

    public void printGannttChart(){
        String CPULine =     "CPU Burst Time:     ";
        String ArrivalLine = "Arrival Time  : ";
        String chart =       "                ";
        String processLine = "                ";
        ArrivalLine += 0 + "       ";
        int aTime = 0;
        for(int i = 0; i < this.processes.length; i++){
            chart +="+-------";
            aTime += this.processes[i].getArrivalTime();
            ArrivalLine += aTime + "       ";
            CPULine += this.processes[i].getCPUBurst() + "       ";
            processLine += this.processes[i].ProcessName + "      ";
        }
        processLine += "";
        System.out.println(CPULine);
        System.out.println(ArrivalLine);
        System.out.println(chart);
        System.out.println(processLine);
    }
}
