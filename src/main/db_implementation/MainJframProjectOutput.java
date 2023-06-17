package main.db_implementation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainJframProjectOutput extends Application {
    private ComboBox<String> patternList; // SOURCE
    private ComboBox<String> list2; // DESTINATION
    private ComboBox<String> dateList; // DATE

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String[] patternExamples = {"Main Road", "Street 1", "Street 2", "Street 3", "Street 4"};
        patternList = new ComboBox<>();
        patternList.getItems().addAll(patternExamples);
        patternList.setEditable(true);

        String[] patternExamples1 = {"Main Road", "Street 1", "Street 2", "Street 3", "Street 4"};
        list2 = new ComboBox<>();
        list2.getItems().addAll(patternExamples1);
        list2.setEditable(true);

        String[] dateExamples = {"2023-06-05", "2023-06-06", "2023-06-07"};
        dateList = new ComboBox<>();
        dateList.getItems().addAll(dateExamples);
        dateList.setEditable(true);

        Button confirm = new Button("Book Ticket");
        Button cancel = new Button("Cancel Ticket");
        Button admin = new Button("Login as Admin");
        Button createAccount = new Button("Create Account");
        Button customerInfo = new Button("Customer Information");
        Button TicketInfo = new Button("Ticket Information");
        TicketInfo.setOnAction(e -> TicketInformationRetrieval.TicketInformationRetriev());


        customerInfo.setOnAction(e -> retrieveCustomerInfo());



        admin.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Login");
            dialog.setHeaderText(null);
            dialog.setContentText("Enter username:");

            dialog.showAndWait().ifPresent(username -> {
                PasswordDialog passwordDialog = new PasswordDialog();
                passwordDialog.setTitle("Login");
                passwordDialog.setHeaderText(null);
                passwordDialog.setContentText("Enter password:");

                passwordDialog.showAndWait().ifPresent(password -> {
                    if (username.equals("Maryam") && password.equals("123456")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Login Successful");
                        alert.setHeaderText(null);
                        alert.setContentText("Welcome, Maryam!");
                        alert.showAndWait();

                        // I will add logic for Admin here later

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Login Failed");
                        alert.setHeaderText(null);
                        alert.setContentText("Invalid username or password. Please try again.");
                        alert.showAndWait();
                    }
                });
            });
        });

        createAccount.setOnAction(e -> {
            RegistrationFormApp registrationForm = new RegistrationFormApp();
            registrationForm.show();
        });

        confirm.setOnAction(e -> {
            String source = patternList.getSelectionModel().getSelectedItem();
            String destination = list2.getSelectionModel().getSelectedItem();
            String date = dateList.getSelectionModel().getSelectedItem();

            // Create a ticket instance based on the selected source, destination, and date
            // Ticket<String> ticket = new Ticket<>(source, destination, date);

            // Read ticket availability information from a file
            String ticketInfo = null;
            try {
                ticketInfo = readTicketAvailabilityFromFile(source, destination, date);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            // Display the ticket availability information in a dialog box
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ticket Availability");
            alert.setHeaderText(null);
            alert.setContentText(ticketInfo);
            alert.showAndWait();

            if (ticketInfo.equals("Ticket available!")) {
                UserForm userForm = new UserForm();
                userForm.show();
            }
        });

        FlowPane buttonFlowPane = new FlowPane();
        buttonFlowPane.setAlignment(Pos.CENTER);
        buttonFlowPane.setHgap(10);
        buttonFlowPane.getChildren().addAll(confirm, cancel, admin, createAccount, customerInfo,TicketInfo);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.addRow(0, new Label("Source:"), patternList);
        gridPane.addRow(1, new Label("Destination:"), list2);
        gridPane.addRow(2, new Label("Date:"), dateList);

        Label lab = new Label("***********************WELCOME***********************");
        lab.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        lab.setWrapText(true);

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));
        borderPane.setTop(lab);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(buttonFlowPane);
        BorderPane.setAlignment(lab, Pos.CENTER);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setTitle("Welcome Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static String readTicketAvailabilityFromFile(String source, String destination, String date) throws FileNotFoundException {
        String filePath = "//Users//maryam.hussein//git//MET-CS-622_PROJECT//Bus//ticket_availability.txt";
        String ticketInfo = "No Ticket available for this information ";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            boolean isTicketAvailable = scanner
                    .useDelimiter("\n")
                    .tokens()
                    .map(line -> line.split(","))
                    .anyMatch(ticketData -> ticketData[0].trim().equals(source) && ticketData[1].trim().equals(destination) && ticketData[3].trim().equals(date));

            if (isTicketAvailable) {
                ticketInfo = "Ticket available!";
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return ticketInfo;
    }

    private static class PasswordDialog extends TextInputDialog {
        PasswordDialog() {
            getDialogPane().getStylesheets().add(
                    PasswordDialog.class.getResource("password-dialog.css").toExternalForm()
            );
            getDialogPane().getStyleClass().add("password-dialog");

            setHeaderText(null);
        }
    }

    

    class UserForm extends Application {
        public void show() {
            start(new Stage());
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("User Form");

            Label nameLabel = new Label("Name:");
            Label genderLabel = new Label("Gender:");
            Label ageLabel = new Label("Age:");
            Label idLabel = new Label("ID:");

            TextField nameField = new TextField();
            TextField genderField = new TextField();
            TextField ageField = new TextField();
            TextField idField = new TextField();

            Button saveButton = new Button("Save");
            saveButton.setOnAction(e -> saveData(nameField.getText(), genderField.getText(),
                    ageField.getText(), idField.getText()));

            VBox vbox = new VBox();
            vbox.setSpacing(10);
            vbox.setPadding(new Insets(10));
            vbox.getChildren().addAll(nameLabel, nameField, genderLabel, genderField, ageLabel, ageField, idLabel, idField, saveButton);

            Scene scene = new Scene(vbox, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void saveData(String name, String gender, String age, String id) {
            try {
                Connection connection = BusCustomerTable.getConnection();

                String query = "INSERT INTO Users (Name, Gender, Age, ID) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, name);
                statement.setString(2, gender);
                statement.setString(3, age);
                statement.setString(4, id);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Data Saved");
                    alert.setHeaderText(null);
                    alert.setContentText("Data has been saved successfully!");
                    alert.showAndWait();
                }

                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void retrieveCustomerInfo() {
        try {
            // Establish a connection to the database
            Connection connection = BusCustomerTable.getConnection();

            // Create a SQL query to retrieve and order records from the Customer_info table
            String query = "SELECT * FROM Customer_info ORDER BY name";
            //name, password, email, phoneNumber

            // Execute the query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Process the retrieved records
            StringBuilder customerInfo = new StringBuilder();
            while (resultSet.next()) {
                // Retrieve data from each column in the current row
                String Name = resultSet.getString("name");
                String Email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("name");
                // ... Retrieve other columns as needed

                // Append the retrieved data to the customerInfo StringBuilder
                customerInfo.append("Name: ").append(Name).append("\n");
                customerInfo.append("Email: ").append(Email).append("\n");
                customerInfo.append("phoneNumber: ").append(phoneNumber).append("\n");
                // ... Append other columns as needed
                customerInfo.append("\n");
            }

            // Close the statement, result set, and connection
            statement.close();
            resultSet.close();
            connection.close();

            // Display the customer information in a dialog box
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Customer Information");
            alert.setHeaderText(null);
            alert.setContentText(customerInfo.toString());
            alert.showAndWait();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
