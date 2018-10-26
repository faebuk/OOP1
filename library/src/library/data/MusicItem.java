package library.data;

public class MusicItem extends Item {
	private Music music;

	public MusicItem(long id, Music music) {
		super(id, music);
		this.music = (Music) this.getDataObject();
	}

	public Music getMusic() {
		return music;
	}

	@Override
	public String toString() {
		return "MusicItem [music=" + music + ", getId()=" + getId() + ", isAvailable()=" + isAvailable()
				+ ", getLending()=" + getLending() + "]";
	}
}
