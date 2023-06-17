package main.db_implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

 public class RegistrationFormApp extends Application {
        public void show() {
            start(new Stage());
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Registration Form");
       	 CustomerTableCreator.createTableIfNotExists();    	 


            Label usernameLabel = new Label("Username:");
            Label passwordLabel = new Label("Password:");
            Label emailLabel = new Label("Email:");
            Label phoneNumberLabel = new Label("Phone Number:");

            TextField usernameField = new TextField();
            PasswordField passwordField = new PasswordField();
            TextField emailField = new TextField();
            TextField phoneNumberField = new TextField();

            Button registerButton = new Button("Register");
            registerButton.setOnAction(e -> register(usernameField.getText(), passwordField.getText(),
                    emailField.getText(), phoneNumberField.getText()));

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(10));
            gridPane.addRow(0, usernameLabel, usernameField);
            gridPane.addRow(1, passwordLabel, passwordField);
            gridPane.addRow(2, emailLabel, emailField);
            gridPane.addRow(3, phoneNumberLabel, phoneNumberField);
            gridPane.addRow(4, registerButton);

            Scene scene = new Scene(gridPane, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        private void register(String username, String password, String email, String phoneNumber) {
            try {
                Connection connection = BusCustomerTable.getConnection();

                String query = "INSERT INTO Customer_info (name, password, email, phoneNumber) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, email);
                statement.setString(4, phoneNumber);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Registration Successful");
                    alert.setHeaderText(null);
                    alert.setContentText("You have successfully registered!");
                    alert.showAndWait();
                    System.out.println("All Customer's Information saved in db  Customer_info Table ");
                }

                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }