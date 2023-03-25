package BookStoreApp_Fullversion;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.awt.Label;
import javax.swing.JDesktopPane;
import java.awt.Window.Type;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */ 
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Customer customer = new Customer();
//					Login frame = new Login(customer);
//					frame.setVisible(true);
//				} catch (Exception e) {
//				e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Login(Customer customer) {
		// set Frame
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/pattiyayiadram/Downloads/book.png"));
		setForeground(new Color(153, 153, 153));
		setBackground(new Color(51, 102, 153));
		setFont(new Font("Hoefler Text", Font.PLAIN, 20));
		setTitle("BookStore");
		setBounds(100, 100, 1050, 750);
		
		// set contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// Email
		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(402, 188, 86, 35);
		labelEmail.setForeground(new Color(192, 192, 192));
		labelEmail.setHorizontalAlignment(SwingConstants.LEFT);
		labelEmail.setFont(new Font("Avenir", Font.PLAIN, 25));
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(402, 249, 303, 31);
		textFieldEmail.setForeground(new Color(0, 0, 0));
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
		
		
		// Password
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setBounds(402, 339, 105, 35);
		labelPassword.setFont(new Font("Avenir", Font.PLAIN, 25));
		labelPassword.setForeground(new Color(192, 192, 192));
		passwordField = new JPasswordField();
		passwordField.setBounds(402, 392, 303, 32);
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
		
		
		// button Login
		JButton buttonLogin = new JButton("Login");
		buttonLogin.setBounds(422, 505, 107, 43);
		buttonLogin.setForeground(new Color(47, 79, 79));
		buttonLogin.setBackground(UIManager.getColor("Button.disabledText"));
		buttonLogin.setFont(new Font("Avenir", Font.PLAIN, 25));
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String emailText = textFieldEmail.getText();
			     String passwordText = passwordField.getText();
			        if (emailText.isEmpty() || passwordText.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Please enter both email and password.");
			            return;
			        }
			        try {
			            boolean success = customer.login(emailText, passwordText);
			            if (success) {
			                dispose();
			                new HomePage(customer).setVisible(true);
			            } else {
			                JOptionPane.showMessageDialog(null, "Invalid email or password. Please try again.");
			            }
			        } catch (FileNotFoundException e1) {
			            System.out.println("Error!");
			            e1.printStackTrace();
			        }
			}
		});
		
		
		// button Sign up
		JButton buttonSignup = new JButton("Signup");
		buttonSignup.setBounds(583, 505, 122, 43);
		buttonSignup.setBackground(UIManager.getColor("Button.disabledText"));
		buttonSignup.setForeground(new Color(47, 79, 79));
		buttonSignup.setFont(new Font("Avenir", Font.PLAIN, 25));
		buttonSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Signup(customer).setVisible(true);
			}
		});
		contentPane.setLayout(null);
		
		// set TextPane
		JTextPane txtpnHeader = new JTextPane();
		txtpnHeader.setBounds(303, 52, 481, 62);
		txtpnHeader.setFont(new Font("Avenir", Font.PLAIN, 45));
		txtpnHeader.setEditable(false);
		txtpnHeader.setForeground(new Color(230, 221, 196));
		txtpnHeader.setBackground(new Color(0, 0, 51));
		txtpnHeader.setText("Welcome To BookStore");
		contentPane.add(txtpnHeader);
		contentPane.add(labelEmail);
		contentPane.add(textFieldEmail);
		contentPane.add(labelPassword);
		contentPane.add(passwordField);
		contentPane.add(buttonLogin);
		contentPane.add(buttonSignup);
	}


}