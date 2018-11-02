package library.data;

public class MusicItem extends Item {
	private Music music;

	public MusicItem(long id, Music music) {
		super(id, music);
		this.music = music;
	}

	public Music getMusic() {
		return music;
	}

	@Override
	public String toString() {
		return "Music: " + music + super.toString();
	}
}
