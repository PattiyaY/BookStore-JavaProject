package BookStoreApp_Fullversion;

import com.opencsv.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Customer extends BookStore{
	private String id;
	private String name;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String phoneNumber;
	private String rewardPoint;
	private boolean isLogin;
	private float total = 0;
	private float tax = 0;
	private float discount;
	private List<Book> bookCart = new ArrayList<Book>();
	
	
	Customer(){
		
	}

	public boolean addToCart(Book e) {
	      bookCart.add(e);
	      return true;
	   }
	
	public boolean deleteFromCart(Book e) {
	      bookCart.remove(e);
	      return true;
	   }
	
	public List<Book> getBook(){
		return bookCart;
	}
	
	public boolean updateInformation(String id, String newFirstName, String newLastName, String newEmail, String newPassword, String newAddress, String newPhoneNumber) {
	    String file = "/Users/pattiyayiadram/Java project/BookStore - Customer1.csv";
	    boolean changed = false;
	

	    try {
	        String[] oldData = {id ,name ,lastName ,email ,password ,address ,phoneNumber ,rewardPoint};
	        String[] newData = {id ,newFirstName ,newLastName ,newEmail ,newPassword ,newAddress ,newPhoneNumber, rewardPoint};
	        
	        CSVReader reader = new CSVReader(new FileReader(file));
	        List<String[]> data = reader.readAll();
	        reader.close();

	        for (int i = 0; i < data.size(); i++) {
	            if (Arrays.equals(data.get(i), oldData)) {
	                data.set(i, newData);
	                changed = true;
	                setID(id);
					setName(newFirstName);
					setLastName(newLastName);
					setEmail(newEmail);
					setPassword(newPassword);
					setAddress(newAddress);
					setPhoneNumber(newPhoneNumber);
					setRewardPoint(rewardPoint);
	                break;
	            }
	        }
	        
	        CSVWriter writer = new CSVWriter(new FileWriter(file));
	        writer.writeAll(data);
	        writer.close();
	        System.out.println("Data updated successfully.");

	    } catch (IOException e) {
	    	 e.printStackTrace();
	    }

	    return changed;
	}

	public void makePurchase(float price) {
			this.total += price;
	}
	
	
	public boolean payment(String cardNumber, String securityNumber) {
		int cardNo = cardNumber.length();
		int securNo = securityNumber.length();
		if(cardNo != 16 && securNo != 3) {
			return false;
		} 
		return true;
	}
	
	public boolean login(String email, String password) throws FileNotFoundException {
		Data customer = new Data();
		List<String[]> info = customer.parse("/Users/pattiyayiadram/Java project/BookStore - Customer1.csv", ",");
		for(String[] account: info) {
			if(account[3].equals(email) && account[4].equals(password)) {
				setID(account[0]);
				setName(account[1]);
				setLastName(account[2]);
				setEmail(account[3]);
				setPassword(account[4]);
				setAddress(account[5]);
				setPhoneNumber(account[6]);
				setRewardPoint(account[7]);
				this.isLogin = true;
				System.out.println("Login Successfully! K. " + name);
				break; 
			}else {
				continue;
			}
		}
		return isLogin;
			
		} 
		
	public void setID(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setRewardPoint(String rewardPoint) {
		this.rewardPoint = rewardPoint;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getRewardPoint() {
		return rewardPoint;
	}

	public String getNewRewardPoint(float price) {
		int point = (int) (price/14.50);
		this.rewardPoint = String.valueOf(point*10);
		return rewardPoint;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getTax() {
		float caltax = getTotal() * 7 /100;
		this.tax = caltax;
		return tax;
	}

	public float calDiscount(String point) {
		int points = Integer.parseInt(point);
		if(points % 100 == 0) {
			this.discount = (float) (points/100*0.29);
		}
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getDiscount() {
		return discount;
	}
	
	public float getBillTotal() {
		float billTotal = getTotal() + getTax() - discount;
		return billTotal;
	}
	
	public String toString() {
		return id + " " + name + " " + lastName + "\n" + email + " " + password + "\n" + address + "\n" + phoneNumber + "\n" + rewardPoint;
	}
}
