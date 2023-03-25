package BookStoreApp_Fullversion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccountPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField newPassword;

	/**
	 * Create the frame.
	 */
	public AccountPage(Customer customer) {
		setFont(new Font("Avenir", Font.PLAIN, 16));
		setTitle("Account Page");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		//System.out.println(((Customer)customer).toString());

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new HomePage(customer).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(btnNewButton);
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Customer customer = new Customer();
				new Login(customer).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(btnNewButton_1);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		ImageIcon iconUser = new ImageIcon("\\Users\\ASUS\\eclipse-workspace\\BookStore\\src\\BookStoreApp\\user (1).png");
		
		ImageIcon iconLibrary = new ImageIcon("\\Users\\ASUS\\eclipse-workspace\\BookStore\\src\\BookStoreApp\\Library.png");
		Image imgLibrary = iconLibrary.getImage();
		Image scaledImg = imgLibrary.getScaledInstance(200, 600, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		JLabel lblNewLabel_7 = new JLabel(scaledIcon);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1057, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel address = new JLabel("Address");
		address.setForeground(new Color(47, 79, 79));
		address.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		JLabel password = new JLabel("Password");
		password.setForeground(new Color(47, 79, 79));
		password.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		JLabel email = new JLabel("Email");
		email.setForeground(new Color(47, 79, 79));
		email.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setForeground(new Color(0, 0, 64));
		lblNewLabel.setFont(new Font("Avenir", Font.PLAIN, 30));
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Avenir", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		
		JTextArea newFirstName = new JTextArea();
		newFirstName.setText(((Customer)customer).getName());
		newFirstName.setFont(new Font("Avenir", Font.PLAIN, 16));
		newFirstName.setBackground(new Color(240, 240, 255));
		
		JTextArea newLastName = new JTextArea();
		newLastName.setText(((Customer)customer).getLastName());
		newLastName.setFont(new Font("Avenir", Font.PLAIN, 16));
		newLastName.setBackground(new Color(240, 240, 255));
		
		JTextArea newEmail = new JTextArea();
		newEmail.setText(((Customer)customer).getEmail());
		newEmail.setFont(new Font("Avenir", Font.PLAIN, 16));
		newEmail.setBackground(new Color(240, 240, 255));
		
		JTextArea newAddress = new JTextArea();
		newAddress.setText(((Customer)customer).getAddress());
		newAddress.setFont(new Font("Avenir", Font.PLAIN, 16));
		newAddress.setBackground(new Color(240, 240, 255));
		
		newPassword = new JPasswordField();
		
		newPassword.setFont(new Font("Avenir", Font.PLAIN, 16));
		newPassword.setBackground(new Color(240, 240, 255));
		newPassword.setText(((Customer)customer).getPassword());
		JLabel phoneNumber = new JLabel("Phone number");
		phoneNumber.setForeground(new Color(47, 79, 79));
		phoneNumber.setFont(new Font("Avenir", Font.PLAIN, 20));
		
		JTextArea newPhoneNumber = new JTextArea();
		newPhoneNumber.setText(((Customer)customer).getPhoneNumber());
		newPhoneNumber.setFont(new Font("Avenir", Font.PLAIN, 16));
		newPhoneNumber.setBackground(new Color(240, 240, 255));
		
		JButton btnNewButton_3 = new JButton("UPDATE");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(((Customer) customer).getID());
				System.out.println(((Customer) customer).getName());
				boolean check = ((Customer) customer).updateInformation(((Customer) customer).getID(), newFirstName.getText(), newLastName.getText(), newEmail.getText(), newPassword.getText(), newAddress.getText(), newPhoneNumber.getText());
				if(check) {
					JOptionPane.showMessageDialog(null, "Changed update!");
				} else {
					JOptionPane.showMessageDialog(null, "Change unsucessfully!");
				}
			}
			});

		btnNewButton_3.setFont(new Font("Avenir", Font.PLAIN, 20));
		btnNewButton_3.setBackground(new Color(0, 0, 128));
		btnNewButton_3.setForeground(new Color(47, 79, 79));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(474)
					.addComponent(lblNewLabel)
					.addContainerGap(498, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(467)
					.addComponent(btnNewButton_3)
					.addContainerGap(469, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(305, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(email, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
										.addComponent(password)
										.addComponent(phoneNumber, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addComponent(address))
									.addGap(68))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(newFirstName, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(newLastName, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(322)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(newAddress, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPhoneNumber, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addComponent(newEmail, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(351, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(newLastName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(newFirstName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(email)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(newEmail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(password)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(phoneNumber, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newPhoneNumber, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(address)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newAddress, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnNewButton_3)
					.addGap(82))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
