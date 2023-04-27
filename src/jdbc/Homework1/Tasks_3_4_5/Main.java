package src.jdbc.Homework1.Tasks_3_4_5;

import java.sql.*;
import java.util.function.Consumer;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String CONTACT_DETAILS = """
            SELECT name_staff, phone, address FROM staff
            INNER JOIN
            personalInfo
            ON staff.id = personalInfo_id""";

    private static final String DIVORCED_PERSONS = """
            SELECT name_staff, birth_day, phone FROM personalInfo
            INNER JOIN
            staff
            ON personalInfo.personalInfo_id = staff.id
            WHERE personalInfo.maritalStatus IN ('неодружений','розведена', 'неодружена') 
            """;


    private static final String MANAGERS = """
            SELECT name_staff, birth_day, phone FROM serviceInfo
            INNER JOIN
            personalInfo
            ON id = personalInfo_id
            INNER JOIN
            staff
            ON serviceInfo.id = staff.id
            WHERE position_staff = 'Менеджер'
            """;

    public static void main(String[] args) {
        registerDriver();
        contactDetails();
        divorcedPersons();
        managers();
    }

    //  1) Получите контактные данные сотрудников (номера телефонов, место жительства).
    private static void contactDetails() {
        System.out.println("ContactDetails table (name_staff, phone, address)");
        selectAndPrint(CONTACT_DETAILS, resultSet -> {
            try {
                String name_staff = resultSet.getString("name_staff");
                String phone = resultSet.getString("phone");
                String address = resultSet.getNString("address");

                System.out.println(name_staff + " " + phone + " " + address);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    // 2) Получите информацию о дате рождения всех холостых сотрудников и их номера.
    private static void divorcedPersons() {
        System.out.println("DivorcedPersons table (name, birthday, phone)");
        selectAndPrint(DIVORCED_PERSONS, resultSet -> {
            try {
                String name_staff = resultSet.getString("name_staff");
                Date birth_day = resultSet.getDate("birth_day");
                String phone = resultSet.getNString("phone");

                System.out.println(name_staff + " " + birth_day + " " + phone);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    // 3) Получите информацию обо всех менеджерах компании: дату рождения и номер телефона.

    private static void managers() {
        System.out.println("Managers table (name, birthday, phone)");
        selectAndPrint(MANAGERS, resultSet -> {
            String name_staff = string(resultSet, "name_staff");
            Date birth_day = date(resultSet, "birth_day");
            String phone = string(resultSet, "phone");
            System.out.println(name_staff + " " + birth_day + " " + phone);
        });
    }

    private static void selectAndPrint(String query, Consumer<ResultSet> processor) {
        try {
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                processor.accept(resultSet);
            }

            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String string(ResultSet resultSet, String fieldName) {
        try {
            return resultSet.getString(fieldName);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e);
            return null;
        }
    }

    private static Date date(ResultSet resultSet, String fieldName) {
        try {
            return resultSet.getDate(fieldName);
        } catch (SQLException e) {
            System.err.println("SQLException: " + e);
            return null;
        }
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
