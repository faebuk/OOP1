package library;

public final class Journal extends Item{
	final private String publisher;
	final private int pages;
	
	public Journal(long articleNumber, String title, String publisher, int pages) {
		super(articleNumber, title);
		this.publisher = publisher;
		this.pages = pages;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pages;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Journal other = (Journal) obj;
		if (pages != other.pages)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}

	public String getPublisher() {
		return publisher;
	}
	
	public int getPages() {
		return pages;
	}
}
