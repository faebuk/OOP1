package persistence;

import java.io.File;

public class DAOFactory {
	private static final String DELIMITER = ";";
    private static final String CUSTOMER_FILE = "res/customers.csv";
    private static final String BOOK_FILE = "res/books.csv";
    private static final String MUSIC_FILE = "res/musics.csv";
    private static final String JOURNAL_FILE = "res/journals.csv";
    private static final String FILM_FILE = "res/films.csv";

    public CustomerDAO createCustomerDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(CUSTOMER_FILE).getFile());
        return new CustomerDAO(file, DELIMITER);
    }
    
    public BookDAO createBookDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(BOOK_FILE).getFile());
        return new BookDAO(file, DELIMITER);
    }
    
    public MusicDAO createMusicDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(MUSIC_FILE).getFile());
        return new MusicDAO(file, DELIMITER);
    }
    
    public FilmDAO createFilmDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(FILM_FILE).getFile());
        return new FilmDAO(file, DELIMITER);
    }
    
    public JournalDAO createJournalDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(JOURNAL_FILE).getFile());
        return new JournalDAO(file, DELIMITER);
    }
    
}
