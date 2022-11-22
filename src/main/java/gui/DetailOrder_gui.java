package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import db.ConnectDB;
import entity.CartItem;
import entity.Order;
import model.CartItemTableModel;
import service.impl.CartItemServiceImpl;

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
	private CartItemServiceImpl cartItemServiceImpl;
	private CartItemTableModel model_CartItem;
	
	/**
	 * Create the frame.
	 */
	public DetailOrder_gui(Order order) {
		setTitle("Chi Tiết Hóa Đơn");
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo.png"));
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
		
		String[] headLine_table = { "STT", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Tổng tiền" };
		cartItemServiceImpl = new CartItemServiceImpl(ConnectDB.getInstance().getConnection());
	
		model_CartItem = new CartItemTableModel(cartItemServiceImpl.getListCartItemByOrderID(order.getID()), headLine_table);

		table = new JTable(model_CartItem);
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
		
		JLabel lblIDOrder = new JLabel(order.getID()+"");
		lblIDOrder.setForeground(Color.BLUE);
		lblIDOrder.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblIDOrder.setBounds(537, 10, 95, 20);
		contentPane.add(lblIDOrder);
		
		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgyLp.setBounds(138, 59, 142, 20);
		contentPane.add(lblNgyLp);
		
		JLabel lblDateOrder = new JLabel(order.getOrderDate().toString());
		lblDateOrder.setForeground(Color.BLACK);
		lblDateOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDateOrder.setBounds(291, 59, 142, 20);
		contentPane.add(lblDateOrder);
		
		JLabel lblTngGi = new JLabel("Tổng Giá:");
		lblTngGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTngGi.setBounds(138, 89, 142, 20);
		contentPane.add(lblTngGi);
		
		JLabel lblPriceOrder = new JLabel(String.format("%,.0f", order.getTotalPrice()) + " ₫");
		lblPriceOrder.setForeground(Color.BLACK);
		lblPriceOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceOrder.setBounds(291, 89, 142, 20);
		contentPane.add(lblPriceOrder);
		
		JLabel lblGimGi = new JLabel("Giảm giá:");
		lblGimGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGimGi.setBounds(138, 119, 142, 20);
		contentPane.add(lblGimGi);
		
		JLabel lblDiscountOrder = new JLabel(String.format("%,.0f", order.getDiscount()) + " ₫");
		lblDiscountOrder.setForeground(Color.BLACK);
		lblDiscountOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiscountOrder.setBounds(291, 119, 142, 20);
		contentPane.add(lblDiscountOrder);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên thực hiện:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(609, 59, 178, 20);
		contentPane.add(lblMNhnVin);
		
		JLabel lblIDPerson = new JLabel(order.getUsers().getID()+"");
		lblIDPerson.setForeground(Color.BLACK);
		lblIDPerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIDPerson.setBounds(798, 59, 142, 20);
		contentPane.add(lblIDPerson);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên thực hiện:");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnNhnVin.setBounds(609, 89, 178, 20);
		contentPane.add(lblTnNhnVin);
		
		JLabel lblNamePerson = new JLabel(order.getUsers().getName()+"");
		lblNamePerson.setForeground(Color.BLACK);
		lblNamePerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNamePerson.setBounds(798, 89, 199, 20);
		contentPane.add(lblNamePerson);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại liên hệ:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSinThoi.setBounds(609, 119, 178, 20);
		contentPane.add(lblSinThoi);
		
		JLabel lblPhonePerson = new JLabel(order.getUsers().getPhone());
		lblPhonePerson.setForeground(Color.BLACK);
		lblPhonePerson.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhonePerson.setBounds(798, 119, 199, 20);
		contentPane.add(lblPhonePerson);
		
		btnClose = new JButton("  Hoàn thành");
		btnClose.setIcon(new ImageIcon("image\\check-mark.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBackground(UIManager.getColor("Button.background"));
		btnClose.setBounds(458, 458, 174, 30);
		contentPane.add(btnClose);
		btnClose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
