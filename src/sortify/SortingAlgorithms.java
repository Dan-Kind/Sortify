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
// SortAlgorithms class containing static sorting methods
public class SortingAlgorithms {
    public static void bubbleSort(SortableInteger[] array) {
       int n = array.length;  
        SortableInteger temp = new SortableInteger(0);
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(array[j-1].compareTo(array[j]) > 1){  
                                 //swap elements  
                                 temp = array[j-1];  
                                 array[j-1] = array[j];  
                                 array[j] = temp;  
                         }  
                          
                 }  
         }  
         System.out.println("Bubble sorted");
        updateArray(array);
    }

    public static void quickSort(SortableInteger[] array) {
        // Implement quicksort algorithm
    }
    
    public static void updateArray(SortableInteger[] array){
        SortLogic.getInstance().setDataArray(array);
    }
}


