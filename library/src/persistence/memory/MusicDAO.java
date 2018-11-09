package persistence.memory;

import java.util.logging.Logger;

import library.data.Music;
import persistence.IMusicDAO;

public class MusicDAO implements IMusicDAO {

	private Music[] musics;
	private static final Logger logger = Logger.getLogger(MemoryDAOFactory.class.getName());

	public MusicDAO() {
		loadMusics();
	}

	private void loadMusics() {
		musics = new Music[15];
		log("load musics");
		for (int i = 0; i < 15; i++) {
			musics[i] = new Music(3456 + i, "Titel" + i, "Band" + i, 60 + i);
		}
	}

	public Music[] getMusics() {
		if (musics == null)
			loadMusics();
		return musics;
	}

	private void log(String stmt) {
		String text = stmt.toString();
		logger.info(text.substring(text.indexOf(":") + 1));
	}
}
