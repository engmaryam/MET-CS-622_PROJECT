package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class Combo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        String selectedValue = (String) comboBox.getSelectedItem();
        
        // Perform actions based on the selected value
        // Example: Print the selected value
        System.out.println("Selected value: " + selectedValue);
    }
}
    
   