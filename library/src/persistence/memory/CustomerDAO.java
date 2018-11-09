package persistence.memory;

import java.util.logging.Logger;

import library.data.Customer;
import persistence.ICustomerDAO;

public class CustomerDAO implements ICustomerDAO {
	private Customer[] customers;
	private static final Logger logger = Logger.getLogger(MemoryDAOFactory.class.getName());

	public CustomerDAO() {
		loadCustomers();
	}

	private void loadCustomers() {
		customers = new Customer[15];
		log("load customers");
		for (int i = 0; i < 15; i++) {
			customers[i] = new Customer("LastName" + i, "FirstName" + i,
					"FirstName" + i + "@" + "LastName" + i + ".ch");
		}
	}

	public Customer[] getCustomers() {
		if (customers == null)
			loadCustomers();
		return customers;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
}
