package persistence;

public interface AbstractFactory {
    public ICustomerDAO createCustomerDAO();

    public IBookDAO createBookDAO();

    public IMusicDAO createMusicDAO();

    public IFilmDAO createFilmDAO();

    public IJournalDAO createJournalDAO();

    public ILendingDAO createLendingDAO();
}
