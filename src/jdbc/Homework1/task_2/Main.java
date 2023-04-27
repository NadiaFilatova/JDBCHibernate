package src.jdbc.Homework1.task_2;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Используя дополнительное задания все вопросы записать
// в текстовом файле с новой строки каждый и используя потоки ввода-вывода считать с файла все запросы и выполнить.
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/Task_6";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        File file = new File("src/jdbc/Homework1/task_2/test.txt");
        registerDriver();
        readFile(file);
    }

    private static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();

            while (scanner.hasNextLine()) {
                String sql = scanner.nextLine();
                System.out.println(sql + " - the contents of the file");
                statement.execute(sql);
            }
        } catch (IOException | SQLException e) {
            System.err.println("Exception: " + e);
        }
    }


    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLException: " + e);
        }
    }
}
