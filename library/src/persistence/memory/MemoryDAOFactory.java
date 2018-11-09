package persistence.memory;

import persistence.AbstractFactory;
import persistence.IBookDAO;
import persistence.ICustomerDAO;
import persistence.IFilmDAO;
import persistence.IJournalDAO;
import persistence.ILendingDAO;
import persistence.IMusicDAO;

public class MemoryDAOFactory implements AbstractFactory {

	@Override
	public ICustomerDAO createCustomerDAO() {
		return new CustomerDAO();
	}

	@Override
	public IBookDAO createBookDAO() {
		return new BookDAO();
	}

	@Override
	public IMusicDAO createMusicDAO() {
		return new MusicDAO();
	}

	@Override
	public IFilmDAO createFilmDAO() {
		return new FilmDAO();
	}

	@Override
	public IJournalDAO createJournalDAO() {
		return new JournalDAO();
	}

	@Override
	public ILendingDAO createLendingDAO() {
		return new LendingDAO();
	}
}
