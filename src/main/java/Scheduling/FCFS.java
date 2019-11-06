package Scheduling;

import java.util.Queue;
import java.util.LinkedList;

public class FCFS implements SchedulingInt{

    Queue<Process> queue = new LinkedList<>();

    public FCFS(Process[] processes){
        for(int i = 0; i < processes.length; i++){
            this.queue.add(processes[i]);
        }
    }

    public void printGannttChart(){
        int size = this.queue.size();
        String CPULine =     "CPU Burst Time:     ";
        String ArrivalLine = "Arrival Time  : ";
        String chart =       "                ";
        String processLine = "                ";
        for(int i = 0; i < size; i++){
            chart +="+-------";

            ArrivalLine += this.queue.peek().getArrivalTime() + "       ";
            CPULine += this.queue.peek().getCPUBurst() + "       ";
            processLine += this.queue.poll().ProcessName + "      ";
        }
        processLine += "";
        System.out.println(CPULine);
        System.out.println(ArrivalLine);
        System.out.println(chart);
        System.out.println(processLine);

    }
}
