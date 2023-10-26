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
public class SortLogic {
    private SortableInteger[] dataArray;
    private int size = 10;
    
    private SortLogic(){
        randomizeArray();
    }
    // Method to randomize the array
    public void randomizeArray() {
        dataArray = new SortableInteger[size];
        for (int i = 0; i < size; i++) {
            dataArray[i] = new SortableInteger((int) (Math.random() * 1000)); // You can adjust the range as needed
        }
        System.out.println("randomized array");
    }
    
     // Singleton instance
    private static volatile SortLogic instance;
    
    // Lazy initialization of the singleton instance
    public static synchronized SortLogic getInstance() {
        if (instance == null) {
            instance = new SortLogic();
        }
        return instance;
    }
    
    // Getter method for the array
    public SortableInteger[] getArray() {
        return dataArray;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDataArray(SortableInteger[] dataArray) {
        this.dataArray = dataArray;
        SortGraphicsPanel.getInstance().setDataArray(dataArray);
    }
    
}
