package models;

import java.util.List;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class CPUSchedule {


    public static List<Process> FCFS(List<Process> processes) {
        int time = 0;
        for (Process p : processes) {
            p.waitingTime += time;
            p.completionTime = time + p.burstTime; /// if I want CT
            p.turnAroundTime += p.burstTime + p.waitingTime;
            time += p.burstTime;
        }
        return processes;
    }

    public static List<Process> SJF(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.burstTime));
        int currentTime = 0;
        for (Process p : processes) {
            p.completionTime = currentTime + p.burstTime; /// if I want CT
            p.turnAroundTime = p.completionTime;/// if I want CT
//            process.turnAroundTime = currentTime + process.burstTime;
            p.waitingTime = p.turnAroundTime - p.burstTime;
            currentTime += p.burstTime;
        }
        return processes;
    }

    public static List<Process> RR(List<Process> processes, int timeQuantum) {

        int n = processes.size();
        int time = 0; // Current time
        Queue<Process> queue = new LinkedList<>();

        // Initially, all processes are added to the queue
        queue.addAll(processes);

        // Process the queue using Round Robin
        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();

            // If the remaining time of the process is less than or equal to time quantum, it completes
            if (currentProcess.remainingTime <= timeQuantum) {
                time += currentProcess.remainingTime;
                currentProcess.completionTime = time;
                currentProcess.turnAroundTime = currentProcess.completionTime;
                currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;
                currentProcess.remainingTime = 0;
            } else {
                // Process runs for the full time quantum
                time += timeQuantum;
                currentProcess.remainingTime -= timeQuantum;
                queue.add(currentProcess);  // Add back to the queue
            }
        }

        return processes;
    }

    public static List<Process> Priority(List<Process> processes) {
        processes.sort(Comparator.comparingInt((Process p) -> p.priority));
        int currentTime = 0;

        for (Process p : processes) {
            p.waitingTime = currentTime; // Waiting time = current time before execution
            p.turnAroundTime = p.waitingTime + p.burstTime; // Turnaround time = waiting time + burst time
            currentTime += p.burstTime; // Update current time after execution
            p.completionTime = currentTime;
        }
        return processes;
    }

}
