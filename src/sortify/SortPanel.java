/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortify;

import javax.swing.JPanel;

/**
 *
 * @author 0607dacs
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SortPanel extends JPanel {
    private int[] dataArray;
    private JButton randomizeButton;
    private JSlider sizeSlider;
    private SortGraphicsPanel graphicsPanel;
    public SortPanel() {
        
        
        // Initialize the array with a default size
        int defaultSize = 10; // You can set a default size
        dataArray = new int[defaultSize];
        randomizeArray();
        this.graphicsPanel = new SortGraphicsPanel(dataArray);
        
        // Create the "Randomize" button
        randomizeButton = new JButton("Randomize");
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomizeArray();
                repaint(); // Redraw the panel after randomization
            }
        });

        // Create the size slider
        sizeSlider = new JSlider(1, 100); // Set the minimum and maximum size values
        sizeSlider.setValue(defaultSize); // Set the initial value
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int newSize = sizeSlider.getValue();
                resizeArray(newSize);
            }
        });

        // Add components to the panel
        add(randomizeButton);
        add(new JLabel("Array Size:"));
        add(sizeSlider);
        add(graphicsPanel);
    }

    // Method to randomize the array
    private void randomizeArray() {
        int size = dataArray.length;
        for (int i = 0; i < size; i++) {
            dataArray[i] = (int) (Math.random() * 100); // You can adjust the range as needed
        }
    }

    // Method to resize the array
    private void resizeArray(int newSize) {
        int[] newArray = new int[newSize];
        System.arraycopy(dataArray, 0, newArray, 0, Math.min(newSize, dataArray.length));
        dataArray = newArray;
        randomizeArray();
        repaint(); // Redraw the panel after resizing
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Add code to visualize the dataArray (colored bars, etc.)
    }
}
