package main.db_implementation;

import java.sql.*;

import javafx.scene.control.Alert;

public class TicketInformationRetrieval {

	public static  void TicketInformationRetriev() {
	    try {
	        // Establish a connection to the database
	        Connection connection = BusCustomerTable.getConnection();

	        // Create a SQL query to retrieve and order records from the TicketReserved_information table
	        String query = "SELECT * FROM TicketReserved_information ORDER BY ticket_id";

	        // Execute the query
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
//INSERT INTO `TicketReserved_information`(`ticket_id`, `source`, `destination`, `date`, `customer_name`, `customer_email`, `customer_phone`) 

	        // Process the retrieved records
	        StringBuilder ticketInfo = new StringBuilder();
	        	while (resultSet.next()) {
	        	    // Retrieve data from each column in the current row
	        	    int ticketId = resultSet.getInt("ticket_id");
	        	    String source = resultSet.getString("source");
	        	    String destination = resultSet.getString("destination");
	        	    String date = resultSet.getString("date");
	        	    String customer_name = resultSet.getString("customer_name");
	        	    String customer_email = resultSet.getString("customer_email");
	        	    String customer_phone = resultSet.getString("customer_phone");


	        	    

	        	    // Append the retrieved data to the ticketInfo StringBuilder
	        	    ticketInfo.append("Ticket ID: ").append(ticketId).append("\n");
	        	    ticketInfo.append("Source: ").append(source).append("\n");
	        	    ticketInfo.append("Destination: ").append(destination).append("\n");
	        	    ticketInfo.append("Date: ").append(date).append("\n");
	        	    ticketInfo.append("Customer Name: ").append(customer_name).append("\n");
	        	    ticketInfo.append("Customer Email ").append(customer_email).append("\n");
	        	    ticketInfo.append("Customer Phone ").append(customer_phone).append("\n");


	        	    ticketInfo.append("\n");
	        	}

	        // Close the statement, result set, and connection
	        statement.close();
	        resultSet.close();
	        connection.close();

	        // Display the ticket information in a dialog box
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Ticket Information");
	        alert.setHeaderText(null);
	        alert.setContentText(ticketInfo.toString());
	        alert.showAndWait();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
}