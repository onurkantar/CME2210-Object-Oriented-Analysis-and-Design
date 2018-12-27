package org.eclipse.wb.swing;

import java.util.Date;

public class User implements java.io.Serializable {

	private String name;
	private int age;
	private String eMail;
	private String city;
	private Product buy;
	private Date date;

	User(String name, int age, String eMail, String city) {
		this.name = name;
		this.age = age;
		this.eMail = eMail;
		this.city = city;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String geteMail() {
		return eMail;
	}

	public String getCity() {
		return city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Product getBuy() {
		return buy;
	}

	public void setBuy(Product buy) {
		this.buy = buy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
}
