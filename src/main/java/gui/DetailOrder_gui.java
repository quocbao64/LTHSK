package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class DetailOrder_gui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailOrder_gui frame = new DetailOrder_gui();
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
	public DetailOrder_gui() {
		setTitle("Chi Tiết Hóa Đơn");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SON.admin\\V\\JavaSuKien\\LTHSK_QuanLySieuThi\\image\\logo.png"));
		setBounds(100, 100, 1069, 534);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Danh s\u00E1ch s\u1EA3n ph\u1EA9m c\u00F3 trong h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 158, 1040, 295);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 20, 1021, 270);
		panel.add(scrollPane);
		

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(UIManager.getColor("Button.light"));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setSelectionBackground(new java.awt.Color(255, 255, 204));
		
		table.setRowHeight(35);
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Mã hóa đơn:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(445, 14, 95, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblIDOrder = new JLabel("01");
		lblIDOrder.setForeground(Color.BLUE);
		lblIDOrder.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIDOrder.setBounds(537, 10, 95, 20);
		contentPane.add(lblIDOrder);
		
		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgyLp.setBounds(138, 59, 142, 20);
		contentPane.add(lblNgyLp);
		
		JLabel lblDateOrder = new JLabel("20/12/2022");
		lblDateOrder.setForeground(Color.BLACK);
		lblDateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOrder.setBounds(291, 59, 142, 20);
		contentPane.add(lblDateOrder);
		
		JLabel lblTngGi = new JLabel("Tổng Giá:");
		lblTngGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTngGi.setBounds(138, 89, 142, 20);
		contentPane.add(lblTngGi);
		
		JLabel lblPriceOrder = new JLabel("200000");
		lblPriceOrder.setForeground(Color.BLACK);
		lblPriceOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceOrder.setBounds(291, 89, 142, 20);
		contentPane.add(lblPriceOrder);
		
		JLabel lblGimGi = new JLabel("Giảm giá:");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGimGi.setBounds(138, 119, 142, 20);
		contentPane.add(lblGimGi);
		
		JLabel lblDiscountOrder = new JLabel("0");
		lblDiscountOrder.setForeground(Color.BLACK);
		lblDiscountOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiscountOrder.setBounds(291, 119, 142, 20);
		contentPane.add(lblDiscountOrder);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên thực hiện:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(609, 59, 178, 20);
		contentPane.add(lblMNhnVin);
		
		JLabel lblIDPerson = new JLabel("01");
		lblIDPerson.setForeground(Color.BLACK);
		lblIDPerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIDPerson.setBounds(798, 59, 142, 20);
		contentPane.add(lblIDPerson);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên thực hiện:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(609, 89, 178, 20);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblNamePerson = new JLabel("Nguyễn văn sơn");
		lblNamePerson.setForeground(Color.BLACK);
		lblNamePerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNamePerson.setBounds(798, 89, 199, 20);
		contentPane.add(lblNamePerson);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại liên hệ:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setBounds(609, 119, 178, 20);
		contentPane.add(lblSinThoi);
		
		JLabel lblPhonePerson = new JLabel("0395906032");
		lblPhonePerson.setForeground(Color.BLACK);
		lblPhonePerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhonePerson.setBounds(798, 119, 199, 20);
		contentPane.add(lblPhonePerson);
		
		btnClose = new JButton("  Hoàn thành");
		btnClose.setIcon(new ImageIcon("image\\check-mark.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBackground(SystemColor.menu);
		btnClose.setBounds(458, 458, 174, 30);
		contentPane.add(btnClose);
		btnClose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
