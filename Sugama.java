package main;

import java.io.Serializable;
import java.util.Scanner;

public class Sugama extends BusFeature implements Tickethandler , Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
    protected String key;
    protected String type ;
    protected String source;
    protected String destination;
    protected String starttime;
    protected String endtime;
    protected String routeno;
   public char seatmatrix[][] = new char[40][40];
    protected String uniqKey;
   protected int seats;
 static int count= 0;
 public int rows = 0;
 public int columns = 0;
 int price;
    @Override
    public void adddetails() // Method to add details of a bus
    {    Scanner scan = new Scanner(System.in);
        // System.out.println("Enter bus type");
         type = scan.nextLine();
        
         //System.out.println("Enter Destination");
         destination = scan.nextLine();
        // System.out.println("Enter Start Time");
         starttime = scan.nextLine();
        // System.out.println("Enter End Time");
         endtime = scan.nextLine();
         //System.out.println("Enter route no");
         routeno = scan.nextLine();
         //System.out.println("Enter Unique Key");
         key = scan.nextLine();
         //System.out.println("Enter price per seat");
         price = scan.nextInt();
          //System.out.println("Enter source");
         source = scan.nextLine();
       //  createseatmatrix();

    }

    @Override
    public void typechange(String str) // method to change the type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str) // method to change the source
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str) // method to change the destination
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str) // method to change the starttime
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str) //method to change the end time 
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str) // method to change the route
    {
        this.routeno = str;
    }


    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix of a given bus
    {
      Scanner scan = new Scanner(System.in);

      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X'; // 'X' signifies that the seat is vacant 
          }
      }
    }

// Methods for the class

public Boolean hastv() // to check if the bus provides a tv facility
{
  if(hastv = true)
      return true;
  else
      return false;
}
public Boolean hascharge()//to check if bus provides a charger facility
{
  if(haschargepoint = true)
      return true;
  else
      return false;
}
public Boolean haslight()// to check if the bus provides a reading light
{
  if(haslight = true)
      return true;
  else
      return false;
}
/*public void addpassdetails()
{

}*/

public void displayall() // method to display the details of the bus
{


         displayseatmatrix();
}
public void displayseatmatrix() //method to display the seat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
      System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}

public void alterseatmatrix() // method to alter the seat matrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
 
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
           // System.out.println("enter number of rows");
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
    public void pricechange(int i) 
    {
     this.price = i;  
    }

    @Override
    public void search() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getprice() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bookticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}

