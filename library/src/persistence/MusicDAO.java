package persistence;

import java.io.File;
import java.util.List;

import library.data.Music;

public class MusicDAO extends DAO implements Mapper {
    private Music[] musics;

    public MusicDAO(File musicFile, String delimiter) {
	super(musicFile, delimiter);

	loadMusics();
    }

    private void loadMusics() {
	musics = new Music[15];
	log("load musics");

	List<Object> musicList = this.loadCsv(this);

	for (int i = 0; i < musics.length; i++) {
	    musics[i] = (Music) musicList.get(i);
	}
    }

    public void log(String stmt) {
	String text = stmt.toString();
	logger.info(text.substring(text.indexOf(":") + 1));
    }

    public Music[] getMusics() {
	if (musics == null)
	    loadMusics();
	return musics;
    }

    @Override
    public Object map(String[] tokens) {
	int articleNumber = Integer.parseInt(tokens[0]);
	int length = Integer.parseInt(tokens[3]);
	Music music = new Music(articleNumber, tokens[1], tokens[2], length);

	return music;
    }
}
