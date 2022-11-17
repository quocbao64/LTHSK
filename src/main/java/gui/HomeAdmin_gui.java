package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import entity.CartItem;
import entity.Categories;
import entity.Order;
import entity.Product;
import entity.Users;
import model.CartItemTableModel;
import model.CategoriesTableModel;
import model.OrderTableModel;
import model.ProductTableModel;
import service.CategoriesService;
import service.impl.CartItemServiceImpl;
import service.impl.CategoriesServiceImpl;
import service.impl.OrdersServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.SuppliersServiceImpl;
import service.impl.UsersServiceImpl;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import db.ConnectDB;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class HomeAdmin_gui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_14;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTable table_3;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_18;
	private JTextField textField_22;
	private JTextField textField_6;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_25;
	private JTextField textField_28;
	private JTable table_4;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_33;
	private JButton btnDetailOrder;
	private JButton btnDetailItem;
	private JComboBox comboBox;
	private CategoriesServiceImpl categoriesServiceImpl;
	private CategoriesTableModel model_category;
	private List<Product> listProductCategory;
	private JButton btnNewButton_2_1_1_1_1_2_1;
	private JButton btnNewButton_2_1_2_1;
	private ArrayList<String> comboBoxContent;
	private JButton btnNewButton_2_1_1_2_1_1;
	private JButton btnNewButton_2_1_1_3_1;
	private JButton btnNewButton_3_2;
	private JComboBox comboBox_3_1_5;
	private JComboBox comboBox_3_1_4;
	private String[] headline_3;
	private List<Product> listProduct;
	private ProductTableModel model_product;
	private String[] headline_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private ArrayList comboBox_1Content;
	private ArrayList comboBox_1_1Content;
	private ProductServiceImpl productServiceImpl;
	private SuppliersServiceImpl suppliersServiceImpl;
	private JButton btnNewButton_2_1_2_2;
	private JButton btnNewButton_2_1_1_2_1_2;
	private JButton btnNewButton_2_1_1_1_1_2_2;
	private JButton btnNewButton_2_1_1_3_2;
	private JButton btnNewButton_3_3;
	private OrdersServiceImpl ordersServiceImpl;
	private List<Order> listOrder;
	private OrderTableModel model_Order;
	private JDateChooser dateChooser;
	private JButton btnNewButton_2_1_1_1_1_2;
	private JButton btnNewButton_2;
	private CartItemServiceImpl cartItemServiceImpl;
	private List<CartItem> listCartItem;
	private ArrayList<CartItem> listCartItem_temp;
	private CartItemTableModel model_CartItem;
	private ArrayList<Integer> listCartItem_ID_temp;
	private JSpinner spinner;
	private JButton btnNewButton_2_1_1;
	private JButton btnNewButton_2_1;
	private JButton btnNewButton_2_1_1_2;
	private JComboBox comboBox_3_1;
	private ArrayList listCartItem_temp2;
	private JButton btnNewButton_2_1_1_1;
	private int idOrder_temp;
	private UsersServiceImpl usersServiceImpl;
	private JButton btnNewButton_2_1_1_2_1;
	private JButton btnNewButton_2_1_1_3;
	private JButton btnNewButton_3;
	private JComboBox comboBox_3_1_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin_gui frame = new HomeAdmin_gui();
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
	public HomeAdmin_gui() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image\\logo.png"));
		setTitle("Quản Lý Siêu Thị   |    Huỳnh Quốc Bảo - Nguyễn Văn Sơn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 1100, 750);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JMenu mnNewMenu_3 = new JMenu("  Thao Tác  ");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("  Thanh toán hóa đơn");
		mntmNewMenuItem_6.setIcon(new ImageIcon("image\\btnAdd.png"));
		mnNewMenu_3.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("   Hủy chi tiết một đơn hàng");
		mntmNewMenuItem_7.setIcon(new ImageIcon("image\\delete-item.png"));
		mnNewMenu_3.add(mntmNewMenuItem_7);

		JMenu mnNewMenu = new JMenu("  Quản Lý  ");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("  Quản lý hóa đơn");
		mntmNewMenuItem.setIcon(new ImageIcon("image\\btnBill.png"));
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("  Quản lý nhân viên");
		mntmNewMenuItem_1.setIcon(new ImageIcon("image\\btnPerson.png"));
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("  Quản lý loại hàng");
		mntmNewMenuItem_2.setIcon(new ImageIcon("image\\catagory.png"));
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("  Quản lý mặt hàng");
		mntmNewMenuItem_8.setIcon(new ImageIcon("image\\btnCatogory.png"));
		mnNewMenu.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_1 = new JMenu("  Cài Đặt  ");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thông tin của bạn");
		mntmNewMenuItem_3.setIcon(new ImageIcon("image\\btnProfile.png"));
		mnNewMenu_1.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_2 = new JMenu("  Trợ Giúp");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("  Đăng xuất");
		mntmNewMenuItem_5.setIcon(new ImageIcon("image\\out.png"));
		mnNewMenu_2.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("  Thoát");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

// Service
		categoriesServiceImpl = new CategoriesServiceImpl(ConnectDB.getInstance().getConnection());
		productServiceImpl = new ProductServiceImpl(ConnectDB.getInstance().getConnection());
		suppliersServiceImpl = new SuppliersServiceImpl(ConnectDB.getInstance().getConnection());
		ordersServiceImpl = new OrdersServiceImpl(ConnectDB.getInstance().getConnection());
		cartItemServiceImpl = new CartItemServiceImpl(ConnectDB.getInstance().getConnection());
		usersServiceImpl = new UsersServiceImpl(ConnectDB.getInstance().getConnection());

// List cartItem

		listProductCategory = categoriesServiceImpl.getListProductNullCategories();
		listProduct = productServiceImpl.getListProducts();
		listOrder = ordersServiceImpl.getListOrders();
		listCartItem = cartItemServiceImpl.getListCartItem();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 1066, 646);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setToolTipText("Tìm kiếm theo mã");
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Thanh Toán Hóa Đơn", new ImageIcon("image\\btnAdd1.png"), panel, null);
		panel.setLayout(null);
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(10, 54, 1041, 183);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setToolTipText("Thêm vào hóa đơn");
		panel_7.setBounds(336, 24, 334, 52);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		textField = new JTextField();
		textField.setToolTipText("Nhập mã sản phẩm");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(10, 10, 175, 32);
		panel_7.add(textField);
		textField.setColumns(10);

		spinner = new JSpinner();
		spinner.setToolTipText("Chọn số lượng");
		spinner.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spinner.setBounds(195, 10, 43, 32);
		panel_7.add(spinner);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Thêm sản phẩm mới vào hóa đơn");
		btnNewButton_2.setBounds(248, 10, 76, 32);
		panel_7.add(btnNewButton_2);
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setIcon(new ImageIcon("image\\add.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.addActionListener(this);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBounds(95, 96, 857, 52);
		panel_5.add(panel_7_1);

		btnNewButton_2_1 = new JButton("  Xóa");
		btnNewButton_2_1.setIcon(new ImageIcon("image\\delete.png"));
		btnNewButton_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1.setBounds(36, 10, 169, 32);
		panel_7_1.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(this);

		btnNewButton_2_1_1 = new JButton("  Làm Rỗng");
		btnNewButton_2_1_1.setIcon(new ImageIcon("image\\clear.png"));
		btnNewButton_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1.setBackground(Color.WHITE);
		btnNewButton_2_1_1.setBounds(445, 10, 169, 32);
		panel_7_1.add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.addActionListener(this);

		btnNewButton_2_1_1_1 = new JButton("  Thanh Toán");
		btnNewButton_2_1_1_1.setIcon(new ImageIcon("image\\check-mark.png"));
		btnNewButton_2_1_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1.setBackground(Color.WHITE);
		btnNewButton_2_1_1_1.setBounds(654, 10, 169, 32);
		panel_7_1.add(btnNewButton_2_1_1_1);
		btnNewButton_2_1_1_1.addActionListener(this);

		btnNewButton_2_1_1_2 = new JButton("  Chỉnh Sửa");
		btnNewButton_2_1_1_2.setIcon(new ImageIcon("image\\edit.png"));
		btnNewButton_2_1_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_2.setBackground(Color.WHITE);
		btnNewButton_2_1_1_2.setBounds(245, 10, 156, 32);
		panel_7_1.add(btnNewButton_2_1_1_2);
		btnNewButton_2_1_1_2.addActionListener(this);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(10, 280, 1041, 310);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 31, 1021, 270);
		panel_6.add(scrollPane);

// table cartItem		

		String[] headLine_table = { "STT", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Tổng tiền" };
		listCartItem_temp = new ArrayList<CartItem>();
		listCartItem_ID_temp = new ArrayList<Integer>();
		model_CartItem = new CartItemTableModel(listCartItem_temp, headLine_table);

		table = new JTable(model_CartItem);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setBackground(UIManager.getColor("Button.light"));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setSelectionBackground(new java.awt.Color(255, 255, 204));

		table.setRowHeight(35);

		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				updateCom_5(index);
			}

			private void updateCom_5(int index) {
				textField.setText(listCartItem_temp.get(index).getProduct().getID() + "");
				spinner.setValue(listCartItem_temp.get(index).getQuantity());
			}
		});

		JLabel lblNewLabel_3_1 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(878, 14, 81, 13);
		panel_6.add(lblNewLabel_3_1);

		comboBox_3_1 = new JComboBox();
		comboBox_3_1.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Số lượng", "Giá" }));
		comboBox_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_3_1.setBounds(950, 10, 81, 20);
		panel_6.add(comboBox_3_1);
		comboBox_3_1.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Thanh Toán Hóa Đơn");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(417, 10, 217, 34);
		panel.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setText("0 ₫");
		textField_2.setBackground(UIManager.getColor("Button.background"));
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(930, 247, 119, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Thành tiền: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(835, 247, 87, 28);
		panel.add(lblNewLabel_2);

		JButton btnNewButton_6 = new JButton("Xuất danh sách sản phẩm");
		btnNewButton_6.setIcon(new ImageIcon("image\\xml.png"));
		btnNewButton_6.setBounds(10, 247, 205, 28);
		panel.add(btnNewButton_6);

		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Hủy Chi Tiết Một Món Hàng", new ImageIcon("image\\delete-item (1).png"), panel_1_2_2, null);

		JPanel panel_5_1_2_2 = new JPanel();
		panel_5_1_2_2.setLayout(null);
		panel_5_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2_2.setBackground(Color.WHITE);
		panel_5_1_2_2.setBounds(10, 54, 1041, 216);
		panel_1_2_2.add(panel_5_1_2_2);

		JPanel panel_7_1_1_2_2 = new JPanel();
		panel_7_1_1_2_2.setLayout(null);
		panel_7_1_1_2_2.setBackground(SystemColor.menu);
		panel_7_1_1_2_2.setBounds(264, 20, 514, 50);
		panel_5_1_2_2.add(panel_7_1_1_2_2);

		JButton btnNewButton_2_1_1_1_1_3_2 = new JButton("");
		btnNewButton_2_1_1_1_1_3_2.setIcon(new ImageIcon("image\\delete.png"));
		btnNewButton_2_1_1_1_1_3_2.setToolTipText("Cập nhật danh sách");
		btnNewButton_2_1_1_1_1_3_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_3_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_3_2.setBounds(428, 10, 52, 32);
		panel_7_1_1_2_2.add(btnNewButton_2_1_1_1_1_3_2);

		textField_27 = new JTextField();
		textField_27.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_27.setToolTipText("Tìm kiếm theo mã");
		textField_27.setColumns(10);
		textField_27.setBackground(Color.WHITE);
		textField_27.setBounds(36, 10, 154, 32);
		panel_7_1_1_2_2.add(textField_27);

		JButton btnNewButton_3_3_2_1 = new JButton("");
		btnNewButton_3_3_2_1.setIcon(new ImageIcon("image\\search.png"));
		btnNewButton_3_3_2_1.setToolTipText("Tìm kiếm theo mã");
		btnNewButton_3_3_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_3_3_2_1.setBounds(189, 10, 42, 31);
		panel_7_1_1_2_2.add(btnNewButton_3_3_2_1);

		JLabel lblNewLabel_1_4_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_2.setBounds(42, 86, 97, 32);
		panel_5_1_2_2.add(lblNewLabel_1_4_2);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setToolTipText("Nhập mã sản phẩm");
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBackground(SystemColor.menu);
		textField_6.setBounds(149, 86, 309, 32);
		panel_5_1_2_2.add(textField_6);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_2.setBounds(42, 128, 108, 32);
		panel_5_1_2_2.add(lblNewLabel_1_1_2_2);

		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setToolTipText("Nhập ngày lập hóa đơn");
		textField_23.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_23.setColumns(10);
		textField_23.setBackground(SystemColor.menu);
		textField_23.setBounds(149, 128, 309, 32);
		panel_5_1_2_2.add(textField_23);

		JLabel lblNewLabel_1_2_3_1 = new JLabel("Nhà cung cấp");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_3_1.setBounds(558, 89, 108, 32);
		panel_5_1_2_2.add(lblNewLabel_1_2_3_1);

		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Loại hàng");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_2_1.setBounds(558, 131, 108, 32);
		panel_5_1_2_2.add(lblNewLabel_1_2_1_2_1);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Giá thành");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2.setBounds(42, 170, 95, 32);
		panel_5_1_2_2.add(lblNewLabel_1_1_1_1_2);

		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		textField_24.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_24.setColumns(10);
		textField_24.setBackground(SystemColor.menu);
		textField_24.setBounds(149, 170, 309, 32);
		panel_5_1_2_2.add(textField_24);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2_1.setBounds(558, 170, 95, 32);
		panel_5_1_2_2.add(lblNewLabel_1_1_1_1_2_1);

		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		textField_26.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_26.setColumns(10);
		textField_26.setBackground(SystemColor.menu);
		textField_26.setBounds(676, 170, 309, 32);
		panel_5_1_2_2.add(textField_26);

		textField_25 = new JTextField();
		textField_25.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		textField_25.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_25.setEditable(false);
		textField_25.setColumns(10);
		textField_25.setBackground(SystemColor.menu);
		textField_25.setBounds(676, 128, 309, 32);
		panel_5_1_2_2.add(textField_25);

		textField_28 = new JTextField();
		textField_28.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		textField_28.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_28.setEditable(false);
		textField_28.setColumns(10);
		textField_28.setBackground(SystemColor.menu);
		textField_28.setBounds(676, 86, 309, 32);
		panel_5_1_2_2.add(textField_28);

		JLabel lblHyChiTit = new JLabel("Hủy Chi Tiết Một Món Hàng");
		lblHyChiTit.setForeground(new Color(128, 0, 255));
		lblHyChiTit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHyChiTit.setBounds(399, 10, 278, 34);
		panel_1_2_2.add(lblHyChiTit);

		JPanel panel_6_1_2_2 = new JPanel();
		panel_6_1_2_2.setLayout(null);
		panel_6_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch m\u1EB7t h\u00E0ng c\u00F3 trong h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6_1_2_2.setBackground(Color.WHITE);
		panel_6_1_2_2.setBounds(10, 280, 1041, 310);
		panel_1_2_2.add(panel_6_1_2_2);

		JScrollPane scrollPane_1_2_2 = new JScrollPane();
		scrollPane_1_2_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2_2.setBounds(10, 31, 1021, 270);
		panel_6_1_2_2.add(scrollPane_1_2_2);

		table_4 = new JTable();
		table_4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_4.setSelectionBackground(new Color(255, 255, 204));
		table_4.setRowHeight(35);
		table_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_4.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_2_2.setViewportView(table_4);

		JLabel lblNewLabel_3_1_1 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(878, 14, 81, 13);
		panel_6_1_2_2.add(lblNewLabel_3_1_1);

		JComboBox comboBox_3_1_1 = new JComboBox();
		comboBox_3_1_1.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Số lượng", "Giá" }));
		comboBox_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_3_1_1.setBounds(950, 10, 81, 20);
		panel_6_1_2_2.add(comboBox_3_1_1);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Hóa Đơn", new ImageIcon("image\\invoice1.png"), panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(10, 54, 1041, 216);
		panel_1.add(panel_5_1);

		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setBackground(new Color(255, 255, 255));
		panel_7_1_1.setLayout(null);
		panel_7_1_1.setBounds(772, 161, 259, 45);
		panel_5_1.add(panel_7_1_1);

		btnNewButton_2_1_1_3 = new JButton("");
		btnNewButton_2_1_1_3.setToolTipText("Sửa hóa đơn đang chọn");
		btnNewButton_2_1_1_3.setIcon(new ImageIcon("image\\edit.png"));
		btnNewButton_2_1_1_3.setForeground(Color.BLACK);
		btnNewButton_2_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_3.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_3.setBounds(134, 10, 52, 32);
		panel_7_1_1.add(btnNewButton_2_1_1_3);
		btnNewButton_2_1_1_3.addActionListener(this);

		btnNewButton_2_1_1_2_1 = new JButton("");
		btnNewButton_2_1_1_2_1.setToolTipText("Xóa hóa đơn đang chọn");
		btnNewButton_2_1_1_2_1.setIcon(new ImageIcon("image\\delete.png"));
		btnNewButton_2_1_1_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_2_1.setBounds(72, 10, 52, 32);
		panel_7_1_1.add(btnNewButton_2_1_1_2_1);
		btnNewButton_2_1_1_2_1.addActionListener(this);
		

		btnNewButton_2_1_1_1_1_2 = new JButton("");
		btnNewButton_2_1_1_1_1_2.setIcon(new ImageIcon("image\\clear.png"));
		btnNewButton_2_1_1_1_1_2.setToolTipText("Làm rỗng các field");
		btnNewButton_2_1_1_1_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_2.setBounds(196, 10, 52, 32);
		panel_7_1_1.add(btnNewButton_2_1_1_1_1_2);
		btnNewButton_2_1_1_1_1_2.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(47, 34, 87, 32);
		panel_5_1.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.background"));
		textField_1.setBounds(154, 34, 309, 32);
		panel_5_1.add(textField_1);
		textField_1.setToolTipText("");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(47, 76, 108, 32);
		panel_5_1.add(lblNewLabel_1_1);

		textField_3 = new JTextField();
		textField_3.setToolTipText("");
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.menu);
		textField_3.setBounds(154, 76, 309, 32);
		panel_5_1.add(textField_3);

		JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền hàng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(562, 34, 108, 32);
		panel_5_1.add(lblNewLabel_1_2);

		textField_4 = new JTextField();
		textField_4.setToolTipText("");
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBackground(SystemColor.menu);
		textField_4.setBounds(680, 34, 309, 32);
		panel_5_1.add(textField_4);

		JLabel lblNewLabel_1_2_1 = new JLabel("Giảm giá");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(562, 76, 108, 32);
		panel_5_1.add(lblNewLabel_1_2_1);

		textField_5 = new JTextField();
		textField_5.setToolTipText("");
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBackground(SystemColor.menu);
		textField_5.setBounds(680, 76, 309, 32);
		panel_5_1.add(textField_5);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày lập");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(47, 122, 95, 32);
		panel_5_1.add(lblNewLabel_1_1_1);

		dateChooser = new JDateChooser(new Date());
		dateChooser.getCalendarButton().setToolTipText("Chọn ngày");
		dateChooser.setForeground(SystemColor.activeCaption);
		dateChooser.getCalendarButton().setForeground(SystemColor.activeCaption);
		dateChooser.getCalendarButton().setBackground(SystemColor.menu);
		dateChooser.getCalendarButton().setIcon(new ImageIcon("image\\calendar.png"));
		dateChooser.setBackground(SystemColor.menu);
		dateChooser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 40));
		dateChooser.setBounds(154, 122, 163, 31);
		panel_5_1.add(dateChooser);

		btnDetailOrder = new JButton("...");
		btnDetailOrder.setToolTipText("Xem chi tiết hơn");
		btnDetailOrder.setIcon(new ImageIcon("image\\info.png"));
		btnDetailOrder.setBounds(10, 174, 49, 32);
		panel_5_1.add(btnDetailOrder);
		btnDetailOrder.addActionListener(this);

		JLabel lblQunLHa = new JLabel("Quản Lý Hóa Đơn");
		lblQunLHa.setForeground(new Color(128, 0, 255));
		lblQunLHa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLHa.setBounds(438, 10, 179, 34);
		panel_1.add(lblQunLHa);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(10, 280, 1041, 310);
		panel_1.add(panel_6_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 31, 1021, 270);
		panel_6_1.add(scrollPane_1);

		// table order
		String[] headLine_1 = { "Mã hóa đơn", "Ngày thanh toán", "Tổng tiền hàng", "Giảm giá", "Tên nhân viên" };
		model_Order = new OrderTableModel(listOrder, headLine_1);

		table_1 = new JTable(model_Order);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_1.setSelectionBackground(new Color(255, 255, 204));
		table_1.setRowHeight(35);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_1.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1.setViewportView(table_1);

		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				updateCom_4(index);
			}

			private void updateCom_4(int index) {
				textField_1.setText(listOrder.get(index).getID() + "");
				textField_3.setText(listOrder.get(index).getUsers().getID()+"");
				textField_4.setText(listOrder.get(index).getTotalPrice() + "");
				textField_5.setText(listOrder.get(index).getDiscount() + "");
				dateChooser.setDate(java.sql.Date.valueOf(listOrder.get(index).getOrderDate()));
			}
		});

		JLabel lblNewLabel_3_1_2 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(878, 14, 81, 13);
		panel_6_1.add(lblNewLabel_3_1_2);

		comboBox_3_1_2 = new JComboBox();
		comboBox_3_1_2.setModel(
				new DefaultComboBoxModel(new String[] { "Không", "Tên nhân viên", "Ngày lập", "Tổng tiền hàng" }));
		comboBox_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_3_1_2.setBounds(950, 10, 81, 20);
		panel_6_1.add(comboBox_3_1_2);
		comboBox_3_1_2.addActionListener(this);

		textField_7 = new JTextField();
		textField_7.setToolTipText("Tìm kiếm theo mã");
		textField_7.setBounds(878, 18, 132, 26);
		panel_1.add(textField_7);
		textField_7.setBackground(UIManager.getColor("Button.background"));
		textField_7.setColumns(10);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText("Tìm kiếm theo mã");
		btnNewButton_3.setBounds(1009, 18, 42, 25);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon("image\\search.png"));
		btnNewButton_3.addActionListener(this);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Nhân Viên", new ImageIcon("image\\btnPerson1.png"), panel_1_2_1, null);

		JPanel panel_5_1_2_1 = new JPanel();
		panel_5_1_2_1.setLayout(null);
		panel_5_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2_1.setBackground(Color.WHITE);
		panel_5_1_2_1.setBounds(10, 54, 1041, 216);
		panel_1_2_1.add(panel_5_1_2_1);

		JPanel panel_7_1_1_2_1 = new JPanel();
		panel_7_1_1_2_1.setLayout(null);
		panel_7_1_1_2_1.setBackground(Color.WHITE);
		panel_7_1_1_2_1.setBounds(772, 161, 259, 45);
		panel_5_1_2_1.add(panel_7_1_1_2_1);

		JButton btnNewButton_2_1_2_2_1 = new JButton("");
		btnNewButton_2_1_2_2_1.setIcon(new ImageIcon("image\\add1.png"));
		btnNewButton_2_1_2_2_1.setToolTipText("Thêm mới vào danh sách");
		btnNewButton_2_1_2_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_2_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_2_2_1.setBounds(10, 10, 52, 32);
		panel_7_1_1_2_1.add(btnNewButton_2_1_2_2_1);

		JButton btnNewButton_2_1_1_3_2_1 = new JButton("");
		btnNewButton_2_1_1_3_2_1.setIcon(new ImageIcon("image\\edit.png"));
		btnNewButton_2_1_1_3_2_1.setToolTipText("Chỉnh sửa dòng đang chọn");
		btnNewButton_2_1_1_3_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_3_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_3_2_1.setBounds(134, 10, 52, 32);
		panel_7_1_1_2_1.add(btnNewButton_2_1_1_3_2_1);

		JButton btnNewButton_2_1_1_2_1_2_1 = new JButton("");
		btnNewButton_2_1_1_2_1_2_1.setIcon(new ImageIcon("image\\delete.png"));
		btnNewButton_2_1_1_2_1_2_1.setToolTipText("Xóa dòng đang chọn");
		btnNewButton_2_1_1_2_1_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_2_1_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_2_1_2_1.setBounds(72, 10, 52, 32);
		panel_7_1_1_2_1.add(btnNewButton_2_1_1_2_1_2_1);

		JButton btnNewButton_2_1_1_1_1_2_2_1 = new JButton("");
		btnNewButton_2_1_1_1_1_2_2_1.setIcon(new ImageIcon("image\\clear.png"));
		btnNewButton_2_1_1_1_1_2_2_1.setToolTipText("Làm rỗng các field");
		btnNewButton_2_1_1_1_1_2_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_2_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_2_2_1.setBounds(196, 10, 52, 32);
		panel_7_1_1_2_1.add(btnNewButton_2_1_1_1_1_2_2_1);

		JLabel lblNewLabel_1_4_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(47, 34, 97, 32);
		panel_5_1_2_1.add(lblNewLabel_1_4_1);

		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.LEFT);
		textField_13.setToolTipText("");
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_13.setColumns(10);
		textField_13.setBackground(SystemColor.menu);
		textField_13.setBounds(154, 34, 309, 32);
		panel_5_1_2_1.add(textField_13);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(47, 76, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1);

		textField_15 = new JTextField();
		textField_15.setToolTipText("");
		textField_15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_15.setColumns(10);
		textField_15.setBackground(SystemColor.menu);
		textField_15.setBounds(154, 76, 309, 32);
		panel_5_1_2_1.add(textField_15);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(562, 118, 69, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_2_4 = new JLabel("Gmail");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4.setBounds(562, 34, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_2_4);

		textField_20 = new JTextField();
		textField_20.setToolTipText("");
		textField_20.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_20.setColumns(10);
		textField_20.setBackground(SystemColor.menu);
		textField_20.setBounds(680, 34, 309, 32);
		panel_5_1_2_1.add(textField_20);

		textField_21 = new JTextField();
		textField_21.setToolTipText("");
		textField_21.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_21.setColumns(10);
		textField_21.setBackground(SystemColor.menu);
		textField_21.setBounds(680, 76, 309, 32);
		panel_5_1_2_1.add(textField_21);

		JLabel lblNewLabel_1_2_1_3 = new JLabel("Password");
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_3.setBounds(562, 76, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_2_1_3);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nư" }));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_2.setBackground(SystemColor.menu);
		comboBox_2.setBounds(680, 119, 69, 30);
		panel_5_1_2_1.add(comboBox_2);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(776, 119, 97, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1_1);

		textField_18 = new JTextField();
		textField_18.setToolTipText("");
		textField_18.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_18.setColumns(10);
		textField_18.setBackground(SystemColor.menu);
		textField_18.setBounds(877, 119, 112, 32);
		panel_5_1_2_1.add(textField_18);

		textField_22 = new JTextField();
		textField_22.setToolTipText("");
		textField_22.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_22.setColumns(10);
		textField_22.setBackground(SystemColor.menu);
		textField_22.setBounds(154, 159, 516, 32);
		panel_5_1_2_1.add(textField_22);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1_1.setBounds(47, 159, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1_1_1);

		JLabel lblNewLabel_1_1_2_1_2 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2.setBounds(47, 118, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1_2);

		JLabel lblNewLabel_1_1_2_1_2_1 = new JLabel("Ngày vào làm");
		lblNewLabel_1_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2_1.setBounds(298, 118, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1_2_1);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setIcon(new ImageIcon("image\\calendar.png"));
		dateChooser_1.getCalendarButton().setToolTipText("Chọn ngày");
		dateChooser_1.getCalendarButton().setForeground(SystemColor.activeCaption);
		dateChooser_1.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 40));
		dateChooser_1.getCalendarButton().setBackground(SystemColor.menu);
		dateChooser_1.setForeground(SystemColor.activeCaption);
		dateChooser_1.setBackground(SystemColor.menu);
		dateChooser_1.setBounds(154, 118, 122, 31);
		panel_5_1_2_1.add(dateChooser_1);

		JDateChooser dateChooser_1_1 = new JDateChooser();
		dateChooser_1_1.getCalendarButton().setIcon(new ImageIcon("image\\calendar.png"));
		dateChooser_1_1.getCalendarButton().setToolTipText("Chọn ngày");
		dateChooser_1_1.getCalendarButton().setForeground(SystemColor.activeCaption);
		dateChooser_1_1.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 40));
		dateChooser_1_1.getCalendarButton().setBackground(SystemColor.menu);
		dateChooser_1_1.setForeground(SystemColor.activeCaption);
		dateChooser_1_1.setBackground(SystemColor.menu);
		dateChooser_1_1.setBounds(404, 118, 122, 31);
		panel_5_1_2_1.add(dateChooser_1_1);

		JLabel lblQunLNhn = new JLabel("Quản Lý Nhân Viên");
		lblQunLNhn.setForeground(new Color(128, 0, 255));
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLNhn.setBounds(438, 10, 190, 34);
		panel_1_2_1.add(lblQunLNhn);

		JPanel panel_6_1_2_1 = new JPanel();
		panel_6_1_2_1.setLayout(null);
		panel_6_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_6_1_2_1.setBackground(Color.WHITE);
		panel_6_1_2_1.setBounds(10, 280, 1041, 310);
		panel_1_2_1.add(panel_6_1_2_1);

		JScrollPane scrollPane_1_2_1 = new JScrollPane();
		scrollPane_1_2_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2_1.setBounds(10, 31, 1021, 270);
		panel_6_1_2_1.add(scrollPane_1_2_1);

		JLabel lblNewLabel_3_1_3 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_3.setBounds(878, 14, 81, 13);
		panel_6_1_2_1.add(lblNewLabel_3_1_3);

		JComboBox comboBox_3_1_3 = new JComboBox();
		comboBox_3_1_3.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên nhân viên", "Ngày vào làm" }));
		comboBox_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_3_1_3.setBounds(950, 10, 81, 20);
		panel_6_1_2_1.add(comboBox_3_1_3);

		textField_19 = new JTextField();
		textField_19.setToolTipText("Tìm kiếm theo mã");
		textField_19.setColumns(10);
		textField_19.setBackground(SystemColor.menu);
		textField_19.setBounds(878, 18, 132, 26);
		panel_1_2_1.add(textField_19);

		JButton btnNewButton_3_3_1 = new JButton("");
		btnNewButton_3_3_1.setIcon(new ImageIcon("image\\search.png"));
		btnNewButton_3_3_1.setToolTipText("Tìm kiếm theo mã");
		btnNewButton_3_3_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_3_3_1.setBounds(1009, 18, 42, 25);
		panel_1_2_1.add(btnNewButton_3_3_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Loại Hàng", new ImageIcon("image\\catagory1.png"), panel_2, null);
		panel_2.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 0, 1061, 619);
		panel_2.add(panel_1_1);

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_1.setBackground(Color.WHITE);
		panel_5_1_1.setBounds(10, 54, 1041, 216);
		panel_1_1.add(panel_5_1_1);

		JLabel lblNewLabel_1_3 = new JLabel("Loại hàng");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(50, 51, 77, 32);
		panel_5_1_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_2_2 = new JLabel("Mã loại hàng hóa");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(538, 53, 133, 32);
		panel_5_1_1.add(lblNewLabel_1_2_2);

		textField_11 = new JTextField();
		textField_11.setToolTipText("");
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_11.setColumns(10);
		textField_11.setBackground(SystemColor.menu);
		textField_11.setBounds(681, 53, 309, 32);
		panel_5_1_1.add(textField_11);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tên loại hàng hóa");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(538, 95, 133, 32);
		panel_5_1_1.add(lblNewLabel_1_2_1_1);

		textField_12 = new JTextField();
		textField_12.setToolTipText("");
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_12.setColumns(10);
		textField_12.setBackground(SystemColor.menu);
		textField_12.setBounds(681, 95, 309, 32);
		panel_5_1_1.add(textField_12);

		JPanel panel_7_1_1_1 = new JPanel();
		panel_7_1_1_1.setLayout(null);
		panel_7_1_1_1.setBackground(Color.WHITE);
		panel_7_1_1_1.setBounds(772, 161, 258, 45);
		panel_5_1_1.add(panel_7_1_1_1);

		btnNewButton_2_1_2_1 = new JButton("");
		btnNewButton_2_1_2_1.setIcon(new ImageIcon("image\\add1.png"));
		btnNewButton_2_1_2_1.setToolTipText("Thêm mới");
		btnNewButton_2_1_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_2_1.setBounds(10, 10, 52, 32);
		panel_7_1_1_1.add(btnNewButton_2_1_2_1);
		btnNewButton_2_1_2_1.addActionListener(this);

		// btn delete category
		btnNewButton_2_1_1_3_1 = new JButton("");
		btnNewButton_2_1_1_3_1.setIcon(new ImageIcon("image\\edit.png"));
		btnNewButton_2_1_1_3_1.setToolTipText("Sửa loại hàng đang chọn");
		btnNewButton_2_1_1_3_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_3_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_3_1.setBounds(134, 10, 52, 32);
		panel_7_1_1_1.add(btnNewButton_2_1_1_3_1);

		btnNewButton_2_1_1_3_1.addActionListener(this);

		btnNewButton_2_1_1_2_1_1 = new JButton("");
		btnNewButton_2_1_1_2_1_1.setIcon(new ImageIcon("image\\delete.png"));
		btnNewButton_2_1_1_2_1_1.setToolTipText("Xóa loại hàng đang chọn");
		btnNewButton_2_1_1_2_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_2_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_2_1_1.setBounds(72, 10, 52, 32);
		panel_7_1_1_1.add(btnNewButton_2_1_1_2_1_1);

		btnNewButton_2_1_1_2_1_1.addActionListener(this);

		// làm rỗng field catagory
		btnNewButton_2_1_1_1_1_2_1 = new JButton("");
		btnNewButton_2_1_1_1_1_2_1.setIcon(new ImageIcon("image\\clear.png"));
		btnNewButton_2_1_1_1_1_2_1.setToolTipText("Làm rỗng các field");
		btnNewButton_2_1_1_1_1_2_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_2_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_2_1.setBounds(196, 10, 52, 32);
		panel_7_1_1_1.add(btnNewButton_2_1_1_1_1_2_1);
		btnNewButton_2_1_1_1_1_2_1.addActionListener(this);

		// thêm tên loại hàng vào comboBox
		comboBoxContent = new ArrayList<>();
		comboBoxContent.add("All");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBoxContent.add(i.getName());
		});
		comboBox = new JComboBox(comboBoxContent.toArray());

		comboBox.addActionListener(this);

		comboBox.setToolTipText("Đổ danh sách theo loại hàng chọn");
		comboBox.setBackground(SystemColor.menu);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(134, 53, 289, 32);
		panel_5_1_1.add(comboBox);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1.setBounds(50, 95, 77, 32);
		panel_5_1_1.add(lblNewLabel_1_2_1_1_1);

		textField_33 = new JTextField();
		textField_33.setEditable(false);
		textField_33.setToolTipText("Số lượng có trong hạng mục đã chọn");
		textField_33.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_33.setColumns(10);
		textField_33.setBackground(SystemColor.menu);
		textField_33.setBounds(134, 95, 42, 32);
		panel_5_1_1.add(textField_33);

		textField_33.setText((categoriesServiceImpl.getListProductNullCategories().size()) + "");

		JLabel lblQunLHa_1 = new JLabel("Quản Lý Loại Hàng");
		lblQunLHa_1.setForeground(new Color(128, 0, 255));
		lblQunLHa_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLHa_1.setBounds(438, 10, 195, 34);
		panel_1_1.add(lblQunLHa_1);

		JPanel panel_6_1_1 = new JPanel();
		panel_6_1_1.setLayout(null);
		panel_6_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch m\u1EB7t h\u00E0ng theo h\u1EA1ng m\u1EE5c", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		panel_6_1_1.setBackground(Color.WHITE);
		panel_6_1_1.setBounds(10, 280, 1041, 310);
		panel_1_1.add(panel_6_1_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_1.setBounds(10, 31, 1021, 270);
		panel_6_1_1.add(scrollPane_1_1);

		// table_catagory
		headline_2 = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Mã loại hàng", "Giá sản phẩm" };
		model_category = new CategoriesTableModel(listProductCategory, headline_2);

		table_2 = new JTable(model_category);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_2.setSelectionBackground(new Color(255, 255, 204));
		table_2.setRowHeight(35);
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_2.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_1.setViewportView(table_2);

		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_2.getSelectedRow();
				updateCom_2(index);
			}

			private void updateCom_2(int index) {
				textField_11.setText(listProductCategory.get(index).getCategories().getID() + "");
				textField_12.setText(listProductCategory.get(index).getCategories().getName());
			}
		});

		JLabel lblNewLabel_3_1_4 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_4.setBounds(878, 14, 81, 13);
		panel_6_1_1.add(lblNewLabel_3_1_4);

		comboBox_3_1_4 = new JComboBox();
		comboBox_3_1_4.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên loại hàng" }));
		comboBox_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_3_1_4.setBounds(950, 10, 81, 20);
		panel_6_1_1.add(comboBox_3_1_4);
		comboBox_3_1_4.addActionListener(this);

		textField_14 = new JTextField();
		textField_14.setToolTipText("Tìm kiếm theo mã");
		textField_14.setColumns(10);
		textField_14.setBackground(UIManager.getColor("Button.background"));
		textField_14.setBounds(878, 18, 132, 26);
		panel_1_1.add(textField_14);

		// btn search category
		btnNewButton_3_2 = new JButton("");
		btnNewButton_3_2.setIcon(new ImageIcon("image\\search.png"));
		btnNewButton_3_2.setToolTipText("Tìm kiếm theo mã");
		btnNewButton_3_2.setBounds(1009, 18, 42, 25);
		panel_1_1.add(btnNewButton_3_2);
		btnNewButton_3_2.addActionListener(this);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Mặt Hàng", new ImageIcon("image\\btnCatogory1.png"), panel_1_2, null);

		JPanel panel_5_1_2 = new JPanel();
		panel_5_1_2.setLayout(null);
		panel_5_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2.setBackground(Color.WHITE);
		panel_5_1_2.setBounds(10, 54, 1041, 216);
		panel_1_2.add(panel_5_1_2);

		JPanel panel_7_1_1_2 = new JPanel();
		panel_7_1_1_2.setLayout(null);
		panel_7_1_1_2.setBackground(Color.WHITE);
		panel_7_1_1_2.setBounds(772, 161, 257, 45);
		panel_5_1_2.add(panel_7_1_1_2);

		btnNewButton_2_1_2_2 = new JButton("");
		btnNewButton_2_1_2_2.setIcon(new ImageIcon("image\\add1.png"));
		btnNewButton_2_1_2_2.setToolTipText("Thêm mới vào danh sách");
		btnNewButton_2_1_2_2.setForeground(Color.BLACK);
		btnNewButton_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_2_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_2_2.setBounds(10, 10, 52, 32);
		panel_7_1_1_2.add(btnNewButton_2_1_2_2);
		btnNewButton_2_1_2_2.addActionListener(this);

		btnNewButton_2_1_1_3_2 = new JButton("");
		btnNewButton_2_1_1_3_2.setIcon(new ImageIcon("image\\edit.png"));
		btnNewButton_2_1_1_3_2.setToolTipText("Chỉnh sửa dòng đang chọn");
		btnNewButton_2_1_1_3_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_3_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_3_2.setBounds(134, 10, 52, 32);
		panel_7_1_1_2.add(btnNewButton_2_1_1_3_2);
		btnNewButton_2_1_1_3_2.addActionListener(this);

		btnNewButton_2_1_1_2_1_2 = new JButton("");
		btnNewButton_2_1_1_2_1_2.setIcon(new ImageIcon("image\\delete.png"));
		btnNewButton_2_1_1_2_1_2.setToolTipText("Xóa dòng đang chọn");
		btnNewButton_2_1_1_2_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_2_1_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_2_1_2.setBounds(72, 10, 52, 32);
		panel_7_1_1_2.add(btnNewButton_2_1_1_2_1_2);
		btnNewButton_2_1_1_2_1_2.addActionListener(this);

		btnNewButton_2_1_1_1_1_2_2 = new JButton("");
		btnNewButton_2_1_1_1_1_2_2.setIcon(new ImageIcon("image\\clear.png"));
		btnNewButton_2_1_1_1_1_2_2.setToolTipText("Làm rỗng các field");
		btnNewButton_2_1_1_1_1_2_2.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_2_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_2_2.setBounds(196, 10, 52, 32);
		panel_7_1_1_2.add(btnNewButton_2_1_1_1_1_2_2);
		btnNewButton_2_1_1_1_1_2_2.addActionListener(this);

		JLabel lblNewLabel_1_4 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(47, 34, 97, 32);
		panel_5_1_2.add(lblNewLabel_1_4);

		textField_9 = new JTextField();
		textField_9.setToolTipText("Nhập mã sản phẩm");
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBackground(SystemColor.menu);
		textField_9.setBounds(154, 34, 309, 32);
		panel_5_1_2.add(textField_9);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(47, 76, 108, 32);
		panel_5_1_2.add(lblNewLabel_1_1_2);

		textField_10 = new JTextField();
		textField_10.setToolTipText("Nhập ngày lập hóa đơn");
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_10.setColumns(10);
		textField_10.setBackground(SystemColor.menu);
		textField_10.setBounds(154, 76, 309, 32);
		panel_5_1_2.add(textField_10);

		JLabel lblNewLabel_1_2_3 = new JLabel("Nhà cung cấp");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_3.setBounds(562, 34, 108, 32);
		panel_5_1_2.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Loại hàng");
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_2.setBounds(562, 76, 108, 32);
		panel_5_1_2.add(lblNewLabel_1_2_1_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giá thành");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(47, 122, 95, 32);
		panel_5_1_2.add(lblNewLabel_1_1_1_1);

		textField_16 = new JTextField();
		textField_16.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		textField_16.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_16.setColumns(10);
		textField_16.setBackground(SystemColor.menu);
		textField_16.setBounds(154, 122, 309, 32);
		panel_5_1_2.add(textField_16);

		// comboBox nhà cung cấp - product
		comboBox_1Content = new ArrayList<>();
		comboBox_1Content.add("Null");
		suppliersServiceImpl.getListSuppliers().forEach(i -> {
			comboBox_1Content.add(i.getName());
		});

		comboBox_1 = new JComboBox(comboBox_1Content.toArray());
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1.setBackground(SystemColor.menu);
		comboBox_1.setBounds(680, 34, 309, 30);
		panel_5_1_2.add(comboBox_1);

		// comboBox loại hàng - product
		comboBox_1_1Content = new ArrayList<>();
		comboBox_1_1Content.add("Null");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBox_1_1Content.add(i.getName());
		});
		comboBox_1_1 = new JComboBox(comboBox_1_1Content.toArray());
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox_1_1.setBackground(SystemColor.menu);
		comboBox_1_1.setBounds(680, 79, 309, 30);
		panel_5_1_2.add(comboBox_1_1);

