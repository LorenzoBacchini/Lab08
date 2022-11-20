package it.unibo.mvc;

import java.util.List;

/**
 *
 * 
 */
public interface Controller {
    /**
     * set the current string to print to newString.
     * 
     * @param newString
     */
    void setString(String newString);

    /**
     * 
     * @return return the current string to print
     */
    String getString();

    /**
     * 
     * @return the history of printed string
     */
    List<String> getHistory();

    /**
     * print the current string.
     */
    void print();
}
