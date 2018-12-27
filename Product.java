package org.eclipse.wb.swing;

public class Product implements java.io.Serializable{
	
	private int barcode;
	private String name;
	private int quantity;
	private int price;
	private int typeSelection;
	private String ADA;

	public Product(int barcode, String name, int quantity, int price, int typeSelection, String ADA) {
		this.barcode = barcode;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.typeSelection = typeSelection;
		this.ADA = ADA;
		
		
	}

	public int getBarcode() {
		return barcode;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public int getTypeSelection() {
		return typeSelection;
	}

	public String getADA() {
		return ADA;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTypeSelection(int typeSelection) {
		this.typeSelection = typeSelection;
	}

	public void setADA(String aDA) {
		ADA = aDA;
	}
	
	public String getType() {
		switch (typeSelection) {
		case 1:
			return "Book";

		case 2:
			
			return "DVD Film";
		case 3:
			
			return "Music";
		default:
			return null;
		}
		
	}
	
	public String getProducer() {
		switch (typeSelection) {
		case 1:
			return " Author : ";

		case 2:
			
			return " Director : ";
		case 3:
			
			return " Artist : ";
		default:
			return null;
		}
		
	}

}
