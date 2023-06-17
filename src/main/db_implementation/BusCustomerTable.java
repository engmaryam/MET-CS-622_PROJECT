package main.db_implementation;

import java.sql.*;

public class BusCustomerTable {
    private static final String jdbcUrl = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9626724";
    private static final String username = "sql9626724";
    private static final String password = "adJaYrCRrX";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }
}

