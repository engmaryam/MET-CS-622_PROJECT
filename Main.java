package main;
/*
 * Author Maryam95
 * Date 05/20/2023
 */
import main.Bus;
import main.exception.BusException;
import src.main.Exception.BusBookingException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


 
public class Main {
    public static void main(String[] args) throws IOException {
      /*
      // Upcasting and Polymorphism
        Bus vrlBus = new Vrl("AC SLEEPER", true, true);
        vrlBus.displayInfo();

        // Downcasting
        if (vrlBus instanceof Vrl) {
            Vrl vrl = (Vrl) vrlBus;
            System.out.println("VRL Bus Type: " + vrl.getBusType());
            System.out.println("TV available: " + vrl.hasTV());
            System.out.println("Light available: " + vrl.hasLight());
            
            System.out.println("week 2 of the class 622");
            System.out.println("---------------------------------------");
            
            BusBookingSystem bookingSystem = new BusBookingSystem();
            try {
                bookingSystem.bookTicket(5);
                bookingSystem.bookTicket(15);
                bookingSystem.bookTicket(0);
                bookingSystem.bookTicket(-5);
            } catch (BusBookingException e) {
               
                System.out.println("Error occurred while booking ticket: " + e.getMessage());
            }
        }*/
        System.out.println("---------------------------------------------");
    System.out.println("this is  file I/O Implementation");
        BusInformationIO busInfo = new BusInformationIO("src/bus_information.txt");
        BusInformationIO.writeBusInformation("Information about Bus we can write it here .still thinking what I can do for fileI/o ");
        busInfo.readBusInformation();
        
        System.out.println("Assigment 3 Show using Generics in the project ");
        
        // Example to call Ticket which is Genercs
        
        Ticket<String> busTicket = new BusTicket("Main Road", 1, 2);
        // Call the cancel() method on the busTicket instance
        busTicket.cancel();

        // Create a TrainTicket instance
        Ticket<String> trainTicket = new TrainTicket("Street 1", 3, 4);
        // Call the cancel() method on the trainTicket instance
        trainTicket.cancel();
       
                // Example usage of generics method
                BusInfo.generics(" Show on console how can we use the generics"); // Generic type T is inferred as String
                BusInfo.generics(10); // Generic type T is inferred as Integer
                BusInfo.generics(3.14); // Generic type T is inferred as Double
                BusInfo.generics(true); // Generic type T is inferred as Boolean

                // Example usage of getFirstElement method
                List<String> stringList = new ArrayList<>();
                stringList.add("Bus1");
                stringList.add("Bus2");
                stringList.add("Bus3");
                String firstString = BusInfo.getFirstElement(stringList); // Generic type T is inferred as String
                System.out.println("First String: " + firstString);

                List<Integer> integerList = new ArrayList<>();
                integerList.add(10);
                integerList.add(20);
                integerList.add(30);
                Integer firstInteger = BusInfo.getFirstElement(integerList); // Generic type T is inferred as Integer
                System.out.println("First Integer: " + firstInteger);

                // Example usage of processPair method
                String name = "Maryam";
                Integer age = 25;
                BusInfo.processPair(name, age); // Generic types T and U are inferred as String and Integer respectively
            }
        }

        

        
        
      
    


       
        
    
    
    

    

