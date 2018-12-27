package org.eclipse.wb.swing;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.eclipse.wb.swing.user_frame;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;

public class GUI {

	private JFrame frame;
	private static DB db;
	private final JButton btnAdmin = new JButton("Admin");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					db = new DB("DB.txt", "SALES.txt");
					GUI window = new GUI(db);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI(DB db) {
		initialize(db);
	}

	/**	
	 * Initialize the contents of the frame.
	 */
	private void initialize(DB db) {
		JLabel lblPleaseSelectYour = new JLabel("Please Select Your Type of User");
		frame = new JFrame();
		this.db = db;
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Login_Check ao = new Admin_Login_Check(db);
				ao.setVisible(true);
			}
		});
		btnAdmin.setBounds(45, 137, 120, 31);
		frame.getContentPane().add(btnAdmin);
		
		JButton button = new JButton("Customer");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				user_frame a = new user_frame(db);
				a.setVisible(true);
				
				
			}
		});
		button.setBounds(252, 137, 120, 31);
		frame.getContentPane().add(button);
		
		lblPleaseSelectYour.setBounds(138, 72, 153, 14);
		frame.getContentPane().add(lblPleaseSelectYour);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), btnAdmin, button, lblPleaseSelectYour}));
	}
}
