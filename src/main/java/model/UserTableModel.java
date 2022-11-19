package model;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Product;
import entity.Users;

public class UserTableModel extends AbstractTableModel{
	private static final int ID = 0;
	private static final int NAME = 1;
	private static final int GENDER = 2;
	private static final int GMAIL = 3;
	private static final int PHONE = 4;
	private static final int ADDRESS = 5;
	private static final int BIRTHDATE = 6;
	private static final int HIREDATE = 7;
	private static final int PASSWORD = 8;
	private List<Users> Users;
	private String[] headLine;

	public UserTableModel(List<entity.Users> users, String[] headLine) {
		super();
		Users = users;
		this.headLine = headLine;
	}

	@Override
	public int getRowCount() {
		return Users.size();
	}

	@Override
	public int getColumnCount() {
		return headLine.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return headLine[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Users u = Users.get(rowIndex);
		switch (columnIndex) {
		case ID:
			return u.getID();
		case NAME:
			return u.getName();
		case GENDER:
			return u.isGender()==0?"Nam":"Nữ";
		case GMAIL:
			return u.getGmail();
		case PHONE:
			return u.getPhone();
		case ADDRESS:
			return u.getAddress();
		case BIRTHDATE:
			return new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(u.getBirthDate()));
		case HIREDATE:
			return new SimpleDateFormat("dd/MM/yyyy").format(Date.valueOf(u.getHireDate()));
		case PASSWORD:
			return u.getPassword();
		default:
			break;
		}
		return u.getID();
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(NAME == columnIndex || PASSWORD == columnIndex || GMAIL==columnIndex || ADDRESS == columnIndex || ID == columnIndex) return String.class;
		return Integer.class;
	}
	
	public void setUsers(List<Users> users) {
		Users = users;
	}
}
