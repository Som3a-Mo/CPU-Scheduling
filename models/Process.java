package models;

public class Process {
    int processNumber;
    int burstTime;
    int priority;

    int remainingTime = 0;
    int completionTime = 0;

    int waitingTime = 0;
    int turnAroundTime = 0;

    public Process(int processNumber, int burstTime, int priority) {
        this.processNumber = processNumber;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processNumber=" + processNumber +
                ", burstTime=" + burstTime +
                ", priority=" + priority +
                ", remainingTime=" + remainingTime +
                ", completionTime=" + completionTime +
                ", waitingTime=" + waitingTime +
                ", turnAroundTime=" + turnAroundTime +
                '}';
    }
}
