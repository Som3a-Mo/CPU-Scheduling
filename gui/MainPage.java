package gui;

import models.Services;
import models.Validation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class MainPage extends JFrame implements ActionListener {

    Panel p1 = new Panel();
    JPanel p2 = new JPanel();
    JLabel l[] = new JLabel[14];
    JButton buttons[] = new JButton[6];
    JTextField fieldarr[] = new JTextField[10];
    String[] typecontact = {"FCFS", "SJF", "RR", "Priority"};
    JComboBox<JButton[]> name = new JComboBox(typecontact);
    DefaultTableModel model;
    JTable table;
    int numRow = 0;
    Object[][] data;
    double avarag_wating_time = 0;
    double avarage_turnaround_time = 0;

    /////////////////////////////////////
    ImageIcon clearicon = new ImageIcon("Images/cleaning.png");
    ImageIcon addicon = new ImageIcon("Images/add.png");
    ImageIcon runicon = new ImageIcon("Images/agility.png");
    ImageIcon comboicon = new ImageIcon("Images/features.png");
    ImageIcon avarage1 = new ImageIcon("Images/response.png");
    ImageIcon avarage2 = new ImageIcon("Images/threshold.png");
    ImageIcon processname = new ImageIcon("Images/statistics.png");
    ImageIcon bursttime = new ImageIcon("Images/microchip.png");
    ImageIcon piority = new ImageIcon("Images/prioritize.png");
    ImageIcon qt = new ImageIcon("Images/qt.png");
    ImageIcon delete = new ImageIcon("Images/delete.png");
    ImageIcon ferest = new ImageIcon("Images/step-1 (2).png");

    public MainPage() {

        this.setName("CPU");
        this.setSize(1500, 800);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        /////////////////////////
        Lanels();
        textfeld();
        combobox();
        bottons();
        tabel();
        ////////////////////////////
        p2.setBounds(570, 200, 3, 530);
        p2.setBackground(Color.white);
        p2.setBorder(new LineBorder(Color.black, 5));
        this.add(p1);
        p2.setLayout(null);
        p1.setLayout(null);
        p1.setBounds(0, 0, 1500, 800);
        MatteBorder border = BorderFactory.createMatteBorder(0, 0, 0, 5, Color.white);

        p2.setBorder(border);
        p1.add(p2);
        this.setVisible(true);
    }

    void Lanels() {

        for (int i = 0; i < 14; i++) {
            l[i] = new JLabel();
            l[i].setFont(new Font(null, Font.TYPE1_FONT, 18));
            l[i].setForeground(new Color(250, 250, 250));

        }

        l[0].setBounds(500, 20, 700, 100);
        l[1].setBounds(670, 80, 200, 100);
        p1.add(l[0]);
        p1.add(l[1]);
        l[2].setBounds(250, 170, 200, 50);
        l[3].setBounds(0, 20, 200, 50);
        p1.add(l[2]);
        ////////////////////////////////
        l[4].setBounds(80, 350, 170, 50);
        l[5].setBounds(330, 350, 150, 50);
        l[6].setBounds(80, 480, 150, 50);
        l[7].setBounds(330, 480, 170, 50);
        p1.add(l[4]);
        p1.add(l[5]);
        p1.add(l[6]);
        p1.add(l[7]);
        ///////////////////////////////////////
        p1.add(l[8]);
        p1.add(l[9]);
        p1.add(l[11]);
        p1.add(l[10]);
        p1.add(l[12]);
        l[8].setBounds(730, 680, 350, 50);
        l[9].setBounds(1100, 680, 350, 50);
        l[10].setBounds(30, 230, 150, 100);
        l[11].setBounds(185, 250, 50, 50);
        l[12].setBounds(1000, 160, 50, 50);
        ////////////////////////////////////////
        l[0].setText("CPU Scheduling");
        l[1].setText("Simulation");
        l[2].setText("Process");
        l[3].setText("Outpout");
        l[4].setText("Process num :");
        l[4].setIcon(processname);
        l[5].setText("Burst Time :");
        l[5].setIcon(bursttime);
        l[6].setText("Piority :");
        l[6].setIcon(piority);
        l[7].setText("quontem time:");
        l[7].setIcon(qt);
        l[8].setText("Average wating time:  " + avarag_wating_time);
        l[8].setIcon(avarage1);
        l[9].setIcon(avarage2);
        l[9].setText("Average turnaround time:  " + avarag_wating_time);
        l[10].setIcon(ferest);
        l[11].setIcon(comboicon);
        l[12].setText("P : "+ numRow);

        ////////////////////////////////////////
        l[0].setFont(new Font(null, Font.ITALIC, 70));
        l[1].setFont(new Font(null, Font.ITALIC, 35));
        l[2].setFont(new Font(null, Font.ITALIC, 35));
        l[3].setFont(new Font(null, Font.ITALIC, 35));

    }

    void textfeld() {

        for (int i = 0; i < 10; i++) {
            fieldarr[i] = new JTextField();
            fieldarr[i].setBorder(new LineBorder(Color.white, 7));
            fieldarr[i].setBackground(new Color(255, 255, 255));
            fieldarr[i].setForeground(Color.black);
            fieldarr[i].setFont(new Font("Georgia", Font.ITALIC, 20));
            fieldarr[i].setCaretColor(Color.black);
            p1.add(fieldarr[i]);
        }

        fieldarr[0].setBounds(80, 400, 150, 50);
        fieldarr[1].setBounds(330, 400, 150, 50);
        fieldarr[2].setBounds(80, 530, 150, 50);
        fieldarr[3].setBounds(330, 530, 150, 50);
    }

    void combobox() {
        p1.add(name);
        name.setBounds(100, 250, 150, 50);
        name.setBackground(Color.white);
        name.setForeground(Color.black);
        name.setBorder(new LineBorder(Color.white, 1));
        setFocusable(false);
        name.setSelectedItem(null);
        name.setFont(new Font("Boli", Font.BOLD, 15));

        name.addActionListener(this);
    }

    void bottons() {
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("Comic Sans", Font.ITALIC, 20));
            buttons[i].setBackground(Color.white);
            buttons[i].setBorder(new LineBorder(Color.BLACK, 3));  // Use black border
            buttons[i].setForeground(Color.BLACK);  // Use black text color
            buttons[i].addActionListener(this);
        }
        buttons[0].setIcon(addicon);
        buttons[0].setText("Add");
        buttons[1].setText("Run");
        buttons[1].setIcon(runicon);
        buttons[2].setIcon(clearicon);
        buttons[2].setText("Clear");
        buttons[3].setIcon(delete);
        buttons[3].setText("Reset");
        buttons[4].setText("Submit");
        buttons[5].setText("Run");

        // Set bounds for the buttons to fit inside the visible area
        buttons[0].setBounds(330, 650, 150, 50);  // Adjust position for visibility
        buttons[1].setBounds(1130, 160, 150, 50);  // Adjust position for visibility
        buttons[2].setBounds(1300, 160, 150, 50);
        buttons[3].setBounds(80, 650, 150, 50);
        p1.add(buttons[0]);
        p1.add(buttons[1]);
        p1.add(buttons[2]);
        p1.add(buttons[3]);
    }

    void tabel() {

        String[] columns = new String[]{
                "Process num", "Burst time", "Piority", "Wating time ", "Turniaround time"
        };
        data = null;
        model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(680, 220, 770, 450);
        p1.add(scrollPane);
        table.getAutoResizeMode();
        Services.getModel(model);
    }

    private void reset() {
        fieldarr[0].setText("");
        fieldarr[1].setText("");
        fieldarr[2].setText("");
        fieldarr[3].setText("");
    }
    private void counter(int val) {
        numRow = val;
        l[12].setText("P : "+ numRow);
    }
    private void clear(){
        Services.clearTable();
        Services.clearList();
        Services.timeQuantum = 0;
        counter(0);
        averageResult(0);
    }
    private void averageResult(int val) {
        if (val == 0) {
            Services.averageWaitingTime = 0;
            Services.averageTurnAroundTime = 0;
        }
        l[8].setText("Average waiting time: " + Services.averageWaitingTime);
        l[9].setText("Average turnaround time: " + Services.averageTurnAroundTime);
    }
    private boolean isEmpty(String p, String b, String pr) {
        return p.isEmpty() && b.isEmpty() && pr.isEmpty();
    }

    private boolean isFull(String p, String b, String pr) {
        return !p.isEmpty() && !b.isEmpty() && !pr.isEmpty();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttons[0]){
            //add
            String qt = fieldarr[3].getText().trim();
            boolean emp = isEmpty(fieldarr[0].getText().trim(), fieldarr[1].getText().trim(),fieldarr[2].getText().trim());
            boolean ok = true;
            if (!qt.isEmpty())ok &= Validation.isValid(qt);
            if (!qt.isEmpty() && emp) {
                Validation.isExist(qt);
                reset();
                return;
            }
            ok &=  Validation.isVaild(fieldarr[0].getText().trim(), fieldarr[1].getText().trim(),fieldarr[2].getText().trim());
            if (ok) {
                if (!qt.isEmpty() ) {
                    Validation.isExist(qt);
                }
                Services.takeNumber(fieldarr[0].getText().trim(), fieldarr[1].getText().trim(),fieldarr[2].getText().trim());
                counter(numRow + 1);
                reset();
            }
        }

        if (e.getSource()==buttons[1]){
            //run
            Services.clearTable();
            boolean ok = Validation.canRun();
            String algorithm = (String)name.getSelectedItem();
            ok &= Validation.haveQuantum(algorithm);
            if (ok) {
                Services.applyCPUAScheduling(algorithm);
                averageResult(1);
            }
        }

        if (e.getSource()==buttons[2]){
            //clear
            clear();
        }

        if (e.getSource()==buttons[3]){
            //delete
            reset();
        }

    }

}
