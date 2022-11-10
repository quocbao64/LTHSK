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
//		Connection con = ConnectDB.getInstance().getConnection();
//		UsersDAO usersDAO = new UsersDAO(con);
//		usersDAO.addUsers(new Users(13, "Huỳnh Quốc Bảo", 1, "bao11@gmail.com", "0333399988",
//				"12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh", LocalDate.of(2002, 10, 10), LocalDate.of(2020, 10, 12),
//				"ROLE_ADMIN", "pass123"));
//		System.out.println(usersDAO.searchUsers(13));
	}
}
