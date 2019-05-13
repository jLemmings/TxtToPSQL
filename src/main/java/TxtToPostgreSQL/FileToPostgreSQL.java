package TxtToPostgreSQL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FileToPostgreSQL {

    public static void fileToPost(Connection connection, List<File> files) {
        LineIterator lineIterator;
        int counter = 0;
        for (File file : files) {
            System.out.println("IMPORTING FILE: " + file + ", COMPLETED " + counter + "/" + files.size());

            long startTime = System.nanoTime();

            try {
                lineIterator = FileUtils.lineIterator(file);
                while (lineIterator.hasNext()) {
                    String currentLine = lineIterator.next();
                    if (currentLine.contains(":")) {
                        String[] columnDetail = currentLine.split(":", 2);
                        PreparedStatement st = connection.prepareStatement("INSERT INTO pwned (username, password) VALUES (?, ?)");
                        // System.out.println(currentLine);
                        if (columnDetail.length >= 2) {
                            st.setString(1, columnDetail[0]);
                            st.setString(2, columnDetail[1]);
                            st.executeUpdate();
                            st.close();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            long endTime = System.nanoTime();
            System.out.println("IMPORT TIME FOR " + file + ": " + (endTime - startTime)/(1000 * 1000 * 1000) + " seconds");
            counter++;
        }




    }

}
