package src.jdbc.Homework1.Task_6;
// Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
// Заполнить ее данными с помощью запросов MySQL в IntelijIdea. Используя JDBC написать пример выполнения всех запросов.

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/Task_6";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String NEW_INSERT = "INSERT INTO info(fName, lName, age, phone, address)" +
            "VALUES(?,?,?,?,?)";
    private static final String SELECT_ALL = "SELECT * FROM info";

    public static void main(String[] args) throws RuntimeException {
        registerDriver();
        truncate();
        insertOne("Anna", "Katrine", 26, "0964455888", "st.13");
        insertOne("Sasha", "Fith", 35, "096665000", "st.3222");
        insertOne("Nadia", "Fil", 10, "0679927890", "st.30097");
        setSelectAll();
    }

    private static void insertOne(String firstName, String lastName, int age, String phone, String address) {
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(NEW_INSERT);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, phone);
            statement.setString(5, address);
            statement.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e);
        }
    }

    private static void truncate() {
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE info");
            statement.execute();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e);
        }
    }

    private static void setSelectAll() {
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            statement.execute();

            ResultSet resultSet = statement.executeQuery();
            System.out.println("All info");

            while (resultSet.next()) {
                String fName = resultSet.getString("fName");
                String lName = resultSet.getString("lName");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                System.out.println(fName + " " + lName + " " + age + " " + phone + " " + address);
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println("SQLException: " + e);
        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
