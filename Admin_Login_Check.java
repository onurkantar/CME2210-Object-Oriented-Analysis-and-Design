package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Admin_Login_Check extends JFrame {

	static DB db;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login_Check frame = new Admin_Login_Check(db);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin_Login_Check(DB db) {
		this.db = db;
		JFrame guiFrame = new JFrame();
		guiFrame.setBounds(100, 100, 450, 300);
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		guiFrame.setTitle("Admin Login");
		guiFrame.setSize(300,200);

		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);

		JTextArea tracker = new JTextArea("Password Tracker:");
		guiFrame.add(tracker);

		JPanel userPanel = new JPanel();
		userPanel.setLayout(new GridLayout(2,2));
		JLabel usernameLbl = new JLabel("Username:");
		JLabel passwordLbl = new JLabel("Password:");
		JTextField username = new JTextField();
		JPasswordField passwordFld = new JPasswordField();
		userPanel.add(usernameLbl);
		userPanel.add(username);
		userPanel.add(passwordLbl);
		userPanel.add(passwordFld);

		int input = JOptionPane.showConfirmDialog(guiFrame, userPanel, "Enter your password:"
		,JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		char[] correctPassword = {'a', 'd', 'a', 'l', 'i','m'};
		if (input == 0) //OK Button = 0
		{
		tracker.append("\nUsername entered was: " + username.getText());
		//Retrieve password
		char[] enteredPassword = passwordFld.getPassword();
		tracker.append("\nPassword entered was: " + String.valueOf(enteredPassword));
		if (Arrays.equals(correctPassword, enteredPassword))
		{
		tracker.append("\nThe password entered is correct!");
		Admin_Option ao = new Admin_Option(db);
		guiFrame.setVisible(false);
		ao.setVisible(true);
		}
		else
		{
		tracker.append("\nWho are you????Call The SECURTY!!!");
		}

		}
		else
		{
		tracker.append("\nDialog cancelled..");
		}
		}}

	
