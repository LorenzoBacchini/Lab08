package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String DEFAULT_PATH = System.getProperty("user.home")
        + File.separator
        + "output.txt";
    private File file;

    /**
     * Constructor method.
     */
    public Controller() {
        this.file = new File(DEFAULT_PATH);
    }

    /**
     * Set the file to the value of newFile.
     * 
     * @param newFile
     */
    public void setFile(final File newFile) {
        this.file = newFile;
    }

    /**
     * 
     * @return the file where String are written
     */
    public File getFile() {
        return this.file;
    }

    /**
     * 
     * @return the path of the file
     */
    public String getPath() {
        return this.file.getAbsolutePath();
    }

    /**
     * Write the String text on this.file.
     * 
     * @param text
     */
    public void writeString(final String text) {
        try (PrintStream ps = new PrintStream(this.file, StandardCharsets.UTF_8)) {
            ps.print(text);
        } catch (IOException e1) {
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
