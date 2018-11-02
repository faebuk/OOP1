package library.data;

public class BookItem extends Item {
	private Book book;

	public BookItem(long id, Book book) {
		super(id, book);
		this.book = book;
	}	

	public Book getBook() {
		return book;
	}

	@Override
	public String toString() {
		return "Book: " + book + super.toString();
	}
}
