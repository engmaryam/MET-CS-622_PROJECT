package main.db_implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerTableCreator {
    private static final String jdbcUrl = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9626724";
    private static final String username = "sql9626724";
    private static final String password = "adJaYrCRrX";

    public static void createTableIfNotExists() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS Customer_info (" +
                             "id INT AUTO_INCREMENT PRIMARY KEY," +
                             "name VARCHAR(50) NOT NULL," +
                             "password VARCHAR(50) NOT NULL," +
                             "email VARCHAR(50) NOT NULL," +
                             "phoneNumber VARCHAR(20) NOT NULL" +
                             ")"
             )) {

            statement.executeUpdate();
            System.out.println("Table created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
