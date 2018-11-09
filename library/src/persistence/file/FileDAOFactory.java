package persistence.file;

import java.io.File;

import persistence.AbstractFactory;
import persistence.IBookDAO;
import persistence.ICustomerDAO;
import persistence.IFilmDAO;
import persistence.IJournalDAO;
import persistence.ILendingDAO;
import persistence.IMusicDAO;

public class FileDAOFactory implements AbstractFactory {
    private static final String DELIMITER = ";";
    private static final String CUSTOMER_FILE = "res/customers.csv";
    private static final String BOOK_FILE = "res/books.csv";
    private static final String MUSIC_FILE = "res/musics.csv";
    private static final String JOURNAL_FILE = "res/journals.csv";
    private static final String FILM_FILE = "res/films.csv";
    private static final String LENDING_FILE = "res/lendings.csv";

    public ICustomerDAO createCustomerDAO() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(CUSTOMER_FILE).getFile());
	return new CustomerDAO(file, DELIMITER);
    }

    public IBookDAO createBookDAO() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(BOOK_FILE).getFile());
	return new BookDAO(file, DELIMITER);
    }

    public IMusicDAO createMusicDAO() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(MUSIC_FILE).getFile());
	return new MusicDAO(file, DELIMITER);
    }

    public IFilmDAO createFilmDAO() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(FILM_FILE).getFile());
	return new FilmDAO(file, DELIMITER);
    }

    public IJournalDAO createJournalDAO() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(JOURNAL_FILE).getFile());
	return new JournalDAO(file, DELIMITER);
    }

    public ILendingDAO createLendingDAO() {
	ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource(LENDING_FILE).getFile());
	return new LendingDAO(file, DELIMITER);
    }

}
