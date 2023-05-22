package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


abstract class AdminMenu {
    JFrame frame;
    JPanel windowContent = new JPanel();

    JButton but1 = new JButton("ADD A BUS");
    JButton but2 = new JButton("MODIFY A BUS");
    JButton but3 = new JButton("REMOVE A BUS");
    JButton but4 = new JButton("BOOK A TICKET");
    JButton backbut = new JButton("Back");
    ButtonHandler5 butlistener = new ButtonHandler5();
    int flag = 0;
    JLabel welcome;

    String company;
    ButtonHandler1 listener1 = new ButtonHandler1();
    ButtonHandler2 listener2 = new ButtonHandler2();
    ButtonHandler3 listener3 = new ButtonHandler3();
    ButtonHandler4 listener4 = new ButtonHandler4();

    int X, Y;

    public AdminMenu(String company) {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        java.awt.Dimension screenSize = toolKit.getScreenSize();
        X = screenSize.height;
        Y = screenSize.width;
        frame = new JFrame(company + " ADMIN");
        frame.setVisible(true);
        frame.setSize(X, Y);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.company = company;
        welcome = new JLabel(
                "***************************************************************************WELCOME TO " + company.toUpperCase()
                        + " ADMIN MENU***************************************************************************");

        but1.addActionListener(listener1);
        but2.addActionListener(listener2);
        but3.addActionListener(listener3);
        but4.addActionListener(listener4);
        backbut.addActionListener(butlistener);

        welcome.setForeground(Color.red);
        welcome.setFont(new Font("Helvetica", Font.BOLD, 18));
        windowContent.setLayout(new GridLayout(0, 1));
        windowContent.add(welcome);
        windowContent.add(but1);
        windowContent.add(but2);
        windowContent.add(but3);
        windowContent.add(but4);
        windowContent.add(backbut);
        frame.setContentPane(windowContent);
        frame.setBounds(0, 0, 2 * X, Y);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public abstract void addButton1Action();

    public abstract void addButton2Action();

    public abstract void addButton3Action();

    public abstract void addButton4Action();

    private class ButtonHandler1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addButton1Action();
            frame.dispose();
        }
    }

    private class ButtonHandler2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addButton2Action();
            frame.dispose();
        }
    }

    private class ButtonHandler3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addButton3Action();
            frame.dispose();
        }
    }

    private class ButtonHandler4 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addButton4Action();
            frame.dispose();
        }
    }

    private class ButtonHandler5 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Main ob = new Main();
            frame.dispose();
        }
    }
}