package concurrency_Bus;

public class TicketReaservationMain {
    public static void main(String[] args) {
        // Create the ticket reservation system
    	int availableTickets =9; // for example
        TicketReservation reservationSystem = new TicketReservation(20);

        // Create the payment system
        PaymentSystem paymentSystem = new PaymentSystem();

        // Reserve tickets
        reservationSystem.reserveTicket("Alice", "A1");
        reservationSystem.reserveTicket("Bob", "A2");
        reservationSystem.reserveTicket("Charlie", "B1");
        reservationSystem.reserveTicket("Dave", "B2");
        reservationSystem.reserveTicket("Eve", "C1");

        // Print the available tickets after reservation
        System.out.println("Available Tickets: " + reservationSystem.getAvailableTickets());

     // Make payments
        paymentSystem.makePayment("Alice", "A1", 50.0);
        paymentSystem.makePayment("Bob", "A2", 60.0);
        paymentSystem.makePayment("Charlie", "B1", 70.0);
        paymentSystem.makePayment("Dave", "B2", 80.0);
        paymentSystem.makePayment("Eve", "C1", 90.0);

        // Print the available tickets after payment
        System.out.println("Available Tickets: " + reservationSystem.getAvailableTickets());

        // Cancel tickets
        reservationSystem.cancelTicket("Alice", "A1");
        reservationSystem.cancelTicket("Bob", "A2");
        reservationSystem.cancelTicket("Charlie", "B1");
        reservationSystem.cancelTicket("Dave", "B2");
        reservationSystem.cancelTicket("Eve", "C1");

        // Print the available tickets after cancellation
        System.out.println("Available Tickets: " + reservationSystem.getAvailableTickets());
    }
}
