package library.data;

public class Book extends PrintMedium {
	private Writer writer;

	public Book(long ean, String title, Writer writer, int pages) {
		this(ean, title, pages);
		this.writer = writer;
	}
	
	public Book(long ean, String title, int pages) {
		super(ean, title, pages);
	}

	public Writer getWriter() {
		return writer;
	}
	
	public void setWriter(Writer w) {
		 writer = w;
	}

	@Override
	public String toString() {
		return "Book: " + super.toString() + " " + writer;
	}
}
