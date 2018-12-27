package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class user_entered extends JFrame {

	private JPanel contentPane;
	static User user;
	static DB db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_entered frame = new user_entered(user,db);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public user_entered(User user,DB db) {
		this.user = user;
		this.db = db;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setBounds(194, 11, 60, 14);
		contentPane.add(lblWelcome);
		
		JLabel username = new JLabel("");
		username.setBounds(194, 36, 46, 14);
		contentPane.add(username);
		username.setText(user.getName());
		
		JLabel lblPleaseSelectYour = new JLabel("Please Select Your Option");
		lblPleaseSelectYour.setBounds(146, 78, 185, 14);
		contentPane.add(lblPleaseSelectYour);
		
		JButton btnNewButton = new JButton("Search an Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search_screen sc = new search_screen(db);
				sc.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 119, 120, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buy an Item");
		btnNewButton_1.setBounds(158, 119, 120, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				buy_screen byscrn = new buy_screen(db);
				byscrn.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(306, 119, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.exit(0);
				
			}
		});
		
		
	}

}
