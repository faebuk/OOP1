package persistence.memory;

import java.util.logging.Logger;

import library.data.Actor;
import library.data.Film;
import persistence.IFilmDAO;

public class FilmDAO implements IFilmDAO {
	private Film[] films;
	private static final Logger logger = Logger.getLogger(MemoryDAOFactory.class.getName());

	public FilmDAO() {
		loadFilms();
	}

	private void loadFilms() {
		films = new Film[15];
		log("load films");
		Actor[] a = createActors();
		for (int i = 0; i < 15; i++) {
			films[i] = new Film(2345 + i, "Titel" + i, "Verlag" + i, 60 + i);
			films[i].addActor(a[i%10], 0);
			films[i].addActor(a[(i + 1)%10], 1);
			films[i].addActor(a[(i + 2)%10], 2);
		}
	}

	@Override
	public Film[] getFilms() {
		if (films == null)
			loadFilms();
		return films;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
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
