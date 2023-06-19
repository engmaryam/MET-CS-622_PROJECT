package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.db_implementation.BusCustomerTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class BusCustomerTableTest {
    private static Connection connection;

    @BeforeAll
    public static void setUp() {
        try {
            connection = BusCustomerTable.getConnection();
        } catch (SQLException e) {
            fail("Failed to establish a database connection: " + e.getMessage());
        }
    }

    @Test
    public void testConnection() throws SQLException {
        assertNotNull(connection);
        assertFalse(connection.isClosed());
    }
}
