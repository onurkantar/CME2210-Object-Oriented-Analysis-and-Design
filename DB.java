package org.eclipse.wb.swing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class DB {

	private static String DBNAME;
	private static String TABLE;
	private static String PREMS = "USERS.txt";
	ArrayList<User> SELLTABLE = new ArrayList<>();
	ArrayList<Premium_User> USERS = new ArrayList<>();
	BufferedWriter writer = null;
	ArrayList<Product> ARLPR = new ArrayList<>();
	private User currentUser;

	public DB(String DBNAME, String transac) throws FileNotFoundException, IOException, ClassNotFoundException {

		this.DBNAME = DBNAME;
		this.TABLE = transac;
		File f = new File(DBNAME);
		File fs = new File(TABLE);
		File fu = new File(PREMS);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			ARLPR = (ArrayList<Product>) ois.readObject();
			ObjectInputStream tableOis = new ObjectInputStream(new FileInputStream(fs));
			SELLTABLE = (ArrayList<User>) tableOis.readObject();
			ObjectInputStream userOis = new ObjectInputStream(new FileInputStream(fu));
			USERS = (ArrayList<Premium_User>) userOis.readObject();
			System.out.println("Older File is Loaded");
		} catch (Exception e) {
			// TODO: handle exception
			try {
				
				ObjectInputStream tableOis = new ObjectInputStream(new FileInputStream(fs));
				SELLTABLE = (ArrayList<User>) tableOis.readObject();
				ObjectInputStream userOis = new ObjectInputStream(new FileInputStream(fu));
				USERS = (ArrayList<Premium_User>) userOis.readObject();
				
			} catch (Exception e2) {
				// TODO: handle exception
				try {
					
					ObjectInputStream userOis = new ObjectInputStream(new FileInputStream(fu));
					USERS = (ArrayList<Premium_User>) userOis.readObject();
					
				} catch (Exception e3) {
					// TODO: handle exception
					
				}
			}
		}

	}
	
	public String addToUsers(Premium_User user) throws FileNotFoundException, IOException {
		File fu = new File(PREMS);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fu));
		USERS.add(user);
		
		oos.writeObject(USERS);
		oos.flush();
		oos.close();
		return "Successfully Registered !!";
		
		
	}
	
	public Premium_User hasUser(int premNumber) {
		for (int i = 0; i < USERS.size(); i++) {
			if (USERS.get(i).getPremNumber() == premNumber) {
				return USERS.get(i);
			}
			
		}
		return null;
		
	}

	public void addToDB(int barcode, String name, int quantity, int price, int typeSelection, String ADA)
			throws IOException {

		File f = new File(DBNAME);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		Product pr = new Product(barcode, name.toLowerCase(), quantity, price, typeSelection, ADA.toLowerCase());
		// ARLPR = ois.readObject();
		ARLPR.add(pr);

		oos.writeObject(ARLPR);
		oos.flush();
		oos.close();

		System.out.println("Successfuly Added To DB");

	}

	public static String getDBNAME() {
		return DBNAME;
	}

	public static void setDBNAME(String dBNAME) {
		DBNAME = dBNAME;
	}

	public void updateDB(int barcode, String name, int quantity, int price, int typeSelection, String ADA)
			throws FileNotFoundException, IOException {
		File f = new File(DBNAME);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		boolean flagCheck = false;

		for (int i = 0; i < ARLPR.size(); i++) {
			if (ARLPR.get(i).getBarcode() == barcode) {
				Product pr = new Product(barcode, name.toLowerCase(), quantity, price, typeSelection,
						ADA.toLowerCase());
				ARLPR.set(i, pr);
				flagCheck = true;
			}
		}

		if (flagCheck) {
			oos.writeObject(ARLPR);
			System.out.println("FILE SUCCESSFULLY UPDATED !!!");
			oos.close();
		} else {
			System.out.println("NO MATCHING BARCODE !!!");
		}

	}

	public void deleteRecord(int barcode) throws FileNotFoundException, IOException {
		File f = new File(DBNAME);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		boolean flagCheck = false;

		for (int i = 0; i < ARLPR.size(); i++) {
			if (ARLPR.get(i).getBarcode() == barcode) {

				if (ARLPR.size() == 1) {
					ARLPR.remove(0);
					flagCheck = true;
				}

				else {

					for (int j = 1; j < ARLPR.size(); j++) {
						ARLPR.set(j - 1, ARLPR.get(j));
						flagCheck = true;

					}

				}
			}
		}

		if (flagCheck) {
			oos.flush();
			oos.writeObject(ARLPR);
			oos.close();
			System.out.println("SuccessFully Deleted !! ");
		} else {
			System.out.println("NO MATCHING BARCODE !!");
		}

	}

	public boolean hasProduct(int barcode) {
		boolean flagCheck = false;
		for (int i = 0; i < ARLPR.size(); i++) {
			if (ARLPR.get(i).getBarcode() == barcode) {
				flagCheck = true;
			}
		}

		return flagCheck;

	}

	public String searchDB(int attSelection, String attValue) {


		String retVal = "";
		
		switch (attSelection) {
		case 1:
			for (int i = 0; i < ARLPR.size(); i++) {
				if (String.valueOf(ARLPR.get(i).getBarcode()).equals(attValue)) {
					System.out.println("FOUND !!");
					System.out.print("Barcode : " + ARLPR.get(i).getBarcode() + "\n" + "Name : " + ARLPR.get(i).getName()
							+ "//Quantity : " + ARLPR.get(i).getQuantity() + "// Price : " + ARLPR.get(i).getPrice()
							+ "//Type : " + ARLPR.get(i).getType() + "//" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n");
					retVal += "Barcode : " + ARLPR.get(i).getBarcode() + "\nName : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "\nPrice : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "-" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n";
				}
			}
			break;

		case 2:

			for (int i = 0; i < ARLPR.size(); i++) {
				if (ARLPR.get(i).getName().equals(attValue)) {
					System.out.println("FOUND !!");
					System.out.print("Barcode : " + ARLPR.get(i).getBarcode() + "// Name : " + ARLPR.get(i).getName()
							+ "//Quantity : " + ARLPR.get(i).getQuantity() + "// Price : " + ARLPR.get(i).getPrice()
							+ "//Type : " + ARLPR.get(i).getType() + "//" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n");
					retVal += "Barcode : " + ARLPR.get(i).getBarcode() + "\nName : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "\nPrice : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "-" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n";
				}
			}

			break;

		case 3:

			for (int i = 0; i < ARLPR.size(); i++) {
				if (String.valueOf(ARLPR.get(i).getQuantity()).equals(attValue)) {
					System.out.println("FOUND !!");
					System.out.print("Barcode : " + ARLPR.get(i).getBarcode() + "// Name : " + ARLPR.get(i).getName()
							+ "//Quantity : " + ARLPR.get(i).getQuantity() + "// Price : " + ARLPR.get(i).getPrice()
							+ "//Type : " + ARLPR.get(i).getType() + "//" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n");
					retVal += "Barcode : " + ARLPR.get(i).getBarcode() + "\nName : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "\nPrice : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "-" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n";
				}
			}

			break;

		case 4:

			for (int i = 0; i < ARLPR.size(); i++) {
				if (String.valueOf(ARLPR.get(i).getPrice()).equals(attValue)) {
					System.out.println("FOUND !!");
					System.out.print("Barcode : " + ARLPR.get(i).getBarcode() + "// Name : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "// Price : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "//" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n");
					retVal += "Barcode : " + ARLPR.get(i).getBarcode() + "\nName : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "\nPrice : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "-" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n";
				}
			}break;

		case 5:
			for (int i = 0; i < ARLPR.size(); i++) {
				if (ARLPR.get(i).getADA().equals(attValue)) {
					System.out.println("FOUND !!");
					System.out.print("Barcode : " + ARLPR.get(i).getBarcode() + "// Name : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "// Price : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "//" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n");
					retVal += "Barcode : " + ARLPR.get(i).getBarcode() + "\nName : " + ARLPR.get(i).getName()
							+ "\nQuantity : " + ARLPR.get(i).getQuantity() + "\nPrice : " + ARLPR.get(i).getPrice()
							+ "\nType : " + ARLPR.get(i).getType() + "-" + ARLPR.get(i).getProducer()
							+ ARLPR.get(i).getADA() + "\n";
				}
			}
			break;
			
		default:
			retVal += "No Match !!";
			break;
		}
		

		return retVal;
	}

	public void createUser(String name, int age, String eMail, String city) {

		User usr = new User(name, age, eMail, city);
		setCurrentUser(usr);

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String sell(int barcode) throws FileNotFoundException, IOException {

		if (hasProduct(barcode)) {
			for (int i = 0; i < ARLPR.size(); i++) {
				if (ARLPR.get(i).getBarcode() == barcode) {
					Product pr;
					pr = ARLPR.get(i);
					currentUser.setBuy(pr);
					Date date = new Date();// WITH DATE
					currentUser.setDate(date);
					ARLPR.get(i).setQuantity(ARLPR.get(i).getQuantity() - 1);
					if (ARLPR.get(i).getQuantity() == 0) {
						deleteRecord(barcode);
					}

					System.out.println("SOLD to " + currentUser.getName());
				}
			}

			File f = new File(TABLE);
			ObjectOutputStream tableOos = new ObjectOutputStream(new FileOutputStream(f));
			SELLTABLE.add(currentUser);
			tableOos.reset();
			tableOos.writeObject(SELLTABLE);
			System.out.println("Successfully Added To DB");
			tableOos.close();


			
			File fx = new File(DBNAME);
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fx));
			oos.writeObject(ARLPR);
			oos.flush();
			oos.close();
			
			return "Successfully Added !!";

		}
		
		else {
			
			return "No Matching Barcode";
		}

	}

	public String searchSales(String eMail) {

		String ret = "";
		for (int i = 0; i < SELLTABLE.size(); i++) {
			if (SELLTABLE.get(i).geteMail().equals(eMail)) {
				System.out.println("FOUND !!");
				System.out.println("NAME : " + SELLTABLE.get(i).getName() + "// AGE : " + SELLTABLE.get(i).getAge()
						+ "\nEmail : " + SELLTABLE.get(i).geteMail() + "// City : " + SELLTABLE.get(i).getCity() + "\n"
						+ "Bought : " + SELLTABLE.get(i).getBuy().getType() + "// Name : "
						+ SELLTABLE.get(i).getBuy().getName() + "\n" + "Date : " + SELLTABLE.get(i).getDate());
				ret += "NAME : " + SELLTABLE.get(i).getName() + "\n AGE : " + SELLTABLE.get(i).getAge()
						+ "\nEmail : " + SELLTABLE.get(i).geteMail() + "// City : " + SELLTABLE.get(i).getCity() + "\n"
						+ "Bought : " + SELLTABLE.get(i).getBuy().getType() + "// Name : "
						+ SELLTABLE.get(i).getBuy().getName() + "\n" + "Date : " + SELLTABLE.get(i).getDate();
			}
		}
		
		if (!ret.equals("")) {
			return ret;
		}
		System.out.println("NO MATCH !!");
		return "NO MATCH !!";

	}

}
