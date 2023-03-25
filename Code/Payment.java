package BookStoreApp_Fullversion;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCardnumber;
	private JTextField textFieldNameOwner;
	private JPasswordField passwordField;
	private JTextField textFieldPoint;
	private float discountData;

	/**
	 * Create the frame.
	 */
	public Payment(Customer customer) {
		
		// set Frame
		setFont(new Font("Avenir", Font.PLAIN, 16));
		setTitle("Payment");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		
		// menuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new ShoppingCartPage(customer).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Avenir", Font.PLAIN, 18));
		menuBar.add(btnNewButton);
		//
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Login(new Customer()).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Avenir", Font.PLAIN, 18));
		menuBar.add(btnNewButton_1);
		
		// set contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon iconLibrary1 = new ImageIcon("\\Users\\ASUS\\eclipse-workspace\\BookStore\\src\\BookStoreApp\\credit.png");
		Image imgLibrary1 = iconLibrary1.getImage();
		Image scaledImg1 = imgLibrary1.getScaledInstance(300, 50, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);
		
		JLabel labelImage = new JLabel(scaledIcon1);
		labelImage.setBounds(504, 206, -1, -1);
		labelImage.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		// Header
		JLabel labelHeader = new JLabel("Book Store");
		labelHeader.setBounds(446, 57, 202, 48);
		labelHeader.setFont(new Font("Avenir", Font.PLAIN, 35));

		// Card Number
		JLabel labelCardnumber = new JLabel("Card Number");
		labelCardnumber.setBounds(366, 217, 133, 28);
		labelCardnumber.setForeground(new Color(0, 0, 0));
		labelCardnumber.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldCardnumber = new JTextField();
		textFieldCardnumber.setBounds(403, 257, 331, 38);
		textFieldCardnumber.setFont(new Font("Avenir", Font.PLAIN, 18));
		textFieldCardnumber.setColumns(10);
		
		// Name of cardholder
		JLabel labelNameOwner = new JLabel("Name of cardholder");
		labelNameOwner.setBounds(366, 313, 193, 28);
		labelNameOwner.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelNameOwner.setForeground(new Color(0, 0, 0));
		textFieldNameOwner = new JTextField();
		textFieldNameOwner.setBounds(411, 353, 323, 38);
		textFieldNameOwner.setFont(new Font("Avenir", Font.PLAIN, 18));
		textFieldNameOwner.setColumns(10);
		
		// Expiry Date
		JLabel labelExpiryDate = new JLabel("Expired date");
		labelExpiryDate.setBounds(362, 403, 122, 28);
		labelExpiryDate.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelExpiryDate.setForeground(new Color(0, 0, 0));
		
		String[] n1 = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		JComboBox comboBox = new JComboBox(n1);
		comboBox.setBounds(372, 442, 73, 30);
		comboBox.setFont(new Font("Avenir", Font.PLAIN, 18));
		
		String[] n2 = {"23","24","25","26","27","28","29","30"};
		JComboBox comboBox_1 = new JComboBox(n2);
		comboBox_1.setBounds(446, 442, 78, 30);
		comboBox_1.setFont(new Font("Avenir", Font.PLAIN, 18));
		
		// Security Code
		JLabel labelSecurityCode = new JLabel("Security code");
		labelSecurityCode.setBounds(596, 403, 131, 28);
		labelSecurityCode.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelSecurityCode.setForeground(new Color(0, 0, 0));
		passwordField = new JPasswordField();
		passwordField.setBounds(596, 437, 131, 38);
		passwordField.setFont(new Font("Avenir", Font.PLAIN, 18));
		
		//Point
		JLabel lblNewLabel_2 = new JLabel("Point");
		lblNewLabel_2.setFont(new Font("Avenir", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(362, 507, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		textFieldPoint = new JTextField();
		textFieldPoint.setFont(new Font("Avenir", Font.PLAIN, 18));
		textFieldPoint.setBounds(392, 537, 130, 30);
		contentPane.add(textFieldPoint);
		textFieldPoint.setColumns(10);
		
		// button Payment
		JButton buttonPayment = new JButton("Submit payment");
		buttonPayment.setBounds(391, 593, 343, 36);
		buttonPayment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float point = Integer.parseInt(textFieldPoint.getText());
				float checkPoint = Integer.parseInt(customer.getRewardPoint());
				boolean payment = customer.payment(textFieldCardnumber.getText(), passwordField.getText());
				if(point <= checkPoint && point > 0) {
					discountData = customer.calDiscount(textFieldPoint.getText());
					customer.setDiscount(discountData);
					if(payment) {
						JOptionPane.showMessageDialog(null, "Payment Successfully!");
						dispose();
						new BillPage(customer).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Payment unsuccessfully!");
					}
				} else if(point == 0){
					discountData = customer.calDiscount(textFieldPoint.getText());
					customer.setDiscount(discountData);
					if(payment) {
						JOptionPane.showMessageDialog(null, "Payment Successfully!");
						dispose();
						new BillPage(customer).setVisible(true);
				}
				
				} else {
					JOptionPane.showMessageDialog(null, "Payment unsuccessfully!");
					}

			}
		});
		buttonPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPayment.setForeground(new Color(0, 0, 0));
		buttonPayment.setBackground(new Color(0, 0, 128));
		buttonPayment.setFont(new Font("Avenir", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(labelExpiryDate);
		contentPane.add(comboBox);
		contentPane.add(comboBox_1);
		contentPane.add(passwordField);
		contentPane.add(labelSecurityCode);
		contentPane.add(labelImage);
		contentPane.add(textFieldNameOwner);
		contentPane.add(buttonPayment);
		contentPane.add(textFieldCardnumber);
		contentPane.add(labelNameOwner);
		contentPane.add(labelCardnumber);
		contentPane.add(labelHeader);
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String price = df.format(customer.getTotal());
	
		//Total
		JLabel lblNewLabel = new JLabel("Total : $" + price );
		lblNewLabel.setBounds(372, 151, 150, 28);
		lblNewLabel.setFont(new Font("Avenir", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
				
		JLabel lblYourRewardPoint = new JLabel("Your reward point  : " + customer.getRewardPoint());
		lblYourRewardPoint.setBounds(540, 151, 286, 28);
		lblYourRewardPoint.setFont(new Font("Avenir", Font.PLAIN, 20));
		contentPane.add(lblYourRewardPoint);
				
		JLabel lblNewLabel_1 = new JLabel("( Every 100 points get $0.29 discount. )");
		lblNewLabel_1.setFont(new Font("Avenir", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(422, 509, 250, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Have no reward points or don't use now : type 0");
		lblNewLabel_1_1.setFont(new Font("Avenir", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(392, 568, 363, 16);
		contentPane.add(lblNewLabel_1_1);
	}
}
