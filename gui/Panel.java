package gui;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GradientPaint;

public class Panel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(52, 143, 80);   // اللون الأخضر
        Color color2 = new Color(86, 180, 211);  // اللون الأزرق
        Color color3 = new Color(255, 255, 204); // اللون الأصفر الفاتح
        Color color4 = new Color(255, 102, 102); // اللون الوردي
        Color color5 = new Color(102, 204, 255); // اللون السماوي

        GradientPaint gradient1 = new GradientPaint(0, 0, color1, width / 4, height, color2);
        GradientPaint gradient2 = new GradientPaint(width / 4, 0, color2, width / 2, height, color3);
        GradientPaint gradient3 = new GradientPaint(width / 2, 0, color3, 3 * width / 4, height, color4);
        GradientPaint gradient4 = new GradientPaint(3 * width / 4, 0, color4, width, height, color5);
        g2d.setPaint(gradient1);
        g2d.fillRect(0, 0, width, height);
        g2d.setPaint(gradient2);
        g2d.fillRect(0, 0, width, height);
        g2d.setPaint(gradient3);
        g2d.fillRect(0, 0, width, height);
        g2d.setPaint(gradient4);
        g2d.fillRect(0, 0, width, height);
    }
}