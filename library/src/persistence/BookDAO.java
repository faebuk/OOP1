package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Actor;
import library.data.Book;
import library.data.DataObject;
import library.data.Film;
import library.data.Writer;

public class BookDAO extends DAO implements Mapper {
	private Book[] books;
	private static final Logger logger = Logger.getLogger(CustomerDAO.class.getName());

	public BookDAO(File bookFile, String delimiter) {
		super(bookFile, delimiter);
		
		loadBooks();
	}

	private void loadBooks() {
		books = new Book[15];
		log("load books");
		
		List<Object> bookList = this.loadCsv(this);
		
		for(int i = 0; i < books.length; i++) {
			books[i] = (Book) bookList.get(i);
		}
	}	

	public void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
	
	public Book[] getBooks() {
		if (books == null)
			loadBooks();
		return books;
	}
	
	@Override
	public Object map(String[] tokens) {
		Writer[] w = createWriters();
		
		int articleNumber = Integer.parseInt(tokens[0]);
		int pages = Integer.parseInt(tokens[2]);
		Book book = new Book(articleNumber, tokens[1], pages);
		book.setWriter(w[Integer.parseInt(tokens[3])]);
		
		return book;
	}

	private Writer[] createWriters() {
		Writer[] w = new Writer[7];
		w[0] = new Writer("Schreiberin", "Barbara");
		w[1] = new Writer("Schreiber", "Hans");
		w[2] = new Writer("Schreiber", "Peter");
		w[3] = new Writer("Schreiber", "Willi");
		w[4] = new Writer("Schreiberin", "Anna");
		return w;
	}
}