// chi tiết sản phẩm - product
		btnDetailItem = new JButton("...");
		btnDetailItem.setIcon(new ImageIcon("image\\info.png"));
		btnDetailItem.setToolTipText("Xem chi tiết hơn");
		btnDetailItem.setBounds(10, 174, 49, 32);
		panel_5_1_2.add(btnDetailItem);
		btnDetailItem.addActionListener(this);

		JLabel lblQunLMt = new JLabel("Quản Lý Mặt Hàng");
		lblQunLMt.setForeground(new Color(128, 0, 255));
		lblQunLMt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLMt.setBounds(438, 10, 190, 34);
		panel_1_2.add(lblQunLMt);

		JPanel panel_6_1_2 = new JPanel();
		panel_6_1_2.setLayout(null);
		panel_6_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch m\u1EB7t h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6_1_2.setBackground(Color.WHITE);
		panel_6_1_2.setBounds(10, 280, 1041, 310);
		panel_1_2.add(panel_6_1_2);

		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2.setBounds(10, 31, 1021, 270);
		panel_6_1_2.add(scrollPane_1_2);

		// table Product
		headline_3 = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Mã loại hàng", "Giá sản phẩm" };
		model_product = new ProductTableModel(listProductCategory, headline_3);

		table_3 = new JTable(model_product);
		table_3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_3.setSelectionBackground(new Color(255, 255, 204));
		table_3.setRowHeight(35);
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_3.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_2.setViewportView(table_3);

		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_3.getSelectedRow();
				updateCom_3(index);
			}

			private void updateCom_3(int index) {
				textField_9.setText(listProduct.get(index).getID() + "");
				textField_10.setText(listProduct.get(index).getName());
				textField_16.setText(listProduct.get(index).getPrice() + "");
				comboBox_1_1.setSelectedIndex(listProduct.get(index).getSuppliers().getID());
				comboBox_1.setSelectedIndex(listProduct.get(index).getSuppliers().getID());
			}
		});

		JLabel lblNewLabel_3_1_5 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_5.setBounds(878, 14, 81, 13);
		panel_6_1_2.add(lblNewLabel_3_1_5);

		// sort category
		comboBox_3_1_5 = new JComboBox();
		comboBox_3_1_5.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Giá" }));
		comboBox_3_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_3_1_5.setBounds(950, 10, 81, 20);
		panel_6_1_2.add(comboBox_3_1_5);
		comboBox_3_1_5.addActionListener(this);

		textField_17 = new JTextField();
		textField_17.setToolTipText("Tìm kiếm theo mã");
		textField_17.setColumns(10);
		textField_17.setBackground(SystemColor.menu);
		textField_17.setBounds(878, 18, 132, 26);
		panel_1_2.add(textField_17);

		btnNewButton_3_3 = new JButton("");
		btnNewButton_3_3.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_3_3.setIcon(new ImageIcon("image\\search.png"));
		btnNewButton_3_3.setToolTipText("Tìm kiếm theo mã");
		btnNewButton_3_3.setBounds(1009, 18, 42, 25);
		panel_1_2.add(btnNewButton_3_3);
		btnNewButton_3_3.addActionListener(this);

		JPanel panel_1_2_1_1 = new JPanel();
		panel_1_2_1_1.setLayout(null);
		panel_1_2_1_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Thông Tin Của Bạn", new ImageIcon("image\\btnProfile1.png"), panel_1_2_1_1, null);

		JPanel panel_5_1_2_1_1 = new JPanel();
		panel_5_1_2_1_1.setLayout(null);
		panel_5_1_2_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2_1_1.setBackground(Color.WHITE);
		panel_5_1_2_1_1.setBounds(10, 54, 1041, 440);
		panel_1_2_1_1.add(panel_5_1_2_1_1);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1_1.setBounds(78, 49, 97, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_4_1_1);

		textField_29 = new JTextField();
		textField_29.setEditable(false);
		textField_29.setToolTipText("");
		textField_29.setHorizontalAlignment(SwingConstants.LEFT);
		textField_29.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_29.setColumns(10);
		textField_29.setBackground(SystemColor.menu);
		textField_29.setBounds(185, 49, 309, 32);
		panel_5_1_2_1_1.add(textField_29);

		JLabel lblNewLabel_1_1_2_1_3 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_3.setBounds(78, 91, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_3);

		textField_30 = new JTextField();
		textField_30.setEditable(false);
		textField_30.setToolTipText("");
		textField_30.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_30.setColumns(10);
		textField_30.setBackground(SystemColor.menu);
		textField_30.setBounds(185, 91, 309, 32);
		panel_5_1_2_1_1.add(textField_30);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(78, 133, 69, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_2_4_1 = new JLabel("Gmail");
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4_1.setBounds(561, 49, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_2_4_1);

		textField_31 = new JTextField();
		textField_31.setEditable(false);
		textField_31.setToolTipText("");
		textField_31.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_31.setColumns(10);
		textField_31.setBackground(SystemColor.menu);
		textField_31.setBounds(679, 49, 309, 32);
		panel_5_1_2_1_1.add(textField_31);

		textField_32 = new JTextField();
		textField_32.setToolTipText("");
		textField_32.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_32.setColumns(10);
		textField_32.setBackground(SystemColor.menu);
		textField_32.setBounds(679, 91, 274, 32);
		panel_5_1_2_1_1.add(textField_32);

		JLabel lblNewLabel_1_2_1_3_1 = new JLabel("Password");
		lblNewLabel_1_2_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_3_1.setBounds(561, 91, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_2_1_3_1);

		JLabel lblNewLabel_1_1_2_1_1_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_1_1_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1_1_1.setBounds(78, 307, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_1_1_1);

		JLabel lblNewLabel_1_1_2_1_2_2 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2_2.setBounds(78, 177, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_2_2);

		JLabel lblNewLabel_1_1_2_1_2_1_1 = new JLabel("Ngày vào làm");
		lblNewLabel_1_1_2_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2_1_1.setBounds(78, 220, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_2_1_1);

		textField_35 = new JTextField();
		textField_35.setEditable(false);
		textField_35.setToolTipText("");
		textField_35.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_35.setColumns(10);
		textField_35.setBackground(SystemColor.menu);
		textField_35.setBounds(185, 177, 309, 32);
		panel_5_1_2_1_1.add(textField_35);

		textField_36 = new JTextField();
		textField_36.setEditable(false);
		textField_36.setToolTipText("");
		textField_36.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_36.setColumns(10);
		textField_36.setBackground(SystemColor.menu);
		textField_36.setBounds(185, 220, 309, 32);
		panel_5_1_2_1_1.add(textField_36);

		textField_37 = new JTextField();
		textField_37.setToolTipText("");
		textField_37.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_37.setEditable(false);
		textField_37.setColumns(10);
		textField_37.setBackground(SystemColor.menu);
		textField_37.setBounds(185, 133, 309, 32);
		panel_5_1_2_1_1.add(textField_37);

		JLabel lblNewLabel_1_1_2_1_2_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2_1_1_1.setBounds(78, 262, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_2_1_1_1);

		textField_38 = new JTextField();
		textField_38.setToolTipText("");
		textField_38.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_38.setEditable(false);
		textField_38.setColumns(10);
		textField_38.setBackground(SystemColor.menu);
		textField_38.setBounds(185, 262, 309, 32);
		panel_5_1_2_1_1.add(textField_38);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.menu);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textPane.setBounds(185, 307, 309, 84);
		panel_5_1_2_1_1.add(textPane);

		JButton btnNewButton_2_1_1_1_1_3_1_1 = new JButton("");
		btnNewButton_2_1_1_1_1_3_1_1.setIcon(new ImageIcon("image\\save.png"));
		btnNewButton_2_1_1_1_1_3_1_1.setToolTipText("Cập nhật mật khẩu");
		btnNewButton_2_1_1_1_1_3_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_3_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_3_1_1.setBounds(936, 133, 52, 32);
		panel_5_1_2_1_1.add(btnNewButton_2_1_1_1_1_3_1_1);

		JButton btnNewButton_2_1_1_1_1_3_1_1_1 = new JButton("");
		btnNewButton_2_1_1_1_1_3_1_1_1.setIcon(new ImageIcon("image\\password.png"));
		btnNewButton_2_1_1_1_1_3_1_1_1.setToolTipText("Xem mật khẩu");
		btnNewButton_2_1_1_1_1_3_1_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_3_1_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_3_1_1_1.setBounds(951, 91, 37, 31);
		panel_5_1_2_1_1.add(btnNewButton_2_1_1_1_1_3_1_1_1);

		JLabel lblThngTinCa = new JLabel("Thông Tin Của Bạn");
		lblThngTinCa.setForeground(new Color(128, 0, 255));
		lblThngTinCa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinCa.setBounds(438, 10, 190, 34);
		panel_1_2_1_1.add(lblThngTinCa);

		JTextPane txtpnTnTi = new JTextPane();
		txtpnTnTi.setText(
				"Tên đề tài:   Quản lý siêu thị.\r\nHướng dẫn: THS. Nguyễn Thị Hoàng Khánh.\r\nThực hiện:   Huỳnh Quốc Bảo - Nguyễn Văn Sơn.");
		txtpnTnTi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnTnTi.setEditable(false);
		txtpnTnTi.setBackground(Color.WHITE);
		txtpnTnTi.setBounds(371, 513, 359, 66);
		panel_1_2_1_1.add(txtpnTnTi);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.menu);
		toolBar.setBounds(0, 0, 1086, 30);
		contentPane.add(toolBar);

		JButton btnOrder = new JButton("");
		btnOrder.setToolTipText("Thanh toán hóa đơn");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder.setIcon(new ImageIcon("image\\btnAdd.png"));
		toolBar.add(btnOrder);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setToolTipText("Hủy chi tiết một đơn hàng");
		btnNewButton_4.setIcon(new ImageIcon("image\\delete-item.png"));
		toolBar.add(btnNewButton_4);

		JButton btnBill = new JButton("");
		btnBill.setToolTipText("Quản lý hóa đơn");
		btnBill.setIcon(new ImageIcon("image\\btnBill.png"));
		toolBar.add(btnBill);

		JButton btnPerson = new JButton("");
		btnPerson.setIcon(new ImageIcon("image\\btnPerson.png"));
		btnPerson.setToolTipText("Quản lý nhân viên");
		toolBar.add(btnPerson);

		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Quản lý loại hàng");
		btnNewButton.setIcon(new ImageIcon("image\\catagory.png"));
		toolBar.add(btnNewButton);

		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon("image\\btnCatogory.png"));
		btnNewButton_5.setToolTipText("Quản lý mặt hàng");
		toolBar.add(btnNewButton_5);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Xem thông tin của bạn");
		btnNewButton_1.setIcon(new ImageIcon("image\\btnProfile.png"));
		toolBar.add(btnNewButton_1);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { tabbedPane }));

		this.setLocationRelativeTo(null);

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

