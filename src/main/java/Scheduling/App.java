package Scheduling;

public final class App {
    public static void main(String[] args) {
        Process p1 = new Process(1, 1, "P1");
        Process p2 = new Process(2, 2, "P2");
        Process p3 = new Process(3, 3, "P3");

        Process[] p = {p1, p2, p3};
        FCFS f = new FCFS(p);
        f.printGannttChart();
    }
}
