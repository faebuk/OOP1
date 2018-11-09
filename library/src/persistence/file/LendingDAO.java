package persistence.file;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

import library.admin.Administration;
import library.data.Customer;
import library.data.Item;
import library.data.Lending;
import persistence.ILendingDAO;

public class LendingDAO extends FileDAO implements Mapper, ILendingDAO {
    Administration admin;
    Lending[] lendings;

    public LendingDAO(File file, String delimiter) {
	super(file, delimiter);
	admin = Administration.getInstance();

	loadLendings();
    }

    private void loadLendings() {
	lendings = new Lending[26];
	log("load lendings");

	List<Object> lendingList = this.loadCsv(this);

	for (int i = 0; i < lendings.length; i++) {
	    lendings[i] = (Lending) lendingList.get(i);
	}
    }

    public void log(String stmt) {
	String text = stmt.toString();
	logger.info(text.substring(text.indexOf(":") + 1));
    }

    /*
     * (non-Javadoc)
     * 
     * @see persistence.ILendingDAO#getLendings()
     */
    @Override
    public Lending[] getLendings() {
	if (lendings == null)
	    loadLendings();
	return lendings;
    }

    @Override
    public Object map(String[] tokens) {
	Customer customer = admin.getDataManager().getCustomers()[Integer.parseInt(tokens[0])];
	Item item = admin.getDataManager().findItem(Integer.parseInt(tokens[1]));
	// TODO Item item = admin.getDataManager().get; Integer.parseInt(tokens[1]
	LocalDate date = LocalDate.of(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
		Integer.parseInt(tokens[4]));

	Lending lending = new Lending(customer, item, date);
	admin.addLending(customer, item, date);

	if (tokens.length > 5 && tokens[5] != null && !tokens[5].equals("")) {
	    LocalDate returnDate = LocalDate.of(Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]),
		    Integer.parseInt(tokens[7]));
	    admin.returnItem(item, returnDate);
	}

	return lending;
    }

}
