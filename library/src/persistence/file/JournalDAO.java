package persistence.file;

import java.io.File;
import java.util.List;

import library.data.Journal;
import persistence.IJournalDAO;

public class JournalDAO extends FileDAO implements Mapper, IJournalDAO {
    private Journal[] journals;

    public JournalDAO(File journalFile, String delimiter) {
	super(journalFile, delimiter);

	loadJournals();
    }

    private void loadJournals() {
	journals = new Journal[15];
	log("load journals");

	List<Object> journalList = this.loadCsv(this);

	for (int i = 0; i < journals.length; i++) {
	    journals[i] = (Journal) journalList.get(i);
	}
    }

    /* (non-Javadoc)
     * @see persistence.IJournalDAO#getJournals()
     */
    @Override
    public Journal[] getJournals() {
	if (journals == null)
	    loadJournals();
	return journals;
    }

    public void log(String stmt) {
	String text = stmt.toString();
	logger.info(text.substring(text.indexOf(":") + 1));
    }

    @Override
    public Object map(String[] tokens) {
	int articleNumber = Integer.parseInt(tokens[0]);
	int pages = Integer.parseInt(tokens[3]);
	Journal journal = new Journal(articleNumber, tokens[1], tokens[2], pages);

	return journal;
    }

}
