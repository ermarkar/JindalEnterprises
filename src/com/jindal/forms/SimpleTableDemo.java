/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.forms;

import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
 
public class SimpleTableDemo extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7271636704107757870L;
	
	final Object[][] data = {
    {"Mary", "Campione", "Snowboarding", "5"},
    {"Alison", "Huml", "Rowing", "3"},
    {"Kathy", "Walrath", "Chasing toddlers", "2"},
    {"Mark", "Andrews", "Speed reading", "20"},
    {"Angela", "Lih", "Teaching high school", "4"}
    };
    final Object[] columnNames = {"First Name",
                              "Last Name",
                              "Sport",
                              "Est. Years Experience"};
    public SimpleTableDemo() {
    JTable table = new JTable(data, columnNames);
    //JTable table = new JTable(4, 4);
    
        //Create the scroll pane and add the table to it.
    JScrollPane scrollPane = JTable.createScrollPaneForTable(table);
    scrollPane.setPreferredSize(new Dimension(400, 100));
 
    //Add the scroll pane to this panel.
    setLayout(new GridLayout(1, 0));
        add(scrollPane);
    }
 
    public static void main(String[] args) {
    JFrame frame = new JFrame("SimpleTableDemo");
 
    frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
        });
 
    frame.getContentPane().add("Center", new SimpleTableDemo());
    //frame.setSize(400, 125);
    frame.pack();
    frame.setVisible(true);
    }
}


