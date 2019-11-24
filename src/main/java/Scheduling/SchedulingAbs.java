package Scheduling;

public abstract class SchedulingAbs implements SchedulingInt{

    protected Process[] processes;

    public SchedulingAbs(Process[] processes){
        this.processes = processes;
    }

    public void printGannttChart(){
        String ArrivalLine = "Arrival Time  : ";
        String chart =       "                ";
        String processLine = "                ";
        ArrivalLine += 0 + "       ";
        int aTime = 0;
        for(int i = 0; i < this.processes.length; i++){
            chart +="+-------";
            aTime += this.processes[i].getArrivalTime();
            ArrivalLine += aTime + "       ";
            processLine += this.processes[i].ProcessName + "      ";
        }
        processLine += "";
        System.out.println(ArrivalLine);
        System.out.println(chart);
        System.out.println(processLine);
    }

    public void printTable(){
        Chart table = new Chart();
        table.addHeaderCols("Process", "Arrival Time", "Completion Time", "Burst Time", "Turnaround Time", "Waiting Time");
        for(Process process : this.processes){
            table.add(process.ProcessName);
            table.add(process.getArrivalTime());
            table.add(process.cTime);
            table.add(process.getBurstTime());
            table.add(process.tTime);
            table.add(process.wTime);
        }
        table.print(System.out);
    }
}