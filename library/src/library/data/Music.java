package library.data;

public  class Music extends DataObject{
	private  String band;
	private  int length;

	public Music(long ean, String title, String band, int length) {
		super(ean, title);
		this.band = band;
		this.length = length;
	}

	public String getBand() {
		return band;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Music: " + super.toString() + " " + band;
	}
}
