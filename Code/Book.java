package BookStoreApp_Fullversion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

public class Book extends BookStore {
	private String id;
	private String category;
	private String isbn;
	private String title;
	private String author;
	private String edition;
	private String describe;
	private String price;
	private String genre;
	private String fileBook = "/Users/pattiyayiadram/Java project/Book-2.csv";
	private String fileFavBook = "/Users/pattiyayiadram/Java project/Favorite Books.csv";


	public Book() {

	}
	
	public Book(String bookName,String price) {
	      this.title = bookName;
	      this.price = price;
	   }

	
	
	public String[][] searchGenreBooks(String keyword) {
		String[][] data = new String[1][5];
		Data customerData = new Data();
		List<String[]> info;
		try {
			info = customerData.parse(fileBook, ",");
			for (String[] book : info) {
				if (book[1].contains(keyword)) {
					data[0][0] = book[3]; // Title
					data[0][1] = book[4]; // Author
					data[0][2] = book[2]; // ISBN
					data[0][3] = book[6]; // Description
					data[0][4] = book[8]; // Genre
					data[0][5] = book[7]; // Price
				} else {
					continue;
				}
//				for (int i = 0; i < data.length; i++) {
//					System.out.print(Arrays.toString(data[i]) + "\n");
//				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
//		System.out.println(data);
		return data;
	}


	// Book use for show textPane (title, author, isbn, edition, describe, genre, price)
	public String[][] searchBooks(String keyword) {
		String[][] data = new String[1][6];
		Data customerData = new Data();
		List<String[]> info;
		try {
			info = customerData.parse(fileBook, ",");
			for (String[] book : info) {
				if (book[1].equals(keyword) ||
					book[2].equals(keyword) ||
					book[3].equals(keyword)) {
					data[0][0] = book[3]; // Title
					data[0][1] = book[4]; // Author
					data[0][2] = book[2]; // ISBN
					data[0][3] = book[6]; // Description
					data[0][4] = book[8]; // Genre
					data[0][5] = book[7]; // Price
					setID(book[0]);
					setCategory(book[1]);
					setISBN(book[2]);
					setTitle(book[3]);
					setAuthor(book[4]);
					setEdition(book[5]);
					setDescribe(book[6]);
					setPrice(book[7]);
					setGenre(book[8]);
				} else {
					continue;
				}

//				for (int i = 0; i < data.length; i++) {
//					System.out.print(Arrays.toString(data[i])+"\n");
//				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}

		return data;
	}
	

	// Book use for show table (title, genre)
	String[][] dataTitleGenre(String filename) {
		List<String[]> elements = new ArrayList<>();
		boolean startReading = false;
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (!startReading) {
					// Skip the first row
					startReading = true;
					continue;
				}
				String[] fields = line.split(",");
				String[] selectedFields = new String[2];
				selectedFields[0] = fields[3]; // title
				selectedFields[1] = fields[1]; // category

				elements.add(selectedFields);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return elements.toArray(new String[0][0]);
	}
	

	public String[][] dataFavorite(String keyword) { // customerID
	    Data customerData = new Data();
	    List<String[]> info;
	    List<String[]> selectedBooks = new ArrayList<>();

	    try {
	        info = customerData.parse(fileFavBook, ",");
	        for (String[] book : info) {
	            if (book[0].contains(keyword)) {
	                String[] selectedFields = new String[2];
	                selectedFields[0] = book[1]; // Title
	                selectedFields[1] = book[2]; // Genre
	                selectedBooks.add(selectedFields);
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	    String[][] data = new String[selectedBooks.size()][2];
	    for (int i = 0; i < selectedBooks.size(); i++) {
	        data[i] = selectedBooks.get(i);
	    }

	    return data;
	}


	// use in Home page
	public void addToWishlist(Book book, Customer customer) {
	    try {
	        FileWriter fw = new FileWriter(fileFavBook, true);
	        BufferedWriter bw = new BufferedWriter(fw);
	        boolean bookExists = false;
	        String[][] data = book.dataFavorite(customer.getID());
	        for (int i=0; i<data.length; i++) {
	            if (book.getTitle().equals(data[i][0])) {
	                bookExists = true;
	                break;
	            }
	        }
	        if (bookExists) {
	            JOptionPane.showMessageDialog(null, "You already have this book in your wish list.");
	        } else {
	            bw.newLine();
	            bw.write(customer.getID() + "," + book.getTitle() + "," + book.getCategory());
	            bw.close();
	            fw.close();
	            JOptionPane.showMessageDialog(null, "Book added to wish list.");
	        }
	    } catch (IOException ex) {
	        System.out.println("Error writing to wishlist.csv: " + ex.getMessage());
	    }
	}

	
	
	// use in Favorite page
	public void deleteFromWishlist(Book book, Customer customer) {
	    try {
	        File inputFile = new File(fileFavBook);
	        File tempFile = new File("temp.csv");
	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String lineToRemove = customer.getID() + "," + book.getTitle() + "," + book.getCategory();
	        String currentLine;

	        while ((currentLine = reader.readLine()) != null) {
	            String trimmedLine = currentLine.trim();
	            if (trimmedLine.equals(lineToRemove)) {
	                continue;
	            }
	            writer.write(currentLine + System.getProperty("line.separator"));
	        }
	        writer.close();
	        reader.close();
	        inputFile.delete();
	        tempFile.renameTo(inputFile);

	        JOptionPane.showMessageDialog(null, "Book removed from wish list.");
	    } catch (IOException ex) {
	        System.out.println("Error deleting from wishlist.csv: " + ex.getMessage());
	    }
	}
	
	
	
	// Setter
	public void setID(String id) {
		this.id = id;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitle(String bookName) {
		this.title = bookName;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	// Getter
	public String getID() {
		return id;
	}
	public String getCategory() {
		return category;
	}

	public String getISBN() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

	public String getEdition() {
		return edition;
	}

	public String getDescribe() {
		return describe;
	}

	public String getPrice() {
		return price;
	}
	
	public String getGenre() {
		return genre;
	}
	
	
	public String getDetails() {
		return "Title : " + getTitle() + "\n" +
			   "Author : " + getAuthor() + "\n" + 
			   "ISBN : " + getISBN() + "\n" +
			   "Edition : " + getEdition() + "\n" +
			   "Description : " + getDescribe() + "\n" +
			   "Price : " + getPrice() + "\n";
			   
			   
	}
	
	public String toString() {
		return getTitle() + " " + getPrice();
	}
}

