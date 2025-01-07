package models;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;


public class Services {
    public static List<Process> list = new ArrayList();
    static DefaultTableModel Model;
    public static double averageWaitingTime;
    public static double averageTurnAroundTime;
    public static int timeQuantum = 0;

    public static void getModel(DefaultTableModel model) {
        Model = model;
    }

    public static void takeNumber(String processnum, String brustTime, String priority) {
        int process = Integer.parseInt(processnum);
        int burst = Integer.parseInt(brustTime);
        int Priority = Integer.parseInt(priority);
        list.add(new Process(process, burst, Priority));
    }

    private static List<Process> getProcess() {
        List<Process> processes = new ArrayList();
        for (var p : list) {
            processes.add(new Process(p.processNumber, p.burstTime, p.priority));
        }
        return processes;
    }

    public static void applyCPUAScheduling(String algorithm) {
        List<Process> answer = new ArrayList<>();
        List<Process> temp = getProcess();

        switch (algorithm) {
            case "FCFS":
                answer = CPUSchedule.FCFS(temp);
                break;
            case "SJF":
                answer = CPUSchedule.SJF(temp);
                break;
            case "RR":
                answer = CPUSchedule.RR(temp, timeQuantum);
                break;
            case "Priority":
                answer = CPUSchedule.Priority(temp);
                break;
            case null:
                Validation.notEmpty("algorithm", " is not selected");
                return;
            default:
                break;
        }

        FullTable(answer);
    }

    private static void FullTable(List<Process> newList) {
        int sz = newList.size();
        float avg_w = 0, avg_t = 0;
        for (var process : newList) {
            Model.addRow(new Object[]{process.processNumber, process.burstTime, process.priority, process.waitingTime, process.turnAroundTime});
            avg_w += process.waitingTime;
            avg_t += process.turnAroundTime;
        }

        averageWaitingTime = avg_w / sz;
        averageTurnAroundTime = avg_t / sz;
        averageWaitingTime = Math.round(averageWaitingTime * 100.0) / 100.0;
        averageTurnAroundTime = Math.round(averageTurnAroundTime * 100.0) / 100.0;
    }

    public static boolean isEmpty() {
        return list.isEmpty();
    }

    public static void clearTable() {
        Model.setRowCount(0);
    }

    public static void clearList() {
        list.clear();
    }
}
