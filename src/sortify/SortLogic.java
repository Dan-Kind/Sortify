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
    private int[] dataArray;
    // Method to randomize the array
    private void randomizeArray() {
        int size = dataArray.length;
        for (int i = 0; i < size; i++) {
            dataArray[i] = (int) (Math.random() * 100); // You can adjust the range as needed
        }
    }
}
