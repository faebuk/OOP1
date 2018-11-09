package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Book;
import library.data.Customer;
import library.data.DataObject;
import persistence.ICustomerDAO;

public class CustomerDAO extends FileDAO implements Mapper, ICustomerDAO {
	private Customer[] customers;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public CustomerDAO(File customerFile, String delimiter) {
		super(customerFile, delimiter);
		
		loadCustomers();
	}

	private void loadCustomers() {
		customers = new Customer[15];
		log("load customers");
		
		List<Object> customerList = this.loadCsv(this);
		
		for(int i = 0; i < customers.length; i++) {
			customers[i] = (Customer) customerList.get(i);
		}
	}	

	public void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
	
	/* (non-Javadoc)
	 * @see persistence.ICustomerDAO#getCustomers()
	 */
	@Override
	public Customer[] getCustomers() {
		if (customers == null)
			loadCustomers();
		return customers;
	}

	@Override
	public Object map(String[] tokens) {
		Customer customer = new Customer(tokens[0], tokens[1], tokens[2]);
		
		return customer;
	}

}