// Event Category
		// combobox category
		if (o.equals(comboBox)) {
			if (comboBox.getSelectedIndex() == 0) {
				textField_11.setText("");
				textField_12.setText("");
				textField_11.setEditable(true);

				updateTableCategory();

				comboBox_3_1_4.setSelectedIndex(0);
				textField_33.setText((categoriesServiceImpl.getListProductNullCategories().size()) + "");
				return;
			}
			for (int i = 1; i <= categoriesServiceImpl.getListCategories().size(); i++) {
				if (comboBox.getSelectedIndex() == i) {
					textField_11.setText(comboBox.getSelectedIndex() + "");
					textField_12.setText(comboBox.getSelectedItem().toString());
					textField_11.setEditable(false);
					comboBox_3_1_4.setSelectedIndex(0);
					textField_33.setText((categoriesServiceImpl.getListProductByCategoriesID(i).size()) + "");

					listProductCategory = categoriesServiceImpl.getListProductByCategoriesID(i);
					model_category.setProducts(listProductCategory);
					table_2.setModel(model_category);
					table_2.updateUI();
					return;
				}
			}
		}

		// btn làm rỗng field category
		if (o.equals(btnNewButton_2_1_1_1_1_2_1)) {
			textField_11.setText("");
			textField_12.setText("");
			textField_11.setEditable(true);
			textField_14.setText("");
			comboBox.setSelectedIndex(0);
		}

		// btn add category
		if (o.equals(btnNewButton_2_1_2_1)) {
			if (textField_11.getText().strip() == "" || textField_12.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Không được để trống các field", "Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(textField_11.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Mã loại hàng hóa\" phải là số nguyên", "Quản Lý Siêu Thị", 2);
				return;
			}

			try {
				categoriesServiceImpl.addCategories(new Categories(id, textField_12.getText()));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Trùng\"Mã loại hàng hóa\"", "Quản Lý Siêu Thị",
						2);
				return;
			}
			updateComboBoxCategory();
			JOptionPane.showMessageDialog(this, "Thêm thành công", "Quản Lý Siêu Thị", 1);
		}

		// btn delete category
		if (o.equals(btnNewButton_2_1_1_2_1_1)) {
			if (comboBox.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn loại hàng để xóa!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa loại hàng \""
					+ comboBoxContent.get(comboBox.getSelectedIndex()) + "\"?\n", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				boolean kq = categoriesServiceImpl.DelCategories(comboBox.getSelectedIndex());

				if (kq) {
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
					updateComboBoxCategory();
				} else
					JOptionPane.showMessageDialog(this, "Xóa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else {
				return;
			}
		}

		// btn edit category
		if (o.equals(btnNewButton_2_1_1_3_1)) {
			if (comboBox.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn loại hàng để sửa!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (textField_12.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Tên loại hàng hóa không được để trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			int i = JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn sửa loại hàng \"" + comboBoxContent.get(comboBox.getSelectedIndex())
							+ "\" thành \"" + textField_12.getText() + "\"?\n",
					"Quản Lý Siêu Thị", 2);
			if (i == 0) {
				Categories categories = new Categories(Integer.parseInt(textField_11.getText()),
						textField_12.getText());
				boolean kq = categoriesServiceImpl.UpdateCategories(categories);
				if (kq) {
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Quản Lý Siêu Thị", 2);
					updateComboBoxCategory();
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else
				return;
		}

		// search category
		if (o.equals(btnNewButton_3_2)) {
			if (textField_14.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (!textField_14.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hàng hóa phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Categories categories = categoriesServiceImpl.searchCategories(Integer.parseInt(textField_14.getText()));
			if (categories == null) {
				JOptionPane.showMessageDialog(this, "Mã hàng hóa \" " + textField_14.getText() + " \" không tồn tại!",
						"Quản Lý Siêu Thị", 2);
				return;
			}

			comboBox.setSelectedIndex(Integer.parseInt(textField_14.getText()));
		}

		// sort category
		if (o.equals(comboBox_3_1_4)) {
			if (comboBox_3_1_4.getSelectedIndex() == 0) {
				updateTableCategory();
				return;
			}
			Collections.sort(listProductCategory, (o1, o2) -> o1.getName().compareTo(o2.getName()));
			model_category.setProducts(listProductCategory);
			table_2.setModel(model_category);
			table_2.updateUI();
		}

// Event product

		// làm rỗng các field
		if (o.equals(btnNewButton_2_1_1_1_1_2_2)) {
			textField_9.setText("");
			textField_10.setText("");
			textField_16.setText("");
			textField_14.setText("");
			textField_17.setText("");
			comboBox_1.setSelectedIndex(0);
			comboBox_1_1.setSelectedIndex(0);
			updateTableProduct();
		}

		// chi tiết sản phẩm - product
		if (btnDetailItem.equals(o)) {
			if (table_3.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm!", "Quản Lý Siêu Thị", 2);
				return;
			}
			new DetailItem_gui(listProduct.get(table_3.getSelectedRow())).setVisible(true);

		}

		// add - product
		if (o.equals(btnNewButton_2_1_2_2)) {
			if (textField_9.getText().strip() == "" || textField_10.getText().strip() == ""
					|| textField_16.getText().strip() == "" || comboBox_1.getSelectedIndex() == 0
					|| comboBox_1_1.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Không được để trống các field và tùy chọn không Null",
						"Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(textField_9.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Mã sản phẩm \" phải là số nguyên", "Quản Lý Siêu Thị", 2);
				return;
			}
			BigDecimal price;
			try {
				price = BigDecimal.valueOf(Double.parseDouble(textField_16.getText()));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Giá sản phẩm \" phải là số nguyên", "Quản Lý Siêu Thị", 2);
				return;
			}

			try {
				Product product = new Product(id, textField_10.getText(), price,
						suppliersServiceImpl.searchSuppliers(comboBox_1.getSelectedIndex()),
						categoriesServiceImpl.searchCategories(comboBox_1_1.getSelectedIndex()));
				productServiceImpl.addProduct(product);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Trùng\"Mã sản phẩm\"", "Quản Lý Siêu Thị", 2);
				return;
			}
			updateTableProduct();
			JOptionPane.showMessageDialog(this, "Thêm thành công", "Quản Lý Siêu Thị", 1);
		}

		// btn delete - product
		if (o.equals(btnNewButton_2_1_1_2_1_2)) {
			if (table_3.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm để xóa!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm có mã \""
					+ listProduct.get(table_3.getSelectedRow()).getID() + "\"?\n", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				boolean kq = productServiceImpl.DelProduct(listProduct.get(table_3.getSelectedRow()).getID());

				if (kq) {
					updateTableProduct();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Xóa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else {
				return;
			}
		}

		// btn edit product
		if (o.equals(btnNewButton_2_1_1_3_2)) {
			if (table_3.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm để sửa!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (textField_9.getText().strip() == "" || textField_10.getText().strip() == ""
					|| textField_16.getText().strip() == "" || comboBox_1.getSelectedIndex() == 0
					|| comboBox_1_1.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Không được để trống các field và tùy chọn không Null",
						"Quản Lý Siêu Thị", 2);
				return;
			}

			// không được sửa mã
			if (Integer.parseInt(textField_9.getText().strip()) != listProduct.get(table_3.getSelectedRow()).getID()) {
				textField_9.setText(listProduct.get(table_3.getSelectedRow()).getID() + "");
				JOptionPane.showMessageDialog(this, "Không được sửa mã sản phẩm!", "Quản Lý Siêu Thị", 2);
				return;
			}

			int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa sản phẩm đang chọn" + " ?\n",
					"Quản Lý Siêu Thị", 2);

			if (i == 0) {
				Product product = new Product(listProduct.get(table_3.getSelectedRow()).getID(),
						textField_10.getText().strip(),
						BigDecimal.valueOf(Double.parseDouble(textField_16.getText().strip())),
						suppliersServiceImpl.searchSuppliers(comboBox_1.getSelectedIndex()),
						categoriesServiceImpl.searchCategories(comboBox_1_1.getSelectedIndex()));
				boolean kq = productServiceImpl.updateProduct(product);
				if (kq) {
					updateTableProduct();
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else
				return;
		}

		// search product
		if (o.equals(btnNewButton_3_3)) {
			if (textField_17.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (!textField_17.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hàng hóa phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Product product = productServiceImpl.searchProduct(Integer.parseInt(textField_17.getText()));
			if (product == null) {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm \" " + textField_17.getText() + " \" không tồn tại!",
						"Quản Lý Siêu Thị", 2);
				return;
			}
			listProduct = new ArrayList<>();
			listProduct.add(product);
			model_product.setProducts(listProduct);
			table_3.setModel(model_product);
			table_3.updateUI();

			textField_9.setText(product.getID() + "");
			textField_10.setText(product.getName());
			textField_16.setText(product.getPrice() + "");
			comboBox_1_1.setSelectedIndex(product.getSuppliers().getID());
			comboBox_1.setSelectedIndex(product.getSuppliers().getID());

		}
		// sort product
		if (o.equals(comboBox_3_1_5)) {
			if (comboBox_3_1_5.getSelectedIndex() == 0) {
				updateTableProduct();
				return;
			} else if (comboBox_3_1_5.getSelectedIndex() == 1) {
				Collections.sort(listProduct, (o1, o2) -> o1.getName().compareTo(o2.getName()));
				model_product.setProducts(listProduct);
				table_3.setModel(model_product);
				table_3.updateUI();
			} else {
				Collections.sort(listProduct, (o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
				model_product.setProducts(listProduct);
				table_3.setModel(model_product);
				table_3.updateUI();
			}

		}

// Event Order	

		// làm rỗng field - order
		if (o.equals(btnNewButton_2_1_1_1_1_2)) {
			textField_7.setText("");
			textField_1.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			dateChooser.setDate(new Date());
			
			updateTableOrder();
		}

		// delete - order
		if(o.equals(btnNewButton_2_1_1_2_1)) {
			if (table_1.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, 
					"Bạn có chắc chắn muốn xóa hóa đơn có mã \""+listOrder.get(table_1.getSelectedRow()).getID()+"\" không?"
					, "Quản Lý Siêu Thị", 2);
			if(i==0) {
				try {
					ordersServiceImpl.delOrder(listOrder.get(table_1.getSelectedRow()).getID());
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
				
					updateTableOrder();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Quản Lý Siêu Thị", 2);
				}
			}else return;
		}
		
		//edit Order
		if(o.equals(btnNewButton_2_1_1_3)) {
			if (table_1.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}
			
			if (Integer.parseInt(textField_1.getText().strip()) != listOrder.get(table_1.getSelectedRow()).getID()) {
				textField_1.setText(listOrder.get(table_1.getSelectedRow()).getID()+"");
				JOptionPane.showMessageDialog(this, "Không được sửa mã hóa đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}
			Users users = usersServiceImpl.searchUsers(Integer.parseInt(textField_3.getText()));
			
			if (users == null) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên \""+textField_3.getText()+"\" không tồn tại", "Quản Lý Siêu Thị", 2);
				textField_3.setText(""+listOrder.get(table_1.getSelectedRow()).getUsers().getID());
				return;
			}
			LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate()));

			if(!LocalDate.now().isAfter(localDate)) {
				if(LocalDate.now().isEqual(localDate)) {
				}else {
					dateChooser.setDate(java.sql.Date.valueOf(listOrder.get(table_1.getSelectedRow()).getOrderDate()));
					JOptionPane.showMessageDialog(this, "Ngày lập hóa đơn không lớn hơn ngày hiện tại!", "Quản Lý Siêu Thị", 2);
					return;
				}
			}
			
			int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa hóa đơn đang chọn" + " ?\n",
					"Quản Lý Siêu Thị", 2);
			
			if (i == 0) {
				Order order = new Order(
						listOrder.get(table_1.getSelectedRow()).getID(),
						localDate,
						BigDecimal.valueOf(Double.parseDouble(textField_4.getText())),
						Double.parseDouble(textField_5.getText()),
						users
						);
				
				boolean kq = ordersServiceImpl.updateOrder(order);
				if (kq) {
					updateTableOrder();
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else
				return;
		}
		
		// search -order
		if (o.equals(btnNewButton_3)) {
			if (textField_7.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (!textField_7.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hóa đơn phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Order order = ordersServiceImpl.searchOrder(Integer.parseInt(textField_7.getText().strip()));
			if (order == null) {
				JOptionPane.showMessageDialog(this, "Mã hóa đơn \" " + textField_7.getText() + " \" không tồn tại!",
						"Quản Lý Siêu Thị", 2);
				return;
			}
			listOrder=new ArrayList<>();
			listOrder.add(order);
			model_Order.setOrders(listOrder);
			table_1.setModel(model_Order);
			table_1.updateUI();
			
			textField_1.setText(order.getID() + "");
			textField_3.setText(order.getUsers().getID() + "");
			textField_4.setText(order.getTotalPrice()+"");
			textField_5.setText(order.getDiscount() + "");
			dateChooser.setDate(new Date());
		}
		
		// detail order
		if (btnDetailOrder.equals(o)) {
			if (table_1.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}
			
			new DetailOrder_gui(listOrder.get(table_1.getSelectedRow())).setVisible(true);
		}
		
		// sort order 
		if (o.equals(comboBox_3_1_2)) {

			if (comboBox_3_1_2.getSelectedIndex() == 0) {
				updateTableOrder();
			} else if (comboBox_3_1_2.getSelectedIndex() == 1) {
				Collections.sort(listOrder,
						(o1, o2) -> o1.getUsers().getName().compareTo(o2.getUsers().getName()));
				table_1.updateUI();
			} else if (comboBox_3_1_2.getSelectedIndex() == 2) {
				Collections.sort(listOrder, (o1, o2) -> (o1.getOrderDate().isAfter(o2.getOrderDate())) ? -1 : 1);
				table_1.updateUI();
			} else {
				Collections.sort(listOrder,
						(o1, o2) -> o2.getTotalPrice().compareTo(o1.getTotalPrice()));
				table_1.updateUI();
			}
		}
		

//Event Thanh toán hóa đơn	

		// add cartItem vào ds temp
		if (o.equals(btnNewButton_2)) {
			if (textField.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm vào field", "Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(textField.getText().strip());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm phải là số nguyên dương", "Quản Lý Siêu Thị", 2);
				return;
			}
			Product product = productServiceImpl.searchProduct(id);
			if (product == null) {
				JOptionPane.showMessageDialog(this, "Mã sản phẩm \" " + id + " \" không tồn tại", "Quản Lý Siêu Thị",
						2);
				return;
			}

			idOrder_temp = listOrder.get(listOrder.size() - 1).getID() + 1;

			CartItem cartItem = new CartItem(1, id, new Order(idOrder_temp), product);
			cartItem.setQuantity(Integer.parseInt(spinner.getValue().toString()));
			listCartItem_temp.add(cartItem);
			
			updateTableCartItem();
			updateTotalPrice();

			textField.setText("");
			spinner.setValue(1);
		}

		// làm rỗng field - cartItem
		if (o.equals(btnNewButton_2_1_1)) {
			textField.setText("");
			spinner.setValue(1);
		}

		// delete 1 dòng trong ds cartItem_temp
		if (o.equals(btnNewButton_2_1)) {
			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để xóa", "Quản Lý Siêu Thị", 2);
				return;
			}
			listCartItem_temp.remove(table.getSelectedRow());
			
			updateTableCartItem();
			updateTotalPrice();
			
			JOptionPane.showMessageDialog(this, "Xóa thành công", "Quản Lý Siêu Thị", 1);
		}

		// edit cartItem_temp
		if (o.equals(btnNewButton_2_1_1_2)) {
			if (table.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để xóa", "Quản Lý Siêu Thị", 2);
				return;
			}
			listCartItem_temp.get(table.getSelectedRow())
					.setProduct(productServiceImpl.searchProduct(Integer.parseInt(textField.getText())));
			listCartItem_temp.get(table.getSelectedRow()).setQuantity(Integer.parseInt(spinner.getValue().toString()));
			
			updateTableCartItem();
			updateTotalPrice();
			
			textField.setText("");
			spinner.setValue(1);
			JOptionPane.showMessageDialog(this, "Sửa thành công", "Quản Lý Siêu Thị", 1);
		}

		// sort cartItem_temp
		if (o.equals(comboBox_3_1)) {

			if (comboBox_3_1.getSelectedIndex() == 0) {
				updateTableCartItem();
			} else if (comboBox_3_1.getSelectedIndex() == 1) {
				Collections.sort(listCartItem_temp,
						(o1, o2) -> o1.getProduct().getName().compareTo(o2.getProduct().getName()));
				updateTableCartItem();
			} else if (comboBox_3_1.getSelectedIndex() == 2) {
				Collections.sort(listCartItem_temp, (o1, o2) -> (o1.getQuantity() > o2.getQuantity()) ? -1 : 1);
				updateTableCartItem();
			} else {
				Collections.sort(listCartItem_temp,
						(o1, o2) -> o2.getProduct().getPrice().compareTo(o1.getProduct().getPrice()));
				updateTableCartItem();
			}
		}

		// Thanh toán - add cartItem
		if (o.equals(btnNewButton_2_1_1_1)) {
			if (listCartItem_temp.size() == 0) {
				JOptionPane.showMessageDialog(this, "Hóa đơn rỗng", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận thanh toán", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				try {
					int cartItemID =listCartItem.get(listCartItem.size()-1).getID()+1;
					
					double totalPrice = 0;
					for (CartItem c : listCartItem_temp)
						totalPrice += c.getQuantity() * Double.parseDouble(c.getProduct().getPrice().toString());

					Order order = new Order(idOrder_temp, LocalDate.now(), BigDecimal.valueOf(totalPrice), 0.0,
							usersServiceImpl.searchUsers(11));
					ordersServiceImpl.addOrders(order);
					
					for (CartItem c : listCartItem_temp) {
						c.setID(cartItemID++);
						cartItemServiceImpl.addCartItem(c);
						totalPrice += c.getQuantity() * Double.parseDouble(c.getProduct().getPrice().toString());
					}

					JOptionPane.showMessageDialog(this, "Thanh toán thành công, hóa đơn đã được lưu",
							"Quản Lý Siêu Thị", 1);
					listCartItem_temp = new ArrayList<>();

					updateTableCartItem();
					updateTotalPrice();
					updateTableOrder();
					
					
					textField.setText("");
					spinner.setValue(1);
					textField_2.setText("");

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Thanh toán thất bại, hóa đơn chưa được lưu",
							"Quản Lý Siêu Thị", 2);
				}
			} else {
				return;
			}
		}
	}

	private void updateTableOrder() {
		listOrder = ordersServiceImpl.getListOrders();
		model_Order.setOrders(listOrder);
		table_1.setModel(model_Order);
		table_1.updateUI();
	}

	private void updateTotalPrice() {
		double totalPrice = 0;
		for (CartItem i : listCartItem_temp)
			totalPrice += i.getQuantity() * Double.parseDouble(i.getProduct().getPrice().toString());

		textField_2.setText(String.format("%,.0f", totalPrice) + " ₫");
	}

	private void updateTableCartItem() {
		model_CartItem.setCartItems(listCartItem_temp);
		table.setModel(model_CartItem);
		table.updateUI();
	}

	private void updateTableProduct() {
		listProduct = productServiceImpl.getListProducts();
		model_product.setProducts(listProduct);
		table_3.setModel(model_product);
		table_3.updateUI();
	}

	private void updateTableCategory() {
		listProductCategory = categoriesServiceImpl.getListProductNullCategories();
		model_category.setProducts(listProductCategory);
		table_2.setModel(model_category);
		table_2.updateUI();
	}

	public void updateComboBoxCategory() {
		comboBoxContent = new ArrayList<>();
		comboBoxContent.add("All");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBoxContent.add(i.getName());
		});
		comboBox.removeAllItems();
		for (int i = 0; i < comboBoxContent.size(); i++) {
			comboBox.insertItemAt(comboBoxContent.get(i), );
		}
		comboBox.setSelectedIndex(0);
		comboBox.updateUI();

	}
}
