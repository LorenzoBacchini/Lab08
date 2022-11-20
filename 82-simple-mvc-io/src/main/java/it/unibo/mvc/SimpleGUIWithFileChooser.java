package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Constructor of SimpleGUIWithFIleChooser.
     * 
     * @param controller
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JPanel select = new JPanel();
        select.setLayout(new BoxLayout(select, BoxLayout.LINE_AXIS));
        final JTextArea text = new JTextArea();
        final JTextField selectedFile = new JTextField(controller.getPath());
        selectedFile.setEditable(false);
        final JButton save = new JButton("Save");
        final JButton browse = new JButton("Browse...");
        select.add(selectedFile);
        select.add(browse);
        canvas.add(select, BorderLayout.NORTH);
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Handlers.
         */
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                controller.writeString(text.getText());
            }
        });

        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final JFileChooser chooser = new JFileChooser();
                final int option = chooser.showSaveDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    final File newFile = chooser.getSelectedFile();
                    controller.setFile(newFile);
                    selectedFile.setText(controller.getPath());
                } else if (option == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, "Selected file Error");
                }
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
       new SimpleGUIWithFileChooser(new Controller()).display();
    }

}
