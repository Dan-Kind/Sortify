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
public class SortableInteger implements Sortable<SortableInteger>{
    private int value;

    public SortableInteger(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(SortableInteger other) {
        return this.value - other.value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
