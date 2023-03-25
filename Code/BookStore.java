package BookStoreApp_Fullversion;

import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookStore {
	private String[][] book;
	private String file = "/Users/pattiyayiadram/Java project/BookStore - Customer1.csv";
	private Data customerData = new Data();
	Scanner sc;
	
	 
	
	public BookStore(){

	}
	
	public boolean addCustomer(String firstName, String lastName, String email, String password, String address, String phoneNumber) throws IOException {
		List<String[]> info = customerData.parse(file, ",");
		String id = Integer.toString(1000 + info.size()-1);
		char point = '0';
		
		FileWriter fw = new FileWriter(file, true);
		BufferedWriter bw = new BufferedWriter(fw);
		 if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty() || 
				 email == null || email.isEmpty() || password == null || password.isEmpty() || 
				 address == null || address.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
			 	bw.close();
		        return false;
		    } else {
		    	bw.newLine();
				bw.write(id + "," + firstName +","+ lastName +","+ email +","+ password +","+ address +","+ phoneNumber +"," + point);
				bw.close();
				return true;
		    }
		 
		//JOptionPane.showMessageDialog(null, "Record Saved!");
	}
	
	
	public void updateRewardPoint(String customerId, String newRewardPoint) throws IOException {
	    String file = "/Users/pattiyayiadram/Java project/BookStore - Customer1.csv";
	    boolean changed = false;

	    try {
	        CSVReader reader = new CSVReader(new FileReader(file));
	        List<String[]> data = reader.readAll();
	        reader.close();

	        for (int i = 0; i < data.size(); i++) {
	            String[] customerData = data.get(i);
	            if (customerData[0].equals(customerId)) {
	                customerData[7] = newRewardPoint;
	                changed = true;
	                break;
	            }
	        }

	        if (changed) {
	            CSVWriter writer = new CSVWriter(new FileWriter(file));
	            writer.writeAll(data);
	            writer.close();
	            System.out.println("Reward point updated successfully.");
	        } else {
	            System.out.println("Customer not found.");
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

		
	}


