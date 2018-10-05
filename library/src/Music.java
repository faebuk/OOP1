
public class Music {
	private long articleNumber;
	private String title;
	private String bandName;
	private int length;
	
	public Music(long articleNumber, String title, String bandName, int length) {
		this.articleNumber = articleNumber;
		this.title = title;
		this.bandName = bandName;
		this.length = length;
	}
	public long getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(long articleNumber) {
		this.articleNumber = articleNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBandName() {
		return bandName;
	}
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
}
