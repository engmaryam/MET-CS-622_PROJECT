package concurrency_Bus;

public class TicketReservation {
    private int availableTickets;
    private Object lock; // Lock object for synchronization

    public TicketReservation(int availableTickets) {
        this.availableTickets = availableTickets;
        this.lock = new Object();
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public void reserveTicket(String customerName, String seat) {
        synchronized (lock) {

            System.out.println("Reserving ticket for " + customerName + " - Seat: " + seat);
            // ... reservation logic ...
            availableTickets--;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Ticket reserved for " + customerName + " - Seat: " + seat + ". Available Tickets: " + availableTickets);
        }
    }
    /*
     * 
     * In the cancelTicket method, I have added synchronization using the lock object. 
     * The cancellation logic is implemented within the synchronized block. 
     * When a ticket is canceled, the availableTickets count is incremented, 
     * and a delay of 1 second is introduced to simulate some processing time.
     *  Afterward, a message is printed to indicate the cancellation 
     *  and the updated number of available tickets.
     * 
     */

    public void cancelTicket(String customerName, String seat) {
        synchronized (lock) {
            System.out.println("Canceling ticket for " + customerName + " - Seat: " + seat);
            availableTickets++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            

            System.out.println("Ticket canceled for " + customerName + " - Seat: " + seat + ". Available Tickets: " + availableTickets);
        }
    }
}
