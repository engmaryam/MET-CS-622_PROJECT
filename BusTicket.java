package main;

	// Subclass BusTicket
	 public class BusTicket extends Ticket<String> {
	    public Object route;
		public Integer row;
		public Integer column;

		public BusTicket(String route, int row, int column) {
	        super(route, row, column);
	    }

	    @Override
	    public void cancel() {
	        // Code specific to canceling a bus ticket
	    }
	}



