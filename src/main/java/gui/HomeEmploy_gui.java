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

public class HomeEmploy_gui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_tabOrder;
	private JTextField tfID_tabOrder;
	private JTextField textField_2;
	private JTextField txtID_tabInfo;
	private JTextField txtName_tabInfo;
	private JTextField txtGmail_tabInfo;
	private JTextField txtDateBirth_tabInfo;
	private JTextField txtDateHir_tabInfo;
	private JTextField txtGender_tabInfo;
	private JTextField txtPhone_tabInfo;
	private CategoriesServiceImpl categoriesServiceImpl;
	private List<Product> listProductCategory;
	private ArrayList<String> comboBoxContent;
	private String[] headline_3;
	private String[] headline_2;
	private ArrayList comboBox_1Content;
	private ArrayList comboBox_1_1Content;
	private ProductServiceImpl productServiceImpl;
	private SuppliersServiceImpl suppliersServiceImpl;
	private OrdersServiceImpl ordersServiceImpl;
	private List<Order> listOrder;
	private JButton btnAdd_tabOrder;
	private CartItemServiceImpl cartItemServiceImpl;
	private List<CartItem> listCartItem;
	private ArrayList<CartItem> listCartItem_temp;
	private CartItemTableModel model_CartItem;
	private JSpinner spinnerQuantity_tabOrder;
	private JButton btnSReset_tabOrder;
	private JButton btnDel_tabOrder;
	private JButton btnEdit_tabOrder;
	private JComboBox comboBoxSort_tabOrder;
	private JButton btnPay_tabOrder;
	private int idOrder_temp;
	private UsersServiceImpl usersServiceImpl;
	private List<CartItem> listCartItemDel;
	private List<Users> listUsers;
	private JButton btnShowPass_tabInfo;
	private JButton btnSave_tabInfo;
	private JPasswordField tfPassWord_tabInfo;
	private boolean password = true;
	private JButton btnOrder;
	private JButton btnInfo;

	// false là hiện
	private boolean btnOrder_tool = true;
	private boolean btnInfo_tool = true;

	private JTabbedPane tabbedPane;
	private JPanel tabOrder;
	private JPanel tabInfo;
	private JMenuItem menu1_1;
	private JMenuItem menu3_1;
	private JMenuItem menu4_1;
	private JMenuItem menu4_2;
	private List<Product> listProduct;
	private ArrayList<Integer> listCartItem_ID_temp;
	private CartItemTableModel model_CartItemDel;
	private OrderTableModel model_Order;
	private UserTableModel model_Users;
	private CategoriesTableModel model_category;
	private ProductTableModel model_product;
	private Users user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeEmploy_gui frame = new HomeEmploy_gui(new Users());

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
	public HomeEmploy_gui(Users usersSupper) throws SQLException {
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

		tfID_tabOrder = new JTextField();
		tfID_tabOrder.setToolTipText("Nhập mã sản phẩm");
		tfID_tabOrder.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfID_tabOrder.setBounds(10, 10, 175, 32);
		panel_7.add(tfID_tabOrder);
		tfID_tabOrder.setColumns(10);

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

		btnSReset_tabOrder = new JButton("  Làm Rỗng");
		btnSReset_tabOrder.setIcon(new ImageIcon("image\\clear.png"));
		btnSReset_tabOrder.setForeground(Color.BLACK);
		btnSReset_tabOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSReset_tabOrder.setBackground(Color.WHITE);
		btnSReset_tabOrder.setBounds(445, 10, 169, 32);
		panel_7_1.add(btnSReset_tabOrder);
		btnSReset_tabOrder.addActionListener(this);

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
				tfID_tabOrder.setText(listCartItem_temp.get(index).getProduct().getID() + "");
				spinnerQuantity_tabOrder.setValue(listCartItem_temp.get(index).getQuantity());
			}
		});

		JLabel lblNewLabel_3_1 = new JLabel("Sắp xếp theo");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(878, 14, 81, 13);
		panel_6.add(lblNewLabel_3_1);

		comboBoxSort_tabOrder = new JComboBox();
		comboBoxSort_tabOrder
				.setModel(new DefaultComboBoxModel(new String[] { "Không", "Tên sản phẩm", "Số lượng", "Giá" }));
		comboBoxSort_tabOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBoxSort_tabOrder.setBounds(950, 10, 81, 20);
		panel_6.add(comboBoxSort_tabOrder);
		comboBoxSort_tabOrder.addActionListener(this);

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

		String[] headLine_table_4 = { "STT", "Tên sản phẩm", "Giá sản phẩm", "Số lượng", "Tổng tiền" };

		model_CartItemDel = new CartItemTableModel(listCartItemDel, headLine_table_4);

		// table order
		String[] headLine_1 = { "Mã hóa đơn", "Ngày thanh toán", "Tổng tiền hàng", "Giảm giá", "Tên nhân viên" };
		model_Order = new OrderTableModel(listOrder, headLine_1);

		String[] headLine_table_5 = { "ID", "Họ tên", "Giới tính", "Gmail", "Phone", "Địa chỉ", "Ngày sinh",
				"Ngày vào làm", "Mật khẩu" };
		model_Users = new UserTableModel(listUsers, headLine_table_5);

		// thêm tên loại hàng vào comboBox
		comboBoxContent = new ArrayList<>();
		comboBoxContent.add("All");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBoxContent.add(i.getName());
		});

		// table_catagory
		headline_2 = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Mã loại hàng", "Giá sản phẩm" };
		model_category = new CategoriesTableModel(listProductCategory, headline_2);

		// comboBox nhà cung cấp - product
		comboBox_1Content = new ArrayList<>();
		comboBox_1Content.add("Null");
		suppliersServiceImpl.getListSuppliers().forEach(i -> {
			comboBox_1Content.add(i.getName());
		});

		// comboBox loại hàng - product
		comboBox_1_1Content = new ArrayList<>();
		comboBox_1_1Content.add("Null");
		categoriesServiceImpl.getListCategories().forEach(i -> {
			comboBox_1_1Content.add(i.getName());
		});

		// table Product
		headline_3 = new String[] { "Mã sản phẩm", "Tên sản phẩm", "Mã nhà cung cấp", "Mã loại hàng", "Giá sản phẩm" };
		model_product = new ProductTableModel(listProductCategory, headline_3);

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
		txtID_tabInfo.setText("11");
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

		txtGmail_tabInfo = new JTextField();
		txtGmail_tabInfo.setText(user.getGmail());
		txtGmail_tabInfo.setEditable(false);
		txtGmail_tabInfo.setToolTipText("");
		txtGmail_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGmail_tabInfo.setColumns(10);
		txtGmail_tabInfo.setBackground(SystemColor.menu);
		txtGmail_tabInfo.setBounds(679, 49, 309, 32);
		panel_5_1_2_1_1.add(txtGmail_tabInfo);

		tfPassWord_tabInfo = new JPasswordField(user.getPassword());
		tfPassWord_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPassWord_tabInfo.setColumns(10);
		tfPassWord_tabInfo.setBackground(SystemColor.menu);
		tfPassWord_tabInfo.setBounds(679, 91, 274, 32);
		panel_5_1_2_1_1.add(tfPassWord_tabInfo);

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

		txtDateBirth_tabInfo = new JTextField();
		txtDateBirth_tabInfo
				.setText(new SimpleDateFormat("dd/MM/yyyy").format(java.sql.Date.valueOf(user.getBirthDate())));
		txtDateBirth_tabInfo.setEditable(false);
		txtDateBirth_tabInfo.setToolTipText("");
		txtDateBirth_tabInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDateBirth_tabInfo.setColumns(10);
		txtDateBirth_tabInfo.setBackground(SystemColor.menu);
		txtDateBirth_tabInfo.setBounds(185, 177, 309, 32);
		panel_5_1_2_1_1.add(txtDateBirth_tabInfo);

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
		txtAddress_tabInfo.setText(user.getAddress());
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

