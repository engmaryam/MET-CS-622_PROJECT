package main.db_implementation;

import java.sql.*;

public class BusAggregation {
    public static void main(String[] args) {
    	 try {
        Connection connection = BusCustomerTable.getConnection();

             Statement stmt = connection.createStatement();
            // Fetching the total number of buses
            ResultSet resultSet = stmt.executeQuery("SELECT COUNT(*) AS totalBuses FROM BusInfo");
            if (resultSet.next()) {
                int totalBuses = resultSet.getInt("totalBuses");
                System.out.println("Total Buses: " + totalBuses);
            }

            // Fetching the sum of total seats
            resultSet = stmt.executeQuery("SELECT SUM(totalSeats) AS totalSeatSum FROM BusInfo");
            if (resultSet.next()) {
                int totalSeatSum = resultSet.getInt("totalSeatSum");
                System.out.println("Total Seats Sum: " + totalSeatSum);
            }

            // Fetching the average fare
            resultSet = stmt.executeQuery("SELECT AVG(fare) AS averageFare FROM BusInfo");
            if (resultSet.next()) {
                double averageFare = resultSet.getDouble("averageFare");
                System.out.println("Average Fare: " + averageFare);
            }

            // Fetching the maximum distance
            resultSet = stmt.executeQuery("SELECT MAX(distance) AS maxDistance FROM BusInfo");
            if (resultSet.next()) {
                double maxDistance = resultSet.getDouble("maxDistance");
                System.out.println("Maximum Distance: " + maxDistance);
            }

            // Fetching the minimum available seats
            resultSet = stmt.executeQuery("SELECT MIN(availableSeats) AS minAvailableSeats FROM BusInfo");
            if (resultSet.next()) {
                int minAvailableSeats = resultSet.getInt("minAvailableSeats");
                System.out.println("Minimum Available Seats: " + minAvailableSeats);
            }

            // Fetching the total fare for all buses
            resultSet = stmt.executeQuery("SELECT SUM(fare) AS totalFare FROM BusInfo");
            if (resultSet.next()) {
                double totalFare = resultSet.getDouble("totalFare");
                System.out.println("Total Fare: " + totalFare);
            }

        } catch (SQLException e) {
            System.out.println("Error executing SQL query: " + e.getMessage());
        }
    }
}

