package main;

/*
 * Author Maryam95
 * Date 05/20/2023
 */

import src.main.Exception.BusBookingException;
import src.main.Exception.InsufficientSeatsException;
import src.main.Exception.InvalidSeatException;

public 
class BusBookingSystem {
    public void bookTicket(int requestedSeats) throws BusBookingException {
        try {
            if (requestedSeats <= 0) {
                throw new InvalidSeatException("Invalid number of seats");
            }

            int availableSeats = 10;
            if (requestedSeats > availableSeats) {
                throw new InsufficientSeatsException("Insufficient seats available");
            }

        } catch (InvalidSeatException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientSeatsException e) {

            System.out.println("Error: " + e.getMessage());
        } catch (BusBookingException e) {
  
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
  
            System.out.println("Unhandled Exception: " + e.getMessage());
       
        }
    }
}
