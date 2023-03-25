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
import java.awt.event.MouseWheelEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FavoritePage extends JFrame {

	private JPanel contentPane;
	private JTextField textSearch;
	private JTable table;
	private String bookSelected;
	private Book bookSearch = new Book();
	private Customer logout = new Customer();

	/**
	 * Create the frame.
	 */
	public FavoritePage(Customer customer) {

		// set Frame
		setFont(new Font("Avenir", Font.PLAIN, 16));
		setTitle("Wish Lish Page");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 750);
		
		// menuBar
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		//
		// button Back
		JButton buttonBack = new JButton("Back");
		buttonBack.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(buttonBack);
		buttonBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new HomePage(customer).setVisible(true);
			}
		});
		//
		Component horizontalGlue = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue); 
		//
		// button Shopping Cart
		JButton buttonShoppingCart = new JButton("Shopping Cart");
		buttonShoppingCart.setFont(new Font("Avenir", Font.PLAIN, 16));
		menuBar.add(buttonShoppingCart);
		buttonShoppingCart.addMouseListener(new MouseAdapter() {
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
		buttonLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Login(logout).setVisible(true);
			}
		});
		
		// set contentPane
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// search
		JLabel labelSearch = new JLabel("Search");
		labelSearch.setForeground(new Color(255, 255, 255));
		labelSearch.setHorizontalAlignment(SwingConstants.CENTER);
		labelSearch.setFont(new Font("Avenir", Font.PLAIN, 16));
		
		textSearch = new JTextField();
		textSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textSearch.setFont(new Font("Avenir", Font.PLAIN, 14));
		textSearch.setColumns(10);
		
		// comboBox Genre
		String[] genre = {"All", "Adventure stories", "Classics", "Crime", 
				  "Fairy tales, fables, and folk tales", "Fantasy", "Historical Fiction", "Horror", 
				  "Humour and satire", "Literary fiction", "Mystery", "Poetry", 
				  "Plays", "Romance", "Science fiction", 
				  "Short stories and novellas", "Thrillers", "War", "Women’s fiction", "Young adult fiction", "Autobiography and memoir", "Biography", 
				  "Essays", "Self-help books"};

		JComboBox comboBoxGenre = new JComboBox(genre);
		comboBoxGenre.setFont(new Font("Avenir", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		// set textPane
		JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(255, 255, 242));
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		textPane.setText("<html><body><div style='text-align:center;font-family:Avenir;font-size:16pt;'><h1>Your wish list</h1></div></body></html>");
		
		
		
		
		
		
		// table ((Customer)customer).getID()
		String[][] titleData = bookSearch.dataFavorite(customer.getID());
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Wish List", "Genre"
			}
		));
		//
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (String[] row : titleData) {
		    model.addRow(row);
		}
		//
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		
		
		// click selected row then show detail
		table.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	int sortedRow = table.getSelectedRow(); 
				int modelRow = table.convertRowIndexToModel(sortedRow); 
				if (modelRow >= 0) { 
					bookSelected = table.getModel().getValueAt(modelRow, 0).toString(); 
					bookSearch.searchBooks(bookSelected); 
				
					// show book detail on textPane
					textPane.setText("<html><body style='font-family: Avenir; font-size: 14px;'><div align='center'><b>" + bookSearch.getTitle() + 
							"</b></div><br> Author: " + bookSearch.getAuthor() + "<br><br> ISBN: "        + bookSearch.getISBN() +
							"<br><br> Edition: "      + bookSearch.getEdition() + "<br><br> Description: " + bookSearch.getDescribe() +
							"<br><br> Genre: "        + bookSearch.getGenre() + "<br><br> Price: "       + bookSearch.getPrice() + "</html>");
				}
		    }
		});
		
		// table set sorter
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
		
		
		
		// button Delete from Wish List
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.setBackground(new Color(128, 128, 0));
		buttonDelete.setForeground(new Color(47, 79, 79));
		buttonDelete.setFont(new Font("Avenir", Font.PLAIN, 20));
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearch.deleteFromWishlist(bookSearch, customer); //((Customer)customer)
			}
		});
		
		
		
		// button add to Cart
		JButton buttonCart = new JButton("Add to Cart");
		buttonCart.setForeground(new Color(47, 79, 79));
		buttonCart.setBackground(new Color(128, 128, 0));
		buttonCart.setFont(new Font("Avenir", Font.PLAIN, 20));
		buttonCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(bookSelected);
				bookSearch.searchBooks(bookSelected);
				String bookName = bookSearch.getTitle();
				String price = bookSearch.getPrice();
				Book book = new Book(bookName,price);
				if(customer.addToCart(book)) {
					JOptionPane.showMessageDialog(null, "Add to cart successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Add to cart unsuccessfully!");
				}
				System.out.println(bookSearch.getDetails());

			}
		});
		
		
		
		
		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(labelSearch)
							.addGap(18)
							.addComponent(textSearch, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxGenre, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonCart, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)))
					.addGap(14))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(labelSearch))
						.addComponent(comboBoxGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(buttonCart, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
