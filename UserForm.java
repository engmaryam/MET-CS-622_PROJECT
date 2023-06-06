package main;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.User;

 public class UserForm extends Stage {
        UserForm() {
            VBox root = new VBox();
            root.setPadding(new Insets(10));
            root.setSpacing(10);

            TextField firstNameField = new TextField();
            TextField lastNameField = new TextField();
            TextField phoneNumberField = new TextField();
            TextField emailAddressField = new TextField();

            root.getChildren().addAll(
                    new Label("First Name:"), firstNameField,
                    new Label("Last Name:"), lastNameField,
                    new Label("Phone Number:"), phoneNumberField,
                    new Label("Email Address:"), emailAddressField
            );

            Button submitButton = new Button("Submit");
            submitButton.setOnAction(e -> {
                // Get the user input and save it
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String emailAddress = emailAddressField.getText();

                // Create a User object and write it to a file
                User user = new User(firstName, lastName, phoneNumber, emailAddress);
                user.saveToFile();
                user.readInfoAndPrint();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Saved");
                alert.setHeaderText(null);
                alert.setContentText("Your information has been saved correctly. Your request will be handled and forwarded to the payment process.");
                alert.showAndWait();

            //    PaymentForm paymentForm = new PaymentForm();
             //   paymentForm.show();

                close(); // Close the user information form
            });

            root.getChildren().add(submitButton);

            Scene scene = new Scene(root);
            setScene(scene);
        }
    }