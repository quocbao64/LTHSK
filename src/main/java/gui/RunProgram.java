package gui;

import java.sql.Connection;
import java.time.LocalDate;

import dao.UsersDAO;
import db.ConnectDB;
import entity.Users;

public class RunProgram {
	public static void main(String[] args) throws Exception {
		Login_gui window = new Login_gui();
		window.setVisible(true);
		
	}
}
