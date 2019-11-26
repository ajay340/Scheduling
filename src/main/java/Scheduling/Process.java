package Scheduling;
import java.util.Random;
public class Process{

    // Variables for different attributes of the process
    public int startTime, arrivalTime, burstTime, turnAroundTime, waitingTime, completionTime, current_progress;

    public String ProcessName;

    //Construct Process with arrival and burst time
    //Randomly generates Process Name
    public Process(int arrivalTime, int burstTime){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        Random rand = new Random();
        this.ProcessName = "Process #" + rand.nextInt(100);
    }

    //Construct Process with arrival, burst, and Process name
    public Process(int arrivalTime, int burstTime, String ProcessName){
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.ProcessName = ProcessName;
    }
    
}