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

public class SortGraphicsPanel extends JPanel {
    private int[] dataArray;

    public SortGraphicsPanel(int[] dataArray) {
        this.dataArray = dataArray;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Add code to visualize the dataArray (colored bars, etc.)
    }

    public void setDataArray(int[] dataArray) {
        this.dataArray = dataArray;
    }
}
