package Scheduling;

public interface SchedulingInt{

    public Process[] deepCopy(Process[] processes);

    public void printGannttChart();

    public void printTable();
}
