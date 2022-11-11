package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;

public class Login_gui extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfGmail;
	private JTextField tfPassword;
	private JButton btnLogin;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_gui frame = new Login_gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_gui() {
		setTitle("Quản Lý Nhân Viên - Đăng Nhập");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\login-1.png"));
		lblNewLabel.setBounds(10, 25, 153, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Nhập gmail");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_2.setBounds(172, 30, 97, 32);
		contentPane.add(lblNewLabel_1_4_2);
		
		tfGmail = new JTextField();
		tfGmail.setToolTipText("Nhập gmail đăng nhập");
		tfGmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfGmail.setColumns(10);
		tfGmail.setBackground(UIManager.getColor("Button.highlight"));
		tfGmail.setBounds(289, 30, 204, 32);
		contentPane.add(tfGmail);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Nhập password");
		lblNewLabel_1_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_2_1.setBounds(172, 76, 117, 32);
		contentPane.add(lblNewLabel_1_4_2_1);
		
		tfPassword = new JTextField();
		tfPassword.setToolTipText("Nhập mật khẩu của bạn");
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPassword.setColumns(10);
		tfPassword.setBackground(Color.WHITE);
		tfPassword.setBounds(289, 76, 171, 32);
		contentPane.add(tfPassword);
		
		btnLogin = new JButton("Đăng nhập");
		btnLogin.setBackground(UIManager.getColor("Button.background"));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(381, 128, 112, 25);
		contentPane.add(btnLogin);
		
		btnExit = new JButton("Thoát");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(175, 128, 100, 25);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("image\\password.png"));
		btnNewButton.setBounds(458, 76, 34, 32);
		contentPane.add(btnNewButton);
		
		btnLogin.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		
		//admin 
		new HomeAdmin_gui().setVisible(true);
		
		
		//Person
//		new HomePerson_gui().setVisible(true);
	}
}
