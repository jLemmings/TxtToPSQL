package TxtToPostgreSQL;

import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;


public class Import {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:postgresql://agent02.home:5432/bdlc";
        String user = "bdlc";
        String password = "123";


        System.out.println("ENTER DIRECTORY: ");
        String path = sc.nextLine();
        File directory = new File(path);
        String[] extensions = new String[] {"txt"};


        PsqlConnector connector = new PsqlConnector();
        Connection connection = connector.psqlConnector(url, user, password);

        List<File> files = FileFinder.findFiles(directory, extensions);


        FileToPostgreSQL.fileToPost(connection, files);

    }
}
