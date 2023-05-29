package main;

import java.util.ArrayList;
import java.util.Scanner;
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
}




class Vrl extends BusFeature implements Tickethandler , Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
    protected String key;
    protected String source1;   //CHANGE THIS
    protected int seat;
     protected String type ;
 protected String source;
 protected String destination;
 protected String starttime;
 protected String endtime;
 protected String routeno;
 protected char seatmatrix[][] = new char[40][40];
 protected String uniqKey;
 protected int seats;
 int price= 0;
 static int count= 0;
 int rows = 0;
 int columns = 0;
    //methods from base class and interface
    @Override
    public void adddetails()//method to add details of a bus 
    {    
         Scanner scan = new Scanner(System.in);
         //System.out.println("Enter bus type");
         this.type = scan.nextLine();
         //System.out.println("Enter Destination");
         this.destination = scan.nextLine();
         //System.out.println("Enter Start Time");
         this.starttime = scan.nextLine();
         //System.out.println("Enter End Time");
         this.endtime = scan.nextLine();
         //System.out.println("Enter route no");
         this.routeno = scan.nextLine();
         //System.out.println("Enter Unique Key");
         this.key = scan.nextLine();
         //System.out.println("Enter Price per ticket");
         this.price = scan.nextInt();
         //System.out.println("Enter source");
         this.source = scan.nextLine();
         //createseatmatrix(int rows,int columns);
      

    }

    @Override
    public void typechange(String str)//method to change the bus type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str)//method to change the source
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str)//method to change the destination
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str)//method to change the starttime
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str)//method to change the end time
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str)//method to change the bus route
    {
        this.routeno = str;
    }

    @Override
    public void search()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pricechange(int i)//method to change price
    {
     this.price = i;   
    }
    @Override
    public void bookticket()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix for the bus
    {
      Scanner scan = new Scanner(System.in);
     // System.out.println("Enter the number of rows for this bus ");
      //rows = scan.nextInt();
     // System.out.println("Enter number of columns for this bus ");
      //columns = scan.nextInt();
      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X';//'X' signifies that the bus is vacant
          }
      }
    }

// Methods for the class

public Boolean hastv()//method to check if the bus has a tv facility
{
  if(hastv = true)
      return true;
  else
      return false;
}
public Boolean hascharge()//method to check if the bus has a charging facility
{
  if(haschargepoint = true)
      return true;
  else
      return false;
}
public Boolean haslight()//method to check if the bus has a reading light facility
{
  if(haslight = true)
      return true;
  else
      return false;
}
public void addpassdetails()
{

}

public void displayall()//method to display the contents of the bus
{

        /* System.out.println(" Bus type :"+type);
         System.out.println(" Source :"+source);
         System.out.println(" Destination :"+destination);
         System.out.println("Start Time :"+starttime);
         System.out.println("End Time :"+endtime);
         System.out.println("Route no"+routeno);
         System.out.println("Unique Key"+key);
         System.out.println("Price per ticket"+price);*/
         displayseatmatrix();
}
public void displayseatmatrix()//method to display seat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
       //System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}

public void alterseatmatrix()//method to alter seatmatrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
  // System.out.println("1.change number of rows \n");
  // System.out.println("2.change the number of columns");
  // System.out.println("3.update");
  // System.out.println("enter choice");
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
            //System.out.println("enter number of rows");
            rows = scan.nextInt();
            break;
        case 2:
          //  System.out.println("enter number of columns");
            columns = scan.nextInt();
            break;
        case 3:
            seatmatrix = new char[rows][columns];
            for(int i = 0;i<rows;i++)
             {
               for(int j = 0;j<columns;j++)
               {
                seatmatrix[i][j] = 'X';
               }
             }
            break;
   }
  }while(choice<=3);

}

   
    @Override
    public void getprice() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

















class Durgamba extends BusFeature implements Tickethandler,Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
     protected String type ;
 protected String source;
 protected String destination;
 protected String starttime;
 protected String endtime;
 protected String routeno;
 protected char seatmatrix[][] = new char[40][40];
 protected String uniqKey;
 protected int seats;
 int price;
 static int count= 0;
 int rows = 0;
 int columns = 0;
    protected int seat;
    protected String key;
    //methods from base class and interface
    @Override
    public void adddetails()//method to add details to a bus
    {    Scanner scan = new Scanner(System.in);
         //System.out.println("Enter bus type");
         type = scan.nextLine();
         
         //System.out.println("Enter Destination");
         destination = scan.nextLine();
        // System.out.println("Enter Start Time");
         starttime = scan.nextLine();
        // System.out.println("Enter End Time");
         endtime = scan.nextLine();
        // System.out.println("Enter route no");
         routeno = scan.nextLine();
        // System.out.println("Enter Unique Key");
         key = scan.nextLine();
       //  System.out.println("Enter the price per ticket");
         price = scan.nextInt();
       //   System.out.println("Enter source");
         source = scan.nextLine();
         //createseatmatrix();


    }

    @Override
    public void typechange(String str) //method to change the bus type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str)//method to change the source type
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str)//method to change the destination type
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str)//method to change the start time 
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str)//method to change the endtime 
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str)//method to change the route
    {
        this.routeno = str;
    }

    @Override
    public void search()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getprice()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bookticket()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket()
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix
    {
      Scanner scan = new Scanner(System.in);
      //System.out.println("Enter the number of rows for this bus ");
      rows = scan.nextInt();
     // System.out.println("Enter number of columns for this bus ");
      columns = scan.nextInt();
      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X';//'X' signifies that the seat is vacant
          }
      }
    }

// Methods for the class

public Boolean hastv()//method to check if the bus has a tv
{
  if(hastv = true)
      return true;
  else
      return false;
}
public Boolean hascharge() //method to check if the bus has a charger
{
  if(haschargepoint = true)
      return true;
  else
      return false;
}
public Boolean haslight()//method to check if the bus has a reading light
{
  if(haslight = true)
      return true;
  else
      return false;
}
public void addpassdetails()
{

}

public void displayall()//method to display the bus details
{

       /*  System.out.println(" Bus type :"+type);
         System.out.println(" Source :"+source);
         System.out.println(" Destination :"+destination);
         System.out.println("Start Time :"+starttime);
         System.out.println("End Time :"+endtime);
         System.out.println("Route no"+routeno);
         System.out.println("Unique Key"+key);
         System.out.println("Price per ticket"+price);*/
         displayseatmatrix();
}
public void displayseatmatrix()//method to display theseat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
       //System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}
public void alterseatmatrix()//method to alter the seat matrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
  // System.out.println("1.change number of rows \n");
  // System.out.println("2.change the number of columns");
   //System.out.println("3.update");
   //System.out.println("enter choice");
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
          //  System.out.println("enter number of rows");
            rows = scan.nextInt();
            break;
        case 2:
            //System.out.println("enter number of columns");
            columns = scan.nextInt();
            break;
        case 3:
            seatmatrix = new char[rows][columns];
            for(int i = 0;i<rows;i++)
             {
               for(int j = 0;j<columns;j++)
               {
                seatmatrix[i][j] = 'X';
               }
             }
            break;
   }
  }while(choice<=3);

}

    @Override
    public void pricechange(int i) //method to changeprice per seat
    {
     this.price = i;
    }




}

class PassDtls implements Serializable //class for storing passenger details
{
    String name;
    String contactno;
    String gender;
    String mail;
    int seatrow;
    int seatcol;
    int seat;
    String age;
    String rte;//For route
    
}







 
