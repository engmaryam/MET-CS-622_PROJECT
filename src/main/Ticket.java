package main;

class Ticket<T> {
    private T source;
    private T destination;

    public Ticket(T source, T destination) {
        this.source = source;
        this.destination = destination;
    }

    public Ticket(String route, int row, int column) {
		// TODO Auto-generated constructor stub
	}

	public T getSource() {
        return source;
    }

    public void setSource(T source) {
        this.source = source;
    }

    public T getDestination() {
        return destination;
    }

    public void setDestination(T destination) {
        this.destination = destination;
    }

    public void bookTicket() {
        System.out.println("Ticket booked from " + source + " to " + destination);
        // Add your code here for booking the ticket
    }

	public void cancel() {
		// TODO Auto-generated method stub
		
	}
}
