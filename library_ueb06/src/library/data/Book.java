package library.data;

public final class Book extends PrintMedium {
	final private Writer writer;

	public Book(long articleNumber, String title, Writer writer, int pages) {
		super(articleNumber, title, pages);
		this.writer = writer;
	}
	
	public Writer getWriter() {
		return writer;
	}
	
	@Override
	public String toString() {
		return "Book [writer=" + writer + ", getPages()=" + getPages() + ", getArticleNumber()=" + getArticleNumber()
				+ ", getTitle()=" + getTitle() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}	
}
