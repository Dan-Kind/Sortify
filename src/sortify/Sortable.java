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
// Create a Sortable interface that extends Comparable
interface Sortable<T> extends Comparable<T> {
    // Define a compareTo method that all implementing classes must implement
    @Override
    int compareTo(T other);
}