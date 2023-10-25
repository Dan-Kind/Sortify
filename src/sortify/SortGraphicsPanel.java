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
        int barWidth = getWidth() / dataArray.length;
        int maxValue = getMaxValue(dataArray);

        for (int i = 0; i < dataArray.length; i++) {
            int barHeight = (int) (((double) dataArray[i].getValue() / maxValue) * getHeight());
            int x = i * barWidth;
            int y = getHeight() - barHeight;
            
            

            g2d.setColor(Color.BLUE);
            g2d.fillRect(x, y, barWidth, barHeight);
            
            // Draw black outline
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y, barWidth, barHeight);
            // Draw the number inside the bar
            Font font = new Font("Arial", Font.PLAIN, 12);
            g2d.setFont(font);
            FontMetrics metrics = g2d.getFontMetrics(font);
            String number = String.valueOf(dataArray[i].getValue());
            Rectangle2D rect = metrics.getStringBounds(number, g2d);
            int textX = x + (barWidth - (int) rect.getWidth()) / 2;
            int textY = y + (barHeight + (int) rect.getHeight()) / 2;
            g2d.setColor(Color.WHITE);
            g2d.drawString(number, textX, textY);
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
