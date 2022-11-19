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
import javax.swing.table.TableModel;

public class HomeEmploy_gui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_29;
	private JTextField txtHunhQucBo;
	private JTextField txtBaogmailcom;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField txtNam;
	private JTextField textField_38;
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
	private JButton btnNewButton_2;
	private CartItemServiceImpl cartItemServiceImpl;
	private List<CartItem> listCartItem;
	private ArrayList<CartItem> listCartItem_temp;
	private CartItemTableModel model_CartItem;
	private JSpinner spinner;
	private JButton btnNewButton_2_1_1;
	private JButton btnNewButton_2_1;
	private JButton btnNewButton_2_1_1_2;
	private JComboBox comboBox_3_1;
	private JButton btnNewButton_2_1_1_1;
	private int idOrder_temp;
	private UsersServiceImpl usersServiceImpl;
	private List<CartItem> listCartItemDel;
	private List<Users> listUsers;
	private JButton btnNewButton_2_1_1_1_1_3_1_1_1;
	private JButton btnNewButton_2_1_1_1_1_3_1_1;
	private JPasswordField textField_32;
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
	 */
	public HomeEmploy_gui(Users users) {
		user = users;
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

		textField_29 = new JTextField();
		textField_29.setText("11");
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

		txtHunhQucBo = new JTextField();
		txtHunhQucBo.setText(users.getName());
		txtHunhQucBo.setEditable(false);
		txtHunhQucBo.setToolTipText("");
		txtHunhQucBo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHunhQucBo.setColumns(10);
		txtHunhQucBo.setBackground(SystemColor.menu);
		txtHunhQucBo.setBounds(185, 91, 309, 32);
		panel_5_1_2_1_1.add(txtHunhQucBo);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1_1_1.setBounds(78, 133, 69, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_2_4_1 = new JLabel("Gmail");
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_4_1.setBounds(561, 49, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_2_4_1);

		txtBaogmailcom = new JTextField();
		txtBaogmailcom.setText(users.getGmail());
		txtBaogmailcom.setEditable(false);
		txtBaogmailcom.setToolTipText("");
		txtBaogmailcom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBaogmailcom.setColumns(10);
		txtBaogmailcom.setBackground(SystemColor.menu);
		txtBaogmailcom.setBounds(679, 49, 309, 32);
		panel_5_1_2_1_1.add(txtBaogmailcom);

		textField_32 = new JPasswordField(users.getPassword());
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
		textField_35.setText(users.getBirthDate().toString());
		textField_35.setEditable(false);
		textField_35.setToolTipText("");
		textField_35.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_35.setColumns(10);
		textField_35.setBackground(SystemColor.menu);
		textField_35.setBounds(185, 177, 309, 32);
		panel_5_1_2_1_1.add(textField_35);

		textField_36 = new JTextField();
		textField_36.setText(users.getHireDate().toString());
		textField_36.setEditable(false);
		textField_36.setToolTipText("");
		textField_36.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_36.setColumns(10);
		textField_36.setBackground(SystemColor.menu);
		textField_36.setBounds(185, 220, 309, 32);
		panel_5_1_2_1_1.add(textField_36);

		txtNam = new JTextField();
		txtNam.setText(users.isGender()==0?"Nam":"Nữ");
		txtNam.setToolTipText("");
		txtNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNam.setEditable(false);
		txtNam.setColumns(10);
		txtNam.setBackground(SystemColor.menu);
		txtNam.setBounds(185, 133, 309, 32);
		panel_5_1_2_1_1.add(txtNam);

		JLabel lblNewLabel_1_1_2_1_2_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_2_1_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_2_1_1_1.setBounds(78, 262, 108, 32);
		panel_5_1_2_1_1.add(lblNewLabel_1_1_2_1_2_1_1_1);

		textField_38 = new JTextField();
		textField_38.setText(users.getPhone());
		textField_38.setToolTipText("");
		textField_38.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_38.setEditable(false);
		textField_38.setColumns(10);
		textField_38.setBackground(SystemColor.menu);
		textField_38.setBounds(185, 262, 309, 32);
		panel_5_1_2_1_1.add(textField_38);

		JTextPane txtpnNguynVn = new JTextPane();
		txtpnNguynVn.setText(users.getAddress());
		txtpnNguynVn.setEditable(false);
		txtpnNguynVn.setBackground(SystemColor.menu);
		txtpnNguynVn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnNguynVn.setBounds(185, 307, 309, 84);
		panel_5_1_2_1_1.add(txtpnNguynVn);

		btnNewButton_2_1_1_1_1_3_1_1 = new JButton("");
		btnNewButton_2_1_1_1_1_3_1_1.setIcon(new ImageIcon("image\\save.png"));
		btnNewButton_2_1_1_1_1_3_1_1.setToolTipText("Cập nhật mật khẩu");
		btnNewButton_2_1_1_1_1_3_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_3_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_3_1_1.setBounds(936, 133, 52, 32);
		panel_5_1_2_1_1.add(btnNewButton_2_1_1_1_1_3_1_1);
		btnNewButton_2_1_1_1_1_3_1_1.addActionListener(this);

		btnNewButton_2_1_1_1_1_3_1_1_1 = new JButton("");
		btnNewButton_2_1_1_1_1_3_1_1_1.setIcon(new ImageIcon("image\\password.png"));
		btnNewButton_2_1_1_1_1_3_1_1_1.setToolTipText("Xem mật khẩu");
		btnNewButton_2_1_1_1_1_3_1_1_1.setForeground(Color.BLACK);
		btnNewButton_2_1_1_1_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2_1_1_1_1_3_1_1_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_2_1_1_1_1_3_1_1_1.setBounds(951, 91, 37, 31);
		panel_5_1_2_1_1.add(btnNewButton_2_1_1_1_1_3_1_1_1);
		btnNewButton_2_1_1_1_1_3_1_1_1.addActionListener(this);

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
					int cartItemID = listCartItem.get(listCartItem.size() - 1).getID() + 1;

					double totalPrice = 0;
					for (CartItem c : listCartItem_temp)
						totalPrice += c.getQuantity() * Double.parseDouble(c.getProduct().getPrice().toString());

					Order order = new Order(idOrder_temp, LocalDate.now(), BigDecimal.valueOf(totalPrice), 0.0,
							user);
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

// info
		// show password
		if (o.equals(btnNewButton_2_1_1_1_1_3_1_1_1)) {
			if (password) {
				textField_32.setEchoChar((char) 0);
				password = false;
				return;
			}
			textField_32.setEchoChar('•');
			password = true;
		}

		// save password
		if (o.equals(btnNewButton_2_1_1_1_1_3_1_1)) {

			int i = JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu", "Quản Lý Siêu Thị", 2);

			if (i == 0) {
				try {
					user.setPassword(textField_32.getText());
					usersServiceImpl.updateUsers(user);
					textField_32.setEchoChar('•');
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
		table.setModel(model_CartItem);
		table.updateUI();
	}
}
