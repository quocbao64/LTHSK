package entity;

public class Suppliers {
	private int ID;
	private String name, gmail, phone, address;
	public Suppliers(int iD, String name, String gmail, String phone, String address) {
		super();
		ID = iD;
		this.name = name;
		this.gmail = gmail;
		this.phone = phone;
		this.address = address;
	}
	public Suppliers() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}
