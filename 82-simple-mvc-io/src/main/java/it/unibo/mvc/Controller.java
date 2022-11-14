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

    public Controller(){
        this.file = new File(DEFAULT_PATH);
    }

    public void setFile(File newFile){
        this.file = newFile;
    }

    public File getFile(){
        return this.file;
    }

    public String getPath(){
        return this.file.getAbsolutePath();
    }

    public void writeString(String text){
        try (PrintStream ps = new PrintStream(this.file, StandardCharsets.UTF_8)) {
            ps.print(text);
        } catch (IOException e1) {
            e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }
}
