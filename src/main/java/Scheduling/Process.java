package Scheduling;
import java.util.Random;
public class Process implements ProcessInt{

    private int aTime, bTime;

    public int tTime, wTime, cTime;

    public String ProcessName;

    public Process(int arrivalTime, int burstTime){
        this.aTime = arrivalTime;
        this.bTime = burstTime;
        Random rand = new Random();
        this.ProcessName = "Process #" + rand.nextInt(100);
    }

    public Process(int arrivalTime, int burstTime, String ProcessName){
        this.aTime = arrivalTime;
        this.bTime = burstTime;
        this.ProcessName = ProcessName;
    }

    public int getArrivalTime(){
        return this.aTime;
    }

    public int getBurstTime(){
        return this.bTime;
    }

}