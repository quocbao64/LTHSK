package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import db.ConnectDB;
import entity.Account;

public class Acount_dao {
	private Connection connection;
	
	public Acount_dao() {
		connection = ConnectDB.getInstance().getConnection();
	}
	
	public boolean addAccount(Account account) throws Exception{
		if(searchAccount(account.getAccountName())!=null)
			throw new InputMismatchException("Trùng AccountName");
		String sql ="INSERT INTO [dbo].[ACCOUNT] "
				+ "           ([EmployeeID] "
				+ "           ,[AccountName] "
				+ "           ,[AccountPassword]) "
				+ "     VALUES "
				+ "           ( ? , ? , ? )";
		PreparedStatement stmt = connection.prepareStatement(sql);	
		stmt.setInt(1, account.getEmployeeID());
		stmt.setString(2, account.getAccountName());
		stmt.setString(3, account.getAccountPassword());
		int n = stmt.executeUpdate();
		return n>0;
	}

	public Account searchAccount(String accountName) throws Exception {
		String sql = "SELECT * FROM ACCOUNT WHERE AccountName = ? ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, accountName);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			Account lh = new Account(rs.getInt("EmployeeID"),rs.getString("AccountName"),rs.getString("AccountPassword"));
			return lh;
		}
		return null;
	}
	public boolean updateLH(Account account) throws Exception {
		if(searchAccount(account.getAccountName()) == null)
			throw new InputMismatchException(account + " Lop khong ton tai!");
		
		String sql ="UPDATE [dbo].[ACCOUNT] "
				+ " SET [AccountName] = ? , [AccountPassword] = ? "
				+ " WHERE EmployeeID= ? ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, account.getAccountName());
		stmt.setString(2, account.getAccountPassword());
		stmt.setInt(3, account.getEmployeeID());
		int n =stmt.executeUpdate();
		return n>0;
	}
	public boolean delLH(String accountName) throws Exception {
		if(searchAccount(accountName) == null)
			throw new InputMismatchException(accountName + " Không tồn tại!");
		String sql ="DELETE FROM [dbo].[ACCOUNT] "
				+ "      WHERE AccountName = ? ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, accountName);
		int n =stmt.executeUpdate();
		return n>0;
	}
	public List<Account> getDsLH() throws Exception {
		List<Account> listAccount = new ArrayList<Account>();
		
		String sql = "SELECT * FROM ACCOUNT";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Account account = new Account(rs.getInt("EmployeeID"), rs.getString("AccountName"),rs.getString("AccountPassword"));
			listAccount.add(account);
		}
		return listAccount;
	}
}
