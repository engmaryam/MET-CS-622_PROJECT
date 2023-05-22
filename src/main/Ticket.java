package main;

import src.main.Exception.InvalidTicketException;

 public class Ticket {
    private String ticketNumber;

    public Ticket(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void validateTicket() throws InvalidTicketException {
        if (ticketNumber == null || ticketNumber.isEmpty()) {
            throw new InvalidTicketException("Invalid ticket number");
        }
    }
}