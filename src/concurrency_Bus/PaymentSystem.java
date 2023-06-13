package concurrency_Bus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PaymentSystem {
    private ExecutorService executorService;

    public PaymentSystem() {
        // Create a thread pool with a fixed number of threads
        int numThreads = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(numThreads);
    }

    public void makePayment(String customerName, String seat, double amount) {
        executorService.execute(() -> {
            // Simulate payment process
            System.out.println("Processing payment for " + customerName + " - Seat: " + seat + " - Amount: $" + amount);

            // Perform payment logic
            boolean paymentSuccessful = processPayment(customerName, seat, amount);

            if (paymentSuccessful) {
                System.out.println("Payment successful for " + customerName + " - Seat: " + seat);
            } else {
                System.out.println("Payment failed for " + customerName + " - Seat: " + seat);
            }
        });
    }

    private boolean processPayment(String customerName, String seat, double amount) {
        // Simulate payment processing
        // Assume payment is successful if the amount is greater than zero
        if (amount > 0) {
            // Perform actual payment processing here
            // e.g., interact with payment gateway, validate payment details, update payment status, etc.
            return true;
        } else {
            return false;
        }
    }

    public void shutdown() {
        // Shutdown the executor service when no longer needed
        executorService.shutdown();
    }
}
