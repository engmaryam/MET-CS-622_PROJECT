package main;

import java.util.ArrayList;
import java.io.Serializable;

abstract class Bus {
    private String busType;

    public Bus(String busType) {
        this.busType = busType;
    }

    public String getBusType() {
        return busType;
    }

    public abstract void displayInfo();

	public void displayDetails() {
		// TODO Auto-generated method stub
		
	}
}

class Vrl extends Bus implements Serializable {
    private boolean hasTV;
    private boolean hasLight;

    public Vrl(String busType, boolean hasTV, boolean hasLight) {
        super(busType);
        this.hasTV = hasTV;
        this.hasLight = hasLight;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public boolean hasLight() {
        return hasLight;
    }

    @Override
    public void displayInfo() {
        System.out.println("VRL Bus Type: " + getBusType());
        System.out.println("TV available: " + hasTV());
        System.out.println("Light available: " + hasLight());
    }

}


