package persistence.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import library.data.Actor;
import library.data.DataObject;
import library.data.Film;
import persistence.IFilmDAO;

public class FilmDAO extends FileDAO implements Mapper, IFilmDAO {
	private Film[] films;
	
	public FilmDAO(File filmFile, String delimiter) {
		super(filmFile, delimiter);
		
		loadFilms();
	}
	
	private void loadFilms() {
		films = new Film[15];
		log("load films");
		
		List<Object> filmList = this.loadCsv(this);
		
		for(int i = 0; i < films.length; i++) {
			films[i] = (Film) filmList.get(i);
		}
	}	
	
	public void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
	
	@Override
	public Object map(String[] tokens) {
		Actor[] a = createActors();
		
		int ean = Integer.parseInt(tokens[0]);
		int length = Integer.parseInt(tokens[3]);
		Film film = new Film(ean, tokens[1], tokens[2], length);
		film.addActor(a[Integer.parseInt(tokens[4])], 0);
		film.addActor(a[Integer.parseInt(tokens[5])], 1);
		film.addActor(a[Integer.parseInt(tokens[6])], 2);
		
		return film;
	}

	/* (non-Javadoc)
	 * @see persistence.IFilmDAO#getFilms()
	 */
	@Override
	public Film[] getFilms() {
		if (films == null)
			loadFilms();
		return films;
	}

	private Actor[] createActors() {
		Actor[] a = new Actor[10];
		a[0] = new Actor("Norton", "Edward");
		a[1] = new Actor("Bale", "Christian");
		a[2] = new Actor("Delon", "Alain");
		a[3] = new Actor("Fels", "Edward");
		a[4] = new Actor("Stein", "Christian");
		a[5] = new Actor("Waltz", "Christoph");
		a[6] = new Actor("Portman", "Natalie");
		a[7] = new Actor("Depp", "Johnny");
		a[8] = new Actor("Weiss", "Johnny");
		a[9] = new Actor("Black", "Edward");
		return a;
	}
}
