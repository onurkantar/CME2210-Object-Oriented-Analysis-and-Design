package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class user_frame extends JFrame {

	private JPanel contentPane;
	private static user_frame frame;
	private JTextField name;
	private JTextField age_place;
	private JTextField city;
	private JTextField mail;
	private static DB db;
	private JTextField premiumNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new user_frame(db);
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
	public user_frame(DB db) {
		this.db = db;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name");
		lblPleaseEnterYour.setBounds(10, 11, 414, 14);
		contentPane.add(lblPleaseEnterYour);
		
		name = new JTextField();
		name.setBounds(10, 36, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblPleaseEnterYour_1 = new JLabel("Please Enter Your Age");
		lblPleaseEnterYour_1.setBounds(10, 59, 414, 14);
		contentPane.add(lblPleaseEnterYour_1);
		
		age_place = new JTextField();
		age_place.setBounds(10, 84, 86, 20);
		contentPane.add(age_place);
		age_place.setColumns(10);
		
		JLabel lblPleaseEnterYour_2 = new JLabel("Please Enter Your City");
		lblPleaseEnterYour_2.setBounds(10, 115, 414, 14);
		contentPane.add(lblPleaseEnterYour_2);
		
		city = new JTextField();
		city.setBounds(10, 140, 86, 20);
		contentPane.add(city);
		city.setColumns(10);
		
		JLabel lblPleaseEnterA = new JLabel("Please Enter A Valid E-mail");
		lblPleaseEnterA.setBounds(10, 171, 414, 14);
		contentPane.add(lblPleaseEnterA);
		
		mail = new JTextField();
		mail.setBounds(10, 196, 244, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(181, 227, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel error = new JLabel("");
		error.setBounds(279, 202, 145, 14);
		contentPane.add(error);
		
		JLabel lblPremiumUser = new JLabel("Premium User ?");
		lblPremiumUser.setBounds(262, 59, 119, 14);
		contentPane.add(lblPremiumUser);
		
		JLabel lblPleaseEnterYour_3 = new JLabel("Please Enter Your Number :");
		lblPleaseEnterYour_3.setBounds(262, 84, 162, 14);
		contentPane.add(lblPleaseEnterYour_3);
		
		premiumNumber = new JTextField();
		premiumNumber.setBounds(272, 112, 86, 20);
		contentPane.add(premiumNumber);
		premiumNumber.setColumns(10);
		
		JButton btnPremiumLogin = new JButton("Premium Login");
		btnPremiumLogin.setBounds(269, 140, 133, 23);
		contentPane.add(btnPremiumLogin);
		
		btnPremiumLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (db.hasUser(Integer.parseInt(premiumNumber.getText())) != null) {
					Premium_User temp = db.hasUser(Integer.parseInt(premiumNumber.getText()));
					db.createUser(temp.getName(),temp.getAge(),temp.geteMail(),temp.getCity());
					user_entered nextStep = new user_entered(temp,db);
					nextStep.setVisible(true);	
				}
				
			}
		});
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(262, 11, 89, 23);
		contentPane.add(btnRegister);
		
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				RegisterPage rgp = new RegisterPage(db);
				rgp.setVisible(true);
				
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				error.setText("");
				try
				
				{
					
					int a;
					String age=age_place.getText();
					a=Integer.parseInt(age);
					}

				catch (NumberFormatException e1)

				{
						error.setText("Invalid Age");
						return;
				
				}
				
				try {
					if (!(mail.getText().contains("@") && mail.getText().contains(".com"))) {

						Exception a = new ArithmeticException();
						throw a;
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					error.setText("Invalid mail address !!");
					return;
				}
				
				
				
				
					User user = new User(name.getText(),Integer.parseInt(age_place.getText()),mail.getText(),city.getText());
					db.createUser(name.getText(),Integer.parseInt(age_place.getText()),mail.getText(),city.getText());
					user_entered nextStep = new user_entered(user,db);
					nextStep.setVisible(true);	
				
				
				
				

				
				
				
			}
		});
	}
}
