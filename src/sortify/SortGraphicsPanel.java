/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortify;

/**
 *
 * @author 0607dacs
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class SortGraphicsPanel extends JPanel {
    private SortableInteger[] dataArray;
    private SortableInteger[] initialArray  = SortLogic.getInstance().getArray();
    private static final int MAX_BAR_WIDTH = 200; // Maximum width of a bar
    private static final int MAX_FONT_SIZE = 12; // Maximum font size
    public SortGraphicsPanel(SortableInteger[] dataArray) {
        this.dataArray = dataArray;
    }
    
    private static SortGraphicsPanel instance;
    public static synchronized SortGraphicsPanel getInstance() {
        if (instance == null) {
            instance = new SortGraphicsPanel(SortLogic.getInstance().getArray());
        }
        return instance;
    }
    



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int numBars = dataArray.length;
        int barWidth = Math.min(getWidth() / dataArray.length, MAX_BAR_WIDTH);
        int totalWidth = numBars * barWidth; // Total width of all bars

        // Calculate the minimum bar width to ensure bars are visible even at large input sizes
        int minBarWidth = Math.max(1, getWidth() / numBars);

        // Calculate the starting position to center the bars horizontally
        int startX = Math.max(0, (getWidth() - totalWidth) / 2);

        int maxValue = getMaxValue(dataArray);

        for (int i = 0; i < numBars; i++) {
            int barHeight = (int) (((double) dataArray[i].getValue() / maxValue) * getHeight());
            int calculatedBarWidth = Math.max(minBarWidth, barWidth); // Ensure bar is at least minBarWidth wide
            int x = startX + i * calculatedBarWidth;
            int y = getHeight() - barHeight;

            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, calculatedBarWidth, barHeight);

            // Draw black outline
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, calculatedBarWidth, barHeight);

            // Draw the number inside the bar
            if (barWidth >= 7) {
                int fontSize = Math.min(MAX_FONT_SIZE, calculatedBarWidth / 2);
                Font font = new Font("Arial", Font.PLAIN, fontSize);
                g2d.setFont(font);
                FontMetrics metrics = g2d.getFontMetrics(font);
                String number = String.valueOf(dataArray[i].getValue());
                Rectangle2D rect = metrics.getStringBounds(number, g2d);
                int textX = x + (calculatedBarWidth - (int) rect.getWidth()) / 2;
                int textY = y + (barHeight + (int) rect.getHeight()) / 2;
                g2d.setColor(Color.WHITE);
                g2d.drawString(number, textX, textY);
            }
        }
    }


    private int getMaxValue(SortableInteger[] dataArray) {
        int maxValue = Integer.MIN_VALUE;
        for (SortableInteger number : dataArray) {
            if (number.getValue() > maxValue) {
                maxValue = number.getValue();
            }
        }
        return maxValue;
    }
    
    public void setDataArray(SortableInteger[] dataArray) {
       this.dataArray = dataArray;
       this.repaint();
       SortPanel.getInstance().repaint();
    }
}
