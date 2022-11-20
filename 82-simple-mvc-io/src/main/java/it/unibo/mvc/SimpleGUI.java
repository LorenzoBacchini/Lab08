package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Constructor of SimpleGUI.
     * 
     * @param controller
     */
    public SimpleGUI(final  Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Handlers
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.writeString(text.getText());
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Main method.
     * 
     * @param args
     */
    public static void main(final String[] args) {
       new SimpleGUI(new Controller()).display();
    }

}
