package library.data;

public class JournalItem extends Item {
	private Journal journal;
	
	

	public JournalItem(long id, Journal journal) {
		super(id, journal);
		this.journal = (Journal) this.getDataObject();
	}

	public Journal getJournal() {
		return journal;
	}

	@Override
	public String toString() {
		return "JournalItem [journal=" + journal + ", getId()=" + getId() + ", isAvailable()=" + isAvailable()
				+ ", getLending()=" + getLending() + "]";
	}
}
