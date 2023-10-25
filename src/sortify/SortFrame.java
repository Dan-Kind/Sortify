/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortify;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author 0607dacs
 */
public class SortFrame extends JFrame {
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 620;
    public SortPanel sortPanel = SortPanel.getInstance();
    public SortFrame() {
        super("Sortify");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Set the frame's size explicitly
        add(sortPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
