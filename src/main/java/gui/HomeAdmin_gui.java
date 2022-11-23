package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import handler.UsersHandler;
import model.CartItemTableModel;
import model.CategoriesTableModel;
import model.OrderTableModel;
import model.ProductTableModel;
import model.UserTableModel;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javax.swing.table.TableModel;

public class HomeAdmin_gui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_tabOrder;
	private JTextField tfIDProduct_tabOrder;
	private JTextField tfIDProduct_tabBill;
	private JTextField textField_2;
	private JTextField tfIDUser_tabBill;
	private JTextField tfTotalPrice_tabBill;
	private JTextField tfDiscout_tabBill;
	private JTextField tfSearch_tabBill;
	private JTextField tfID_tabCategory;
	private JTextField tfName_tabCategory;
	private JTextField tfSearch_tabCategory;
	private JTable table_tabBill;
	private JTable table_tabCategory;
	private JTextField tfID_tabProduct;
	private JTextField tfName_tabProduct;
	private JTextField tfPrice_tabProduct;
	private JTextField tfSearch_tabProduct;
	private JTable table_tabProduct;
	private JTextField tfID_tabUser;
	private JTextField tfName_tabUser;
	private JTextField tfSearch_tabUser;
	private JTextField tfGmail_tabUser;
	private JTextField tfPassword_tabUser;
	private JTextField tfPhone_tabUser;
	private JTextField tfAddress_tabUser;
	private JTextField tfID_tabDelOrder;
	private JTextField tfNameProduct_tabDelOrder;
	private JTextField tfPrice_tabDelOrder;
	private JTextField tfQuatity_tabDelOrder;
	private JTextField tfSearch_tabDelOrder;
	private JTextField tfCategory_tabDelOrder;
	private JTextField tfSup_tabDelOrder;
	private JTable table_tabDelOrder;
	private JTextField txtID_tabInfo;
	private JTextField txtName_tabInfo;
	private JTextField txtGmail_tabInfor;
	private JTextField txtBirthDate_tabInfo;
	private JTextField txtDateHir_tabInfo;
	private JTextField txtGender_tabInfo;
	private JTextField txtPhone_tabInfo;
	private JTextField tfQuantity_tabCategory;
	private JButton btnDetailOrder_tabBill;
	private JButton btnDetailItem_tabProduct;
	private JComboBox comboBoxCategory_tabCategory;
	private CategoriesServiceImpl categoriesServiceImpl;
	private CategoriesTableModel model_category;
	private List<Product> listProductCategory;
	private JButton btnReset_tabCategory;
	private JButton btnAdd_tabCategory;
	private ArrayList<String> comboBoxContent;
	private JButton btnDel_tabCategory;
	private JButton btnEdit_tabCategory;
	private JButton btnSearch_tabCategory;
	private JComboBox comboBoxSort_tabProduct;
	private JComboBox comboBoxSort_tabCategory;
	private String[] headline_3;
	private List<Product> listProduct;
	private ProductTableModel model_product;
	private String[] headline_2;
	private JComboBox comboBoxNameSup_tabProduct;
	private JComboBox comboBoxNameCa_tabProduct;
	private ArrayList comboBox_1Content;
	private ArrayList comboBox_1_1Content;
	private ProductServiceImpl productServiceImpl;
	private SuppliersServiceImpl suppliersServiceImpl;
	private JButton btnAdd_tabProduct;
	private JButton btnDel_tabProduct;
	private JButton btnReset_tabProduct;
	private JButton btnEdit_tabProduct;
	private JButton btnSearch_tabProduct;
	private OrdersServiceImpl ordersServiceImpl;
	private List<Order> listOrder;
	private OrderTableModel model_Order;
	private JDateChooser dateOrder_tabBill;
	private JButton btnReset_tabBill;
	private JButton btnAdd_tabOrder;
	private CartItemServiceImpl cartItemServiceImpl;
	private List<CartItem> listCartItem;
	private ArrayList<CartItem> listCartItem_temp;
	private CartItemTableModel model_CartItem;
	private ArrayList<Integer> listCartItem_ID_temp;
	private JSpinner spinnerQuantity_tabOrder;
	private JButton btnReset_tabOrder;
	private JButton btnDel_tabOrder;
	private JButton btnEdit_tabOrder;
	private JComboBox comboBoxSort_Order;
	private ArrayList listCartItem_temp2;
	private JButton btnPay_tabOrder;
	private int idOrder_temp;
	private UsersServiceImpl usersServiceImpl;
	private JButton btnDel_tabBill;
	private JButton btnEdit_tabBill;
	private JButton btnSearc_tabBill;
	private JComboBox comboBoxSort_tabBill;
	private CartItemTableModel model_CartItemDel;
	private List<CartItem> listCartItemDel;
	private JButton btnSearch_tabDelOrder;
	private JButton btnDel_tabDelOrder;
	private JComboBox comboBoxSort_tabDelOrder;
	private JTable table_tabUser;
	private List<Users> listUsers;
	private UserTableModel model_Users;
	private JButton btnReset_tabUser;
	private JDateChooser dateBirth_tabUser;
	private JDateChooser dateHir_tabUser;
	private JComboBox gender_tabUser;
	private JButton btnAdd_tabUser;
	private JButton btnDel_tabUser;
	private JButton btnEdit_tabUser;
	private JButton btnShowPass_tabInfo;
	private JButton btnSave_tabInfo;
	private JPasswordField txtPassword_tabInfo;
	private boolean password = true;
	private JButton btnOrder;
	private JButton btnBill;
	private JButton btnCategory;
	private JButton btnInfo;
	private JButton btnDelOrder;
	private JButton btnUsers;
	private JButton btnProduct;

	// false là hiện
	private boolean btnOrder_tool = true;
	private boolean btnBill_tool = true;
	private boolean btnCategory_tool = true;
	private boolean btnInfo_tool = true;
	private boolean btnDelOrder_tool = true;
	private boolean btnUsers_tool = true;
	private boolean btnProduct_tool = true;

	private JTabbedPane tabbedPane;
	private JPanel tabOrder;
	private JPanel tabDelOrder;
	private JPanel tabBill;
	private JPanel tabUser;
	private JPanel tabCategory;
	private JPanel tabProduct;
	private JPanel tabInfo;
	private JMenuItem menu1_1;
	private JMenuItem menu1_2;
	private JMenuItem menu2_1;
	private JMenuItem menu2_2;
	private JMenuItem menu2_3;
	private JMenuItem menu2_4;
	private JMenuItem menu3_1;
	private JMenuItem menu4_1;
	private JMenuItem menu4_2;
	private JButton writeXMLListUser;
	private JButton btnSearch_tabUser;
	private JComboBox comboBoxSort_tabUser;
	private Users user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin_gui frame = new HomeAdmin_gui(new Users());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public HomeAdmin_gui(Users usersSupper) throws SQLException {
		user = usersSupper;
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

		menu1_1 = new JMenuItem("  Thanh toán hóa đơn");
		menu1_1.setIcon(new ImageIcon("image\\btnAdd.png"));
		mnNewMenu_3.add(menu1_1);
		menu1_1.addActionListener(this);

		menu1_2 = new JMenuItem("   Hủy chi tiết một đơn hàng");
		menu1_2.setIcon(new ImageIcon("image\\delete-item.png"));
		mnNewMenu_3.add(menu1_2);
		menu1_2.addActionListener(this);

		JMenu mnNewMenu = new JMenu("  Quản Lý  ");
		menuBar.add(mnNewMenu);

		menu2_1 = new JMenuItem("  Quản lý hóa đơn");
		menu2_1.setIcon(new ImageIcon("image\\btnBill.png"));
		mnNewMenu.add(menu2_1);
		menu2_1.addActionListener(this);

		menu2_2 = new JMenuItem("  Quản lý nhân viên");
		menu2_2.setIcon(new ImageIcon("image\\btnPerson.png"));
		mnNewMenu.add(menu2_2);
		menu2_2.addActionListener(this);

		menu2_3 = new JMenuItem("  Quản lý loại hàng");
		menu2_3.setIcon(new ImageIcon("image\\catagory.png"));
		mnNewMenu.add(menu2_3);
		menu2_3.addActionListener(this);

		menu2_4 = new JMenuItem("  Quản lý mặt hàng");
		menu2_4.setIcon(new ImageIcon("image\\btnCatogory.png"));
		mnNewMenu.add(menu2_4);
		menu2_4.addActionListener(this);

		JMenu mnNewMenu_1 = new JMenu("  Cài Đặt  ");
		menuBar.add(mnNewMenu_1);

		menu3_1 = new JMenuItem("Thông tin của bạn");
		menu3_1.setIcon(new ImageIcon("image\\btnProfile.png"));
		mnNewMenu_1.add(menu3_1);
		menu3_1.addActionListener(this);

		JMenu mnNewMenu_2 = new JMenu("  Trợ Giúp");
		menuBar.add(mnNewMenu_2);

		menu4_1 = new JMenuItem("  Đăng xuất");
		menu4_1.setIcon(new ImageIcon("image\\out.png"));
		mnNewMenu_2.add(menu4_1);
		menu4_1.addActionListener(this);

		menu4_2 = new JMenuItem("  Thoát");
		mnNewMenu_2.add(menu4_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		menu4_2.addActionListener(this);

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
		listCartItemDel = new ArrayList<CartItem>();
		listUsers = usersServiceImpl.getListUsers();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 1066, 646);
		contentPane.add(tabbedPane);

		tabOrder = new JPanel();
		tabOrder.setToolTipText("Tìm kiếm theo mã");
		tabOrder.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Thanh Toán Hóa Đơn", new ImageIcon("image\\btnAdd1.png"), tabOrder, null);
		tabOrder.setLayout(null);
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(10, 54, 1041, 183);
		tabOrder.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setToolTipText("Thêm vào hóa đơn");
		panel_7.setBounds(336, 24, 334, 52);
		panel_5.add(panel_7);
		panel_7.setLayout(null);

		tfIDProduct_tabOrder = new JTextField();
		tfIDProduct_tabOrder.setToolTipText("Nhập mã sản phẩm");
		tfIDProduct_tabOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfIDProduct_tabOrder.setBounds(10, 10, 175, 32);
		panel_7.add(tfIDProduct_tabOrder);
		tfIDProduct_tabOrder.setColumns(10);

		spinnerQuantity_tabOrder = new JSpinner();
		spinnerQuantity_tabOrder.setToolTipText("Chọn số lượng");
		spinnerQuantity_tabOrder.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		spinnerQuantity_tabOrder.setBounds(195, 10, 43, 32);
		panel_7.add(spinnerQuantity_tabOrder);
		spinnerQuantity_tabOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnAdd_tabOrder = new JButton("");
		btnAdd_tabOrder.setToolTipText("Thêm sản phẩm mới vào hóa đơn");
		btnAdd_tabOrder.setBounds(248, 10, 76, 32);
		panel_7.add(btnAdd_tabOrder);
		btnAdd_tabOrder.setBackground(new Color(255, 255, 255));
		btnAdd_tabOrder.setForeground(Color.BLACK);
		btnAdd_tabOrder.setIcon(new ImageIcon("image\\add.png"));
		btnAdd_tabOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_tabOrder.addActionListener(this);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBounds(95, 96, 857, 52);
		panel_5.add(panel_7_1);

		btnDel_tabOrder = new JButton("  Xóa");
		btnDel_tabOrder.setIcon(new ImageIcon("image\\delete.png"));
		btnDel_tabOrder.setForeground(Color.BLACK);
		btnDel_tabOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDel_tabOrder.setBackground(new Color(255, 255, 255));
		btnDel_tabOrder.setBounds(36, 10, 169, 32);
		panel_7_1.add(btnDel_tabOrder);
		btnDel_tabOrder.addActionListener(this);

		btnReset_tabOrder = new JButton("  Làm Rỗng");
		btnReset_tabOrder.setIcon(new ImageIcon("image\\clear.png"));
		btnReset_tabOrder.setForeground(Color.BLACK);
		btnReset_tabOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset_tabOrder.setBackground(Color.WHITE);
		btnReset_tabOrder.setBounds(445, 10, 169, 32);
		panel_7_1.add(btnReset_tabOrder);
		btnReset_tabOrder.addActionListener(this);

		btnPay_tabOrder = new JButton("  Thanh Toán");
		btnPay_tabOrder.setIcon(new ImageIcon("image\\check-mark.png"));
		btnPay_tabOrder.setForeground(Color.BLACK);
		btnPay_tabOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPay_tabOrder.setBackground(Color.WHITE);
		btnPay_tabOrder.setBounds(654, 10, 169, 32);
		panel_7_1.add(btnPay_tabOrder);
		btnPay_tabOrder.addActionListener(this);

		btnEdit_tabOrder = new JButton("  Chỉnh Sửa");
		btnEdit_tabOrder.setIcon(new ImageIcon("image\\edit.png"));
		btnEdit_tabOrder.setForeground(Color.BLACK);
		btnEdit_tabOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit_tabOrder.setBackground(Color.WHITE);
		btnEdit_tabOrder.setBounds(245, 10, 156, 32);
		panel_7_1.add(btnEdit_tabOrder);
		btnEdit_tabOrder.addActionListener(this);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(10, 280, 1041, 310);
		tabOrder.add(panel_6);
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

		table_tabOrder = new JTable(model_CartItem);
		table_tabOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tabOrder.setBackground(UIManager.getColor("Button.light"));
		table_tabOrder.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_tabOrder.setSelectionBackground(new java.awt.Color(255, 255, 204));

		table_tabOrder.setRowHeight(35);

		scrollPane.setViewportView(table_tabOrder);

		table_tabOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_tabOrder.getSelectedRow();
				updateCom_5(index);
			}

			private void updateCom_5(int index) {
				tfIDProduct_tabOrder.setText(listCartItem_temp.get(index).getProduct().getID() + "");
				spinnerQuantity_tabOrder.setValue(listCartItem_temp.get(index).getQuantity());
			}
		});

		JLabel lblNewLabel_3_1 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(878, 14, 81, 13);
		panel_6.add(lblNewLabel_3_1);

		comboBoxSort_Order = new JComboBox();
		comboBoxSort_Order
				.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Số lượng", "Giá" }));
		comboBoxSort_Order.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_Order.setBounds(950, 10, 81, 20);
		panel_6.add(comboBoxSort_Order);
		comboBoxSort_Order.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Thanh Toán Hóa Đơn");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(417, 10, 217, 34);
		tabOrder.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setText("0 ₫");
		textField_2.setBackground(UIManager.getColor("Button.background"));
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(930, 247, 119, 28);
		tabOrder.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Thành tiền: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(835, 247, 87, 28);
		tabOrder.add(lblNewLabel_2);

		tabDelOrder = new JPanel();
		tabDelOrder.setLayout(null);
		tabDelOrder.setBackground(Color.WHITE);
		tabbedPane.addTab("Hủy Chi Tiết Một Món Hàng", new ImageIcon("image\\delete-item (1).png"), tabDelOrder, null);

		JPanel panel_5_1_2_2 = new JPanel();
		panel_5_1_2_2.setLayout(null);
		panel_5_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2_2.setBackground(Color.WHITE);
		panel_5_1_2_2.setBounds(10, 54, 1041, 216);
		tabDelOrder.add(panel_5_1_2_2);

		JPanel panel_7_1_1_2_2 = new JPanel();
		panel_7_1_1_2_2.setLayout(null);
		panel_7_1_1_2_2.setBackground(SystemColor.menu);
		panel_7_1_1_2_2.setBounds(264, 20, 514, 50);
		panel_5_1_2_2.add(panel_7_1_1_2_2);

		btnDel_tabDelOrder = new JButton("");
		btnDel_tabDelOrder.setIcon(new ImageIcon("image\\delete.png"));
		btnDel_tabDelOrder.setToolTipText("Cập nhật danh sách");
		btnDel_tabDelOrder.setForeground(Color.BLACK);
		btnDel_tabDelOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDel_tabDelOrder.setBackground(UIManager.getColor("Button.background"));
		btnDel_tabDelOrder.setBounds(428, 10, 52, 32);
		panel_7_1_1_2_2.add(btnDel_tabDelOrder);
		btnDel_tabDelOrder.addActionListener(this);

		tfSearch_tabDelOrder = new JTextField();
		tfSearch_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfSearch_tabDelOrder.setToolTipText("Tìm kiếm theo mã");
		tfSearch_tabDelOrder.setColumns(10);
		tfSearch_tabDelOrder.setBackground(Color.WHITE);
		tfSearch_tabDelOrder.setBounds(36, 10, 154, 32);
		panel_7_1_1_2_2.add(tfSearch_tabDelOrder);

		btnSearch_tabDelOrder = new JButton("");
		btnSearch_tabDelOrder.setIcon(new ImageIcon("image\\search.png"));
		btnSearch_tabDelOrder.setToolTipText("Tìm kiếm theo mã");
		btnSearch_tabDelOrder.setBackground(UIManager.getColor("Button.background"));
		btnSearch_tabDelOrder.setBounds(189, 10, 42, 31);
		panel_7_1_1_2_2.add(btnSearch_tabDelOrder);
		btnSearch_tabDelOrder.addActionListener(this);

		JLabel lblNewLabel_1_4_2 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_2.setBounds(42, 86, 97, 32);
		panel_5_1_2_2.add(lblNewLabel_1_4_2);

		tfID_tabDelOrder = new JTextField();
		tfID_tabDelOrder.setEditable(false);
		tfID_tabDelOrder.setToolTipText("Nhập mã sản phẩm");
		tfID_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfID_tabDelOrder.setColumns(10);
		tfID_tabDelOrder.setBackground(SystemColor.menu);
		tfID_tabDelOrder.setBounds(149, 86, 309, 32);
		panel_5_1_2_2.add(tfID_tabDelOrder);

		JLabel lblNewLabel_1_1_2_2 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_2.setBounds(31, 128, 108, 32);
		panel_5_1_2_2.add(lblNewLabel_1_1_2_2);

		tfNameProduct_tabDelOrder = new JTextField();
		tfNameProduct_tabDelOrder.setEditable(false);
		tfNameProduct_tabDelOrder.setToolTipText("Nhập ngày lập hóa đơn");
		tfNameProduct_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNameProduct_tabDelOrder.setColumns(10);
		tfNameProduct_tabDelOrder.setBackground(SystemColor.menu);
		tfNameProduct_tabDelOrder.setBounds(149, 128, 309, 32);
		panel_5_1_2_2.add(tfNameProduct_tabDelOrder);

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

		tfPrice_tabDelOrder = new JTextField();
		tfPrice_tabDelOrder.setEditable(false);
		tfPrice_tabDelOrder.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		tfPrice_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPrice_tabDelOrder.setColumns(10);
		tfPrice_tabDelOrder.setBackground(SystemColor.menu);
		tfPrice_tabDelOrder.setBounds(149, 170, 309, 32);
		panel_5_1_2_2.add(tfPrice_tabDelOrder);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Số lượng");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_2_1.setBounds(558, 170, 95, 32);
		panel_5_1_2_2.add(lblNewLabel_1_1_1_1_2_1);

		tfQuatity_tabDelOrder = new JTextField();
		tfQuatity_tabDelOrder.setEditable(false);
		tfQuatity_tabDelOrder.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		tfQuatity_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfQuatity_tabDelOrder.setColumns(10);
		tfQuatity_tabDelOrder.setBackground(SystemColor.menu);
		tfQuatity_tabDelOrder.setBounds(676, 170, 309, 32);
		panel_5_1_2_2.add(tfQuatity_tabDelOrder);

		tfCategory_tabDelOrder = new JTextField();
		tfCategory_tabDelOrder.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		tfCategory_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCategory_tabDelOrder.setEditable(false);
		tfCategory_tabDelOrder.setColumns(10);
		tfCategory_tabDelOrder.setBackground(SystemColor.menu);
		tfCategory_tabDelOrder.setBounds(676, 128, 309, 32);
		panel_5_1_2_2.add(tfCategory_tabDelOrder);

		tfSup_tabDelOrder = new JTextField();
		tfSup_tabDelOrder.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		tfSup_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfSup_tabDelOrder.setEditable(false);
		tfSup_tabDelOrder.setColumns(10);
		tfSup_tabDelOrder.setBackground(SystemColor.menu);
		tfSup_tabDelOrder.setBounds(676, 86, 309, 32);
		panel_5_1_2_2.add(tfSup_tabDelOrder);

		JLabel lblHyChiTit = new JLabel("Hủy Chi Tiết Một Món Hàng");
		lblHyChiTit.setForeground(new Color(128, 0, 255));
		lblHyChiTit.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHyChiTit.setBounds(399, 10, 278, 34);
		tabDelOrder.add(lblHyChiTit);

		JPanel panel_6_1_2_2 = new JPanel();
		panel_6_1_2_2.setLayout(null);
		panel_6_1_2_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch m\u1EB7t h\u00E0ng c\u00F3 trong h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6_1_2_2.setBackground(Color.WHITE);
		panel_6_1_2_2.setBounds(10, 280, 1041, 310);
		tabDelOrder.add(panel_6_1_2_2);

		JScrollPane scrollPane_1_2_2 = new JScrollPane();
		scrollPane_1_2_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2_2.setBounds(10, 31, 1021, 270);
		panel_6_1_2_2.add(scrollPane_1_2_2);

		String[] headLine_table_4 = { "STT", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Tổng tiền" };

		model_CartItemDel = new CartItemTableModel(listCartItemDel, headLine_table_4);

		table_tabDelOrder = new JTable(model_CartItemDel);
		table_tabDelOrder.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_tabDelOrder.setSelectionBackground(new Color(255, 255, 204));
		table_tabDelOrder.setRowHeight(35);
		table_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tabDelOrder.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_2_2.setViewportView(table_tabDelOrder);
		//
		table_tabDelOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_tabDelOrder.getSelectedRow();
				updateCom_4(index);
			}

			private void updateCom_4(int index) {
				tfID_tabDelOrder.setText(listCartItemDel.get(index).getProduct().getID() + "");
				tfNameProduct_tabDelOrder.setText(listCartItemDel.get(index).getProduct().getName());
				tfPrice_tabDelOrder
						.setText(String.format("%,.0f", listCartItemDel.get(index).getProduct().getPrice()) + " ₫");
				tfSup_tabDelOrder.setText(listCartItemDel.get(index).getProduct().getSuppliers().getName());
				tfCategory_tabDelOrder.setText(listCartItemDel.get(index).getProduct().getCategories().getName());
				tfQuatity_tabDelOrder.setText(listCartItemDel.get(index).getQuantity() + "");
			}
		});

		JLabel lblNewLabel_3_1_1 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(878, 14, 81, 13);
		panel_6_1_2_2.add(lblNewLabel_3_1_1);

		comboBoxSort_tabDelOrder = new JComboBox();
		comboBoxSort_tabDelOrder
				.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Số lượng", "Giá" }));
		comboBoxSort_tabDelOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_tabDelOrder.setBounds(950, 10, 81, 20);
		panel_6_1_2_2.add(comboBoxSort_tabDelOrder);
		comboBoxSort_tabDelOrder.addActionListener(this);

		tabBill = new JPanel();
		tabBill.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Hóa Đơn", new ImageIcon("image\\invoice1.png"), tabBill, null);
		tabBill.setLayout(null);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(10, 54, 1041, 216);
		tabBill.add(panel_5_1);

		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setBackground(new Color(255, 255, 255));
		panel_7_1_1.setLayout(null);
		panel_7_1_1.setBounds(772, 161, 259, 45);
		panel_5_1.add(panel_7_1_1);

		btnEdit_tabBill = new JButton("");
		btnEdit_tabBill.setEnabled(false);
		btnEdit_tabBill.setToolTipText("Sửa hóa đơn đang chọn");
		btnEdit_tabBill.setIcon(new ImageIcon("image\\edit.png"));
		btnEdit_tabBill.setForeground(Color.BLACK);
		btnEdit_tabBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit_tabBill.setBackground(UIManager.getColor("Button.background"));
		btnEdit_tabBill.setBounds(134, 10, 52, 32);
		panel_7_1_1.add(btnEdit_tabBill);
		btnEdit_tabBill.addActionListener(this);

		btnDel_tabBill = new JButton("");
		btnDel_tabBill.setToolTipText("Xóa hóa đơn đang chọn");
		btnDel_tabBill.setIcon(new ImageIcon("image\\delete.png"));
		btnDel_tabBill.setForeground(Color.BLACK);
		btnDel_tabBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDel_tabBill.setBackground(UIManager.getColor("Button.background"));
		btnDel_tabBill.setBounds(72, 10, 52, 32);
		panel_7_1_1.add(btnDel_tabBill);
		btnDel_tabBill.addActionListener(this);

		btnReset_tabBill = new JButton("");
		btnReset_tabBill.setIcon(new ImageIcon("image\\clear.png"));
		btnReset_tabBill.setToolTipText("Làm rỗng các field");
		btnReset_tabBill.setForeground(Color.BLACK);
		btnReset_tabBill.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset_tabBill.setBackground(UIManager.getColor("Button.background"));
		btnReset_tabBill.setBounds(196, 10, 52, 32);
		panel_7_1_1.add(btnReset_tabBill);
		
		JButton btnAdd_tabProduct_1 = new JButton("");
		btnAdd_tabProduct_1.setIcon(new ImageIcon("image\\add1.png"));
		btnAdd_tabProduct_1.setEnabled(false);
		btnAdd_tabProduct_1.setToolTipText("Thêm mới vào danh sách");
		btnAdd_tabProduct_1.setForeground(Color.BLACK);
		btnAdd_tabProduct_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_tabProduct_1.setBackground(SystemColor.menu);
		btnAdd_tabProduct_1.setBounds(10, 10, 52, 32);
		panel_7_1_1.add(btnAdd_tabProduct_1);
		btnReset_tabBill.addActionListener(this);

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(47, 34, 87, 32);
		panel_5_1.add(lblNewLabel_1);

		tfIDProduct_tabBill = new JTextField();
		tfIDProduct_tabBill.setEditable(false);
		tfIDProduct_tabBill.setBackground(UIManager.getColor("Button.background"));
		tfIDProduct_tabBill.setBounds(154, 34, 309, 32);
		panel_5_1.add(tfIDProduct_tabBill);
		tfIDProduct_tabBill.setToolTipText("");
		tfIDProduct_tabBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfIDProduct_tabBill.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(47, 76, 108, 32);
		panel_5_1.add(lblNewLabel_1_1);

		tfIDUser_tabBill = new JTextField();
		tfIDUser_tabBill.setEditable(false);
		tfIDUser_tabBill.setToolTipText("");
		tfIDUser_tabBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfIDUser_tabBill.setColumns(10);
		tfIDUser_tabBill.setBackground(SystemColor.menu);
		tfIDUser_tabBill.setBounds(154, 76, 309, 32);
		panel_5_1.add(tfIDUser_tabBill);

		JLabel lblNewLabel_1_2 = new JLabel("Tổng tiền hàng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(562, 34, 108, 32);
		panel_5_1.add(lblNewLabel_1_2);

		tfTotalPrice_tabBill = new JTextField();
		tfTotalPrice_tabBill.setEditable(false);
		tfTotalPrice_tabBill.setToolTipText("");
		tfTotalPrice_tabBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfTotalPrice_tabBill.setColumns(10);
		tfTotalPrice_tabBill.setBackground(SystemColor.menu);
		tfTotalPrice_tabBill.setBounds(680, 34, 309, 32);
		panel_5_1.add(tfTotalPrice_tabBill);

		JLabel lblNewLabel_1_2_1 = new JLabel("Giảm giá");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(562, 76, 108, 32);
		panel_5_1.add(lblNewLabel_1_2_1);

		tfDiscout_tabBill = new JTextField();
		tfDiscout_tabBill.setEditable(false);
		tfDiscout_tabBill.setToolTipText("");
		tfDiscout_tabBill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfDiscout_tabBill.setColumns(10);
		tfDiscout_tabBill.setBackground(SystemColor.menu);
		tfDiscout_tabBill.setBounds(680, 76, 309, 32);
		panel_5_1.add(tfDiscout_tabBill);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày lập");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(47, 122, 95, 32);
		panel_5_1.add(lblNewLabel_1_1_1);

		dateOrder_tabBill = new JDateChooser(new Date());
		dateOrder_tabBill.getCalendarButton().setToolTipText("Chọn ngày");
		dateOrder_tabBill.setForeground(SystemColor.activeCaption);
		dateOrder_tabBill.getCalendarButton().setForeground(SystemColor.activeCaption);
		dateOrder_tabBill.getCalendarButton().setBackground(SystemColor.menu);
		dateOrder_tabBill.getCalendarButton().setIcon(new ImageIcon("image\\calendar.png"));
		dateOrder_tabBill.setBackground(SystemColor.menu);
		dateOrder_tabBill.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 40));
		dateOrder_tabBill.setBounds(154, 122, 163, 31);
		panel_5_1.add(dateOrder_tabBill);

		btnDetailOrder_tabBill = new JButton("...");
		btnDetailOrder_tabBill.setToolTipText("Xem chi tiết hơn");
		btnDetailOrder_tabBill.setIcon(new ImageIcon("image\\info.png"));
		btnDetailOrder_tabBill.setBounds(10, 174, 49, 32);
		panel_5_1.add(btnDetailOrder_tabBill);
		btnDetailOrder_tabBill.addActionListener(this);

		JLabel lblQunLHa = new JLabel("Quản Lý Hóa Đơn");
		lblQunLHa.setForeground(new Color(128, 0, 255));
		lblQunLHa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLHa.setBounds(438, 10, 179, 34);
		tabBill.add(lblQunLHa);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_6_1.setBackground(Color.WHITE);
		panel_6_1.setBounds(10, 280, 1041, 310);
		tabBill.add(panel_6_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(10, 31, 1021, 270);
		panel_6_1.add(scrollPane_1);

		// table order
		String[] headLine_1 = { "Mã hóa đơn", "Ngày thanh toán", "Tổng tiền hàng", "Giảm giá", "Tên nhân viên" };
		model_Order = new OrderTableModel(listOrder, headLine_1);

		table_tabBill = new JTable(model_Order);
		table_tabBill.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_tabBill.setSelectionBackground(new Color(255, 255, 204));
		table_tabBill.setRowHeight(35);
		table_tabBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tabBill.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1.setViewportView(table_tabBill);

		table_tabBill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_tabBill.getSelectedRow();
				updateCom_4(index);
			}

			private void updateCom_4(int index) {
				tfIDProduct_tabBill.setText(listOrder.get(index).getID() + "");
				tfIDUser_tabBill.setText(listOrder.get(index).getUsers().getName() + "");
				tfTotalPrice_tabBill.setText(listOrder.get(index).getTotalPrice() + "");
				tfDiscout_tabBill.setText(listOrder.get(index).getDiscount() + "");
				dateOrder_tabBill.setDate(java.sql.Date.valueOf(listOrder.get(index).getOrderDate()));
			}
		});

		JLabel lblNewLabel_3_1_2 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(878, 14, 81, 13);
		panel_6_1.add(lblNewLabel_3_1_2);

		comboBoxSort_tabBill = new JComboBox();
		comboBoxSort_tabBill.setModel(
				new DefaultComboBoxModel(new String[] { "Không", "Tên nhân viên", "Ngày lập", "Tổng tiền hàng" }));
		comboBoxSort_tabBill.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_tabBill.setBounds(950, 10, 81, 20);
		panel_6_1.add(comboBoxSort_tabBill);
		comboBoxSort_tabBill.addActionListener(this);

		tfSearch_tabBill = new JTextField();
		tfSearch_tabBill.setToolTipText("Tìm kiếm theo mã");
		tfSearch_tabBill.setBounds(878, 18, 132, 26);
		tabBill.add(tfSearch_tabBill);
		tfSearch_tabBill.setBackground(UIManager.getColor("Button.background"));
		tfSearch_tabBill.setColumns(10);

		btnSearc_tabBill = new JButton("");
		btnSearc_tabBill.setToolTipText("Tìm kiếm theo mã");
		btnSearc_tabBill.setBounds(1009, 18, 42, 25);
		tabBill.add(btnSearc_tabBill);
		btnSearc_tabBill.setIcon(new ImageIcon("image\\search.png"));
		btnSearc_tabBill.addActionListener(this);

		tabUser = new JPanel();
		tabUser.setLayout(null);
		tabUser.setBackground(Color.WHITE);
		tabbedPane.addTab("Nhân Viên", new ImageIcon("image\\btnPerson1.png"), tabUser, null);

		JPanel panel_5_1_2_1 = new JPanel();
		panel_5_1_2_1.setLayout(null);
		panel_5_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2_1.setBackground(Color.WHITE);
		panel_5_1_2_1.setBounds(10, 54, 1041, 216);
		tabUser.add(panel_5_1_2_1);

		JPanel panel_7_1_1_2_1 = new JPanel();
		panel_7_1_1_2_1.setLayout(null);
		panel_7_1_1_2_1.setBackground(Color.WHITE);
		panel_7_1_1_2_1.setBounds(772, 161, 259, 45);
		panel_5_1_2_1.add(panel_7_1_1_2_1);

		btnAdd_tabUser = new JButton("");
		btnAdd_tabUser.setIcon(new ImageIcon("image\\add1.png"));
		btnAdd_tabUser.setToolTipText("Thêm mới vào danh sách");
		btnAdd_tabUser.setForeground(Color.BLACK);
		btnAdd_tabUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_tabUser.setBackground(UIManager.getColor("Button.background"));
		btnAdd_tabUser.setBounds(10, 10, 52, 32);
		panel_7_1_1_2_1.add(btnAdd_tabUser);
		btnAdd_tabUser.addActionListener(this);

		btnEdit_tabUser = new JButton("");
		btnEdit_tabUser.setIcon(new ImageIcon("image\\edit.png"));
		btnEdit_tabUser.setToolTipText("Chỉnh sửa dòng đang chọn");
		btnEdit_tabUser.setForeground(Color.BLACK);
		btnEdit_tabUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit_tabUser.setBackground(UIManager.getColor("Button.background"));
		btnEdit_tabUser.setBounds(134, 10, 52, 32);
		panel_7_1_1_2_1.add(btnEdit_tabUser);
		btnEdit_tabUser.addActionListener(this);

		btnDel_tabUser = new JButton("");
		btnDel_tabUser.setIcon(new ImageIcon("image\\delete.png"));
		btnDel_tabUser.setToolTipText("Xóa dòng đang chọn");
		btnDel_tabUser.setForeground(Color.BLACK);
		btnDel_tabUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDel_tabUser.setBackground(UIManager.getColor("Button.background"));
		btnDel_tabUser.setBounds(72, 10, 52, 32);
		panel_7_1_1_2_1.add(btnDel_tabUser);
		btnDel_tabUser.addActionListener(this);

		btnReset_tabUser = new JButton("");
		btnReset_tabUser.setIcon(new ImageIcon("image\\clear.png"));
		btnReset_tabUser.setToolTipText("Làm rỗng các field");
		btnReset_tabUser.setForeground(Color.BLACK);
		btnReset_tabUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset_tabUser.setBackground(UIManager.getColor("Button.background"));
		btnReset_tabUser.setBounds(196, 10, 52, 32);
		panel_7_1_1_2_1.add(btnReset_tabUser);
		btnReset_tabUser.addActionListener(this);

		JLabel lblNewLabel_1_4_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(47, 34, 97, 32);
		panel_5_1_2_1.add(lblNewLabel_1_4_1);

		tfID_tabUser = new JTextField();
		tfID_tabUser.setHorizontalAlignment(SwingConstants.LEFT);
		tfID_tabUser.setToolTipText("");
		tfID_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfID_tabUser.setColumns(10);
		tfID_tabUser.setBackground(SystemColor.menu);
		tfID_tabUser.setBounds(154, 34, 309, 32);
		panel_5_1_2_1.add(tfID_tabUser);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1.setBounds(47, 76, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1);

		tfName_tabUser = new JTextField();
		tfName_tabUser.setToolTipText("");
		tfName_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfName_tabUser.setColumns(10);
		tfName_tabUser.setBackground(SystemColor.menu);
		tfName_tabUser.setBounds(154, 76, 309, 32);
		panel_5_1_2_1.add(tfName_tabUser);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1.setBounds(562, 118, 69, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_2_4 = new JLabel("Gmail");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4.setBounds(562, 34, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_2_4);

		tfGmail_tabUser = new JTextField();
		tfGmail_tabUser.setToolTipText("");
		tfGmail_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfGmail_tabUser.setColumns(10);
		tfGmail_tabUser.setBackground(SystemColor.menu);
		tfGmail_tabUser.setBounds(680, 34, 309, 32);
		panel_5_1_2_1.add(tfGmail_tabUser);

		tfPassword_tabUser = new JTextField();
		tfPassword_tabUser.setToolTipText("");
		tfPassword_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPassword_tabUser.setColumns(10);
		tfPassword_tabUser.setBackground(SystemColor.menu);
		tfPassword_tabUser.setBounds(680, 76, 309, 32);
		panel_5_1_2_1.add(tfPassword_tabUser);

		JLabel lblNewLabel_1_2_1_3 = new JLabel("Password");
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_3.setBounds(562, 76, 108, 32);
		panel_5_1_2_1.add(lblNewLabel_1_2_1_3);

		gender_tabUser = new JComboBox();
		gender_tabUser.setModel(new DefaultComboBoxModel(new String[] { "Nữ", "Nam" }));
		gender_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gender_tabUser.setBackground(SystemColor.menu);
		gender_tabUser.setBounds(680, 119, 69, 30);
		panel_5_1_2_1.add(gender_tabUser);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(776, 119, 97, 32);
		panel_5_1_2_1.add(lblNewLabel_1_1_2_1_1);

		tfPhone_tabUser = new JTextField();
		tfPhone_tabUser.setToolTipText("");
		tfPhone_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPhone_tabUser.setColumns(10);
		tfPhone_tabUser.setBackground(SystemColor.menu);
		tfPhone_tabUser.setBounds(877, 119, 112, 32);
		panel_5_1_2_1.add(tfPhone_tabUser);

		tfAddress_tabUser = new JTextField();
		tfAddress_tabUser.setToolTipText("");
		tfAddress_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfAddress_tabUser.setColumns(10);
		tfAddress_tabUser.setBackground(SystemColor.menu);
		tfAddress_tabUser.setBounds(154, 159, 516, 32);
		panel_5_1_2_1.add(tfAddress_tabUser);

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

		dateBirth_tabUser = new JDateChooser();
		dateBirth_tabUser.getCalendarButton().setIcon(new ImageIcon("image\\calendar.png"));
		dateBirth_tabUser.getCalendarButton().setToolTipText("Chọn ngày");
		dateBirth_tabUser.getCalendarButton().setForeground(SystemColor.activeCaption);
		dateBirth_tabUser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 40));
		dateBirth_tabUser.getCalendarButton().setBackground(SystemColor.menu);
		dateBirth_tabUser.setForeground(SystemColor.activeCaption);
		dateBirth_tabUser.setBackground(SystemColor.menu);
		dateBirth_tabUser.setBounds(154, 118, 122, 31);
		panel_5_1_2_1.add(dateBirth_tabUser);

		dateHir_tabUser = new JDateChooser();
		dateHir_tabUser.getCalendarButton().setIcon(new ImageIcon("image\\calendar.png"));
		dateHir_tabUser.getCalendarButton().setToolTipText("Chọn ngày");
		dateHir_tabUser.getCalendarButton().setForeground(SystemColor.activeCaption);
		dateHir_tabUser.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 40));
		dateHir_tabUser.getCalendarButton().setBackground(SystemColor.menu);
		dateHir_tabUser.setForeground(SystemColor.activeCaption);
		dateHir_tabUser.setBackground(SystemColor.menu);
		dateHir_tabUser.setBounds(404, 118, 122, 31);
		panel_5_1_2_1.add(dateHir_tabUser);

		JLabel lblQunLNhn = new JLabel("Quản Lý Nhân Viên");
		lblQunLNhn.setForeground(new Color(128, 0, 255));
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLNhn.setBounds(438, 10, 190, 34);
		tabUser.add(lblQunLNhn);

		JPanel panel_6_1_2_1 = new JPanel();
		panel_6_1_2_1.setLayout(null);
		panel_6_1_2_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_6_1_2_1.setBackground(Color.WHITE);
		panel_6_1_2_1.setBounds(10, 280, 1041, 310);
		tabUser.add(panel_6_1_2_1);

		JScrollPane scrollPane_1_2_1 = new JScrollPane();
		scrollPane_1_2_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2_1.setBounds(10, 31, 1021, 270);
		panel_6_1_2_1.add(scrollPane_1_2_1);

		String[] headLine_table_5 = { "ID", "Họ tên", "Giới tính", "Gmail", "Phone", "Địa chỉ", "Ngày sinh",
				"Ngày vào làm", "Mật khẩu" };
		model_Users = new UserTableModel(listUsers, headLine_table_5);

		table_tabUser = new JTable(model_Users);
		table_tabUser.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_tabUser.setSelectionBackground(new Color(255, 255, 204));
		table_tabUser.setRowHeight(35);
		table_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tabUser.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_2_1.setViewportView(table_tabUser);
		table_tabUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_tabUser.getSelectedRow();
				updateCom_5_1(index);
			}

			private void updateCom_5_1(int index) {
				tfID_tabUser.setText(listUsers.get(index).getID() + "");
				tfName_tabUser.setText(listUsers.get(index).getName());
				tfGmail_tabUser.setText(listUsers.get(index).getGmail());
				tfPassword_tabUser.setText(listUsers.get(index).getPassword());
				tfAddress_tabUser.setText(listUsers.get(index).getAddress());
				tfPhone_tabUser.setText(listUsers.get(index).getPhone());
				gender_tabUser.setSelectedIndex(listUsers.get(index).isGender());
				dateBirth_tabUser.setDate(java.sql.Date.valueOf(listUsers.get(index).getBirthDate()));
				dateHir_tabUser.setDate(java.sql.Date.valueOf(listUsers.get(index).getHireDate()));
			}
		});

		JLabel lblNewLabel_3_1_3 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_3.setBounds(878, 14, 81, 13);
		panel_6_1_2_1.add(lblNewLabel_3_1_3);

		comboBoxSort_tabUser = new JComboBox();
		comboBoxSort_tabUser
				.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên nhân viên", "Ngày vào làm" }));
		comboBoxSort_tabUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_tabUser.setBounds(950, 10, 81, 20);
		panel_6_1_2_1.add(comboBoxSort_tabUser);
		comboBoxSort_tabUser.addActionListener(this);

		tfSearch_tabUser = new JTextField();
		tfSearch_tabUser.setToolTipText("Tìm kiếm theo mã");
		tfSearch_tabUser.setColumns(10);
		tfSearch_tabUser.setBackground(SystemColor.menu);
		tfSearch_tabUser.setBounds(878, 18, 132, 26);
		tabUser.add(tfSearch_tabUser);

		btnSearch_tabUser = new JButton("");
		btnSearch_tabUser.setIcon(new ImageIcon("image\\search.png"));
		btnSearch_tabUser.setToolTipText("Tìm kiếm theo mã");
		btnSearch_tabUser.setBackground(UIManager.getColor("Button.background"));
		btnSearch_tabUser.setBounds(1009, 18, 42, 25);
		tabUser.add(btnSearch_tabUser);
		btnSearch_tabUser.addActionListener(this);

		writeXMLListUser = new JButton("Xuất danh sách");
		writeXMLListUser.setIcon(new ImageIcon("C:\\SON.admin\\V\\JavaSuKien\\LTHSK_QuanLySieuThi\\image\\xml.png"));
		writeXMLListUser.setBounds(10, 16, 142, 28);
		tabUser.add(writeXMLListUser);
		writeXMLListUser.addActionListener(this);

		tabCategory = new JPanel();
		tabCategory.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Loại Hàng", new ImageIcon("image\\catagory1.png"), tabCategory, null);
		tabCategory.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(0, 0, 1061, 619);
		tabCategory.add(panel_1_1);

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

		tfID_tabCategory = new JTextField();
		tfID_tabCategory.setToolTipText("");
		tfID_tabCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfID_tabCategory.setColumns(10);
		tfID_tabCategory.setBackground(SystemColor.menu);
		tfID_tabCategory.setBounds(681, 53, 309, 32);
		panel_5_1_1.add(tfID_tabCategory);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tên loại hàng hóa");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1.setBounds(538, 95, 133, 32);
		panel_5_1_1.add(lblNewLabel_1_2_1_1);

		tfName_tabCategory = new JTextField();
		tfName_tabCategory.setToolTipText("");
		tfName_tabCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfName_tabCategory.setColumns(10);
		tfName_tabCategory.setBackground(SystemColor.menu);
		tfName_tabCategory.setBounds(681, 95, 309, 32);
		panel_5_1_1.add(tfName_tabCategory);

		JPanel panel_7_1_1_1 = new JPanel();
		panel_7_1_1_1.setLayout(null);
		panel_7_1_1_1.setBackground(Color.WHITE);
		panel_7_1_1_1.setBounds(772, 161, 258, 45);
		panel_5_1_1.add(panel_7_1_1_1);

		btnAdd_tabCategory = new JButton("");
		btnAdd_tabCategory.setIcon(new ImageIcon("image\\add1.png"));
		btnAdd_tabCategory.setToolTipText("Thêm mới");
		btnAdd_tabCategory.setForeground(Color.BLACK);
		btnAdd_tabCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_tabCategory.setBackground(UIManager.getColor("Button.background"));
		btnAdd_tabCategory.setBounds(10, 10, 52, 32);
		panel_7_1_1_1.add(btnAdd_tabCategory);
		btnAdd_tabCategory.addActionListener(this);

		// btn delete category
		btnEdit_tabCategory = new JButton("");
		btnEdit_tabCategory.setIcon(new ImageIcon("image\\edit.png"));
		btnEdit_tabCategory.setToolTipText("Sửa loại hàng đang chọn");
		btnEdit_tabCategory.setForeground(Color.BLACK);
		btnEdit_tabCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit_tabCategory.setBackground(UIManager.getColor("Button.background"));
		btnEdit_tabCategory.setBounds(134, 10, 52, 32);
		panel_7_1_1_1.add(btnEdit_tabCategory);

		btnEdit_tabCategory.addActionListener(this);

		btnDel_tabCategory = new JButton("");
		btnDel_tabCategory.setIcon(new ImageIcon("image\\delete.png"));
		btnDel_tabCategory.setToolTipText("Xóa loại hàng đang chọn");
		btnDel_tabCategory.setForeground(Color.BLACK);
		btnDel_tabCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDel_tabCategory.setBackground(UIManager.getColor("Button.background"));
		btnDel_tabCategory.setBounds(72, 10, 52, 32);
		panel_7_1_1_1.add(btnDel_tabCategory);

		btnDel_tabCategory.addActionListener(this);

		// làm rỗng field catagory
		btnReset_tabCategory = new JButton("");
		btnReset_tabCategory.setIcon(new ImageIcon("image\\clear.png"));
		btnReset_tabCategory.setToolTipText("Làm rỗng các field");
		btnReset_tabCategory.setForeground(Color.BLACK);
		btnReset_tabCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset_tabCategory.setBackground(UIManager.getColor("Button.background"));
		btnReset_tabCategory.setBounds(196, 10, 52, 32);
		panel_7_1_1_1.add(btnReset_tabCategory);
		btnReset_tabCategory.addActionListener(this);

		// thêm tên loại hàng vào comboBox
		comboBoxContent = new ArrayList<>();
		comboBoxContent.add("All");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBoxContent.add(i.getName());
		});
		comboBoxCategory_tabCategory = new JComboBox(comboBoxContent.toArray());

		comboBoxCategory_tabCategory.addActionListener(this);

		comboBoxCategory_tabCategory.setToolTipText("Đổ danh sách theo loại hàng chọn");
		comboBoxCategory_tabCategory.setBackground(SystemColor.menu);
		comboBoxCategory_tabCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxCategory_tabCategory.setBounds(134, 53, 289, 32);
		panel_5_1_1.add(comboBoxCategory_tabCategory);

		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1_1_1.setBounds(50, 95, 77, 32);
		panel_5_1_1.add(lblNewLabel_1_2_1_1_1);

		tfQuantity_tabCategory = new JTextField();
		tfQuantity_tabCategory.setEditable(false);
		tfQuantity_tabCategory.setToolTipText("Số lượng có trong hạng mục đã chọn");
		tfQuantity_tabCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfQuantity_tabCategory.setColumns(10);
		tfQuantity_tabCategory.setBackground(SystemColor.menu);
		tfQuantity_tabCategory.setBounds(134, 95, 42, 32);
		panel_5_1_1.add(tfQuantity_tabCategory);

		tfQuantity_tabCategory.setText((categoriesServiceImpl.getListProductNullCategories().size()) + "");

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

		table_tabCategory = new JTable(model_category);
		table_tabCategory.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_tabCategory.setSelectionBackground(new Color(255, 255, 204));
		table_tabCategory.setRowHeight(35);
		table_tabCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tabCategory.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_1.setViewportView(table_tabCategory);

		table_tabCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_tabCategory.getSelectedRow();
				updateCom_2(index);
			}

			private void updateCom_2(int index) {
				tfID_tabCategory.setText(listProductCategory.get(index).getCategories().getID() + "");
				tfName_tabCategory.setText(listProductCategory.get(index).getCategories().getName());
			}
		});

		JLabel lblNewLabel_3_1_4 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_4.setBounds(878, 14, 81, 13);
		panel_6_1_1.add(lblNewLabel_3_1_4);

		comboBoxSort_tabCategory = new JComboBox();
		comboBoxSort_tabCategory.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên loại hàng" }));
		comboBoxSort_tabCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_tabCategory.setBounds(950, 10, 81, 20);
		panel_6_1_1.add(comboBoxSort_tabCategory);
		comboBoxSort_tabCategory.addActionListener(this);

		tfSearch_tabCategory = new JTextField();
		tfSearch_tabCategory.setToolTipText("Tìm kiếm theo mã");
		tfSearch_tabCategory.setColumns(10);
		tfSearch_tabCategory.setBackground(UIManager.getColor("Button.background"));
		tfSearch_tabCategory.setBounds(878, 18, 132, 26);
		panel_1_1.add(tfSearch_tabCategory);

		// btn search category
		btnSearch_tabCategory = new JButton("");
		btnSearch_tabCategory.setIcon(new ImageIcon("image\\search.png"));
		btnSearch_tabCategory.setToolTipText("Tìm kiếm theo mã");
		btnSearch_tabCategory.setBounds(1009, 18, 42, 25);
		panel_1_1.add(btnSearch_tabCategory);
		btnSearch_tabCategory.addActionListener(this);

		tabProduct = new JPanel();
		tabProduct.setLayout(null);
		tabProduct.setBackground(Color.WHITE);
		tabbedPane.addTab("Mặt Hàng", new ImageIcon("image\\btnCatogory1.png"), tabProduct, null);

		JPanel panel_5_1_2 = new JPanel();
		panel_5_1_2.setLayout(null);
		panel_5_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2.setBackground(Color.WHITE);
		panel_5_1_2.setBounds(10, 54, 1041, 216);
		tabProduct.add(panel_5_1_2);

		JPanel panel_7_1_1_2 = new JPanel();
		panel_7_1_1_2.setLayout(null);
		panel_7_1_1_2.setBackground(Color.WHITE);
		panel_7_1_1_2.setBounds(772, 161, 257, 45);
		panel_5_1_2.add(panel_7_1_1_2);

		btnAdd_tabProduct = new JButton("");
		btnAdd_tabProduct.setIcon(new ImageIcon("image\\add1.png"));
		btnAdd_tabProduct.setToolTipText("Thêm mới vào danh sách");
		btnAdd_tabProduct.setForeground(Color.BLACK);
		btnAdd_tabProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd_tabProduct.setBackground(UIManager.getColor("Button.background"));
		btnAdd_tabProduct.setBounds(10, 10, 52, 32);
		panel_7_1_1_2.add(btnAdd_tabProduct);
		btnAdd_tabProduct.addActionListener(this);

		btnEdit_tabProduct = new JButton("");
		btnEdit_tabProduct.setIcon(new ImageIcon("image\\edit.png"));
		btnEdit_tabProduct.setToolTipText("Chỉnh sửa dòng đang chọn");
		btnEdit_tabProduct.setForeground(Color.BLACK);
		btnEdit_tabProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEdit_tabProduct.setBackground(UIManager.getColor("Button.background"));
		btnEdit_tabProduct.setBounds(134, 10, 52, 32);
		panel_7_1_1_2.add(btnEdit_tabProduct);
		btnEdit_tabProduct.addActionListener(this);

		btnDel_tabProduct = new JButton("");
		btnDel_tabProduct.setIcon(new ImageIcon("image\\delete.png"));
		btnDel_tabProduct.setToolTipText("Xóa dòng đang chọn");
		btnDel_tabProduct.setForeground(Color.BLACK);
		btnDel_tabProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDel_tabProduct.setBackground(UIManager.getColor("Button.background"));
		btnDel_tabProduct.setBounds(72, 10, 52, 32);
		panel_7_1_1_2.add(btnDel_tabProduct);
		btnDel_tabProduct.addActionListener(this);

		btnReset_tabProduct = new JButton("");
		btnReset_tabProduct.setIcon(new ImageIcon("image\\clear.png"));
		btnReset_tabProduct.setToolTipText("Làm rỗng các field");
		btnReset_tabProduct.setForeground(Color.BLACK);
		btnReset_tabProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset_tabProduct.setBackground(UIManager.getColor("Button.background"));
		btnReset_tabProduct.setBounds(196, 10, 52, 32);
		panel_7_1_1_2.add(btnReset_tabProduct);
		btnReset_tabProduct.addActionListener(this);

		JLabel lblNewLabel_1_4 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(47, 34, 97, 32);
		panel_5_1_2.add(lblNewLabel_1_4);

		tfID_tabProduct = new JTextField();
		tfID_tabProduct.setToolTipText("Nhập mã sản phẩm");
		tfID_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfID_tabProduct.setColumns(10);
		tfID_tabProduct.setBackground(SystemColor.menu);
		tfID_tabProduct.setBounds(154, 34, 309, 32);
		panel_5_1_2.add(tfID_tabProduct);

		JLabel lblNewLabel_1_1_2 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(47, 76, 108, 32);
		panel_5_1_2.add(lblNewLabel_1_1_2);

		tfName_tabProduct = new JTextField();
		tfName_tabProduct.setToolTipText("Nhập ngày lập hóa đơn");
		tfName_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfName_tabProduct.setColumns(10);
		tfName_tabProduct.setBackground(SystemColor.menu);
		tfName_tabProduct.setBounds(154, 76, 309, 32);
		panel_5_1_2.add(tfName_tabProduct);

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

		tfPrice_tabProduct = new JTextField();
		tfPrice_tabProduct.setToolTipText("Nhập mã nhân viên lập hóa đơn");
		tfPrice_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPrice_tabProduct.setColumns(10);
		tfPrice_tabProduct.setBackground(SystemColor.menu);
		tfPrice_tabProduct.setBounds(154, 122, 309, 32);
		panel_5_1_2.add(tfPrice_tabProduct);

		// comboBox nhà cung cấp - product
		comboBox_1Content = new ArrayList<>();
		comboBox_1Content.add("Null");
		suppliersServiceImpl.getListSuppliers().forEach(i -> {
			comboBox_1Content.add(i.getName());
		});

		comboBoxNameSup_tabProduct = new JComboBox(comboBox_1Content.toArray());
		comboBoxNameSup_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxNameSup_tabProduct.setBackground(SystemColor.menu);
		comboBoxNameSup_tabProduct.setBounds(680, 34, 309, 30);
		panel_5_1_2.add(comboBoxNameSup_tabProduct);

		// comboBox loại hàng - product
		comboBox_1_1Content = new ArrayList<>();
		comboBox_1_1Content.add("Null");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBox_1_1Content.add(i.getName());
		});
		comboBoxNameCa_tabProduct = new JComboBox(comboBox_1_1Content.toArray());
		comboBoxNameCa_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxNameCa_tabProduct.setBackground(SystemColor.menu);
		comboBoxNameCa_tabProduct.setBounds(680, 79, 309, 30);
		panel_5_1_2.add(comboBoxNameCa_tabProduct);

		// chi tiết sản phẩm - product
		btnDetailItem_tabProduct = new JButton("...");
		btnDetailItem_tabProduct.setIcon(new ImageIcon("image\\info.png"));
		btnDetailItem_tabProduct.setToolTipText("Xem chi tiết hơn");
		btnDetailItem_tabProduct.setBounds(10, 174, 49, 32);
		panel_5_1_2.add(btnDetailItem_tabProduct);
		btnDetailItem_tabProduct.addActionListener(this);

		JLabel lblQunLMt = new JLabel("Quản Lý Mặt Hàng");
		lblQunLMt.setForeground(new Color(128, 0, 255));
		lblQunLMt.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblQunLMt.setBounds(438, 10, 190, 34);
		tabProduct.add(lblQunLMt);

		JPanel panel_6_1_2 = new JPanel();
		panel_6_1_2.setLayout(null);
		panel_6_1_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh s\u00E1ch m\u1EB7t h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6_1_2.setBackground(Color.WHITE);
		panel_6_1_2.setBounds(10, 280, 1041, 310);
		tabProduct.add(panel_6_1_2);

		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1_2.setBounds(10, 31, 1021, 270);
		panel_6_1_2.add(scrollPane_1_2);

		// table Product
		headline_3 = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Mã loại hàng", "Giá sản phẩm" };
		model_product = new ProductTableModel(listProductCategory, headline_3);

		table_tabProduct = new JTable(model_product);
		table_tabProduct.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table_tabProduct.setSelectionBackground(new Color(255, 255, 204));
		table_tabProduct.setRowHeight(35);
		table_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table_tabProduct.setBackground(UIManager.getColor("Button.light"));
		scrollPane_1_2.setViewportView(table_tabProduct);

		table_tabProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_tabProduct.getSelectedRow();
				updateCom_3(index);
			}

			private void updateCom_3(int index) {
				tfID_tabProduct.setText(listProduct.get(index).getID() + "");
				tfName_tabProduct.setText(listProduct.get(index).getName());
				tfPrice_tabProduct.setText(listProduct.get(index).getPrice() + "");
				comboBoxNameCa_tabProduct.setSelectedIndex(listProduct.get(index).getSuppliers().getID());
				comboBoxNameSup_tabProduct.setSelectedIndex(listProduct.get(index).getSuppliers().getID());
			}
		});

		JLabel lblNewLabel_3_1_5 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_5.setBounds(878, 14, 81, 13);
		panel_6_1_2.add(lblNewLabel_3_1_5);

		// sort category
		comboBoxSort_tabProduct = new JComboBox();
		comboBoxSort_tabProduct.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Giá" }));
		comboBoxSort_tabProduct.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_tabProduct.setBounds(950, 10, 81, 20);
		panel_6_1_2.add(comboBoxSort_tabProduct);
		comboBoxSort_tabProduct.addActionListener(this);

		tfSearch_tabProduct = new JTextField();
		tfSearch_tabProduct.setToolTipText("Tìm kiếm theo mã");
		tfSearch_tabProduct.setColumns(10);
		tfSearch_tabProduct.setBackground(SystemColor.menu);
		tfSearch_tabProduct.setBounds(878, 18, 132, 26);
		tabProduct.add(tfSearch_tabProduct);

		btnSearch_tabProduct = new JButton("");
		btnSearch_tabProduct.setBackground(UIManager.getColor("Button.background"));
		btnSearch_tabProduct.setIcon(new ImageIcon("image\\search.png"));
		btnSearch_tabProduct.setToolTipText("Tìm kiếm theo mã");
		btnSearch_tabProduct.setBounds(1009, 18, 42, 25);
		tabProduct.add(btnSearch_tabProduct);
		btnSearch_tabProduct.addActionListener(this);

		tabInfo = new JPanel();
		tabInfo.setLayout(null);
		tabInfo.setBackground(Color.WHITE);
		tabbedPane.addTab("Thông Tin Của Bạn", new ImageIcon("image\\btnProfile1.png"), tabInfo, null);

		JPanel panel_5_1_2_1_1 = new JPanel();
		panel_5_1_2_1_1.setLayout(null);
		panel_5_1_2_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1_2_1_1.setBackground(Color.WHITE);
		panel_5_1_2_1_1.setBounds(10, 54, 1041, 440);
		tabInfo.add(panel_5_1_2_1_1);

		JLabel lblNewLabel_1_4_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1_1.setBounds(78, 49, 97, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_4_1_1);

		txtID_tabInfo = new JTextField();
		txtID_tabInfo.setText(user.getID() + "");
		txtID_tabInfo.setEditable(false);
		txtID_tabInfo.setToolTipText("");
		txtID_tabInfo.setHorizontalAlignment(SwingConstants.LEFT);
		txtID_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtID_tabInfo.setColumns(10);
		txtID_tabInfo.setBackground(SystemColor.menu);
		txtID_tabInfo.setBounds(185, 49, 309, 32);
		panel_5_1_2_1_1.add(txtID_tabInfo);

		JLabel lblNewLabel_1_1_2_1_3 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_3.setBounds(78, 91, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_3);

		txtName_tabInfo = new JTextField();
		txtName_tabInfo.setText(user.getName());
		txtName_tabInfo.setEditable(false);
		txtName_tabInfo.setToolTipText("");
		txtName_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName_tabInfo.setColumns(10);
		txtName_tabInfo.setBackground(SystemColor.menu);
		txtName_tabInfo.setBounds(185, 91, 309, 32);
		panel_5_1_2_1_1.add(txtName_tabInfo);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(78, 133, 69, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_2_4_1 = new JLabel("Gmail");
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4_1.setBounds(561, 49, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_2_4_1);

		txtGmail_tabInfor = new JTextField();
		txtGmail_tabInfor.setText(user.getGmail());
		txtGmail_tabInfor.setEditable(false);
		txtGmail_tabInfor.setToolTipText("");
		txtGmail_tabInfor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGmail_tabInfor.setColumns(10);
		txtGmail_tabInfor.setBackground(SystemColor.menu);
		txtGmail_tabInfor.setBounds(679, 49, 309, 32);
		panel_5_1_2_1_1.add(txtGmail_tabInfor);

		txtPassword_tabInfo = new JPasswordField(user.getPassword());
		txtPassword_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassword_tabInfo.setColumns(10);
		txtPassword_tabInfo.setBackground(SystemColor.menu);
		txtPassword_tabInfo.setBounds(679, 91, 274, 32);
		panel_5_1_2_1_1.add(txtPassword_tabInfo);

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

		txtBirthDate_tabInfo = new JTextField();
		txtBirthDate_tabInfo
				.setText(new SimpleDateFormat("dd/MM/yyyy").format(java.sql.Date.valueOf(user.getBirthDate())));
		txtBirthDate_tabInfo.setEditable(false);
		txtBirthDate_tabInfo.setToolTipText("");
		txtBirthDate_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBirthDate_tabInfo.setColumns(10);
		txtBirthDate_tabInfo.setBackground(SystemColor.menu);
		txtBirthDate_tabInfo.setBounds(185, 177, 309, 32);
		panel_5_1_2_1_1.add(txtBirthDate_tabInfo);

		txtDateHir_tabInfo = new JTextField();
		txtDateHir_tabInfo
				.setText(new SimpleDateFormat("dd/MM/yyyy").format(java.sql.Date.valueOf(user.getHireDate())));
		txtDateHir_tabInfo.setEditable(false);
		txtDateHir_tabInfo.setToolTipText("");
		txtDateHir_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateHir_tabInfo.setColumns(10);
		txtDateHir_tabInfo.setBackground(SystemColor.menu);
		txtDateHir_tabInfo.setBounds(185, 220, 309, 32);
		panel_5_1_2_1_1.add(txtDateHir_tabInfo);

		txtGender_tabInfo = new JTextField();
		txtGender_tabInfo.setText(user.isGender() == 0 ? "Nam" : "Nữ");
		txtGender_tabInfo.setToolTipText("");
		txtGender_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender_tabInfo.setEditable(false);
		txtGender_tabInfo.setColumns(10);
		txtGender_tabInfo.setBackground(SystemColor.menu);
		txtGender_tabInfo.setBounds(185, 133, 309, 32);
		panel_5_1_2_1_1.add(txtGender_tabInfo);

		JLabel lblNewLabel_1_1_2_1_2_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2_1_1_1.setBounds(78, 262, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_2_1_1_1);

		txtPhone_tabInfo = new JTextField();
		txtPhone_tabInfo.setText(user.getPhone());
		txtPhone_tabInfo.setToolTipText("");
		txtPhone_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone_tabInfo.setEditable(false);
		txtPhone_tabInfo.setColumns(10);
		txtPhone_tabInfo.setBackground(SystemColor.menu);
		txtPhone_tabInfo.setBounds(185, 262, 309, 32);
		panel_5_1_2_1_1.add(txtPhone_tabInfo);

		JTextPane txtAddress_tabInfo = new JTextPane();
		txtAddress_tabInfo.setText("12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh");
		txtAddress_tabInfo.setEditable(false);
		txtAddress_tabInfo.setBackground(SystemColor.menu);
		txtAddress_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAddress_tabInfo.setBounds(185, 307, 309, 84);
		panel_5_1_2_1_1.add(txtAddress_tabInfo);

		btnSave_tabInfo = new JButton("");
		btnSave_tabInfo.setIcon(new ImageIcon("image\\save.png"));
		btnSave_tabInfo.setToolTipText("Cập nhật mật khẩu");
		btnSave_tabInfo.setForeground(Color.BLACK);
		btnSave_tabInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave_tabInfo.setBackground(UIManager.getColor("Button.background"));
		btnSave_tabInfo.setBounds(936, 133, 52, 32);
		panel_5_1_2_1_1.add(btnSave_tabInfo);
		btnSave_tabInfo.addActionListener(this);

		btnShowPass_tabInfo = new JButton("");
		btnShowPass_tabInfo.setIcon(new ImageIcon("image\\password.png"));
		btnShowPass_tabInfo.setToolTipText("Xem mật khẩu");
		btnShowPass_tabInfo.setForeground(Color.BLACK);
		btnShowPass_tabInfo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShowPass_tabInfo.setBackground(UIManager.getColor("Button.background"));
		btnShowPass_tabInfo.setBounds(951, 91, 37, 31);
		panel_5_1_2_1_1.add(btnShowPass_tabInfo);
		btnShowPass_tabInfo.addActionListener(this);

		JLabel lblThngTinCa = new JLabel("Thông Tin Của Bạn");
		lblThngTinCa.setForeground(new Color(128, 0, 255));
		lblThngTinCa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinCa.setBounds(438, 10, 190, 34);
		tabInfo.add(lblThngTinCa);

		JTextPane txtpnTnTi = new JTextPane();
		txtpnTnTi.setText(
				"Tên đề tài:   Quản lý siêu thị.\r\nHướng dẫn: THS. Nguyễn Thị Hoàng Khánh.\r\nThực hiện:   Huỳnh Quốc Bảo - Nguyễn Văn Sơn.");
		txtpnTnTi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnTnTi.setEditable(false);
		txtpnTnTi.setBackground(Color.WHITE);
		txtpnTnTi.setBounds(371, 513, 359, 66);
		tabInfo.add(txtpnTnTi);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.menu);
		toolBar.setBounds(0, 0, 1086, 30);
		contentPane.add(toolBar);

		btnOrder = new JButton("");
		btnOrder.setToolTipText("Thanh toán hóa đơn");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder.setIcon(new ImageIcon("image\\btnAdd.png"));
		toolBar.add(btnOrder);
		btnOrder.addActionListener(this);

		btnDelOrder = new JButton("");
		btnDelOrder.setToolTipText("Hủy chi tiết một đơn hàng");
		btnDelOrder.setIcon(new ImageIcon("image\\delete-item.png"));
		toolBar.add(btnDelOrder);
		btnDelOrder.addActionListener(this);

		btnBill = new JButton("");
		btnBill.setToolTipText("Quản lý hóa đơn");
		btnBill.setIcon(new ImageIcon("image\\btnBill.png"));
		toolBar.add(btnBill);
		btnBill.addActionListener(this);

		btnUsers = new JButton("");
		btnUsers.setIcon(new ImageIcon("image\\btnPerson.png"));
		btnUsers.setToolTipText("Quản lý nhân viên");
		toolBar.add(btnUsers);
		btnUsers.addActionListener(this);

		btnCategory = new JButton("");
		btnCategory.setToolTipText("Quản lý loại hàng");
		btnCategory.setIcon(new ImageIcon("image\\catagory.png"));
		toolBar.add(btnCategory);
		btnCategory.addActionListener(this);

		btnProduct = new JButton("");
		btnProduct.setIcon(new ImageIcon("image\\btnCatogory.png"));
		btnProduct.setToolTipText("Quản lý mặt hàng");
		toolBar.add(btnProduct);
		btnProduct.addActionListener(this);

		btnInfo = new JButton("");
		btnInfo.setToolTipText("Xem thông tin của bạn");
		btnInfo.setIcon(new ImageIcon("image\\btnProfile.png"));
		toolBar.add(btnInfo);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { tabbedPane }));
		btnInfo.addActionListener(this);

		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// event toolBar

		if (o.equals(btnOrder) || o.equals(menu1_1)) {
			if (btnOrder_tool) {
				tabbedPane.remove(tabOrder);
				btnOrder_tool = false;
				return;
			}
			tabbedPane.addTab("Thanh Toán Hóa Đơn", new ImageIcon("image\\btnAdd1.png"), tabOrder, null);
			btnOrder_tool = true;
		}
		if (o.equals(btnDelOrder) || o.equals(menu1_2)) {
			if (btnDelOrder_tool) {
				tabbedPane.remove(tabDelOrder);
				btnDelOrder_tool = false;
				return;
			}
			tabbedPane.addTab("Hủy Chi Tiết Một Món Hàng", new ImageIcon("image\\delete-item (1).png"), tabDelOrder,
					null);
			btnDelOrder_tool = true;

		}
		if (o.equals(btnBill) || o.equals(menu2_1)) {
			if (btnBill_tool) {
				tabbedPane.remove(tabBill);
				btnBill_tool = false;
				return;
			}
			tabbedPane.addTab("Hóa Đơn", new ImageIcon("image\\invoice1.png"), tabBill, null);
			btnBill_tool = true;

		}
		if (o.equals(btnUsers) || o.equals(menu2_2)) {
			if (btnUsers_tool) {
				tabbedPane.remove(tabUser);
				btnUsers_tool = false;
				return;
			}
			tabbedPane.addTab("Nhân Viên", new ImageIcon("image\\btnPerson1.png"), tabUser, null);
			btnUsers_tool = true;
		}
		if (o.equals(btnCategory) || o.equals(menu2_3)) {
			if (btnCategory_tool) {
				tabbedPane.remove(tabCategory);
				btnCategory_tool = false;
				return;
			}
			tabbedPane.addTab("Loại Hàng", new ImageIcon("image\\catagory1.png"), tabCategory, null);
			btnCategory_tool = true;
		}
		if (o.equals(btnProduct) || o.equals(menu2_4)) {
			if (btnProduct_tool) {
				tabbedPane.remove(tabProduct);
				btnProduct_tool = false;
				return;
			}
			tabbedPane.addTab("Mặt Hàng", new ImageIcon("image\\btnCatogory1.png"), tabProduct, null);
			btnProduct_tool = true;

		}
		if (o.equals(btnInfo) || o.equals(menu3_1)) {
			if (btnInfo_tool) {
				tabbedPane.remove(tabInfo);
				btnInfo_tool = false;
				return;
			}
			tabbedPane.addTab("Thông Tin Của Bạn", new ImageIcon("image\\btnProfile1.png"), tabInfo, null);
			btnInfo_tool = true;
		}

		if (o.equals(menu4_1)) {
			this.setVisible(false);
			new Login_gui().setVisible(true);
		}

		if (o.equals(menu4_2)) {
			System.exit(0);
		}
		
