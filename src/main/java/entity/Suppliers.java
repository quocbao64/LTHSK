package entity;

public class Suppliers {
	private int ID;
	private String name, address, phone, gmail;

	public Suppliers(int iD, String name, String address, String phone, String gmail) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gmail = gmail;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

}
