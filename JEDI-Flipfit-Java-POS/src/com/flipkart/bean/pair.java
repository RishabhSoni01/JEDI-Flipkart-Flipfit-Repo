package com.flipkart.bean;

/**
 * Represents a generic pair of values.
 * This class encapsulates two related objects, allowing you to store and manipulate them together.
 *
 * @author JEDI-GroupD
 * @params This class does not have any parameters.
 * @throws this class does not throw any exceptions.
 *
 * @param <T>  the type of the first element in the pair.
 * @param <T1> the type of the second element in the pair.
 */
public class pair<T, T1> {
    // The first element of the pair.
    private T first;

    // The second element of the pair.
    private T1 second;

    /**
     * Constructs a pair object with the specified elements.
     *
     * @param first  The first element of the pair.
     * @param second The second element of the pair.
     */
    public pair(T first, T1 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first element of the pair.
     *
     * @return the first element of the pair.
     */
    public T getFirst() {
        return first;
    }

    /**
     * Sets the first element of the pair.
     *
     * @param first the first element to set.
     */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * Gets the second element of the pair.
     *
     * @return the second element of the pair.
     */
    public T1 getSecond() {
        return second;
    }

    /**
     * Sets the second element of the pair.
     *
     * @param second the second element to set.
     */
    public void setSecond(T1 second) {
        this.second = second;
    }
}
