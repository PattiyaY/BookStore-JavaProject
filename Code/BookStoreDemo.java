package BookStoreApp_Fullversion;

import java.awt.EventQueue;

public class BookStoreDemo {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer customer = new Customer();
					Login frame = new Login(customer);
					frame.setVisible(true);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}

}
