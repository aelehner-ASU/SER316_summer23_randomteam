 * UserAccountsPanel.java
 * Runs window for user log in and creating new account
 *
 * @author Anna Lehner
 * @version 7/8/23 Sprint 3
 */
package main.java.memoranda.ui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;

public class UserAccountsPanel {
	
	/**
	 * Opening User Accounts Window
	 */
	public UserAccountsPanel() {
        final JFrame frame = new JFrame("User Account");
        final JPanel panel = new JPanel();
        // Login
        JButton logb = new JButton("Login");
        
        logb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showInputDialog(frame,"Username:"); 
            	JOptionPane.showInputDialog(frame,"Password:");
                frame.dispose();
            }
        });
        
        // NewAccount
        JButton newUAb = new JButton("Create New Account");
        newUAb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	newAccountPanel();
                frame.dispose();
            }
        });
        
        panel.add(logb);
        panel.add(newUAb);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	/**
	 * New Account Window
	 */
	public void newAccountPanel() {

        JFrame NAframe = new JFrame("New User");
        JPanel buttonPane = new JPanel();
        JPanel fieldsPanel = new JPanel();
        JRadioButton student = new JRadioButton();
        student.setActionCommand("S");
        student.setSelected(true);
        JRadioButton trainer = new JRadioButton();
        trainer.setActionCommand("T");
        student.setText("Student");
        trainer.setText("Trainer");
        JLabel username = new JLabel("Username:");
        JLabel password = new JLabel("Password");
        JLabel beltrank = new JLabel("Belt Rank:");
        JTextField usernameField = new JTextField("");
        JTextField passwordField = new JTextField("");
        String[] beltRankStrings = {"WHITE", "YELLOW", "ORANGE", "PURPLE", "BLUE", 
        		"BLUE STRIPE", "GREEN", "GREEN STRIPE", "BROWN 1", "BROWN 2",
        		"BLACK 1", "BLACK 2", "BLACK 3" };
        JComboBox beltRankList = new JComboBox(beltRankStrings);
        beltRankList.setSelectedIndex(0);
        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.PAGE_AXIS));
        buttonPane.setLayout(new FlowLayout());
        
        ButtonGroup group = new ButtonGroup();
        group.add(student);
        group.add(trainer);

        fieldsPanel.add(student);
        fieldsPanel.add(trainer);
        fieldsPanel.add(username);
        fieldsPanel.add(usernameField);
        fieldsPanel.add(password);
        fieldsPanel.add(passwordField);
        fieldsPanel.add(beltrank);
        fieldsPanel.add(beltRankList);
        buttonPane.add(create);
        buttonPane.add(cancel);
        NAframe.add(fieldsPanel, BorderLayout.PAGE_START);
        NAframe.add(buttonPane, BorderLayout.PAGE_END);

        NAframe.pack();
        NAframe.setLocationRelativeTo(null);
        NAframe.setVisible(true);
        
        /**
         * Action Listener for "Create" button, calls constructor and write() for UserAccount
         */
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String inUsername = usernameField.getText();
            	String inPassword = passwordField.getText();
            	int a;
            	if(group.getSelection().getActionCommand().compareTo("S") == 0) {
            		a = 1;
            		}
            	else {
            		a = 0;
            		}
            	int b = beltRankList.getSelectedIndex();
            	try {
            	UserAccount newUA = new UserAccount(inUsername, inPassword, a, b);
            	newUA.write();
            	}
            	catch (IOException ex) {};
                NAframe.dispose();
                NAframe.setVisible(false);
            }           
        });
        /**
         * Action Listener for "Cancel" button, closes window
         */
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	NAframe.dispose();
            	NAframe.setVisible(false);
            }
        });
	}
}
