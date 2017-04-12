package gr.anneta.civilization_selector.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chsifinos@gmail.com
 */
public class FileUtils {

    private final File file;

    public FileUtils(String path) {
        this.file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
    }

    public boolean deleteFile() {
        file.delete();
        return true;
    }

    public boolean emptyFile() {
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException ex) {
        }
        return true;
    }

    public boolean writeInFile(String text) {
        try {
            Formatter formatter = new Formatter("");
            formatter.format(text);
            formatter.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
        return true;
    }

    public boolean appendInFile(String text) {
        try {
            OutputStreamWriter filewriter = new OutputStreamWriter(new FileOutputStream(file, true)); //the true will append the new data
            // Appends the text to the file.
            filewriter.write(text);
            filewriter.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
        return true;
    }

    public StringBuilder readFile() {
        File file = new File("");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error");
        }
        return stringBuilder;
    }
}
