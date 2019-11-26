package Scheduling;

import java.util.Arrays;
public abstract class SchedulingAbs implements SchedulingInt{

    protected Process[] processes;

    public SchedulingAbs(Process[] processes){
        this.processes = deepCopy(processes);
        Arrays.sort(this.processes, (a, b) -> a.arrivalTime < b.arrivalTime ? -1 : a.arrivalTime == b.arrivalTime ? 0 : 1);
    }

    public Process[] deepCopy(Process[] processes){
        Process[] clone = new Process[processes.length];
        for(int i = 0; i < processes.length; i++){
            Process temp_process = processes[i];
            if (temp_process != null){
                clone[i] = new Process(temp_process.arrivalTime, temp_process.burstTime, temp_process.ProcessName);
            }
        }
        return clone;
    }

    @Override
    public void printGannttChart(){
        String ArrivalLine = "        Time  : ";
        String chart =       "                ";
        String processLine = "                ";
        ArrivalLine += "";
        for(int i = 0; i < this.processes.length; i++){
            chart +="+-------";
            ArrivalLine += this.processes[i].startTime + "       ";
            processLine += this.processes[i].ProcessName + "      ";
        }
        chart += "+";
        ArrivalLine += this.processes[processes.length - 1].completionTime;
        System.out.println(ArrivalLine);
        System.out.println(chart);
        System.out.println(processLine);
    }

    @Override
    public void printTable(){
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s %20s %20s", "Process", "Arrival Time", "Completion Time", "Burst Time", "Turnaround Time", "Waiting Time");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for(Process process: this.processes){
            System.out.format("%5s %20s %20s %20s %20s %20s",
                    process.ProcessName, process.arrivalTime, process.completionTime, process.burstTime, process.turnAroundTime, process.waitingTime);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n\n");
    }
}