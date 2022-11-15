package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.mvc.impl.ControllerImpl;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    public SimpleGUI(ControllerImpl controller){
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel canvas1 = new JPanel();
        canvas1.setLayout(new BoxLayout(canvas1, BoxLayout.LINE_AXIS));
        final JTextField showPrint = new JTextField();
        final JTextArea showHistory = new JTextArea();
        showHistory.setEditable(false);
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show History");

        canvas.add(showPrint, BorderLayout.NORTH);
        canvas.add(showHistory, BorderLayout.CENTER);
        canvas1.add(print);
        canvas1.add(history);
        canvas.add(canvas1, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Handlers
         */
        print.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.setString(showPrint.getText());
                controller.print();
            }    
        });

        history.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                showHistory.setText("");
                final List<String> story = controller.getHistory();
                for (final String el : story) {
                    showHistory.setText(showHistory.getText() + "\n" + el);
                } 
            } 
        }); 
        
    }

    private void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI(new ControllerImpl()).display();
    }
}
