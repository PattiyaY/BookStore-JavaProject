package BookStoreApp_Fullversion;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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

public class BillPage extends JFrame {

	private JPanel contentPane;
	private String discount;
	private String total;
	private String tax;
	private String newRewardPoint;

	/**
	 * Create the frame.
	 * 
	 */
	public BillPage(Customer customer) {
		
		// set Frame
		setFont(new Font("Avenir", Font.PLAIN, 16));
		setTitle("Home Page");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		
		// set contentPanel
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		// textPane show bill
		Date dd = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy - MMMM - dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		String dateD = date.format(dd);
		String timeT = time.format(dd);

		//
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Avenir", Font.PLAIN, 13));
		textPane.setBounds(299, 70, 427, 504);
		textPane.setBackground(new Color(255, 255, 255));
		textPane.setEditable(false);
		textPane.setText("\n\t\t           Book Store\n");
		textPane.setText(textPane.getText() + "\t             Suvarnabhumi Campus. 88 Moo 8\n");
		textPane.setText(textPane.getText() + "\t          Bang Na-Trad Km. 26, Bang Sao Thong,\n");
		textPane.setText(textPane.getText() + "\t               Samut Prakan Thailand 10570\n");
		textPane.setText(textPane.getText() + "   ----------------------------------------------------------------------------------------------------\n");
		textPane.setText(textPane.getText() + "   Items\t\t\tQty\t\tPrice\n");
		textPane.setText(textPane.getText() + "   ----------------------------------------------------------------------------------------------------\n");
		for (Book item : customer.getBook()) {
		    String itemName = item.getTitle();
		    String itemPrice = item.getPrice();
		    textPane.setText(textPane.getText() + String.format(" %1$-30s%2$-20s%3$10s\n", itemName, "1", itemPrice));

		}
		this.discount = String.format("%.2f", customer.getDiscount());
		this.total = String.format("%.2f", customer.getBillTotal());
		this.tax = String.format("%.2f", customer.getTax());
		this.newRewardPoint = customer.getNewRewardPoint(customer.getTotal());
		try {
			((BookStore)customer).updateRewardPoint(customer.getID(), newRewardPoint);
		} catch (IOException e1) {
			System.out.println("Update unsuccessful!");
			e1.printStackTrace();
		}
		textPane.setText(textPane.getText()
		    + "   ----------------------------------------------------------------------------------------------------\n"
		    + "   Discount :\t\t\t\t" + "$" + discount +"\n"
		    + "   Total :\t\t\t\t" + "$" + total + "\n"
			+ "   incl. VAT 7%\t\t\t" + "$" +tax + "\n"
			+ "   Reward Points :\t\t\t" + newRewardPoint + "\n"
			+ "   ----------------------------------------------------------------------------------------------------\n"
			+ "   Date : " + dateD + "\t\tTime : " + timeT + "\n"
			+ "   **************************************************************************************\n"
			+ "\t\tHave A Nice Day :)\n"
			+ "   **************************************************************************************");
		contentPane.setLayout(null);
		
		
		// button Done
		JButton buttonDone = new JButton("Done");
		buttonDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer.getBook().clear();
				dispose();
				new HomePage(customer).setVisible(true);
			}
		});
		buttonDone.setBounds(429, 586, 188, 37);
		buttonDone.setBackground(new Color(128, 128, 0));
		buttonDone.setForeground(new Color(47, 79, 79));
		buttonDone.setFont(new Font("Avenir", Font.PLAIN, 20));
		contentPane.add(buttonDone);
		contentPane.add(textPane);
		
	}
}
