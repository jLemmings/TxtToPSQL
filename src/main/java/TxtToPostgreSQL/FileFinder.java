package TxtToPostgreSQL;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileFinder {

    public static List<File> findFiles(File directory, String[] extensions) {
        List<File> files = (List<File>) FileUtils.listFiles(directory, extensions, true);

        System.out.println("FOUND " + files.size() + " FILES");
        return files;
    }
}
