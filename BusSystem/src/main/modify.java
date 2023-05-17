package main;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class modify {
    String key;
    String type;
    String startTime;
    String endTime;
    int price;

    public modify(String key, String type, String startTime, String endTime, int price) {
        this.key = key;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public abstract void displayDetails();

    public void typeChange(String newType) {
        this.type = newType;
    }

    public void startTimeChange(String newStartTime) {
        this.startTime = newStartTime;
    }

    public void endTimeChange(String newEndTime) {
        this.endTime = newEndTime;
    }

    public void priceChange(int newPrice) {
        this.price = newPrice;
    }
}



class busses extends Bus {
    public busses(String key, String type, String startTime, String endTime, int price) {
        super(key);
    }

  

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		
	}
}
