package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class search_screen extends JFrame {

	private JPanel contentPane;
	private static DB db;
	private JTextField value;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_screen frame = new search_screen(db);
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
	public search_screen(DB db) {
		search_screen.db = db;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchBy = new JLabel("Search By ?");
		lblSearchBy.setBounds(10, 24, 109, 14);
		contentPane.add(lblSearchBy);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(268, 24, 46, 14);
		contentPane.add(lblValue);
		
		value = new JTextField();
		value.setBounds(243, 46, 86, 20);
		contentPane.add(value);
		value.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(240, 77, 89, 23);
		contentPane.add(btnSearch);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 58, 134, 20);
		contentPane.add(comboBox);
		
		JLabel error = new JLabel("");
		error.setBounds(10, 180, 186, 14);
		contentPane.add(error);
		
		JTextArea result_screen = new JTextArea();
		result_screen.setBounds(173, 124, 261, 137);
		contentPane.add(result_screen);
		

		
		
		
		String Barcode = "Barcode";
		String Name = "Name";
		String Price = "Price";
		String ADA = "Author/Director/Artist";
		
		
		comboBox.addItem(Barcode);
		comboBox.addItem(Name);
		comboBox.addItem(Price);
		comboBox.addItem(ADA);
		String searchVal = "";
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					
				if (comboBox.getSelectedIndex() == 0) {
					if (value.getText().length() != 9) {
						error.setText("Barcode must be 9 digits !!");
						return;
					}
					
					else {
						result_screen.setText(db.searchDB(1, value.getText().toString()));
						
						return;
					}
				}
				
				else if (comboBox.getSelectedIndex() == 1) {
					result_screen.setText(db.searchDB(2, value.getText().toString()));
					return;

				}
				
				else if (comboBox.getSelectedIndex() == 2) {
					result_screen.setText(db.searchDB(4, value.getText().toString()));
					return;

				}
				
				else {
					result_screen.setText(db.searchDB(5, value.getText().toString()));
					return;

				}
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
	}
}
