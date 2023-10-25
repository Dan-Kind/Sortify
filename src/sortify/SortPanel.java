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
    private SortableInteger[] currentArray;
    private JButton randomizeButton;
    private JButton bubbleSortButton;
    private JButton selectionSortButton;
    private JButton mergeSortButton;
    private JButton quickSortButton;
    private JSlider sizeSlider;
    private SortGraphicsPanel graphicsPanel;

    public SortPanel() {
        // Initialize the array with a default size
        int defaultSize = 10;
        currentArray = SortLogic.getInstance().getArray();
        this.graphicsPanel = new SortGraphicsPanel(currentArray);
        
        // Create the "Randomize" button
        randomizeButton = new JButton("Randomize");
        randomizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortLogic.getInstance().randomizeArray();
                currentArray = SortLogic.getInstance().getArray();
                graphicsPanel.setDataArray(currentArray);
                repaint(); // Redraw the panel after randomization
            }
        });
        
        // Create the "BubbleSort" button
        bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingAlgorithms.bubbleSortAsync(currentArray);
            }
        });
        //Create the "Selection Sort" btuoon
        selectionSortButton = new JButton("Selection Sort");
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingAlgorithms.selectionSortAsync(currentArray);
            }
        });
        
        //Create the "Merge Sort" button
        mergeSortButton = new JButton("Merge Sort");
        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingAlgorithms.mergeSortAsync(currentArray);
            }
        });
        
        //Create the "quick Sort" button
        quickSortButton = new JButton("Quick Sort");
        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortingAlgorithms.quickSortAsync(currentArray);
            }
        });
        
        // Create the size slider
        sizeSlider = new JSlider(1, 100); // Set the minimum and maximum size values
        sizeSlider.setValue(defaultSize); // Set the initial value
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int newSize = sizeSlider.getValue();
                SortLogic.getInstance().setSize(newSize);
                
            }
        });

        // Set layout manager to arrange components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add components to the panel
        add(randomizeButton);
        add(new JLabel("Array Size:"));
        add(sizeSlider);
        add(bubbleSortButton);
        add(selectionSortButton);
        add(mergeSortButton);
        add(quickSortButton);
        // Add the SortGraphicsPanel to the larger area below existing components
        add(Box.createRigidArea(new Dimension(0, 20))); // Adds some space between components
        add(graphicsPanel);
    }
    
    private static SortPanel instance;
    public static SortPanel getInstance() {
        if (instance == null) {
            instance = new SortPanel();
        }
        return instance;
    }
    public static void repaintThis() {
        instance.repaint();
    }
}
