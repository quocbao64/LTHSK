package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.toedter.calendar.JDateChooser;

public class HomePerson_gui extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_8;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePerson_gui frame = new HomePerson_gui();
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
		public HomePerson_gui() {
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
			panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thao t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
			
			JSpinner spinner = new JSpinner();
			spinner.setToolTipText("Chọn số lượng");
			spinner.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
			spinner.setBounds(195, 10, 43, 32);
			panel_7.add(spinner);
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
			
			JButton btnNewButton_2 = new JButton("");
			btnNewButton_2.setToolTipText("Thêm sản phẩm mới vào hóa đơn");
			btnNewButton_2.setBounds(248, 10, 76, 32);
			panel_7.add(btnNewButton_2);
			btnNewButton_2.setBackground(new Color(255, 255, 255));
			btnNewButton_2.setForeground(Color.BLACK);
			btnNewButton_2.setIcon(new ImageIcon("image\\add.png"));
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			
			JPanel panel_7_1 = new JPanel();
			panel_7_1.setLayout(null);
			panel_7_1.setBounds(95, 96, 857, 52);
			panel_5.add(panel_7_1);
			
			JButton btnNewButton_2_1 = new JButton("  Xóa");
			btnNewButton_2_1.setIcon(new ImageIcon("image\\delete.png"));
			btnNewButton_2_1.setForeground(Color.BLACK);
			btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton_2_1.setBackground(new Color(255, 255, 255));
			btnNewButton_2_1.setBounds(36, 10, 169, 32);
			panel_7_1.add(btnNewButton_2_1);
			
			JButton btnNewButton_2_1_1 = new JButton("  Làm Rỗng");
			btnNewButton_2_1_1.setIcon(new ImageIcon("image\\clear.png"));
			btnNewButton_2_1_1.setForeground(Color.BLACK);
			btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton_2_1_1.setBackground(Color.WHITE);
			btnNewButton_2_1_1.setBounds(445, 10, 169, 32);
			panel_7_1.add(btnNewButton_2_1_1);
			
			JButton btnNewButton_2_1_1_1 = new JButton("  Thanh Toán");
			btnNewButton_2_1_1_1.setIcon(new ImageIcon("image\\check-mark.png"));
			btnNewButton_2_1_1_1.setForeground(Color.BLACK);
			btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton_2_1_1_1.setBackground(Color.WHITE);
			btnNewButton_2_1_1_1.setBounds(654, 10, 169, 32);
			panel_7_1.add(btnNewButton_2_1_1_1);
			
			JButton btnNewButton_2_1_1_2 = new JButton("  Chỉnh Sửa");
			btnNewButton_2_1_1_2.setIcon(new ImageIcon("image\\edit.png"));
			btnNewButton_2_1_1_2.setForeground(Color.BLACK);
			btnNewButton_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton_2_1_1_2.setBackground(Color.WHITE);
			btnNewButton_2_1_1_2.setBounds(245, 10, 156, 32);
			panel_7_1.add(btnNewButton_2_1_1_2);
			
			JPanel panel_6 = new JPanel();
			panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_6.setBackground(new Color(255, 255, 255));
			panel_6.setBounds(10, 280, 1041, 310);
			panel.add(panel_6);
			panel_6.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(10, 31, 1021, 270);
			panel_6.add(scrollPane);
			
	        
			table = new JTable();
			table.setFont(new Font("Tahoma", Font.PLAIN, 15));
			table.setBackground(UIManager.getColor("Button.light"));
			table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			table.setSelectionBackground(new java.awt.Color(255, 255, 204));
			
			table.setRowHeight(35);
			
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel_3_1 = new JLabel("Sắp xếp theo");
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3_1.setBounds(878, 14, 81, 13);
			panel_6.add(lblNewLabel_3_1);
			
			JComboBox comboBox_3_1 = new JComboBox();
			comboBox_3_1.setModel(new DefaultComboBoxModel(new String[] {"Không", "Tên sản phẩm", "Số lượng", "Giá"}));
			comboBox_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			comboBox_3_1.setBounds(950, 10, 81, 20);
			panel_6.add(comboBox_3_1);
			
			JLabel lblNewLabel = new JLabel("Thanh Toán Hóa Đơn");
			lblNewLabel.setForeground(new Color(128, 0, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(417, 10, 217, 34);
			panel.add(lblNewLabel);
			
			textField_2 = new JTextField();
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
			
			textField_8 = new JTextField();
			textField_8.setToolTipText("Tìm kiếm theo mã");
			textField_8.setColumns(10);
			textField_8.setBackground(UIManager.getColor("Button.background"));
			textField_8.setBounds(878, 18, 132, 26);
			panel.add(textField_8);
			
			JButton btnNewButton_3_1 = new JButton("");
			btnNewButton_3_1.setIcon(new ImageIcon("image\\search.png"));
			btnNewButton_3_1.setToolTipText("Tìm kiếm theo mã");
			btnNewButton_3_1.setBounds(1009, 18, 42, 25);
			panel.add(btnNewButton_3_1);
			
			JPanel panel_1_2_1_1 = new JPanel();
			panel_1_2_1_1.setLayout(null);
			panel_1_2_1_1.setBackground(Color.WHITE);
			tabbedPane.addTab("Thông Tin Của Bạn", new ImageIcon("image\\btnProfile1.png"), panel_1_2_1_1, null);
			
			JPanel panel_5_1_2_1_1 = new JPanel();
			panel_5_1_2_1_1.setLayout(null);
			panel_5_1_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
			txtpnTnTi.setText("Tên đề tài:   Quản lý siêu thị.\r\nHướng dẫn: THS. Nguyễn Thị Hoàng Khánh.\r\nThực hiện:   Huỳnh Quốc Bảo - Nguyễn Văn Sơn.");
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
			
			JButton btnNewButton_1 = new JButton("");
			btnNewButton_1.setToolTipText("Xem thông tin của bạn");
			btnNewButton_1.setIcon(new ImageIcon("image\\btnProfile.png"));
			toolBar.add(btnNewButton_1);
			contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
			
			this.setLocationRelativeTo(null);
		}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (btnDetailOrder.equals(o)) {
			new DetailOrder_gui().setVisible(true);
		} else if (btnDetailItem.equals(o)) {
			new DetailItem_gui().setVisible(true);
		}
	}

}
