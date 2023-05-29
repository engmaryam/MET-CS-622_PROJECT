package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainJframProjectOutput extends JFrame {
	private static JFrame frame; // Declare frame as a class-level static variable
    private static String date;
    public static void main(String[] args) {
        String svar; // Variable to record the source data
        String dvar; // Variable to record the destination data
        

        JTextField inputDate = new JTextField("ENTER DATE IN DD-MM-YYYY", 20); // TO INPUT DATE

        JButton confirm = new JButton("Book Ticket");
        JButton cancel = new JButton("Cancel Ticket");
        JButton admin = new JButton("Login as Admin");
        admin.addActionListener(new ButtonHandler2());

        JLabel lab = new JLabel("*********************************************************************************************************************************************WELCOME*********************************************************************************************************************************************");
        Choice ch = new Choice();
        JLabel l1 = new JLabel("Source");
        JLabel l2 = new JLabel("Destination");
        Choice ch2 = new Choice();
        JPanel windowContent;
        ButtonHandler1 listener4 = new ButtonHandler1();
        ButtonHandler2 listener5 = new ButtonHandler2();

        int X, Y;
        Point p;
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolKit.getScreenSize();
        X = screenSize.height;
        Y = screenSize.width;

        frame = new JFrame("Welcome Page");
        JComboBox<String> patternList; // SOURCE
        JComboBox<String> list2; // DESTINATION
        JComboBox<String> dateList; // DATE

        Combo listener1 = new Combo(); // For the Jcombox1, i.e., Source
        Combo1 listener2 = new Combo1(); // For the Jcombox1, i.e., Destination
        Combo2 listener3 = new Combo2(); // For the JComboBox2, i.e., date

        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        JPanel j3 = new JPanel();
        JPanel j4 = new JPanel();

        String[] patternExamples = { "Main Road", "Street 1", "Street 2", "Street 3", "Street 4" };
        svar = patternExamples[0];
        patternList = new JComboBox<>(patternExamples);
        patternList.setEditable(true);
        patternList.addActionListener(listener1);

        String[] patternExamples1 = { "Main Road", "Street 1", "Street 2", "Street 3", "Street 4" };
        dvar = patternExamples1[0];
        list2 = new JComboBox<>(patternExamples1);
        list2.setEditable(true);
        list2.addActionListener(listener2);

        String[] dateExamples = new String[61];
        int k;
        int i = 0;
        for (i = 0; i < 30; i++) {
            k = i + 1;
            dateExamples[i] = k + " MAY" + " 2023";
        }
        for (int j = 0; j < 31; j++) {
            k = j + 1;
            dateExamples[i] = k + " JUNE" + " 2023";
            ++i;
        }
        date = dateExamples[0];
        dateList = new JComboBox<>(dateExamples);
        dateList.setEditable(false);
        dateList.addActionListener(listener3);

        j1.setLayout(new FlowLayout());
        j2.setLayout(new FlowLayout());

        j2.add(l1);
        j2.add(patternList);
        j2.add(l2);
        j2.add(list2);
        j2.add(dateList);

        j1.add(confirm);
        j1.add(cancel);
        j1.add(admin);

        lab.setForeground(Color.red);
        lab.setFont(new Font("Serif", Font.BOLD, 18));

        windowContent = new JPanel();
        windowContent.setLayout(new BorderLayout());
        windowContent.add(lab, BorderLayout.NORTH);
        windowContent.add(j2, BorderLayout.CENTER);
        windowContent.add(j1, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(windowContent);
        frame.setSize(X, Y);
        frame.setVisible(true);
        frame.setBounds(0, 0, 2 * X, Y - 630);
        frame.setIconImage(new ImageIcon("bus.jpg").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static class ButtonHandler1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Action for cancel button
        }
    }

    static class ButtonHandler2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Code for handling the login functionality
            String username = JOptionPane.showInputDialog(frame, "Enter username:"); // Prompt for username
            String password = JOptionPane.showInputDialog(frame, "Enter password:"); // Prompt for password

            // Check if the username and password match the admin credentials
            if (username.equals("Maryam") && password.equals("123456")) {
                // Successful login
                JOptionPane.showMessageDialog(frame, "Login successful. Welcome, Admin!");

                // Perform the desired actions for the admin
                // Add your code here for the admin functionality

            } else {
                // Incorrect credentials
                JOptionPane.showMessageDialog(frame, ";Invalid username or password. Please try again.")

            ;}
        }
    }


    static class Combo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Action for source combo box
        }
    }

    static class Combo1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Action for destination combo box
        }
    }

    static class Combo2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Action for date combo box
        }
    

    
   
        // will use it with Ticket class here
     // Create a BusTicket instance
        Ticket<String> busTicket = new BusTicket("Main Road", 1, 2);
        

        // Create a TrainTicket instance
        Ticket<String> trainTicket = new TrainTicket("Street 1", 3, 4);
        
    }

}
       
       
