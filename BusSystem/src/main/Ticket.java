package main;

import java.awt.*;
import java.awt.event.*;

// Generic class Ticket<T> with type parameter T
 public abstract class Ticket<T> {
    public T route;
    public int row;
    public int column;

    public Ticket(T route, int row, int column) {
        this.route = route;
        this.row = row;
        this.column = column;
    }

    public abstract void cancel();
}

