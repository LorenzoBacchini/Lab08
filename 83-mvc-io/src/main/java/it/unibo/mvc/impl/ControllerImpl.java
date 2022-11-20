package it.unibo.mvc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.unibo.mvc.Controller;

/**
 * class that implement Controller.
 * 
 * this class set a String and print it with
 * the method print
 */
public class ControllerImpl implements Controller {
    private String currentString;
    private final List<String> stringHistory = new ArrayList<>();

    /**
     * set the current string to newString (if not null).
     */
    @Override
    public void setString(final String newString) {
        Objects.requireNonNull(newString);
        this.currentString = newString;
    }

    /**
     * @return the current string to print
     */
    @Override
    public String getString() {
        return this.currentString;
    }

    /**
     * @return a list<String> containing the history of printed string
     */
    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.stringHistory);
    }

    /**
     * print the currenti string.
     * 
     * @throws IllegalStateException if current string is null
     */
    @Override
    public void print() {
        if (this.currentString != null) {
            System.out.println(this.currentString); //NOPMD
            this.stringHistory.add(this.currentString);
        } else {
            throw new IllegalStateException("The string is null");
        }
    }
}
