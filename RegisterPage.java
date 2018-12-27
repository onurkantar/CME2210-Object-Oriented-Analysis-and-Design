package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterPage extends JFrame {

	private JPanel contentPane;

	static DB db;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage(db);
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
	public RegisterPage(DB db) {
		this.db = db;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name");
		lblPleaseEnterYour.setBounds(10, 11, 414, 14);
		contentPane.add(lblPleaseEnterYour);
		
		JTextField name = new JTextField();
		name.setBounds(10, 36, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblPleaseEnterYour_1 = new JLabel("Please Enter Your Age");
		lblPleaseEnterYour_1.setBounds(10, 59, 414, 14);
		contentPane.add(lblPleaseEnterYour_1);
		
		JTextField age_place = new JTextField();
		age_place.setBounds(10, 84, 86, 20);
		contentPane.add(age_place);
		age_place.setColumns(10);
		
		JLabel lblPleaseEnterYour_2 = new JLabel("Please Enter Your City");
		lblPleaseEnterYour_2.setBounds(10, 115, 414, 14);
		contentPane.add(lblPleaseEnterYour_2);
		
		JTextField city = new JTextField();
		city.setBounds(10, 140, 86, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel lblPleaseEnterA = new JLabel("Please Enter A Valid E-mail");
		lblPleaseEnterA.setBounds(10, 171, 414, 14);
		contentPane.add(lblPleaseEnterA);
		
		JTextField mail = new JTextField();
		mail.setBounds(10, 196, 244, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnLogin = new JButton("Register");
		btnLogin.setBounds(181, 227, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel premnumber = new JLabel("");
		premnumber.setBounds(260, 115, 164, 14);
		contentPane.add(premnumber);
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				premnumber.setText("");
				try
				
				{
					
					int a;
					String age=age_place.getText();
					a=Integer.parseInt(age);
					}

				catch (NumberFormatException e1)

				{
					premnumber.setText("Invalid Age");
						return;
				
				}
				
				try {
					if (!(mail.getText().contains("@") && mail.getText().contains(".com"))) {

						Exception a = new ArithmeticException();
						throw a;
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					premnumber.setText("Invalid mail address !!");
					return;
				}
				
				
				
				
					User user = new User(name.getText(),Integer.parseInt(age_place.getText()),mail.getText(),city.getText());
					Premium_User newUser ;
					db.createUser(name.getText(),Integer.parseInt(age_place.getText()),mail.getText(),city.getText());
					if (db.USERS.size() == 0) {
						newUser = new Premium_User(name.getText(),Integer.parseInt(age_place.getText()),mail.getText(),city.getText(), 0);
						try {
							db.addToUsers(newUser);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						newUser = new Premium_User(name.getText(),Integer.parseInt(age_place.getText()),mail.getText(),city.getText(), db.USERS.size());
					
						try {
							db.addToUsers(newUser);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					premnumber.setText("PremNumber = " + newUser.getPremNumber());
					btnLogin.setVisible(false);
				
				
				

				
				
				
			}
		});

	}

}
