package library.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import library.data.Actor;
import library.data.BookItem;
import library.data.Customer;
import library.data.DataObject;
import library.data.FilmItem;
import library.data.Item;
import library.data.JournalItem;
import library.data.MusicItem;
import library.data.Writer;
import library.util.Util;

public class DataManager {
	private Collection<Customer> customers;	
	
	private DataObject[] dataObjects;
	
	private BookItem[] bookItems;
	private MusicItem[] musicItems;
	private FilmItem[] filmItems;
	private JournalItem[] journalItems;
	
	public DataManager() {
		this.customers = new ArrayList<>();
		this.dataObjects = new DataObject[44];
		this.bookItems = new BookItem[14];
		this.musicItems = new MusicItem[12];
		this.filmItems = new FilmItem[6];
		this.journalItems = new JournalItem[12];		
	}
	
	public DataObject[] getDataObjects() {
		return this.dataObjects;
	}
	
	public Customer[] getCustomers() {
		return (Customer[]) this.customers.toArray();
	}
	
	public BookItem[] getBookItems() {
		return this.bookItems;
	}

	public FilmItem[] getFilmItems() {
		return this.filmItems;
	}
	
	public MusicItem[] getMusicItems() {
		return this.musicItems;
	}
	
	public JournalItem[] getJournalItems() {
		return this.journalItems;
	}
	
	public Item isDataObjectAvailable(DataObject obj) {
		Item[] allItems = Util.concat(bookItems, musicItems, filmItems, journalItems);
		
		for(Item item : allItems) {
			if(item.getDataObject().equals(obj)) {
				return item;
			}
		}
		 
		return null;
	}
	
	public DataObject findDataObject(long articleNumber) {
		for(DataObject obj : this.dataObjects) {
			if(obj.getArticleNumber() == articleNumber) {
				return obj;
			}
		}
		
		return null;
	}

	public DataObject findDataObject(String title) {
		for(DataObject obj : this.dataObjects) {
			if(obj.getTitle().equals(title)) {
				return obj;
			}
		}
		
		return null;
	}
	
	public long[] findItems(String title) {
		List<Long> ids = new ArrayList<>();
		
		Item[] allItems = Util.concat(bookItems, musicItems, filmItems, journalItems);
		
		for(Item item : allItems) {
			if(item.getDataObject().getTitle().equals(title)) {
				ids.add(item.getId());
			}
		}
		 
		return convertToArray(ids);
	}
	
	private long[] convertToArray(List<Long> list) {
		long[] longIds = new long[list.size()];		
		int counter = 0;
		for(Long id : list) {
			longIds[counter] = id;
			counter++;
		}
				
		return longIds;
	}
	
	public long[] findBookItems(Writer writer) {
		List<Long> ids = new ArrayList<>();
		
		for(BookItem item : this.bookItems) {
			if(item.getBook().getWriter().equals(writer)) {
				ids.add(item.getId());
			}
		}		
		 
		return convertToArray(ids);
	}
	
	public long[] findFilmItems(Actor actor) {
		List<Long> ids = new ArrayList<>();
		
		for(FilmItem item : this.filmItems) {
			for(Actor itemActor : item.getFilm().getActors()) {
				if(itemActor != null && itemActor.equals(actor)) {
					ids.add(item.getId());
				}
			}
		}
		 
		return convertToArray(ids);
	}
	
	public long[] findMusicItems(String band) {
		List<Long> ids = new ArrayList<>();
		
		for(MusicItem item : this.musicItems) {
			if(item.getMusic().getBandName().equals(band)) {
				ids.add(item.getId());
			}
		}
		 
		return convertToArray(ids);
	}


}
