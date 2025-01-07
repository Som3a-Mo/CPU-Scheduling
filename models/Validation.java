package models;

import javax.swing.JOptionPane;

public class Validation {

    public static void notEmpty(String s, String msg) {
        message(s, msg, "Empty field");
    }

    private static void noInt(String val) {
        message(val, "is not vaild", "Cannot parse");
    }

    private static boolean isInt(String s, int target) {
        try {
            int val = Integer.parseInt(s);
            if (val < target) {
                throw new Exception();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    private static void message(String filed, String msg, String title) {
        JOptionPane.showMessageDialog(null, filed + " " + msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static boolean isValid(String timeQuantum){
        String msg = "is Empty";
        if (timeQuantum.isEmpty()) {
            notEmpty("Quantum time", msg);
            return false;
        } else if (!isInt(timeQuantum, 1)) {

            noInt(timeQuantum);
            return false;
        }
        return true;
    }
    public static void isExist(String timeQ){
        int time = time = Integer.parseInt(timeQ);
        if (Services.timeQuantum == 0) {
            Services.timeQuantum = time;
            return;
        }
        String[] options = {"keep old value", "Change value"};

        // Show the option dialog
        int choice = JOptionPane.showOptionDialog(
                null, // Parent component (null for center of screen)
                "Choose an option:", // Message
                "Quantum time is exist", // Title
                JOptionPane.DEFAULT_OPTION, // Option type
                JOptionPane.QUESTION_MESSAGE, // Message type
                null, // Icon (null for default)
                options, // Array of options
                options[0] // Default option
        );

        // Handle the selected option
        switch (choice){
            case 1:
                Services.timeQuantum = time;
                break;
            default:
                break;
        }
    }
    public static boolean isVaild(String processnum, String bursTime, String priority) {
        String msg = "is Empty";
        if (processnum.isEmpty()) {
            notEmpty("Process number", msg);
            return false;
        } else if (!isInt(processnum, 1)) {

            noInt(processnum);
            return false;
        }
        if (bursTime.isEmpty()) {
            notEmpty("burstTime", msg);
            return false;
        } else if (!isInt(bursTime, 1)) {

            noInt(bursTime);
            return false;
        }
        if (priority.isEmpty()) {
            notEmpty("priority", msg);
            return false;
        } else if (!isInt(priority, 0)) {

            noInt(priority);
            return false;
        }

        return true;
    }

    public static boolean canRun(){
        boolean canRun = !Services.isEmpty();
        if (!canRun)message("", "Empty CPU", "Cannot Run");
        return canRun;
    }
    public static boolean haveQuantum(String algorithm){
        if (algorithm != "RR" || Services.timeQuantum != 0)return true;
        message("", "Quantum is Empty", "Cannot Run");
        return false;
    }

}
