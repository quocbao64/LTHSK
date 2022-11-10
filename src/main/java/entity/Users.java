package entity;

import java.time.LocalDate;

public class Users {
	private int ID;
	private String name;
	private int gender;
	private String gmail, phone, address;
	private LocalDate birthDate;
	private LocalDate hireDate;
	private String role, password;
	
	public Users(int iD, String name, int gender, String gmail, String phone, String address, LocalDate birthDate,
			LocalDate hireDate, String role, String password) {
		super();
		ID = iD;
		this.name = name;
		this.gender = gender;
		this.gmail = gmail;
		this.phone = phone;
		this.address = address;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.role = role;
		this.password = password;
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

	public int isGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [ID=" + ID + ", name=" + name + ", gender=" + gender + ", gmail=" + gmail + ", phone=" + phone
				+ ", address=" + address + ", birthDate=" + birthDate + ", hireDate=" + hireDate + ", role=" + role
				+ ", password=" + password + "]";
	}
	
	
}
