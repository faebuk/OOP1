package persistence.memory;

import java.time.LocalDate;
import java.util.logging.Logger;

import library.admin.Administration;
import library.admin.LendingManager;
import library.data.Customer;
import library.data.Lending;
import persistence.ILendingDAO;

public class LendingDAO implements ILendingDAO {

	private Lending[] lendings;
	private static final Logger logger = Logger.getLogger(MemoryDAOFactory.class.getName());
	Administration admin;

	public LendingDAO() {
		admin = Administration.getInstance();
		loadLendings();
	}

	private void loadLendings() {
		LendingManager lendingManager = admin.getLendingManager();
		Customer[] customers = admin.getCustomers();
		lendings = new Lending[50];
		log("load lendings");

		for (int i = 0; i < 10; i++) {
			lendings[i] = new Lending(customers[i], admin.findItem(i+1), LocalDate.now().minusDays(5 * i + 5));
			lendingManager.addLending(lendings[i]);
			lendingManager.returnItem(admin.findItem(i+1), LocalDate.now().minusDays(5 + i));
		}
	}

	@Override
	public Lending[] getLendings() {
		if (lendings == null)
			loadLendings();
		return lendings;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}

}
