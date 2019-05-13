package TxtToPostgreSQL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Checker {
    public static void checker(List<File> files) {
        LineIterator lineIterator;

        for (File file : files) {
            try {
                lineIterator = FileUtils.lineIterator(file);
                while (lineIterator.hasNext()) {
                    String currentLine = lineIterator.next();
                    if (currentLine.contains(":")) {
                        String[] columnDetail = currentLine.split(":", 2);
                        // System.out.println(currentLine);
                    } else {

                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
