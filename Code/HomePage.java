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

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.awt.event.MouseWheelEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.*;
public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField textSearch;
	private JTable table;
	private Book book = new Book();
	public String bookSelected;
	private String fileBook = "/Users/pattiyayiadram/Java project/Book-2.csv";

	/**
	 * Create the frame.
	 */
	public HomePage(Customer customer) {
		// set Frame
		setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		setTitle("Home Page");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		
		
		// menuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		//
		// button Account
		JButton buttonAccount = new JButton("Account");
		buttonAccount.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(buttonAccount);
		buttonAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AccountPage(customer).setVisible(true);
			}
		});
		
		//
        setJMenuBar(menuBar);
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue); 
		//
		// button Wish List
		JButton buttonWishList = new JButton("Wishlist");
		buttonWishList.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(buttonWishList);
		buttonWishList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new FavoritePage(customer).setVisible(true);
			}
		});
		//
		// button Cart
		JButton buttonCart = new JButton("Shopping Cart");
		buttonCart.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(buttonCart);
		buttonCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new ShoppingCartPage(customer).setVisible(true);
			}
		});
		//
		// button Logout
		JButton buttonLogout = new JButton("Logout");
		buttonLogout.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(buttonLogout);
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Customer customer = new Customer();
				new Login(customer).setVisible(true);
			}
		});
		
		
		// set contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		// Search
		JLabel labelSearch = new JLabel("Search");
		labelSearch.setBounds(11, 34, 48, 22);
		labelSearch.setForeground(new Color(255, 255, 255));
		labelSearch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearch.setFont(new Font("Avenir", Font.PLAIN, 16));
		textSearch = new JTextField();
		textSearch.setBounds(81, 29, 255, 32);
		textSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textSearch.setFont(new Font("Avenir", Font.PLAIN, 16));
		textSearch.setColumns(10);
		
		
		// comboBox Genre
		String[] genre = {"All", "Adventure stories", "Classics", "Crime", 
				  "Fairy tales | fables | folk tales", "Fantasy", "Historical Fiction", "Horror", 
				  "Humour and satire", "Literary fiction", "Mystery", "Poetry", 
				  "Plays", "Romance", "Science fiction", "Short stories and novellas", 
				  "Thrillers", "War", "Women's fiction", "Young adult fiction", 
				  "Autobiography and memoir", "Biography", 
				  "Essays", "Self-help books"};

		JComboBox comboBoxGenre = new JComboBox(genre);
		comboBoxGenre.setBounds(348, 34, 233, 27);
		comboBoxGenre.setFont(new Font("Avenir", Font.PLAIN, 14));
		
		
		// scrollPane (table)
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 89, 577, 559);
		
		
		// textPane (show book details)
	    JTextPane textPane = new JTextPane();
	    textPane.setBounds(617, 89, 427, 504);
		textPane.setForeground(new Color(105, 105, 105));
		textPane.setFont(new Font("Avenir", Font.PLAIN, 16));
		textPane.setBackground(new Color(255, 255, 242));
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		textPane.setText("<html><body><div style='text-align:center;font-family:Avenir;font-size:16pt;'><h1>Welcome to Book Store</h1></div></body></html>");
		
		
		
		
		
		// table
		String[][] titleData = book.dataTitleGenre(fileBook);
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Avenir", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book List", "Genre"
			}
		));
		//
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (String[] row : titleData) {
		    model.addRow(row);
		}
		//
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		scrollPane.setViewportView(table);
		//
		// table (mouse click row then show book detail)
		table.addMouseListener(new MouseAdapter() { // click on selected row then show book detail
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
				}
		     }
		});
		//
		// table search
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);
		//
		textSearch.addKeyListener(new KeyAdapter() {
		    public void keyReleased(KeyEvent e) {
		        String text = textSearch.getText();
		        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
		    }
		});
		//
		comboBoxGenre.addActionListener(e -> {
		    String selectedValue = (String) comboBoxGenre.getSelectedItem();
		    if (selectedValue.equals("All")) {
		        sorter.setRowFilter(null);
		    } else {
		        sorter.setRowFilter(RowFilter.regexFilter(selectedValue));
		    }
		});
		


		// button AddWishList
		JButton buttonAddWishList = new JButton("Add to wish list");
		buttonAddWishList.setBounds(626, 611, 188, 37);
		buttonAddWishList.setBackground(new Color(128, 128, 0));
		buttonAddWishList.setForeground(new Color(51, 102, 102));
		buttonAddWishList.setFont(new Font("Avenir", Font.PLAIN, 16));
		buttonAddWishList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book.addToWishlist(book, customer);
			}
		});
		
		
		
		// button Add Cart
		JButton buttonAddCart = new JButton("Add to Cart");
		buttonAddCart.setBounds(838, 611, 185, 37);
		buttonAddCart.setForeground(new Color(51, 102, 102));
		buttonAddCart.setFont(new Font("Avenir", Font.PLAIN, 16));
		buttonAddCart.setBackground(new Color(128, 128, 0));
		buttonAddCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(bookSelected);
				book.searchBooks(bookSelected);
				String bookName = book.getTitle();
				String price = book.getPrice();
				Book book = new Book(bookName,price);
				if(customer.addToCart(book)) {
					JOptionPane.showMessageDialog(null, "Add to cart successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Add to cart unsuccessfully!");
				}
				System.out.println(book.getDetails());

			}
		});
		contentPane.setLayout(null);
		contentPane.add(labelSearch);
		contentPane.add(textSearch);
		contentPane.add(comboBoxGenre);
		contentPane.add(scrollPane);
		contentPane.add(textPane);
		contentPane.add(buttonAddWishList);
		contentPane.add(buttonAddCart);
		
		
		
	}

}