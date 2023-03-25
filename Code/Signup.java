package BookStoreApp_Fullversion;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JPasswordField passwordField;
	private Customer login = new Customer();

	/**
	 * Create the frame.
	 */
	public Signup(BookStore customer) {
		
		// set Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		ImageIcon imageIcon = new ImageIcon("/Users/pattiyayiadram/Java project/bookstore.jpg");

		
		JLabel labelHeader = new JLabel("Sign Up");
		labelHeader.setBounds(523, 41, 127, 33);
		labelHeader.setForeground(new Color(255, 255, 255));
		labelHeader.setFont(new Font("Avenir", Font.PLAIN, 24));
		
		// Name
		JLabel labelName = new JLabel("Name");
		labelName.setBounds(354, 126, 74, 28);
		labelName.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelName.setForeground(new Color(192, 192, 192));
		textFieldName = new JTextField();
		textFieldName.setBounds(354, 160, 211, 36);
		textFieldName.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldName.setColumns(10);
		
		JLabel watermarkName = new JLabel("Type your name");
		watermarkName.setFont(new Font("Avenir", Font.PLAIN, 20));
		watermarkName.setForeground(Color.LIGHT_GRAY);
		textFieldName.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		textFieldName.add(watermarkName);
		textFieldName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	watermarkName.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldName.getText().isEmpty()) {
                	watermarkName.setVisible(true);
                }
            }
        });
		
		// Last Name
		JLabel labelLastName = new JLabel("Last Name");
		labelLastName.setBounds(595, 126, 127, 28);
		labelLastName.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelLastName.setForeground(new Color(192, 192, 192));
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(595, 160, 211, 36);
		textFieldLastName.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldLastName.setColumns(10);
		
		JLabel watermarkLastName = new JLabel("Type your last name");
		watermarkLastName.setFont(new Font("Avenir", Font.PLAIN, 20));
		watermarkLastName.setForeground(Color.LIGHT_GRAY);
		textFieldLastName.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		textFieldLastName.add(watermarkLastName);
		textFieldLastName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	watermarkLastName.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldLastName.getText().isEmpty()) {
                	watermarkLastName.setVisible(true);
                }
            }
        });
		
		//Email
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(354, 218, 74, 28);
		labelEmail.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelEmail.setForeground(new Color(192, 192, 192));
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(354, 252, 452, 36);
		textFieldEmail.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		
		JLabel watermarkEmail = new JLabel("Type your email");
		watermarkEmail.setFont(new Font("Avenir", Font.PLAIN, 20));
        watermarkEmail.setForeground(Color.LIGHT_GRAY);
        textFieldEmail.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        textFieldEmail.add(watermarkEmail);
        textFieldEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                watermarkEmail.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldEmail.getText().isEmpty()) {
                    watermarkEmail.setVisible(true);
                }
            }
        });
		
		//Password
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(354, 311, 110, 28);
		labelPassword.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelPassword.setForeground(new Color(192, 192, 192));
		passwordField = new JPasswordField();
		passwordField.setBounds(354, 345, 452, 37);
		passwordField.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		JLabel watermarkPassword = new JLabel("Type your password");
		watermarkPassword.setFont(new Font("Avenir", Font.PLAIN, 20));
		watermarkPassword.setForeground(Color.LIGHT_GRAY);
		passwordField.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		passwordField.add(watermarkPassword);
		passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	watermarkPassword.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                	watermarkPassword.setVisible(true);
                }
            }
        });
		
		//Phone Number
		JLabel labelPhoneNumber = new JLabel("Phone Number");
		labelPhoneNumber.setBounds(354, 411, 136, 28);
		labelPhoneNumber.setForeground(new Color(192, 192, 192));
		labelPhoneNumber.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(354, 445, 452, 37);
		textFieldPhoneNumber.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldPhoneNumber.setColumns(10);
		
		JLabel watermarkPhoneNumber = new JLabel("Type your phone number");
		watermarkPhoneNumber.setFont(new Font("Avenir", Font.PLAIN, 20));
		watermarkPhoneNumber.setForeground(Color.LIGHT_GRAY);
		textFieldPhoneNumber.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		textFieldPhoneNumber.add(watermarkPhoneNumber);
		textFieldPhoneNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	watermarkPhoneNumber.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldPhoneNumber.getText().isEmpty()) {
                	watermarkPhoneNumber.setVisible(true);
                }
            }
        });
		
		//Address
		JLabel labelAddress = new JLabel("Address");
		labelAddress.setBounds(354, 509, 144, 28);
		labelAddress.setFont(new Font("Avenir", Font.PLAIN, 20));
		labelAddress.setForeground(new Color(192, 192, 192));
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(354, 543, 452, 79);
		textFieldAddress.setFont(new Font("Avenir", Font.PLAIN, 20));
		textFieldAddress.setColumns(10);
		
		JLabel watermarkAddress = new JLabel("Type your address");
		watermarkAddress.setFont(new Font("Avenir", Font.PLAIN, 20));
		watermarkAddress.setForeground(Color.LIGHT_GRAY);
		textFieldAddress.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		textFieldAddress.add(watermarkAddress);
		textFieldAddress.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            	watermarkAddress.setVisible(false);
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textFieldAddress.getText().isEmpty()) {
                	watermarkPassword.setVisible(true);
                }
            }
        });
		
		// CreateAccount
		JButton buttonCreateAccount = new JButton("Create Account");
		buttonCreateAccount.setBounds(509, 640, 154, 30);
		buttonCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean signup;
				try {
					signup = customer.addCustomer(textFieldName.getText(), textFieldLastName.getText(), textFieldEmail.getText(), 
							passwordField.getText(), textFieldAddress.getText(), textFieldPhoneNumber.getText());
					if(signup) {
						JOptionPane.showMessageDialog(null, "Signup Successful!");
						dispose();
						new Login(login).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Please fill in the empty blank!");
					}
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "Signup unsuccessful!");
					e2.printStackTrace();
				}
			}
		});
		buttonCreateAccount.setForeground(new Color(47, 79, 79));
		buttonCreateAccount.setBackground(new Color(128, 128, 0));
		buttonCreateAccount.setFont(new Font("Avenir", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(11, 11, 82, 33);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer customer = new Customer();
				dispose();
				new Login(customer).setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Avenir", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		contentPane.add(textFieldAddress);
		contentPane.add(labelAddress);
		contentPane.add(labelHeader);
		contentPane.add(labelName);
		contentPane.add(labelLastName);
		contentPane.add(textFieldName);
		contentPane.add(textFieldLastName);
		contentPane.add(labelEmail);
		contentPane.add(textFieldEmail);
		contentPane.add(labelPassword);
		contentPane.add(passwordField);
		contentPane.add(labelPhoneNumber);
		contentPane.add(textFieldPhoneNumber);
		contentPane.add(buttonCreateAccount);
	}
	}
