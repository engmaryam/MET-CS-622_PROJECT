package main;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BusMode {
	
	    

	    public static void main(String[] args) throws IOException, ClassNotFoundException
	    {
	        Scanner scan = new Scanner(System.in);
	        ArrayList<Vrl> vrllist = new ArrayList<Vrl>();//holds list of vrl buse
	        ArrayList<Sugama> sugalist = new ArrayList<Sugama>();//holds list of sugama buses
	        ArrayList<Durgamba> durlist = new ArrayList<Durgamba>(); // holds list of durgamba buses
	        ArrayList<PassDtls> vrlp = new ArrayList();
	        ArrayList<PassDtls> sugap = new ArrayList();
	        ArrayList<PassDtls> durp = new ArrayList();
	         Vrl vcust = new Vrl();
	        ArrayList<Vrl> vcustlist = new ArrayList<Vrl>();
	        Sugama scust = new Sugama();
	        ArrayList<Sugama> scustlist = new ArrayList<Sugama>();
	        Durgamba dcust = new Durgamba();
	        ArrayList<Durgamba> dcustlist = new ArrayList<Durgamba>();
	        int i;
	        int choice;
	       String type[] = {"AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SLEEPER","NON AC SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","NON AC SEMI SLEEPER","NON AC  SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER"};
	        String source[] = {"Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Bangalore","Chennai","Chennai","Chennai","Chennai","Chennai","Chennai","Kochi","Kochi","Kochi","Kochi","Kochi","Kochi","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Manipal","Manipal","Manipal","Manipal","Manipal","Manipal","Manipal"};
	        String []destination = {"Chennai","Chennai","Chennai","Kochi","Kochi","Hyderabad","Hyderabad","Hyderabad","Manipal","Manipal","Manipal","Manipal","Bangalore","Bangalore","Bangalore","Kochi","Hyderabad","Hyderabad","Bangalore","Bangalore","Chennai","Hyderabad","Manipal","Manipal","Bangalore","Bangalore","Bangalore","Chennai","Chennai","Kochi","Manipal","Manipal","Bangalore","Bangalore","Bangalore","Bangalore","Kochi","Kochi","Hyderabad"};       
	        String []startime1 = {"16:30","15:00","23:00","22:00","23:00","14:00","12:00","21:00","22:00","22:45","21:30","20:45","16:30","15:00","23:00","22:00","22:15","13:00","22:00","23:00","22:00","21:00","13:00","14:00","14:00","12:00","23:00","22:15","13:00","21:00","15:00","13:30","22:00","22:45","21:30","20:45","01:00","02:00","15:00"};
	        String []endtime1 = {"22:00","20:00","05:00","08:00","08:20","20:30","18:30","06:30","06:00","06:00","05:45","04:30","21:00","20:00","05:00","08:30","06:00","19:30","08:00","08:20","08:30","07:00","17:30","18:00","20:30","18:30","06:30","06:00","19:30","07:00","07:25","06:40","06:00","06:00","05:45","04:30","17:30","18:00","19:25"};
	        String []startime2 = {"16:40","12:00","23:00","22:30","23:00","12:00","12:10","20:00","22:20","22:15","21:40","20:45","15:30","15:50","23:00","22:10","22:15","14:00","22:50","23:10","22:00","21:20","13:00","13:00","14:00","12:10","23:00","22:45","13:00","21:10","15:00","13:00","22:15","22:35","21:10","20:45","00:00","01:00","14:00"};
	        String []endtime2 = {"22:10","17:00","05:30","08:40","08:30","19:30","19:00","06:00","06:40","05:40","05:45","04:00","22:00","21:00","04:40","08:50","06:30","20:30","08:50","08:20","08:30","08:00","17:00","18:45","20:30","18:40","07:00","06:30","19:50","07:40","07:45","06:10","06:55","06:10","05:00","04:30","16:30","17:00","18:25"};
	        String []startime3 = {"16:00","14:00","23:10","22:00","23:00","16:00","12:00","20:00","22:00","23:15","21:20","21:00","16:30","15:30","23:00","22:40","21:15","13:00","21:00","23:00","22:40","21:00","13:00","13:00","14:30","12:00","23:40","22:45","13:20","21:50","14:00","13:00","22:30","22:45","21:40","20:45","00:30","01:30","15:00"};
	        String []endtime3 = {"22:50","20:00","05:00","08:20","08:30","22:30","18:55","06:15","06:00","06:30","06:05","05:30","22:00","20:00","05:40","09:30","05:30","19:00","07:00","08:20","09:30","06:45","17:30","18:00","21:30","18:30","06:55","06:10","19:40","08:00","06:25","06:20","06:40","07:00","06:15","04:30","17:45","17:30","19:25"};
	        String [][]seatmatrix = new String[20][20];
	        String []uniquekey= {"V1","V2","V3","V4","V5","V6","V7","V8","V9","V10","V11","V12","V13","V14","V15","V16","V17","V18","V19","V20","V21","V22","V23","V24","V25","V26","V27","V28","V29","V30","V31","V32","V33","V34","V35","V36","V37","V38","V39"};
	        String []uniquekey1= {"D1","D2","D3","D4","D5","D6","D7","D8","D9","D10","D11","D12","D13","D14","D15","D16","D17","D18","D19","D20","D21","D22","D23","D24","D25","D26","D27","D28","D29","D30","D31","D32","D33","D34","D35","D36","D37","D38","D39"};
	        String []uniquekey2= {"S1","S2","S3","S4","S5","S6","S7","S8","S9","S10","S11","S12","S13","S14","S15","S16","S17","S18","S19","S20","S21","S22","S23","S24","S25","S26","S27","S28","S29","S30","S31","S32","S33","S34","S35","S36","S37","S38","S39"};
	        int []prices1 =       {600,750,450,600,750,600,750,450,600,600,450,450,600,750,450,600,600,750,600,750,600,600,600,750,600,750,450,600,750,600,600,750,600,600,450,450,600,750,600,750,600};
	        int []prices2 =       {650,720,400,650,720,650,720,400,650,650,400,400,650,720,400,650,650,720,650,720,650,650,650,720,650,720,400,650,720,650,650,720,650,650,400,400,650,720,650,720,650};
	        int []prices3 =       {620,750,500,620,750,620,750,500,620,620,500,500,620,750,500,620,620,750,620,750,620,620,620,750,620,750,500,620,750,620,620,750,620,620,500,500,620,750,620,750,620};
	        
	        
	        int []rows   =  {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	        int []columns = {8,10,8,8,10,8,10,8,8,8,8,8,8,10,8,8,8,10,8,10,8,8,8,10,8,10,8,8,10,8,8,10,8,8,8,8,8,10,8};
	        int j,k;
	        
	        
	        /*OutputStream file = new FileOutputStream("VRLTesting.dat",true);
	        OutputStream buffer = new BufferedOutputStream(file);
	        ObjectOutput output = new ObjectOutputStream(buffer);*/
	        /*OutputStream file1 = new FileOutputStream("DurgambaTesting.dat",true);
	        OutputStream buffer1 = new BufferedOutputStream(file1);
	        ObjectOutput output1 = new ObjectOutputStream(buffer1);*/
	        /*OutputStream file2 = new FileOutputStream("SugamaTesting.dat",true);
	        OutputStream buffer2 = new BufferedOutputStream(file2);
	        ObjectOutput output2 = new ObjectOutputStream(buffer2);*/
	        for(i=0;i<39;i++)      
	        {   Vrl obj = new Vrl();
	            Durgamba obj1=new Durgamba();
	            Sugama obj2=new Sugama();                        
	            obj.type = type[i];
	            obj.source = source[i];
	            obj.destination = destination[i];
	            obj.starttime = startime1[i];
	            obj.endtime = endtime1[i];
	            obj.key = uniquekey[i];
	            obj.price = prices1[i]; //VRL buses are inputted here
	            obj.rows = rows[i];
	            obj.columns = columns[i];
	            
	             for(j = 0;j<obj.rows;j++)
	             { 
	                 for(k = 0;k<obj.columns;k++)
	                     obj.seatmatrix[j][k] = 'X';
	             }
	            obj1.type = type[i];
	            obj1.source = source[i];
	            obj1.destination = destination[i];
	            obj1.starttime = startime2[i];
	            obj1.endtime = endtime2[i];//durgamba buses are inputted here
	            obj1.key = uniquekey1[i];
	            obj1.price = prices2[i];
	            obj1.rows = rows[i];
	            obj1.columns = columns[i];
	             
	            for(j = 0;j<obj1.rows;j++)
	             { 
	                 for(k = 0;k<obj1.columns;k++)
	                     obj1.seatmatrix[j][k] = 'X';
	             }
	            obj2.type = type[i];
	            obj2.source = source[i];
	            obj2.destination = destination[i];
	            obj2.starttime = startime3[i];
	            obj2.endtime = endtime3[i];
	            obj2.key = uniquekey2[i];//Sugama buses are inputted here
	            obj2.price = prices3[i];
	            obj2.rows = rows[i];
	            obj2.columns = columns[i];
	             for(j = 0;j<obj2.rows;j++)
	             { 
	                 for(k = 0;k<obj2.columns;k++)
	                     obj2.seatmatrix[j][k] = 'X';
	             }
	            vrllist.add(obj);//vrl buses added to this list
	            durlist.add(obj1);//durgamba buses added to ths list
	            sugalist.add(obj2);//sugama buses added to this list
	        }
	        File f=new File ("VRLTesting.dat");//file to store vrl buses
	        if(!f.exists())// to check if file exists
	        {  
	        f.createNewFile();
	        OutputStream file = new FileOutputStream(f); // 10/11/13-Removed the true
	        OutputStream buffer = new BufferedOutputStream(file);
	        ObjectOutput output = new ObjectOutputStream(buffer);
	        output.writeObject(vrllist);//writing to vrl file
	        output.close();
	        buffer.close();
	        file.close();
	        }
	        File f1=new File("DurgambaTesting.dat"); // file to store durgamba buses
	        if(!f1.exists())
	        {
	           f1.createNewFile();
	           OutputStream file1 = new FileOutputStream(f1);
	           OutputStream buffer1 = new BufferedOutputStream(file1);
	           ObjectOutput output1 = new ObjectOutputStream(buffer1);
	           output1.writeObject(durlist);//writing to durgamba file
	           output1.close();
	           buffer1.close();
	           file1.close();
	        } 
	       File f2=new File("SugamaTesting.dat"); // file to store sugama buses
	       if(!f2.exists())
	       { 
	        f2.createNewFile();   
	        OutputStream file2 = new FileOutputStream(f2);
	        OutputStream buffer2 = new BufferedOutputStream(file2);
	        ObjectOutput output2 = new ObjectOutputStream(buffer2);
	        output2.writeObject(sugalist); // file to store sugama buses
	        output2.close();
	        buffer2.close();
	        file2.close();
	       } 
	    
	      MainJframProjectOutput ob=new MainJframProjectOutput();
	       }
	// Menus for admin
	   public static  void adminmenu() throws IOException, ClassNotFoundException
	    {
	        Scanner scan = new Scanner(System.in);
	        int i;
	        int choice;
	       // do
	        //{
	        /*  System.out.println("1. Vrl ");
	          System.out.println("2. Sugama");
	          System.out.println("3. Durgamba");
	          System.out.println("4. Exit");
	          System.out.println("Enter your choice ");*/
	       //   i = scan.nextInt();
	         /* switch(i)
	          {
	              case 1:
	              vrladminmenu();
	              break;
	              case 2:
	              sugadminmenu();
	              break;
	              case 3:
	              duradminmenu();
	              break;



	          }
	        }while(i<=3);
	*/

	       }






	 public static void vrladminmenu() throws IOException, ClassNotFoundException
	    {
	       
	        ArrayList<Vrl> vrltemp = new ArrayList();       
	        Vrl obj1 = new Vrl();
	        Scanner scan = new Scanner(System.in);
	        int i;
	        int choice;
	        int count = 0;
	        boolean eof =false;

	        do
	        {
	        /*  System.out.println("1.Add a new bus ");
	          System.out.println("2.Modify the details of existing bus");
	          System.out.println("3.Remove a bus");
	          System.out.println("4.Display a list of all the buses");
	          System.out.println("5. Exit");
	          System.out.println("Enter your choice ");*/
	          i = scan.nextInt();
	          switch(i)
	          {
	              case 1:
	              Vrl obj = new Vrl();
	              FileInputStream f = new FileInputStream("VrlTesting.dat");//open vrl file to read the buses
	              ObjectInputStream objectinput = new ObjectInputStream(f);
	              ArrayList<Vrl> read = (ArrayList<Vrl>) objectinput.readObject();//list containig these buses
	              objectinput.close();
	              obj.adddetails();
	              read.add(obj);//add new bus to list
	              
	              OutputStream file = new FileOutputStream("VrlTesting.dat");
	              OutputStream buffer = new BufferedOutputStream(file);
	              ObjectOutput output = new ObjectOutputStream(buffer);
	             
	              output.writeObject(read);//rewrite contents back to list
	              
	              output.close();
	             
	              break;
	              case 2:
	            	  vrladminmenu();
	              break;
	              case 3:
	             // vrlremove();
	              break;

	              case 4:
	               FileInputStream f1 = new FileInputStream("VrlTesting.dat");
	        
	        try
	       {   
	          ObjectInputStream objectinputstream = new ObjectInputStream(f1);
	          ArrayList<Vrl> readCase = (ArrayList<Vrl>) objectinputstream.readObject();
	          System.out.println(readCase.size());
	          objectinputstream .close();
	          for(i = 0;i<readCase.size();i++)
	          {
	           /* System.out.println(readCase.get(i).type);
	            System.out.println(readCase.get(i).source);
	            System.out.println(readCase.get(i).destination);
	            System.out.println(readCase.get(i).starttime);
	            System.out.println(readCase.get(i).endtime);
	            System.out.println(readCase.get(i).key);
	            System.out.println(readCase.get(i).price);*/
	            readCase.get(i).displayseatmatrix();
	          }
	          
	              


	        }
	               catch (Exception e) 
	               {
	                 e.printStackTrace();
	               }
	        break;          
	     }

	        }while(i<=4);


	    }
	 
	   public static  void duradminmenu() throws IOException, ClassNotFoundException
	    {


	        Durgamba obj1 = new Durgamba();
	        Scanner scan = new Scanner(System.in);
	        int i;
	        int choice;
	        int count = 0;

	        do
	        {
	          /*System.out.println("1.Add a new bus ");
	          System.out.println("2.Modify the details of existing bus");
	          System.out.println("3.Remove a bus");
	          System.out.println("4.Display a list of all the buses");
	          System.out.println("5. Exit");
	          System.out.println("Enter your choice ");*/
	          i = scan.nextInt();
	          switch(i)
	          {
	              case 1:
	              Durgamba obj = new Durgamba();
	              FileInputStream f = new FileInputStream("DurgambaTesting.dat");//opening file to read the buses
	              ObjectInputStream objectinput = new ObjectInputStream(f);
	              ArrayList<Durgamba> read = (ArrayList<Durgamba>) objectinput.readObject();//list contining all the buses
	              objectinput.close();
	              obj.adddetails();
	              read.add(obj);//adding a new bus to the list
	              
	              OutputStream file = new FileOutputStream("DurgambaTesting.dat");
	              OutputStream buffer = new BufferedOutputStream(file);
	              ObjectOutput output = new ObjectOutputStream(buffer);
	             
	              output.writeObject(read);//re writing the modified list
	              
	              output.close();
	              break;
	              case 2:
	              duradminmenu();
	              break;
	              case 3:
//	              durremove();
	              break;
	              case 4:
	              FileInputStream f1 = new FileInputStream("DurgambaTesting.dat");
	        
	        try
	       {   
	          ObjectInputStream objectinputstream = new ObjectInputStream(f1);
	          ArrayList<Durgamba> readCase = (ArrayList<Durgamba>) objectinputstream.readObject();
	          objectinputstream .close();
	          for(i = 0;i<readCase.size();i++)
	          {
	            /*System.out.println(readCase.get(i).type);
	            System.out.println(readCase.get(i).source);
	            System.out.println(readCase.get(i).destination);
	            System.out.println(readCase.get(i).starttime);
	            System.out.println(readCase.get(i).endtime);
	            System.out.println(readCase.get(i).key);
	            System.out.println(readCase.get(i).price);*/
	            readCase.get(i).displayseatmatrix();
	          }
	              
	              


	        }
	               catch (Exception e) 
	               {
	                 e.printStackTrace();
	               }
	              break;


	          }
	        }while(i<=4);



	 }

}
