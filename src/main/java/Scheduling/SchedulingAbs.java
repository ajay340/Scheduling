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
            ArrivalLine += this.processes[i].arrivalTime + "       ";
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
        Chart table = new Chart();
        table.addHeaderCols("Process", "Arrival Time", "Completion Time", "Burst Time", "Turnaround Time", "Waiting Time");
        for(Process process : this.processes){
            table.add(process.ProcessName);
            table.add(process.arrivalTime);
            table.add(process.completionTime);
            table.add(process.burstTime);
            table.add(process.turnAroundTime);
            table.add(process.waitingTime);
        }
        table.print(System.out);
        System.out.println("\n\n");
    }
}