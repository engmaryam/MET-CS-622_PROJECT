package main.db_implementation;

	import java.sql.*;
	/*
	 * the class will fitching the information from Two tables using Join
	 * 
	 */

	public class TicketInfoCustmerInfo{

	    
                    public static void main(String[] args) {
                        try {

            	            // Establishing a database connection
                            Connection connection = BusCustomerTable.getConnection();

                            // Create a SQL query to retrieve records from the TicketReserved_information and Customer_info tables
                            String query = "SELECT t.ticket_id, t.source, t.destination, t.date, c.name, c.email, c.phoneNumber " +
                                           "FROM TicketReserved_information t " +
                                           "JOIN Customer_info c ON t.customer_name = c.name";

                            // Execute the query
                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery(query);

                            // Process the retrieved records
                            StringBuilder ticketInfo = new StringBuilder();
                            while (resultSet.next()) {
                                // Retrieve data from each column in the current row
                                int ticketId = resultSet.getInt("ticket_id");
                                String source = resultSet.getString("source");
                                String destination = resultSet.getString("destination");
                                String date = resultSet.getString("date");
                                String customerName = resultSet.getString("name");
                                String customerEmail = resultSet.getString("email");
                                String customerPhone = resultSet.getString("phoneNumber");

                                // Append the retrieved data to the ticketInfo StringBuilder
                                ticketInfo.append("Ticket ID: ").append(ticketId).append("\n");
                                ticketInfo.append("Source: ").append(source).append("\n");
                                ticketInfo.append("Destination: ").append(destination).append("\n");
                                ticketInfo.append("Date: ").append(date).append("\n");
                                ticketInfo.append("Customer Name: ").append(customerName).append("\n");
                                ticketInfo.append("Customer Email: ").append(customerEmail).append("\n");
                                ticketInfo.append("Customer Phone: ").append(customerPhone).append("\n");
                                ticketInfo.append("\n");
                            }

                            // Print the aggregated ticket and customer information
                            System.out.println(ticketInfo.toString());

                            // Close the connection
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
