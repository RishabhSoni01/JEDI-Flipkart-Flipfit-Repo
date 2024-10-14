package com.flipkart.bean;
/*
 * Represents a [brief description of the class's purpose or functionality].
 *
 * @author Mukul
 * @params This class does not have any parameters.
 * @throws This class does not throw any exceptions.
 */
// Represents a generic pair of values.
public class pair<T, T1> {
    private T first;
    private T1 second;

    /* Constructor to initialize a pair object.
     Parameters:
     first: The first element of the pair.
     second: The second element of the pair.
     */
    public pair(T first, T1 second) {
        this.first = first;
        this.second = second;
    }

    // Getter for the first element of the pair.
    public T getFirst() {
        return first;
    }

    // Setter for the first element of the pair.
    public void setFirst(T first) {
        this.first = first;
    }

    // Getter for the second element of the pair.
    public T1 getSecond() {
        return second;
    }

    // Setter for the second element of the pair.
    public void setSecond(T1 second) {
        this.second = second;
    }
}