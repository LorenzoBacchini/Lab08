package it.unibo.mvc.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.unibo.mvc.Controller;

public class ControllerImpl implements Controller{
    private String currentString;
    private final List<String> stringHistory = new ArrayList<>();

    public ControllerImpl(final String currentString){
        setString(currentString);
    }

    @Override
    public void setString(final String newString) {
        try {
            Objects.requireNonNull(newString);
            this.currentString = newString;
        }catch(NullPointerException e){
            System.out.println("Null values are not accepted"); //NOPMD
        }
    }

    @Override
    public String getString() {
        return new String(this.currentString);
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.stringHistory);
    }

    @Override
    public void print() {
        try {
            Objects.requireNonNull(this.currentString);
            System.out.println(this.currentString); //NOPMD
            this.stringHistory.add(this.currentString);
        }catch(NullPointerException e){
            System.out.println("Null values are not accepted"); //NOPMD
        }
    }
    
}
