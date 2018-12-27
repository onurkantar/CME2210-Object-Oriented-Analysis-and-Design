package org.eclipse.wb.swing;

import java.util.Date;

@SuppressWarnings("serial")
public class Premium_User extends User {

	int premNumber;
	
	@SuppressWarnings("static-access")
	Premium_User(String name, int age, String eMail, String city,int number) {
		super(name, age, eMail, city);
		// TODO Auto-generated constructor stub
		this.premNumber = number;
	}

	public int getPremNumber() {
		return premNumber;
	}

	public void setPremNumber(int premNumber) {
		this.premNumber = premNumber;
	}
	
	

}
