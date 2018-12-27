package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class buy_screen extends JFrame {

	private JPanel contentPane;
	static DB db;
	private JTextField barcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buy_screen frame = new buy_screen(db);
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
	public buy_screen(DB db) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter The Barcode");
		lblPleaseEnterThe.setBounds(10, 11, 414, 14);
		contentPane.add(lblPleaseEnterThe);
		
		barcode = new JTextField();
		barcode.setBounds(10, 36, 86, 20);
		contentPane.add(barcode);
		barcode.setColumns(10);
		
		JButton btnBuy = new JButton("BUY");
		btnBuy.setBounds(175, 227, 89, 23);
		contentPane.add(btnBuy);
		
		JLabel error = new JLabel("");
		error.setBounds(231, 11, 193, 14);
		contentPane.add(error);
		
		btnBuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (barcode.getText().length() != 9) {
					error.setText("Barcode must be 9 digits");
					return;
				}
				
				else {
					
					try {
						
						error.setText(db.sell(Integer.parseInt(barcode.getText())));
						btnBuy.setVisible(false);
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
			}
		});
		
		
	}

}
