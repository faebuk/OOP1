package persistence.memory;

import java.util.logging.Logger;

import library.data.Book;
import library.data.Writer;
import persistence.IBookDAO;

public class BookDAO implements IBookDAO {
    private Book[] books;
    private static final Logger logger = Logger.getLogger(MemoryDAOFactory.class.getName());

    public BookDAO() {
	loadBooks();
    }

    private void loadBooks() {
	Writer[] w = createWriters();
	books = new Book[15];
	log("load books");
	for (int i = 0; i < 15; i++) {
	    books[i] = new Book(1234 + i, "Titel" + i, w[i % 10], 300 + i);
	}
    }

    private void log(String stmt) {
	String text = stmt.toString();
	logger.info(text.substring(text.indexOf(":") + 1));
    }

    private Writer[] createWriters() {
	Writer[] w = new Writer[10];
	w[0] = new Writer("Schreiberin", "Barbara");
	w[1] = new Writer("Schreiber", "Hans");
	w[2] = new Writer("Schreiber", "Peter");
	w[3] = new Writer("Schreiber", "Willi");
	w[4] = new Writer("Schreiberin", "Anna");
	w[5] = new Writer("Autor", "Willi");
	w[6] = new Writer("Autorin", "Anna");
	w[7] = new Writer("Autor", "Willi");
	w[8] = new Writer("Autorin", "Anna");
	w[9] = new Writer("Autorin", "Maria");
	return w;
    }

    @Override
    public Book[] getBooks() {
	if (books == null)
	    loadBooks();
	return books;
    }
}
