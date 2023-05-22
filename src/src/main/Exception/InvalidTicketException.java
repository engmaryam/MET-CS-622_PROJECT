package src.main.Exception;
/*
 * Author Maryam95
 * Date 05/20/2023
 */

public class InvalidTicketException extends BusBookingException {
    public InvalidTicketException(String message) {
        super(message);
    }
}