package concurrency_Bus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicketReservationTask implements Runnable {
    private String customerName;
    private String seat;
    private TicketReservation reservationSystem;
    private PaymentSystem paymentSystem;
    private float price;

    public TicketReservationTask(String customerName, String seat, TicketReservation reservationSystem, PaymentSystem paymentSystem) {
        this.customerName = customerName;
        this.seat = seat;
        this.reservationSystem = reservationSystem;
        this.paymentSystem = paymentSystem;
    }

    @Override
    public void run() {
        reservationSystem.reserveTicket(customerName, seat);
        paymentSystem.makePayment(customerName, seat,price);
        reservationSystem.cancelTicket(customerName, seat);
    }
}
