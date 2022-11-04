package entity;

public class Account {
	private int EmployeeID;
	private String AccountName;
	private String AccountPassword;
	public Account(int employeeID, String accountName, String accountPassword) {
		super();
		EmployeeID = employeeID;
		AccountName = accountName;
		AccountPassword = accountPassword;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getAccountPassword() {
		return AccountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		AccountPassword = accountPassword;
	}
	@Override
	public String toString() {
		return "Account [EmployeeID=" + EmployeeID + ", AccountName=" + AccountName + ", AccountPassword="
				+ AccountPassword + "]";
	}
}
