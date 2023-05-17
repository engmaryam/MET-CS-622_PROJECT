package main;
import main.Bus;
 
	public class Main{
		    public static void main(String[] args) {
		        // Upcasting and Polymorphism
		        Bus vrlBus = new Vrl("AC SLEEPER", true, true);
		        vrlBus.displayInfo();

		        // Downcasting
		        if (vrlBus instanceof Vrl) {
		            Vrl vrl = (Vrl) vrlBus;
		            System.out.println("VRL Bus Type: " + vrl.getBusType());
		            System.out.println("TV available: " + vrl.hasTV());
		            System.out.println("Light available: " + vrl.hasLight());
		        }
		    }

}
