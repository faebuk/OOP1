package persistence.memory;

import java.util.logging.Logger;

import library.data.Journal;
import persistence.IJournalDAO;

public class JournalDAO implements IJournalDAO {
	private Journal[] journals;
	private static final Logger logger = Logger.getLogger(MemoryDAOFactory.class.getName());

	public JournalDAO() {
		loadJournals();
	}

	private void loadJournals() {
		journals = new Journal[15];
		log("load journals");
		for (int i = 0; i < 15; i++) {
			journals[i] = new Journal(4567 + i, "Titel" + i, "Verlag" + i, 30 + i);
		}
	}

	@Override
	public Journal[] getJournals() {
		if (journals == null)
			loadJournals();
		return journals;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
}
