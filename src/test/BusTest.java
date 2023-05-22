package test;
/*
 * Author :Maryam95
 * BusTest to start using Junit test in my project to test out the Functions of Project
 */


import org.junit.Test;
import static org.junit.Assert.*;

public class BusTest {

    @Test
    public void testVrlDisplayDetails() {
        Bus vrlBus = new Vrl("VRL123", "AC Sleeper", "9:00 AM", "6:00 PM", 500);
        vrlBus.displayDetails();

    }


    @Test
    public void testTypeChange() {
        Bus vrlBus = new Vrl("VRL123", "AC Sleeper", "9:00 AM", "6:00 PM", 500);
        vrlBus.typeChange("AC Seater");
    }

    @Test
    public void testStartTimeChange() {
        Bus vrlBus = new Vrl("VRL123", "AC Sleeper", "9:00 AM", "6:00 PM", 500);
        vrlBus.startTimeChange("8:30 AM");

    }

    @Test
    public void testEndTimeChange() {
        Bus vrlBus = new Vrl("VRL123", "AC Sleeper", "9:00 AM", "6:00 PM", 500);
        vrlBus.endTimeChange("5:30 PM");

    }

    @Test
    public void testPriceChange() {
        Bus vrlBus = new Vrl("VRL123", "AC Sleeper", "9:00 AM", "6:00 PM", 500);
        vrlBus.priceChange(600);
    }

}


abstract class Bus {
    String key;
    String type;
    String startTime;
    String endTime;
    int price;

    public Bus(String key, String type, String startTime, String endTime, int price) {
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

class Vrl extends Bus {
    public Vrl(String key, String type, String startTime, String endTime, int price) {
        super(key, type, startTime, endTime, price);
    }

    @Override
    public void displayDetails() {
        System.out.println("VRL Bus Details:");
        System.out.println("Key: " + key);
        System.out.println("Type: " + type);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Price: " + price);
        System.out.println();
    }
}

class busses extends Bus {
    public busses(String key, String type, String startTime, String endTime, int price) {
        super(key, type, startTime, endTime, price);
    }

    @Override
    public void displayDetails() {
        System.out.println("Bus Details:");
        System.out.println("Key: " + key);
        System.out.println("Type: " + type);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Price: " + price);
        System.out.println();
    }
}
