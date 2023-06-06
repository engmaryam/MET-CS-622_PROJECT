package test;

	import org.junit.jupiter.api.Test;

import main.BusTicket;
import main.TrainTicket;

import static org.junit.jupiter.api.Assertions.assertEquals;

	public class TicketTest {

	    @Test
	    public void testBusTicketCancel() {
	        // Create a BusTicket object
	        BusTicket busTicket = new BusTicket("Route 1", 1, 2);

	        // Call the cancel method
	        busTicket.cancel();

	        // Assert that the cancel method was called (you can add specific assertions here)
	    }

	    @Test
	    public void testTrainTicketCancel() {
	        // Create a TrainTicket object
	        TrainTicket trainTicket = new TrainTicket("Route 2", 3, 4);

	        // Call the cancel method
	        trainTicket.cancel();

	        // Assert that the cancel method was called (you can add specific assertions here)
	    }

	    @Test
	    public void testBusTicketInitialization() {
	        // Create a BusTicket object
	        BusTicket busTicket = new BusTicket("Route 1", 1, 2);

	        // Verify the route, row, and column values are initialized correctly
	        assertEquals("Route 1", busTicket.route);
	        assertEquals(1, busTicket.row);
	        assertEquals(2, busTicket.column);
	    }

	    @Test
	    public void testTrainTicketInitialization() {
	        // Create a TrainTicket object
	        TrainTicket trainTicket = new TrainTicket("Route 2", 3, 4);

	        // Verify the route, row, and column values are initialized correctly
	        assertEquals("Route 2", trainTicket.route);
	        assertEquals(3, trainTicket.row);
	        assertEquals(4, trainTicket.column);
	    }
	}



