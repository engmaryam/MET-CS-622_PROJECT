package concurrency_Bus;


public class TicketCounter {
	    private int ticketCount;

	    public TicketCounter(int initialCount) {
	        this.ticketCount = initialCount;
	    }

	    public int getTicketCount() {
	        return ticketCount;
	    }

	    public void incrementTicketCount() {
	        // Simulate some delay
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        ticketCount++;
	    }
	}



