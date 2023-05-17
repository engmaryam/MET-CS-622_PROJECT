package main;

import java.awt.*;
import java.awt.event.*;


abstract class Ticket {
    protected String route;
    protected int row;
    protected int column;

    public Ticket(String route, int row, int column) {
        this.route = route;
        this.row = row;
        this.column = column;
    }

    public abstract void cancel();
}

class BusTicket extends Ticket {
    public BusTicket(String route, int row, int column) {
        super(route, row, column);
    }

    @Override
    public void cancel() {
        // I will do code here
    }
}

class TrainTicket extends Ticket {
    public TrainTicket(String route, int row, int column) {
        super(route, row, column);
    }

    @Override
    public void cancel() {
        // Same I will do code here later on
    }
}