package src.main.Exception;
/*
 * Author Maryam95
 * Date 05/22/2023
 */

public class InsufficientSeatsException extends BusBookingException {
    public InsufficientSeatsException(String message) {
        super(message);
    }
}