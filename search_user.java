package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;

public class search_user extends JFrame {

	private JPanel contentPane;
	private JTextField mail;
	static DB db;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_user frame = new search_user(db);
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
	public search_user(DB db) {
		this.db = db;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter The Email");
		lblPleaseEnterThe.setBounds(10, 11, 162, 14);
		contentPane.add(lblPleaseEnterThe);
		
		mail = new JTextField();
		mail.setBounds(10, 36, 261, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(10, 67, 89, 23);
		contentPane.add(btnSearch);
		
		JTextArea result = new JTextArea();
		result.setBounds(10, 101, 414, 149);
		contentPane.add(result);
		
		
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				result.setText(db.searchSales(mail.getText()));
				
				
			}
		});
	}
}
