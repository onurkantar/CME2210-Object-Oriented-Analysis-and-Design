package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Admin_Option extends JFrame {

	private JPanel contentPane;
	static DB db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Option frame = new Admin_Option(db);
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
	public Admin_Option(DB db) {
		this.db = db;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddToD = new JButton("ADD TO DATABASE");
		btnAddToD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.repaint();

				JFormattedTextField frmtdtxtfldBarcode = new JFormattedTextField();
				frmtdtxtfldBarcode.setEditable(false);
				frmtdtxtfldBarcode.setText("BARCODE");
				frmtdtxtfldBarcode.setBounds(10, 30, 65, 20);
				contentPane.add(frmtdtxtfldBarcode);

				JFormattedTextField formattedTextField = new JFormattedTextField();
				formattedTextField.setText("NAME");
				formattedTextField.setEditable(false);
				formattedTextField.setBounds(10, 61, 65, 20);
				contentPane.add(formattedTextField);

				JFormattedTextField formattedTextField_1 = new JFormattedTextField();
				formattedTextField_1.setText("QUANTITY");
				formattedTextField_1.setEditable(false);
				formattedTextField_1.setBounds(10, 92, 65, 20);
				contentPane.add(formattedTextField_1);

				JFormattedTextField formattedTextField_2 = new JFormattedTextField();
				formattedTextField_2.setText("PRICE");
				formattedTextField_2.setEditable(false);
				formattedTextField_2.setBounds(10, 123, 65, 20);
				contentPane.add(formattedTextField_2);

				JFormattedTextField formattedTextField_3 = new JFormattedTextField();
				formattedTextField_3.setText("OWNER");
				formattedTextField_3.setEditable(false);
				formattedTextField_3.setBounds(10, 154, 65, 20);
				contentPane.add(formattedTextField_3);

				JFormattedTextField formattedTextField_4 = new JFormattedTextField();
				formattedTextField_4.setText("TYPE");
				formattedTextField_4.setEditable(false);
				formattedTextField_4.setBounds(10, 185, 65, 20);
				contentPane.add(formattedTextField_4);

				JTextArea textArea = new JTextArea();
				textArea.setBounds(107, 30, 271, 20);
				contentPane.add(textArea);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(107, 61, 271, 20);
				contentPane.add(textArea_1);

				JTextArea textArea_2 = new JTextArea();
				textArea_2.setBounds(107, 92, 271, 20);
				contentPane.add(textArea_2);

				JTextArea textArea_3 = new JTextArea();
				textArea_3.setBounds(107, 123, 271, 20);
				contentPane.add(textArea_3);

				JTextArea textArea_4 = new JTextArea();
				textArea_4.setBounds(107, 154, 271, 20);
				contentPane.add(textArea_4);

				JComboBox comboBox = new JComboBox();
				comboBox.setEditable(true);
				comboBox.setBounds(107, 185, 95, 20);
				contentPane.add(comboBox);
				String a = "Book", b = "Movie", c = "Music";
				comboBox.addItem(a);
				comboBox.addItem(b);
				comboBox.addItem(c);
				JButton btnOk = new JButton("OK");
				btnOk.setBounds(289, 213, 89, 23);
				contentPane.add(btnOk);
				btnOk.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							JTextArea textArea_5 = new JTextArea();
							int barcode = Integer.parseInt(textArea.getText());
							if (textArea.getText().length()!= 9) {
//								btnOk.setText("Invalid Input");
								textArea_5.setText("Invalid Input !!");
								textArea_5.setBounds(10, 217, 257, 16);
								textArea_5.setVisible(true);
								contentPane.add(textArea_5);
								textArea_5.setEditable(false);
								return;
							}
							String name = textArea_1.getText();
							int quantity = Integer.parseInt(textArea_2.getText());
							int price = Integer.parseInt(textArea_3.getText());
							String a = textArea_1.getText();
							textArea_5.setText(a + " has been added");
							textArea_5.setBounds(10, 217, 257, 16);
							contentPane.add(textArea_5);
							String owner = textArea_4.getText();
							textArea_5.setEditable(false);

							if (comboBox.getSelectedIndex() == 0) {
								try {
									db.addToDB(barcode, name, quantity, price, 1, owner);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else if (comboBox.getSelectedIndex() == 1) {
								try {
									db.addToDB(barcode, name, quantity, price, 2, owner);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else if (comboBox.getSelectedIndex() == 2) {
								try {
									db.addToDB(barcode, name, quantity, price, 3, owner);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						} catch (Exception e2) {
							// TODO: handle exception
						}

					}
				});
				;

			}
		});
		btnAddToD.setBounds(110, 27, 186, 23);
		contentPane.add(btnAddToD);

		JButton button = new JButton("UPDATE A PRODUCT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();

				JFormattedTextField frmtdtxtfldBarcode = new JFormattedTextField();
				frmtdtxtfldBarcode.setEditable(false);
				frmtdtxtfldBarcode.setText("BARCODE");
				frmtdtxtfldBarcode.setBounds(10, 30, 65, 20);
				contentPane.add(frmtdtxtfldBarcode);

				JFormattedTextField formattedTextField = new JFormattedTextField();
				formattedTextField.setText("NAME");
				formattedTextField.setEditable(false);
				formattedTextField.setBounds(10, 61, 65, 20);
				contentPane.add(formattedTextField);

				JFormattedTextField formattedTextField_1 = new JFormattedTextField();
				formattedTextField_1.setText("QUANTITY");
				formattedTextField_1.setEditable(false);
				formattedTextField_1.setBounds(10, 92, 65, 20);
				contentPane.add(formattedTextField_1);

				JFormattedTextField formattedTextField_2 = new JFormattedTextField();
				formattedTextField_2.setText("PRICE");
				formattedTextField_2.setEditable(false);
				formattedTextField_2.setBounds(10, 123, 65, 20);
				contentPane.add(formattedTextField_2);

				JFormattedTextField formattedTextField_3 = new JFormattedTextField();
				formattedTextField_3.setText("OWNER");
				formattedTextField_3.setEditable(false);
				formattedTextField_3.setBounds(10, 154, 65, 20);
				contentPane.add(formattedTextField_3);

				JFormattedTextField formattedTextField_4 = new JFormattedTextField();
				formattedTextField_4.setText("TYPE");
				formattedTextField_4.setEditable(false);
				formattedTextField_4.setBounds(10, 185, 65, 20);
				contentPane.add(formattedTextField_4);

				JTextArea textArea = new JTextArea();
				textArea.setBounds(107, 30, 271, 20);
				contentPane.add(textArea);

				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(107, 61, 271, 20);
				contentPane.add(textArea_1);

				JTextArea textArea_2 = new JTextArea();
				textArea_2.setBounds(107, 92, 271, 20);
				contentPane.add(textArea_2);

				JTextArea textArea_3 = new JTextArea();
				textArea_3.setBounds(107, 123, 271, 20);
				contentPane.add(textArea_3);

				JTextArea textArea_4 = new JTextArea();
				textArea_4.setBounds(107, 154, 271, 20);
				contentPane.add(textArea_4);

				JComboBox comboBox = new JComboBox();
				comboBox.setEditable(true);
				comboBox.setBounds(107, 185, 95, 20);
				contentPane.add(comboBox);
				String a = "Book", b = "Movie", c = "Music";
				comboBox.addItem(a);
				comboBox.addItem(b);
				comboBox.addItem(c);
				JButton btnOk = new JButton("OK");
				btnOk.setBounds(289, 213, 89, 23);
				contentPane.add(btnOk);
				btnOk.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							JTextArea textArea_5 = new JTextArea();
							int barcode = Integer.parseInt(textArea.getText());
							if (textArea.getText().length()!= 9) {
//								btnOk.setText("Invalid Input");
								textArea_5.setText("Invalid Input !!");
								textArea_5.setBounds(10, 217, 257, 16);
								textArea_5.setVisible(true);
								contentPane.add(textArea_5);
								textArea_5.setEditable(false);
								return;
							}
							String name = textArea_1.getText();
							int quantity = Integer.parseInt(textArea_2.getText());
							int price = Integer.parseInt(textArea_3.getText());
							String a = textArea_1.getText();
							if (db.hasProduct(barcode)) {
								textArea_5.setText(a + " has been updated");
							} else {
								textArea_5.setText(a + " has not been updated");
							}

							textArea_5.setBounds(10, 217, 257, 16);
							contentPane.add(textArea_5);
							String owner = textArea_4.getText();
							textArea_5.setEditable(false);

							if (comboBox.getSelectedIndex() == 0) {
								try {
									db.updateDB(barcode, name, quantity, price, 1, owner);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else if (comboBox.getSelectedIndex() == 1) {
								try {
									db.updateDB(barcode, name, quantity, price, 2, owner);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else if (comboBox.getSelectedIndex() == 2) {
								try {
									db.updateDB(barcode, name, quantity, price, 3, owner);
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}

						} catch (Exception e2) {
							// TODO: handle exception
						}

					}
				});
			}
		});
		button.setBounds(110, 61, 186, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("DELETE A PRODUCT");
		button_1.setBounds(110, 96, 186, 23);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.repaint();
				JTextArea textField = new JTextArea();
				textField.setBounds(152, 106, 211, 29);
				contentPane.add(textField);
				textField.setColumns(10);
				JButton btnOk = new JButton("OK");
				btnOk.setBounds(274, 164, 89, 23);
				contentPane.add(btnOk);
				JTextPane txtpnBarcode = new JTextPane();
				txtpnBarcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtpnBarcode.setEnabled(false);
				txtpnBarcode.setEditable(false);
				txtpnBarcode.setText("Barcode Number");
				txtpnBarcode.setBounds(24, 106, 117, 29);
				contentPane.add(txtpnBarcode);

				btnOk.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							JTextArea textArea_5 = new JTextArea();
							int barcode = Integer.parseInt(textField.getText());
							if (textField.getText().length()!= 9) {
//								btnOk.setText("Invalid Input");
								textArea_5.setText("Invalid Input !!");
								textArea_5.setBounds(10, 217, 257, 16);
								textArea_5.setVisible(true);
								contentPane.add(textArea_5);
								textArea_5.setEditable(false);
								return;
							}
							db.deleteRecord(barcode);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});

			}
		});

		JButton button_2 = new JButton("SEARCH FOR AN ITEM");
		button_2.setBounds(110, 130, 186, 23);
		contentPane.add(button_2);

		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				search_screen sc = new search_screen(db);
				sc.setVisible(true);

			}
		});

		JButton button_3 = new JButton("SEARCH FOR AN USER");
		button_3.setBounds(110, 164, 186, 23);
		contentPane.add(button_3);

		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				search_user su = new search_user(db);
				su.setVisible(true);

			}
		});

		JButton button_4 = new JButton("EXIT");
		button_4.setBounds(110, 198, 186, 23);
		contentPane.add(button_4);

		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				System.exit(0);

			}
		});
	}
}
