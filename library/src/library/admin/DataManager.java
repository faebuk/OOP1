package library.admin;

import java.util.ArrayList;
import java.util.List;

import library.data.Actor;
import library.data.BookItem;
import library.data.Customer;
import library.data.DataObject;
import library.data.FilmItem;
import library.data.Item;
import library.data.JournalItem;
import library.data.MusicItem;
import library.data.Writer;

public class DataManager {
    private Customer[] customers;
    private BookItem[] bookItems;
    private FilmItem[] filmItems;
    private MusicItem[] musicItems;
    private JournalItem[] journalItems;

    public DataManager() {
	customers = new Customer[20];
	bookItems = new BookItem[30];
	filmItems = new FilmItem[30];
	musicItems = new MusicItem[30];
	journalItems = new JournalItem[30];
    }

    public long[] findItemsByArticleNumber(long ean) {
	List<Long> ids = new ArrayList<>();

	Item[] allItems = Utils.concat(bookItems, musicItems, filmItems, journalItems);

	for (Item item : allItems) {
	    if (item.getDataObject().getArticleNumber() == ean) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    public long[] findItems(String s) {
	long[] result = null;
	result = Utils.concat(result, findBookItems(s));
	result = Utils.concat(result, findMusicItems(s));
	result = Utils.concat(result, findFilmItems(s));
	result = Utils.concat(result, findJournalItems(s));
	return result;
    }

    public Item findItem(long id) {
	Item[] allItems = Utils.concat(bookItems, musicItems, filmItems, journalItems);

	for (Item item : allItems) {
	    if (item.getId() == id) {
		return item;
	    }
	}

	return null;
    }

    // TODO
    public <T> long[] findItems(Class<T> type, String string) {
	List<Long> ids = new ArrayList<>();

	for (long id : this.findItems(string)) {
	    DataObject object = this.findItem(id).getDataObject();

	    if (type.isInstance(object)) {
		ids.add(id);
	    }
	}

	return Utils.convertToArray(ids);
    }

    public long[] findItems(String title, Actor actor) {
	List<Long> ids = new ArrayList<>();

	for (FilmItem item : filmItems) {
	    if (this.contains(item.getFilm().getActors(), actor) && item.getFilm().getTitle().equals(title)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    public long[] findItems(Writer writer) {
	List<Long> ids = new ArrayList<>();

	for (BookItem item : bookItems) {
	    if (item.getBook().getWriter().equals(writer)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    public long[] findItems(Actor actor) {
	List<Long> ids = new ArrayList<>();

	for (FilmItem item : filmItems) {
	    if (this.contains(item.getFilm().getActors(), actor)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    private long[] findBookItems(String title) {
	List<Long> ids = new ArrayList<>();

	for (BookItem item : bookItems) {
	    if (item.getBook().getTitle().equals(title)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    private long[] findMusicItems(String s) {
	List<Long> ids = new ArrayList<>();

	for (MusicItem item : musicItems) {
	    if (item.getMusic().getTitle().equals(s) || item.getMusic().getBand().equals(s)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    private long[] findFilmItems(String s) {
	List<Long> ids = new ArrayList<>();

	for (FilmItem item : filmItems) {
	    if (item.getFilm().getPublisher().equals(s) || item.getFilm().getTitle().equals(s)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    private long[] findJournalItems(String s) {
	List<Long> ids = new ArrayList<>();

	for (JournalItem item : journalItems) {
	    if (item.getJournal().getPublisher().equals(s) || item.getJournal().getTitle().equals(s)) {
		ids.add(item.getId());
	    }
	}

	return Utils.convertToArray(ids);
    }

    private boolean contains(Actor[] actors, Actor actor) {
	for (Actor a : actors) {
	    if (a != null && a.equals(actor))
		return true;
	}
	return false;
    }

    public void printItems() {
	for (BookItem e : bookItems) {
	    System.out.println(e.toString());
	}
	for (MusicItem e : musicItems) {
	    System.out.println(e.toString());
	}
	for (FilmItem e : filmItems) {
	    System.out.println(e.toString());
	}
	for (JournalItem e : journalItems) {
	    System.out.println(e.toString());
	}
    }

    public Customer[] getCustomers() {
	return customers;
    }

    public BookItem[] getBookItems() {
	return bookItems;
    }

    public FilmItem[] getFilmItems() {
	return filmItems;
    }

    public MusicItem[] getMusicItems() {
	return musicItems;
    }

    public JournalItem[] getJournalItems() {
	return journalItems;
    }
}
