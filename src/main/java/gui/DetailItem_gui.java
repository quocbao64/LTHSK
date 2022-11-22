package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import entity.Product;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class DetailItem_gui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DetailItem_gui frame = new DetailItem_gui();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DetailItem_gui(Product product) {
		setTitle("Chi tiết Sản Phẩm");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\SON.admin\\V\\JavaSuKien\\LTHSK_QuanLySieuThi\\image\\logo.png"));
		setBounds(100, 100, 800, 381);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin chi ti\u1EBFt c\u1EE7a s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 10, 766, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sản phẩm:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(24, 25, 112, 20);
		panel.add(lblNewLabel);
		
		JLabel lblIDProduct = new JLabel("1");
		lblIDProduct.setForeground(Color.BLACK);
		lblIDProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIDProduct.setBounds(165, 25, 88, 20);
		panel.add(lblIDProduct);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnSnPhm.setBounds(24, 55, 112, 20);
		panel.add(lblTnSnPhm);
		
		JLabel lblNameProduct = new JLabel(product.getName());
		lblNameProduct.setForeground(Color.BLACK);
		lblNameProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameProduct.setBounds(165, 55, 578, 20);
		panel.add(lblNameProduct);
		
		JLabel lblGi = new JLabel("Giá sản phẩm:");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGi.setBounds(24, 85, 127, 20);
		panel.add(lblGi);
		
		JLabel lblPriceProduct = new JLabel(String.format("%,.0f", product.getPrice()) + " ₫");
		lblPriceProduct.setForeground(Color.BLACK);
		lblPriceProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPriceProduct.setBounds(165, 85, 258, 20);
		panel.add(lblPriceProduct);
		
		JLabel lblMNhCung = new JLabel("Mã nhà cung cấp:");
		lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhCung.setBounds(24, 203, 127, 20);
		panel.add(lblMNhCung);
		
		JLabel lblIDSupply = new JLabel(product.getSuppliers().getID()+"");
		lblIDSupply.setForeground(Color.BLACK);
		lblIDSupply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIDSupply.setBounds(165, 203, 258, 20);
		panel.add(lblIDSupply);
		
		JLabel lblMNhCung_1 = new JLabel("Tên nhà cung cấp:");
		lblMNhCung_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhCung_1.setBounds(24, 233, 132, 20);
		panel.add(lblMNhCung_1);
		
		JLabel lblNameSupply = new JLabel(product.getSuppliers().getName());
		lblNameSupply.setForeground(Color.BLACK);
		lblNameSupply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameSupply.setBounds(165, 233, 258, 20);
		panel.add(lblNameSupply);
		
		JLabel lblMNhCung_1_1 = new JLabel("Phone:");
		lblMNhCung_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhCung_1_1.setBounds(484, 203, 78, 20);
		panel.add(lblMNhCung_1_1);
		
		JLabel lblPhoneSupply = new JLabel(product.getSuppliers().getPhone());
		lblPhoneSupply.setForeground(Color.BLACK);
		lblPhoneSupply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneSupply.setBounds(552, 203, 191, 20);
		panel.add(lblPhoneSupply);
		
		JLabel lblMNhCung_1_1_1 = new JLabel("Gmail:");
		lblMNhCung_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhCung_1_1_1.setBounds(484, 233, 56, 20);
		panel.add(lblMNhCung_1_1_1);
		
		JLabel lblGmailSupply = new JLabel(product.getSuppliers().getGmail());
		lblGmailSupply.setForeground(Color.BLACK);
		lblGmailSupply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGmailSupply.setBounds(552, 233, 191, 20);
		panel.add(lblGmailSupply);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblaCh.setBounds(24, 263, 112, 20);
		panel.add(lblaCh);
		
		JLabel lblAddressSupply = new JLabel(product.getSuppliers().getAddress());
		lblAddressSupply.setForeground(Color.BLACK);
		lblAddressSupply.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddressSupply.setBounds(165, 263, 578, 20);
		panel.add(lblAddressSupply);
		
		JLabel lblMLoiHng = new JLabel("Mã loại hàng:");
		lblMLoiHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMLoiHng.setBounds(24, 129, 112, 20);
		panel.add(lblMLoiHng);
		
		JLabel lblIDCatagory = new JLabel(product.getCategories().getID()+"");
		lblIDCatagory.setForeground(Color.BLACK);
		lblIDCatagory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIDCatagory.setBounds(165, 129, 88, 20);
		panel.add(lblIDCatagory);
		
		JLabel lblTnLoiHng = new JLabel("Tên loại hàng:");
		lblTnLoiHng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTnLoiHng.setBounds(24, 159, 112, 20);
		panel.add(lblTnLoiHng);
		
		JLabel lblNameCatagory = new JLabel(product.getCategories().getName());
		lblNameCatagory.setForeground(Color.BLACK);
		lblNameCatagory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNameCatagory.setBounds(165, 159, 258, 20);
		panel.add(lblNameCatagory);
		
		btnClose = new JButton("  Hoàn thành");
		btnClose.setIcon(new ImageIcon("image\\check-mark.png"));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBackground(UIManager.getColor("Button.background"));
		btnClose.setBounds(302, 306, 174, 30);
		contentPane.add(btnClose);
		btnClose.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
