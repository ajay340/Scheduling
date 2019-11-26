package Scheduling;
import java.util.Random;
public class Process implements ProcessInt{

    public int startTime, arrivalTime, burstTime, turnAroundTime, waitingTime, completionTime, current_progress;

    public String ProcessName;

    public Process(int arrivalTime, int burstTime){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        Random rand = new Random();
        this.ProcessName = "Process #" + rand.nextInt(100);
    }

    public Process(int arrivalTime, int burstTime, String ProcessName){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.ProcessName = ProcessName;
    }


}