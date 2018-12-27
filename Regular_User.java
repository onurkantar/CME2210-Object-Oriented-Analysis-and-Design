package org.eclipse.wb.swing;

import java.util.Date;

public class Regular_User extends User {

	static Date date;
	
	Regular_User(String name, int age, String eMail, String city,Date date) {
		super(name, age, eMail, city);
		// TODO Auto-generated constructor stub
		this.date = date;
	}
	
	

}
