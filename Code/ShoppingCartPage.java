package BookStoreApp_Fullversion;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;

import java.awt.event.MouseWheelListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.MouseWheelEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ShoppingCartPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String bookSelected;
	private Book book = new Book();
	private String file = "/Users/pattiyayiadram/Java project/Book-2.csv";

	/**
	 * Create the frame.
	 */
	public ShoppingCartPage(Customer customer) {
		
		// set Frame
		setFont(new Font("Avenir", Font.PLAIN, 16));
		setTitle("Shopping Cart Page");
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
				new HomePage(customer).setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(btnNewButton);
		//
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue); 
		
		JButton btnNewButton_1 = new JButton("Wishlist");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new FavoritePage(customer).setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Customer logout = new Customer();
				new Login(logout).setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(btnNewButton_3);
		
		// set contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// comboBox Genre
		String[] genre = {"All", "Adventure stories", "Classics", "Crime", 
				  "Fairy tales, fables, and folk tales", "Fantasy", "Historical Fiction", "Horror", 
				  "Humour and satire", "Literary fiction", "Mystery", "Poetry", 
				  "Plays", "Romance", "Science fiction", 
				  "Short stories and novellas", "Thrillers", "War", "Women’s fiction", "Young adult fiction", "Autobiography and memoir", "Biography", 
				  "Essays", "Self-help books"};
		
		// set textPane
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Avenir", Font.PLAIN, 16));
		textPane.setBackground(new Color(255, 255, 242));
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		textPane.setText("<html><body><div style='text-align:center;font-family:Avenir;font-size:18pt;'><h1>Your shopping Cart</h1></div></body></html>");
		
		
		
		
		// Table
		JScrollPane scrollPane = new JScrollPane();

		String[][] titleData = new String[customer.getBook().size()][2];
		for (int i = 0; i < customer.getBook().size(); i++) {
		    Book book = customer.getBook().get(i);
		    titleData[i][0] = book.getTitle();  // Set book title
		    titleData[i][1] = book.getPrice();  // Set book price
		}

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
					new String[] {
						"Title","Price"
					}
				));
				//
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (String[] row : titleData) {
			System.out.println(row);
			model.addRow(row);
		}
		
		table.getColumnModel().getColumn(0).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);

		// click selected row then show detail
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int sortedRow = table.getSelectedRow(); 
				int modelRow = table.convertRowIndexToModel(sortedRow); 
				if (modelRow >= 0) { 
					bookSelected = table.getModel().getValueAt(modelRow, 0).toString(); 
					book.searchBooks(bookSelected); 
				
					// show book detail on textPane
					textPane.setText("<html><body style='font-family: Avenir; font-size: 14px;'><div align='center'><b>" + book.getTitle() + 
							"</b></div><br> Author: " + book.getAuthor() + "<br><br> ISBN: "        + book.getISBN() +
							"<br><br> Edition: "      + book.getEdition() + "<br><br> Description: " + book.getDescribe() +
							"<br><br> Genre: "        + book.getGenre() + "<br><br> Price: "       + book.getPrice() + "</html>");
				}			}
		});

		// set sorter to table
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		
		
		
		
		// button Delete
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setBackground(new Color(128, 128, 0));
		buttonDelete.setForeground(new Color(47, 79, 79));
		buttonDelete.setFont(new Font("Avenir", Font.PLAIN, 20));
		buttonDelete.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        System.out.println(bookSelected);
				for (int i = 0; i < customer.getBook().size(); i++) {
				    Book check = customer.getBook().get(i);
				    if (check.getTitle().equals(bookSelected)) {
		                if(customer.deleteFromCart(check)) {
		                    JOptionPane.showMessageDialog(null, "Remove from cart successfully!");
		                    
		                    model.setRowCount(0);
		                    for (Book item : customer.getBook()) {
		                        model.addRow(new Object[]{item.getTitle(), item.getPrice()});
		                    }
		                } else {
		                    JOptionPane.showMessageDialog(null, "Remove from cart unsuccessfully!");
		                }
		            }
		        }
		    }
		});

	
		
		
		// button Purchase
		JButton buttonPurchase = new JButton("Purchase");
		buttonPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPurchase.setForeground(new Color(47, 79, 79));
		buttonPurchase.setBackground(new Color(128, 128, 0));
		buttonPurchase.setFont(new Font("Avenir", Font.PLAIN, 20));
		buttonPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customer.setTotal(0);
				for (int i = 0; i < customer.getBook().size(); i++) {
				     Book check = customer.getBook().get(i);
				     String bookPrice = check.getPrice();
				     bookPrice = bookPrice.replace("$", "");
				     float price = Float.parseFloat(bookPrice);
				     customer.makePurchase(price);
				     }
				
				//System.out.print(customer.getTotal());
				dispose();
				new Payment(customer).setVisible(true);
			}
		});
		
		
		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(196)
					.addComponent(buttonPurchase, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(320)
					.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonPurchase, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
		pack();
		
	}
}