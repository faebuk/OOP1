package library.data;

public final class Journal extends PrintMedium{
	final private String publisher;
	
	public Journal(long articleNumber, String title, String publisher, int pages) {
		super(articleNumber, title, pages);
		this.publisher = publisher;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Journal [publisher=" + publisher + ", getPages()=" + getPages() + ", getArticleNumber()="
				+ getArticleNumber() + ", getTitle()=" + getTitle() + "]";
	}

	public String getPublisher() {
		return publisher;
	}
}