// Event Category
		// combobox category
		if (o.equals(comboBoxCategory_tabCategory)) {
			if (comboBoxCategory_tabCategory.getSelectedIndex() == 0) {
				tfID_tabCategory.setText("");
				tfName_tabCategory.setText("");
				tfID_tabCategory.setEditable(true);

				updateTableCategory();

				comboBoxSort_tabCategory.setSelectedIndex(0);
				tfQuantity_tabCategory.setText((categoriesServiceImpl.getListProductNullCategories().size()) + "");
				return;
			}
			for (int i = 1; i <= categoriesServiceImpl.getListCategories().size(); i++) {
				if (comboBoxCategory_tabCategory.getSelectedIndex() == i) {
					tfID_tabCategory.setText(comboBoxCategory_tabCategory.getSelectedIndex() + "");
					tfName_tabCategory.setText(comboBoxCategory_tabCategory.getSelectedItem().toString());
					tfID_tabCategory.setEditable(false);
					comboBoxSort_tabCategory.setSelectedIndex(0);
					tfQuantity_tabCategory.setText((categoriesServiceImpl.getListProductByCategoriesID(i).size()) + "");

					listProductCategory = categoriesServiceImpl.getListProductByCategoriesID(i);
					model_category.setProducts(listProductCategory);
					table_tabCategory.setModel(model_category);
					table_tabCategory.updateUI();
					return;
				}
			}
		}

		// btn làm rỗng field category
		if (o.equals(btnReset_tabCategory)) {
			tfID_tabCategory.setText("");
			tfName_tabCategory.setText("");
			tfID_tabCategory.setEditable(true);
			tfSearch_tabCategory.setText("");
			comboBoxCategory_tabCategory.setSelectedIndex(0);
		}

		// btn add category
		if (o.equals(btnAdd_tabCategory)) {
			if (tfID_tabCategory.getText().strip() == "" || tfName_tabCategory.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Không được để trống các field", "Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(tfID_tabCategory.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Mã loại hàng hóa\" phải là số nguyên", "Quản Lý Siêu Thị", 2);
				return;
			}

			try {
				categoriesServiceImpl.addCategories(new Categories(id, tfName_tabCategory.getText()));
				JOptionPane.showMessageDialog(this, "Thêm thành công!", "Quản Lý Siêu Thị",
						2);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Trùng\"Mã loại hàng hóa\"", "Quản Lý Siêu Thị",
						2);
				return;
			}
			listProductCategory = categoriesServiceImpl.getListProductNullCategories();
			updateComboBoxCategory();
			JOptionPane.showMessageDialog(this, "Thêm thành công", "Quản Lý Siêu Thị", 1);
		}

		// btn delete category
		if (o.equals(btnDel_tabCategory)) {
			if (comboBoxCategory_tabCategory.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn loại hàng để xóa!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn xóa loại hàng \""
							+ comboBoxContent.get(comboBoxCategory_tabCategory.getSelectedIndex()) + "\"?\n",
					"Quản Lý Siêu Thị", 2);
			if (i == 0) {
				boolean kq = categoriesServiceImpl.DelCategories(comboBoxCategory_tabCategory.getSelectedIndex());

				if (kq) {
					listProductCategory = categoriesServiceImpl.getListProductNullCategories();
					updateComboBoxCategory();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Xóa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else {
				return;
			}
		}

		// btn edit category
		if (o.equals(btnEdit_tabCategory)) {
			if (comboBoxCategory_tabCategory.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn loại hàng để sửa!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (tfName_tabCategory.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Tên loại hàng hóa không được để trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			int i = JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn sửa loại hàng \""
							+ comboBoxContent.get(comboBoxCategory_tabCategory.getSelectedIndex()) + "\" thành \""
							+ tfName_tabCategory.getText() + "\"?\n",
					"Quản Lý Siêu Thị", 2);
			if (i == 0) {
				Categories categories = new Categories(Integer.parseInt(tfID_tabCategory.getText()),
						tfName_tabCategory.getText());
				boolean kq = categoriesServiceImpl.UpdateCategories(categories);
				if (kq) {
					listProductCategory = categoriesServiceImpl.getListProductNullCategories();
					updateComboBoxCategory();
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else
				return;
		}

		// search category
		if (o.equals(btnSearch_tabCategory)) {
			if (tfSearch_tabCategory.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (!tfSearch_tabCategory.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hàng hóa phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Categories categories = categoriesServiceImpl
					.searchCategories(Integer.parseInt(tfSearch_tabCategory.getText()));
			if (categories == null) {
				JOptionPane.showMessageDialog(this,
						"Mã hàng hóa \" " + tfSearch_tabCategory.getText() + " \" không tồn tại!", "Quản Lý Siêu Thị",
						2);
				return;
			}

			comboBoxCategory_tabCategory.setSelectedIndex(Integer.parseInt(tfSearch_tabCategory.getText()));
		}

		// sort category
		if (o.equals(comboBoxSort_tabCategory)) {
			if (comboBoxSort_tabCategory.getSelectedIndex() == 0) {
				listProductCategory = categoriesServiceImpl.getListProductNullCategories();
				updateTableCategory();
				return;
			}
			Collections.sort(listProductCategory, (o1, o2) -> o1.getName().compareTo(o2.getName()));
			updateTableCategory();
		}

// Event product

		// làm rỗng các field
		if (o.equals(btnReset_tabProduct)) {
			tfID_tabProduct.setText("");
			tfName_tabProduct.setText("");
			tfPrice_tabProduct.setText("");
			tfSearch_tabCategory.setText("");
			tfSearch_tabProduct.setText("");
			comboBoxNameSup_tabProduct.setSelectedIndex(0);
			comboBoxNameCa_tabProduct.setSelectedIndex(0);
			listProduct = productServiceImpl.getListProducts();
			updateTableProduct();
		}

		// chi tiết sản phẩm - product
		if (btnDetailItem_tabProduct.equals(o)) {
			if (table_tabProduct.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm!", "Quản Lý Siêu Thị", 2);
				return;
			}
			new DetailItem_gui(listProduct.get(table_tabProduct.getSelectedRow())).setVisible(true);

		}

		// add - product
		if (o.equals(btnAdd_tabProduct)) {
			if (tfID_tabProduct.getText().strip() == "" || tfName_tabProduct.getText().strip() == ""
					|| tfPrice_tabProduct.getText().strip() == "" || comboBoxNameSup_tabProduct.getSelectedIndex() == 0
					|| comboBoxNameCa_tabProduct.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Không được để trống các field và tùy chọn không Null",
						"Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(tfID_tabProduct.getText());
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Mã sản phẩm \" phải là số nguyên dương", "Quản Lý Siêu Thị", 2);
				return;
			}
			BigDecimal price;
			try {
				price = BigDecimal.valueOf(Double.parseDouble(tfPrice_tabProduct.getText()));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Giá sản phẩm \" phải là số nguyên dương", "Quản Lý Siêu Thị", 2);
				return;
			}

			try {
				Product product = new Product(id, tfName_tabProduct.getText(), price,
						suppliersServiceImpl.searchSuppliers(comboBoxNameSup_tabProduct.getSelectedIndex()),
						categoriesServiceImpl.searchCategories(comboBoxNameCa_tabProduct.getSelectedIndex()));
				productServiceImpl.addProduct(product);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại! \n Trùng\"Mã sản phẩm\"", "Quản Lý Siêu Thị", 2);
				return;
			}
			
			listProduct = productServiceImpl.getListProducts();
			updateTableProduct();
			JOptionPane.showMessageDialog(this, "Thêm thành công", "Quản Lý Siêu Thị", 1);
		}

		// btn delete - product
		if (o.equals(btnDel_tabProduct)) {
			if (table_tabProduct.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm để xóa!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this,
					"Bạn có chắc chắn muốn xóa sản phẩm có mã \""
							+ listProduct.get(table_tabProduct.getSelectedRow()).getID() + "\"?\n",
					"Quản Lý Siêu Thị", 2);
			if (i == 0) {
				boolean kq = productServiceImpl.DelProduct(listProduct.get(table_tabProduct.getSelectedRow()).getID());

				if (kq) {
					listProduct = productServiceImpl.getListProducts();
					updateTableProduct();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Xóa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else {
				return;
			}
		}

		// btn edit product
		if (o.equals(btnEdit_tabProduct)) {
			if (table_tabProduct.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm để sửa!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (tfID_tabProduct.getText().strip() == "" || tfName_tabProduct.getText().strip() == ""
					|| tfPrice_tabProduct.getText().strip() == "" || comboBoxNameSup_tabProduct.getSelectedIndex() == 0
					|| comboBoxNameCa_tabProduct.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Không được để trống các field và tùy chọn không Null",
						"Quản Lý Siêu Thị", 2);
				return;
			}

			// không được sửa mã
			if (Integer.parseInt(tfID_tabProduct.getText().strip()) != listProduct
					.get(table_tabProduct.getSelectedRow()).getID()) {
				tfID_tabProduct.setText(listProduct.get(table_tabProduct.getSelectedRow()).getID() + "");
				JOptionPane.showMessageDialog(this, "Không được sửa mã sản phẩm!", "Quản Lý Siêu Thị", 2);
				return;
			}
			
			try {
				BigDecimal.valueOf(Double.parseDouble(tfPrice_tabProduct.getText()));
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "\"Giá sản phẩm \" phải là số nguyên dương", "Quản Lý Siêu Thị", 2);
				return;
			}

			int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa sản phẩm đang chọn" + " ?\n",
					"Quản Lý Siêu Thị", 2);

			if (i == 0) {
				Product product = new Product(listProduct.get(table_tabProduct.getSelectedRow()).getID(),
						tfName_tabProduct.getText().strip(),
						BigDecimal.valueOf(Double.parseDouble(tfPrice_tabProduct.getText().strip())),
						suppliersServiceImpl.searchSuppliers(comboBoxNameSup_tabProduct.getSelectedIndex()),
						categoriesServiceImpl.searchCategories(comboBoxNameCa_tabProduct.getSelectedIndex()));
				boolean kq = productServiceImpl.updateProduct(product);
				if (kq) {
					listProduct = productServiceImpl.getListProducts();
					updateTableProduct();
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else
				return;
		}

		// search product
		if (o.equals(btnSearch_tabProduct)) {
			if (tfSearch_tabProduct.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (!tfSearch_tabProduct.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hàng hóa phải là số nguyên dương!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Product product = productServiceImpl.searchProduct(Integer.parseInt(tfSearch_tabProduct.getText()));
			if (product == null) {
				JOptionPane.showMessageDialog(this,
						"Mã sản phẩm \" " + tfSearch_tabProduct.getText() + " \" không tồn tại!", "Quản Lý Siêu Thị",
						2);
				return;
			}
			listProduct = new ArrayList<>();
			listProduct.add(product);
			model_product.setProducts(listProduct);
			table_tabProduct.setModel(model_product);
			table_tabProduct.updateUI();

			tfID_tabProduct.setText(product.getID() + "");
			tfName_tabProduct.setText(product.getName());
			tfPrice_tabProduct.setText(product.getPrice() + "");
			comboBoxNameCa_tabProduct.setSelectedIndex(product.getSuppliers().getID());
			comboBoxNameSup_tabProduct.setSelectedIndex(product.getSuppliers().getID());

		}
		// sort product
		if (o.equals(comboBoxSort_tabProduct)) {
			if (comboBoxSort_tabProduct.getSelectedIndex() == 0) {
				listProduct = productServiceImpl.getListProducts();
				updateTableProduct();
				return;
			} else if (comboBoxSort_tabProduct.getSelectedIndex() == 1) {
				Collections.sort(listProduct, (o1, o2) -> o1.getName().compareTo(o2.getName()));
				updateTableProduct();
			} else {
				Collections.sort(listProduct, (o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
				updateTableProduct();
			}

		}

// Event Order

		// làm rỗng field - order
		if (o.equals(btnReset_tabBill)) {
			tfSearch_tabBill.setText("");
			tfIDProduct_tabBill.setText("");
			tfIDUser_tabBill.setText("");
			tfTotalPrice_tabBill.setText("");
			tfDiscout_tabBill.setText("");
			dateOrder_tabBill.setDate(new Date());

			listOrder=ordersServiceImpl.getListOrders();
			updateTableOrder();
		}

		// delete - order
		if (o.equals(btnDel_tabBill)) {
			if (table_tabBill.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(
					this, "Bạn có chắc chắn muốn xóa hóa đơn có mã \""
							+ listOrder.get(table_tabBill.getSelectedRow()).getID() + "\" không?",
					"Quản Lý Siêu Thị", 2);
			if (i == 0) {
				try {
					ordersServiceImpl.delOrder(listOrder.get(table_tabBill.getSelectedRow()).getID());
					listOrder=ordersServiceImpl.getListOrders();
					updateTableOrder();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Quản Lý Siêu Thị", 2);
				}
			} else
				return;
		}

		// edit Order
		if (o.equals(btnEdit_tabBill)) {
			if (table_tabBill.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (Integer.parseInt(tfIDProduct_tabBill.getText().strip()) != listOrder.get(table_tabBill.getSelectedRow())
					.getID()) {
				tfIDProduct_tabBill.setText(listOrder.get(table_tabBill.getSelectedRow()).getID() + "");
				JOptionPane.showMessageDialog(this, "Không được sửa mã hóa đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}
			Users users = null;
			try {
				users = usersServiceImpl.searchUsers(Integer.parseInt(tfIDUser_tabBill.getText()));
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (users == null) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên \"" + tfIDUser_tabBill.getText() + "\" không tồn tại",
						"Quản Lý Siêu Thị", 2);
				tfIDUser_tabBill.setText("" + listOrder.get(table_tabBill.getSelectedRow()).getUsers().getID());
				return;
			}
			LocalDate localDate = LocalDate
					.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateOrder_tabBill.getDate()));

			if (!LocalDate.now().isAfter(localDate)) {
				if (LocalDate.now().isEqual(localDate)) {
				} else {
					dateOrder_tabBill.setDate(
							java.sql.Date.valueOf(listOrder.get(table_tabBill.getSelectedRow()).getOrderDate()));
					JOptionPane.showMessageDialog(this, "Ngày lập hóa đơn không lớn hơn ngày hiện tại!",
							"Quản Lý Siêu Thị", 2);
					return;
				}
			}

			int i = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa hóa đơn đang chọn" + " ?\n",
					"Quản Lý Siêu Thị", 2);

			if (i == 0) {
				Order order = new Order(listOrder.get(table_tabBill.getSelectedRow()).getID(), localDate,
						BigDecimal.valueOf(Double.parseDouble(tfTotalPrice_tabBill.getText())),
						Double.parseDouble(tfDiscout_tabBill.getText()), users);
				boolean kq = ordersServiceImpl.updateOrder(order);
				if (kq) {
					listOrder=ordersServiceImpl.getListOrders();
					updateTableOrder();
					JOptionPane.showMessageDialog(this, "Sửa thành công!", "Quản Lý Siêu Thị", 2);
				} else
					JOptionPane.showMessageDialog(this, "Sửa thất bại! \n", "Quản Lý Siêu Thị", 2);
			} else
				return;
		}

		// search -order
		if (o.equals(btnSearc_tabBill)) {
			if (tfSearch_tabBill.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (!tfSearch_tabBill.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hóa đơn phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Order order = ordersServiceImpl.searchOrder(Integer.parseInt(tfSearch_tabBill.getText().strip()));
			if (order == null) {
				JOptionPane.showMessageDialog(this,
						"Mã hóa đơn \" " + tfSearch_tabBill.getText() + " \" không tồn tại!", "Quản Lý Siêu Thị", 2);
				return;
			}
			listOrder = new ArrayList<>();
			listOrder.add(order);
			model_Order.setOrders(listOrder);
			table_tabBill.setModel(model_Order);
			table_tabBill.updateUI();

			tfIDProduct_tabBill.setText(order.getID() + "");
			tfIDUser_tabBill.setText(order.getUsers().getID() + "");
			tfTotalPrice_tabBill.setText(order.getTotalPrice() + "");
			tfDiscout_tabBill.setText(order.getDiscount() + "");
			dateOrder_tabBill.setDate(new Date());
		}

		// detail order
		if (btnDetailOrder_tabBill.equals(o)) {
			if (table_tabBill.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!", "Quản Lý Siêu Thị", 2);
				return;
			}

			new DetailOrder_gui(listOrder.get(table_tabBill.getSelectedRow())).setVisible(true);
		}

		// sort order
		if (o.equals(comboBoxSort_tabBill)) {

			if (comboBoxSort_tabBill.getSelectedIndex() == 0) {
				listOrder = ordersServiceImpl.getListOrders();
				updateTableOrder();
			} else if (comboBoxSort_tabBill.getSelectedIndex() == 1) {
				Collections.sort(listOrder, (o1, o2) -> o1.getUsers().getName().compareTo(o2.getUsers().getName()));
				updateTableOrder();
			} else if (comboBoxSort_tabBill.getSelectedIndex() == 2) {
				Collections.sort(listOrder, (o1, o2) -> (o1.getOrderDate().isAfter(o2.getOrderDate())) ? 1 : -1);
				updateTableOrder();
			} else {
				Collections.sort(listOrder, (o1, o2) -> o1.getTotalPrice().compareTo(o2.getTotalPrice()));
				updateTableOrder();
			}
		}

// Event Thanh toán hóa đơn

		// add cartItem vào ds temp
		if (o.equals(btnAdd_tabOrder)) {
			if (tfIDProduct_tabOrder.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm vào field", "Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(tfIDProduct_tabOrder.getText().strip());
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

			for (CartItem c : listCartItem_temp) {
				if (c.getProduct().getID() == product.getID()) {
					c.setQuantity(c.getQuantity() + Integer.parseInt(spinnerQuantity_tabOrder.getValue().toString()));
					updateTableCartItem();
					updateTotalPrice();
					return;
				}
			}

			idOrder_temp = ordersServiceImpl.getListOrders().get(ordersServiceImpl.getListOrders().size() - 1).getID() + 1;

			CartItem cartItem = new CartItem(1, id, new Order(idOrder_temp), product);
			cartItem.setQuantity(Integer.parseInt(spinnerQuantity_tabOrder.getValue().toString()));
			listCartItem_temp.add(cartItem);

			tfIDProduct_tabOrder.setText("");
			spinnerQuantity_tabOrder.setValue(1);
			updateTableCartItem();
			updateTotalPrice();
		}

		// làm rỗng field - cartItem
		if (o.equals(btnReset_tabOrder)) {
			tfIDProduct_tabOrder.setText("");
			spinnerQuantity_tabOrder.setValue(1);
		}

		// delete 1 dòng trong ds cartItem_temp
		if (o.equals(btnDel_tabOrder)) {
			if (table_tabOrder.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để xóa", "Quản Lý Siêu Thị", 2);
				return;
			}
			listCartItem_temp.remove(table_tabOrder.getSelectedRow());

			updateTableCartItem();
			updateTotalPrice();

			JOptionPane.showMessageDialog(this, "Xóa thành công", "Quản Lý Siêu Thị", 1);
		}

		// edit cartItem_temp
		if (o.equals(btnEdit_tabOrder)) {
			if (table_tabOrder.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để xóa", "Quản Lý Siêu Thị", 2);
				return;
			}
			listCartItem_temp.get(table_tabOrder.getSelectedRow())
					.setProduct(productServiceImpl.searchProduct(Integer.parseInt(tfIDProduct_tabOrder.getText())));
			listCartItem_temp.get(table_tabOrder.getSelectedRow())
					.setQuantity(Integer.parseInt(spinnerQuantity_tabOrder.getValue().toString()));

			updateTableCartItem();
			updateTotalPrice();

			tfIDProduct_tabOrder.setText("");
			spinnerQuantity_tabOrder.setValue(1);
			JOptionPane.showMessageDialog(this, "Sửa thành công", "Quản Lý Siêu Thị", 1);
		}

		// sort cartItem_temp
		if (o.equals(comboBoxSort_Order)) {

			if (comboBoxSort_Order.getSelectedIndex() == 0) {
				updateTableCartItem();
			} else if (comboBoxSort_Order.getSelectedIndex() == 1) {
				Collections.sort(listCartItem_temp,
						(o1, o2) -> o1.getProduct().getName().compareTo(o2.getProduct().getName()));
				updateTableCartItem();
			} else if (comboBoxSort_Order.getSelectedIndex() == 2) {
				Collections.sort(listCartItem_temp, (o1, o2) -> (o1.getQuantity() > o2.getQuantity()) ? -1 : 1);
				updateTableCartItem();
			} else {
				Collections.sort(listCartItem_temp,
						(o1, o2) -> o2.getProduct().getPrice().compareTo(o1.getProduct().getPrice()));
				updateTableCartItem();
			}
		}

		// Thanh toán - add cartItem
		if (o.equals(btnPay_tabOrder)) {
			if (listCartItem_temp.size() == 0) {
				JOptionPane.showMessageDialog(this, "Hóa đơn rỗng", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận thanh toán", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				try {
					int cartItemID = cartItemServiceImpl.getListCartItem().get(cartItemServiceImpl.getListCartItem().size() - 1).getID() + 1;

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
					

					listOrder = ordersServiceImpl.getListOrders();
					updateTableCartItem();
					updateTotalPrice();
					updateTableOrder();

					tfIDProduct_tabOrder.setText("");
					spinnerQuantity_tabOrder.setValue(1);
					textField_2.setText("");

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Thanh toán thất bại, hóa đơn chưa được lưu",
							"Quản Lý Siêu Thị", 2);
				}
			} else {
				return;
			}
		}

// hủy chi tiết một món hàng trong hóa đơn

		if (o.equals(btnSearch_tabDelOrder)) {
			if (tfSearch_tabDelOrder.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Field tìm kiếm trống!", "Quản Lý Siêu Thị", 2);
				return;
			}
			if (!tfSearch_tabDelOrder.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã hóa đơn phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Order order = ordersServiceImpl.searchOrder(Integer.parseInt(tfSearch_tabDelOrder.getText().strip()));
			if (order == null) {
				JOptionPane.showMessageDialog(this,
						"Mã hóa đơn \" " + tfSearch_tabDelOrder.getText() + " \" không tồn tại!", "Quản Lý Siêu Thị",
						2);
				return;
			}
			listCartItemDel = cartItemServiceImpl.getListCartItemByOrderID(order.getID());
			updateTableCartItemDel();
		}
		if (o.equals(btnDel_tabDelOrder)) {
			if (table_tabDelOrder.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để xóa!", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận xóa dòng đang chọn", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				try {
					int id = listCartItemDel.get(table_tabDelOrder.getSelectedRow()).getID();
					cartItemServiceImpl.delCartItem(id);
					listCartItemDel.remove(table_tabDelOrder.getSelectedRow());

					double totalPrice = 0;
					for (CartItem c : listCartItemDel)
						totalPrice += c.getQuantity() * Double.parseDouble(c.getProduct().getPrice().toString());

					Order order = ordersServiceImpl.searchOrder(listCartItemDel.get(0).getOrder().getID());
					order.setTotalPrice(BigDecimal.valueOf(totalPrice));

					ordersServiceImpl.updateOrder(order);
					listOrder = ordersServiceImpl.getListOrders();
					updateTableOrder();
					updateTableCartItemDel();
					JOptionPane.showMessageDialog(this, "Xóa thành công!", "Quản Lý Siêu Thị", 2);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Xóa thất bại!", "Quản Lý Siêu Thị", 2);
				}
			} else {
				return;
			}
		}

		// sort hủy cartItem
		if (o.equals(comboBoxSort_tabDelOrder)) {

			if (comboBoxSort_tabDelOrder.getSelectedIndex() == 0) {
				updateTableCartItemDel();
			} else if (comboBoxSort_tabDelOrder.getSelectedIndex() == 1) {
				Collections.sort(listCartItemDel,
						(o1, o2) -> o1.getProduct().getName().compareTo(o2.getProduct().getName()));
				updateTableCartItemDel();
			} else if (comboBoxSort_tabDelOrder.getSelectedIndex() == 2) {
				Collections.sort(listCartItemDel, (o1, o2) -> (o1.getQuantity() > o2.getQuantity()) ? -1 : 1);
				updateTableCartItemDel();
			} else {
				Collections.sort(listCartItemDel,
						(o1, o2) -> o2.getProduct().getPrice().compareTo(o1.getProduct().getPrice()));
				updateTableCartItemDel();
			}
		}

// event Users
		// rỗng field
		if (o.equals(btnReset_tabUser)) {
			tfSearch_tabUser.setText("");

			tfID_tabUser.setText("");
			tfName_tabUser.setText("");
			tfGmail_tabUser.setText("");
			tfPassword_tabUser.setText("");
			tfAddress_tabUser.setText("");
			tfPhone_tabUser.setText("");
			gender_tabUser.setSelectedIndex(0);
			dateBirth_tabUser.setDate(new Date());
			dateHir_tabUser.setDate(new Date());
			try {
				listUsers = usersServiceImpl.getListUsers();
				updateTableUsers();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// add users
		if (o.equals(btnAdd_tabUser)) {
			Boolean regex = regexUsers();
			if (!regex) {
				return;
			}

			try {
				Users users = new Users(Integer.parseInt(tfID_tabUser.getText().strip()),
						tfName_tabUser.getText().strip(), gender_tabUser.getSelectedIndex(),
						tfGmail_tabUser.getText().strip(), tfPhone_tabUser.getText().strip(),
						tfAddress_tabUser.getText().strip(),
						LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateBirth_tabUser.getDate())),
						LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateHir_tabUser.getDate())),
						"ROLE_EMPLOYEE", tfPassword_tabUser.getText());

				usersServiceImpl.addUsers(users);
				listUsers = usersServiceImpl.getListUsers();
				updateTableUsers();
				JOptionPane.showMessageDialog(this, "Thêm thành công", "Quản Lý Siêu Thị", 2);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại: " + e2.getMessage(), "Quản Lý Siêu Thị", 2);
			}
		}

		// delete user
		if (o.equals(btnDel_tabUser)) {
			if (table_tabUser.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để xóa", "Quản Lý Siêu Thị", 2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận xóa dòng đang chọn", "Quản Lý Siêu Thị", 2);
			if(i==0) {
				try {
					usersServiceImpl.delUsers(listUsers.get(table_tabUser.getSelectedRow()).getID());
					listUsers = usersServiceImpl.getListUsers();
					updateTableUsers();
					JOptionPane.showMessageDialog(this, "Xóa thành công", "Quản Lý Siêu Thị", 2);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Xóa thất bại", "Quản Lý Siêu Thị", 2);
				}
			} else return;
		}

		// edit user
		if (o.equals(btnEdit_tabUser)) {
			if (table_tabUser.getSelectedRow() < 0) {
				JOptionPane.showMessageDialog(this, "Mời chọn dòng để sửa", "Quản Lý Siêu Thị", 2);
				return;
			}

			if (Integer.parseInt(tfID_tabUser.getText().strip()) != listUsers.get(table_tabUser.getSelectedRow())
					.getID()) {
				JOptionPane.showMessageDialog(this, "Không được sửa mã nhân viên", "Quản Lý Siêu Thị", 2);
				return;
			}

			Boolean regex = regexUsers();
			if (!regex)
				return;
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận sửa dòng đang chọn", "Quản Lý Siêu Thị", 2);
			if(i==0) {
				try {
					Users users = new Users(Integer.parseInt(tfID_tabUser.getText().strip()),
							tfName_tabUser.getText().strip(), gender_tabUser.getSelectedIndex(),
							tfGmail_tabUser.getText().strip(), tfPhone_tabUser.getText().strip(),
							tfAddress_tabUser.getText().strip(),
							LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateBirth_tabUser.getDate())),
							LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(dateHir_tabUser.getDate())),
							"ROLE_EMPLOYEE", tfPassword_tabUser.getText());
					usersServiceImpl.updateUsers(users);
					listUsers = usersServiceImpl.getListUsers();
					updateTableUsers();
					JOptionPane.showMessageDialog(this, "Sửa thành công", "Quản Lý Siêu Thị", 2);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Sửa thât bại", "Quản Lý Siêu Thị", 2);
				}
			}else return;

		}
		// search -user
		if (o.equals(btnSearch_tabUser)) {
			if (tfSearch_tabUser.getText().strip() == "") {
				listUsers = new ArrayList<>();
				try {
					listUsers = usersServiceImpl.getListUsers();
					model_Users.setUsers(listUsers);
					table_tabUser.setModel(model_Users);
					table_tabUser.updateUI();
					tfSearch_tabUser.setText("");
					tfID_tabUser.setText("");
					tfName_tabUser.setText("");
					tfGmail_tabUser.setText("");
					tfPassword_tabUser.setText("");
					tfAddress_tabUser.setText("");
					tfPhone_tabUser.setText("");
					gender_tabUser.setSelectedIndex(0);
					dateBirth_tabUser.setDate(new Date());
					dateHir_tabUser.setDate(new Date());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return;
			}

			if (!tfSearch_tabUser.getText().matches("[0-9]+")) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên phải là số nguyên!", "Quản Lý Siêu Thị", 2);
				return;
			}

			Users users = null;
			try {
				users = usersServiceImpl.searchUsers(Integer.parseInt(tfSearch_tabUser.getText().strip()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (users == null) {
				JOptionPane.showMessageDialog(this,
						"Mã nhân viên \" " + tfSearch_tabUser.getText() + " \" không tồn tại!", "Quản Lý Siêu Thị", 2);
				return;
			}
			listUsers = new ArrayList<>();
			listUsers.add(users);
			model_Users.setUsers(listUsers);
			table_tabUser.setModel(model_Users);
			table_tabUser.updateUI();

			tfSearch_tabUser.setText("");

			tfID_tabUser.setText(users.getID() + "");
			tfName_tabUser.setText(users.getName());
			tfGmail_tabUser.setText(users.getGmail());
			tfPassword_tabUser.setText(users.getPassword());
			tfAddress_tabUser.setText(users.getAddress());
			tfPhone_tabUser.setText(users.getPhone());
			gender_tabUser.setSelectedIndex(users.isGender() == 0 ? 1 : 0);
			dateBirth_tabUser.setDate(new Date());
			dateHir_tabUser.setDate(new Date());
		}

		// sort user
		if (o.equals(comboBoxSort_tabUser)) {

			if (comboBoxSort_tabUser.getSelectedIndex() == 0) {
				try {
					listUsers = usersServiceImpl.getListUsers();
					updateTableUsers();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (comboBoxSort_tabUser.getSelectedIndex() == 1) {
				Collections.sort(listUsers, (o1, o2) -> o1.getName().compareTo(o2.getName()));
				try {
					updateTableUsers();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else if (comboBoxSort_tabUser.getSelectedIndex() == 2) {
				Collections.sort(listUsers, (o1, o2) -> (o1.getHireDate().isAfter(o2.getHireDate())) ? 1 : -1);
				try {
					updateTableUsers();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
// info
		// show password
		if (o.equals(btnShowPass_tabInfo)) {
			if (password) {
				txtPassword_tabInfo.setEchoChar((char) 0);
				password = false;
				return;
			}
			txtPassword_tabInfo.setEchoChar('•');
			password = true;
		}

		// save password
		if (o.equals(btnSave_tabInfo)) {

			if (txtPassword_tabInfo.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Mật khẩu rỗng!", "Quản Lý Siêu Thị", 2);
				return;
			}

			String patternPassword = "^(?=.*[A-Za-z0-9]).{6,}$";
			if (!checkRegex(patternPassword, txtPassword_tabInfo.getText().strip())) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại: Password không đúng định dạng", "Quản Lý Siêu Thị",
						2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				try {
					user.setPassword(txtPassword_tabInfo.getText());
					usersServiceImpl.updateUsers(user);
					txtPassword_tabInfo.setEchoChar('•');
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Quản Lý Siêu Thị", 1);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại", "Quản Lý Siêu Thị", 2);
				}
			}
		}

// Xuất file xml danh sách sinh viên xml/user.xml

		if (o.equals(writeXMLListUser)) {
			String location = JOptionPane.showInputDialog(this, "File sẽ được lưu ở: ", "Quản Lý Siêu Thị", 1);
			UsersHandler usersHandler = new UsersHandler();
			if (location == null) {
				JOptionPane.showMessageDialog(this, "Xuất file thất bại! \"không nhập đường dẫn\"", "Quản Lý Siêu Thị",
						2);
				return;
			}
			if (location.strip() == "") {
				JOptionPane.showMessageDialog(this, "Xuất file thất bại! \"Đường dẫn rỗng\"", "Quản Lý Siêu Thị", 2);
				return;
			}
			try {
				usersHandler.writeUsersXML(usersServiceImpl.getListUsers(), location);
				JOptionPane.showMessageDialog(this, "File đã được lưu theo đường dẫn \"" + location + "\"",
						"Quản Lý Siêu Thị", 2);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Xuất file thất bại! \"Lỗi đường dẫn\"!", "Quản Lý Siêu Thị", 2);
			}
		}
	}

	private boolean checkRegex(String pattern, String str) {
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher m = r.matcher(str);
		return m.find();
	}

	private Boolean regexUsers() {
		if (tfID_tabUser.getText().strip() == "" || tfName_tabUser.getText().strip() == ""
				|| tfGmail_tabUser.getText().strip() == "" || tfPassword_tabUser.getText().strip() == ""
				|| tfAddress_tabUser.getText().strip() == "" || tfPhone_tabUser.getText().strip() == "") {
			JOptionPane.showMessageDialog(this, "Không được trống các field", "Quản Lý Siêu Thị", 2);
			return false;
		}
		String patternEmail = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		String patternPhone = "^(03|05|07|08|09|01)+([0-9]{8})";
		String patternPassword = "^(?=.*[A-Za-z0-9]).{6,}$";

		if (!checkRegex(patternEmail, tfGmail_tabUser.getText().strip())) {
			JOptionPane.showMessageDialog(this, "Gmail không đúng định dạng", "Quản Lý Siêu Thị", 2);
			return false;
		} else if (!checkRegex(patternPhone, tfPhone_tabUser.getText().strip())) {
			JOptionPane.showMessageDialog(this, "Phone không đúng định dạng", "Quản Lý Siêu Thị", 2);
			return false;
		} else if (!checkRegex(patternPassword, tfPassword_tabUser.getText().strip())) {
			JOptionPane.showMessageDialog(this, "Password không đúng định dạng", "Quản Lý Siêu Thị", 2);
			return false;
		}
		Date birthday = dateBirth_tabUser.getDate();
		Date hiredate = dateHir_tabUser.getDate();
		if (hiredate.before(birthday)) {
			JOptionPane.showMessageDialog(this, "Ngày vào làm phải sau ngày sinh", "Quản Lý Siêu Thị", 2);
			return false;
		}
		return true;
	}
	
	

	private void updateTableUsers() throws SQLException {
		model_Users.setUsers(listUsers);
		table_tabUser.setModel(model_Users);
		table_tabUser.updateUI();
	}

	private void updateTableCartItemDel() {
		model_CartItemDel.setCartItems(listCartItemDel);
		table_tabDelOrder.setModel(model_CartItemDel);
		table_tabDelOrder.updateUI();
	}

	private void updateTableOrder() {
		model_Order.setOrders(listOrder);
		table_tabBill.setModel(model_Order);
		table_tabBill.updateUI();
	}

	private void updateTotalPrice() {
		double totalPrice = 0;
		for (CartItem i : listCartItem_temp)
			totalPrice += i.getQuantity() * Double.parseDouble(i.getProduct().getPrice().toString());

		textField_2.setText(String.format("%,.0f", totalPrice) + " ₫");
	}

	private void updateTableCartItem() {
		model_CartItem.setCartItems(listCartItem_temp);
		table_tabOrder.setModel(model_CartItem);
		table_tabOrder.updateUI();
	}

	private void updateTableProduct() {
		model_product.setProducts(listProduct);
		table_tabProduct.setModel(model_product);
		table_tabProduct.updateUI();
	}

	private void updateTableCategory() {
		model_category.setProducts(listProductCategory);
		table_tabCategory.setModel(model_category);
		table_tabCategory.updateUI();
	}

	public void updateComboBoxCategory() {
		comboBoxContent = new ArrayList<>();
		comboBoxContent.add("All");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBoxContent.add(i.getName());
		});
		comboBoxCategory_tabCategory.removeAllItems();
		
		// product
		comboBoxNameCa_tabProduct.removeAllItems();
		
		for (int i = 0; i < comboBoxContent.size(); i++) {
			comboBoxCategory_tabCategory.insertItemAt(comboBoxContent.get(i), i);
			
			// product
			comboBoxNameCa_tabProduct.insertItemAt(comboBoxContent.get(i), i);
			
		}
		comboBoxCategory_tabCategory.setSelectedIndex(0);
		comboBoxCategory_tabCategory.updateUI();
	}
}