//Event Thanh toán hóa đơn	

		// add cartItem vào ds temp
		if (o.equals(btnAdd_tabOrder)) {
			if (tfID_tabOrder.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm vào field", "Quản Lý Siêu Thị", 2);
				return;
			}
			int id;
			try {
				id = Integer.parseInt(tfID_tabOrder.getText().strip());
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
			tfID_tabOrder.setText("");
			spinnerQuantity_tabOrder.setValue(1);
			updateTableCartItem();
			updateTotalPrice();
		}

		// làm rỗng field - cartItem
		if (o.equals(btnSReset_tabOrder)) {
			tfID_tabOrder.setText("");
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
					.setProduct(productServiceImpl.searchProduct(Integer.parseInt(tfID_tabOrder.getText())));
			listCartItem_temp.get(table_tabOrder.getSelectedRow())
					.setQuantity(Integer.parseInt(spinnerQuantity_tabOrder.getValue().toString()));

			updateTableCartItem();
			updateTotalPrice();

			tfID_tabOrder.setText("");
			spinnerQuantity_tabOrder.setValue(1);
			JOptionPane.showMessageDialog(this, "Sửa thành công", "Quản Lý Siêu Thị", 1);
		}

		// sort cartItem_temp
		if (o.equals(comboBoxSort_tabOrder)) {

			if (comboBoxSort_tabOrder.getSelectedIndex() == 0) {
				updateTableCartItem();
			} else if (comboBoxSort_tabOrder.getSelectedIndex() == 1) {
				Collections.sort(listCartItem_temp,
						(o1, o2) -> o1.getProduct().getName().compareTo(o2.getProduct().getName()));
				updateTableCartItem();
			} else if (comboBoxSort_tabOrder.getSelectedIndex() == 2) {
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

					Order order = new Order(idOrder_temp, LocalDate.now(), BigDecimal.valueOf(totalPrice), 0.0, user);
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

					tfID_tabOrder.setText("");
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

// info
		// show password
		if (o.equals(btnShowPass_tabInfo)) {
			if (password) {
				tfPassWord_tabInfo.setEchoChar((char) 0);
				password = false;
				return;
			}
			tfPassWord_tabInfo.setEchoChar('•');
			password = true;
		}

		// save password
		if (o.equals(btnSave_tabInfo)) {
			if (tfPassWord_tabInfo.getText().strip() == "") {
				JOptionPane.showMessageDialog(this, "Mật khẩu rỗng!", "Quản Lý Siêu Thị", 2);
				return;
			}

			String patternPassword = "^(?=.*[A-Za-z0-9]).{6,}$";
			if (!checkRegex(patternPassword, tfPassWord_tabInfo.getText().strip())) {
				JOptionPane.showMessageDialog(this, "Thêm thất bại: Password không đúng định dạng", "Quản Lý Siêu Thị",
						2);
				return;
			}
			int i = JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu", "Quản Lý Siêu Thị", 2);
			if (i == 0) {
				try {
					user.setPassword(tfPassWord_tabInfo.getText());
					usersServiceImpl.updateUsers(user);
					tfPassWord_tabInfo.setEchoChar('•');
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công", "Quản Lý Siêu Thị", 1);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại", "Quản Lý Siêu Thị", 2);
				}
			}
		}

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

	private boolean checkRegex(String pattern, String str) {
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		Matcher m = r.matcher(str);
		return m.find();
	}

}
