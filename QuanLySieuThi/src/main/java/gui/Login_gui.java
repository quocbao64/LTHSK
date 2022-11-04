package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import dao.Acount_dao;
import entity.Account;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Login_gui implements ActionListener {

	private JFrame frmQunLSiu;
	private JTextField tfName;
	private JPasswordField tfpassword;
	private JButton btnLogin;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_gui window = new Login_gui();
					window.frmQunLSiu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunLSiu = new JFrame();
		frmQunLSiu.setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo.png"));
		frmQunLSiu.setTitle("Quản Lý Siêu Thị");
		frmQunLSiu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQunLSiu.setBounds(100, 100, 296, 295);
		frmQunLSiu.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		frmQunLSiu.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBounds(28, 98, 226, 33);
		panel.add(tfName);
		tfName.setColumns(10);
		
		btnLogin = new JButton("Đăng Nhập");
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(152, 210, 102, 26);
		panel.add(btnLogin);
		
		tfpassword = new JPasswordField();
		tfpassword.setBounds(28, 157, 226, 33);
		panel.add(tfpassword);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản");
		lblNewLabel_1.setBounds(28, 75, 95, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setBounds(28, 141, 62, 13);
		panel.add(lblNewLabel_2);
		
		btnExit = new JButton("Thoát");
		btnExit.setBounds(26, 210, 71, 26);
		panel.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\logo_login.png"));
		lblNewLabel.setBounds(111, 10, 71, 64);
		panel.add(lblNewLabel);
		
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnExit)) System.exit(0);
		else {
			String account = tfName.getText();
			String password = new String(tfpassword.getPassword());
			Acount_dao acount_dao = new  Acount_dao();
			try {
				Account ac = acount_dao.searchAccount(account);
				if(ac == null) {
					JOptionPane.showMessageDialog(btnExit, "Tài khoản không tồn tại");
					return;
				}
				if(ac.getAccountPassword().compareTo(password)!=0) {
					JOptionPane.showMessageDialog(btnExit, "Mật khẩu sai");
					return;
				}
				
				//Kiểm tra 'nhân viên' hay 'quản lý'
				//Nhân viên: mã 4 chữ số
				//Quản lý: mã 2 chữ số
				String regex = "[0-9]{2}";
				if(regex.matches(String.valueOf(ac.getEmployeeID()))){
					new Home_gui(true,ac).setVisible(true);
				}
				else new Home_gui(false,ac).setVisible(true);
				
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(btnExit, e1);
			}
		}
	}
}
