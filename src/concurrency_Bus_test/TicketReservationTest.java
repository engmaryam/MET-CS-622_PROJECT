package concurrency_Bus_test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import concurrency_Bus.TicketReservation;

public class TicketReservationTest {
    private TicketReservation reservationSystem;

    @BeforeEach
    public void setup() {
        reservationSystem = new TicketReservation(20);
    }

    @Test
    public void testReserveTicket() {
        reservationSystem.reserveTicket("Maryam", "A1");
        reservationSystem.reserveTicket("karam", "A2");

        int expectedAvailableTickets = 18;
        int actualAvailableTickets = reservationSystem.getAvailableTickets();

        Assertions.assertEquals(expectedAvailableTickets, actualAvailableTickets);
    }

    @Test
    public void testCancelTicket() {
        reservationSystem.reserveTicket("maryam", "A1");
        reservationSystem.reserveTicket("karam", "A2");

        reservationSystem.cancelTicket("maray", "A1");

        int expectedAvailableTickets = 19;
        int actualAvailableTickets = reservationSystem.getAvailableTickets();

        Assertions.assertEquals(expectedAvailableTickets, actualAvailableTickets);
    }
}
