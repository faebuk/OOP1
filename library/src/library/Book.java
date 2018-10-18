package library;

public final class Book extends Item {
	final private Writer writer;
	final private int pages;

	public Book(long articleNumber, String title, Writer writer, int pages) {
		super(articleNumber, title);
		this.writer = writer;
		this.pages = pages;
	}
	
	public Writer getWriter() {
		return writer;
	}

	public int getPages() {
		return pages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pages;
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
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
		Book other = (Book) obj;
		if (pages != other.pages)
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}	
}
