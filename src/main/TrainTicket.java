package main;


	// Subclass TrainTicket
 public class TrainTicket extends Ticket<String> {
	    public Object route;
		public Integer row;
		public Integer column;

		public TrainTicket(String route, int row, int column) {
	        super(route, row, column);
	    }

	    @Override
	    public void cancel() {
	        // Code specific to canceling a train ticket
	    }
	}



