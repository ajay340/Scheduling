package Scheduling;
import java.util.Random;
public class Process implements ProcessInt{

    private int aTime, cTime;

    public int tTime, wTime;

    public String ProcessName;

    public Process(int arrivalTime, int CPUburst){
        this.aTime = arrivalTime;
        this.cTime = CPUburst;
        Random rand = new Random();
        this.ProcessName = "Process #" + rand.nextInt(100);
    }

    public Process(int arrivalTime, int CPUburst, String ProcessName){
        this.aTime = arrivalTime;
        this.cTime = CPUburst;
        this.ProcessName = ProcessName;
    }

    public int getArrivalTime(){
        return this.aTime;
    }

    public int getCPUBurst(){
        return this.cTime;
    }
}