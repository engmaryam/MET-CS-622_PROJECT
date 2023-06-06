package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public User(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    

    public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void saveToFile() {// this method  implement write Object 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("//Users//maryam.hussein//git//MET-CS-622_PROJECT//Bus//user_information.txt"))) {
            oos.writeObject(this);
            System.out.println("User information saved to user_information file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readInfoAndPrint() { // this method to implement 
    	 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user_information.txt"))) {
             User user = (User) ois.readObject();
             System.out.println("User information read from user_information after save it as a binary Object ");
             System.out.println("First Name: " + user.getFirstName());
             System.out.println("Last Name: " + user.getLastName());
             System.out.println("Phone Number: " + user.getPhoneNumber());
             System.out.println("Email Address: " + user.getEmailAddress());
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
     }


    public void readAllUsers(List<String> userFilePaths) {
        userFilePaths.stream()
                .forEach(filePath -> readInfoAndPrint());
    }
    
}
