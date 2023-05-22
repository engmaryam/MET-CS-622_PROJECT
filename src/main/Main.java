package main;
/*
 * Author Maryam95
 * Date 05/20/2023
 */
import main.Bus;
import main.exception.BusException;
import src.main.Exception.BusBookingException;
import java.io.*;


 
public class Main {
    public static void main(String[] args) throws IOException {
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
        }
        System.out.println("---------------------------------------------");
    System.out.println("this is  file I/O Implementation");
        BusInformationIO busInfo = new BusInformationIO("src/bus_information.txt");
        BusInformationIO.writeBusInformation("Information about Bus we can write it here .still thinking what I can do for fileI/o ");
        busInfo.readBusInformation();
       
        }
    }

    


