package main;

abstract class BusFeature {
	
	 protected String typef ;
	 protected String sourcef;
	 protected String destinationf;
	 protected String starttimef;
	 protected String endtimef;
	 protected String routenof;
	 protected char seatmatrixf[][];
	 protected String uniqKeyf;
	 protected int seatsf;
	 static int countf= 0;
	 int rowsf = 0;
	 int columnsf = 0;
	 int pricef = 0;
	 //Methods common to all derived classes
	 abstract public void adddetails();
	 abstract public void typechange(String str);
	 abstract public void sourcechange(String str);
	 abstract public void destinationchange(String str);
	 abstract public void starttimechange(String str);
	 abstract public void endtimechange(String str);
	 abstract public void routechange(String str);
	 abstract public void pricechange(int i);
	 abstract public void createseatmatrix(int rows,int columns);
	 abstract public void search();
	 abstract public void getprice();
	}




