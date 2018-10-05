
public class Film {
	private Actor[] actors;
	private long articleNumber;
	private String title;
	private String publisher;
	private int length;
	
	public Film(long articleNumber, String title, String publisher, int length) {
		this.articleNumber = articleNumber;
		this.title = title;
		this.publisher = publisher;
		this.length = length;
	}
	public Actor[] getActors() {
		return actors;
	}
	public void setActors(Actor[] actors) {
		this.actors = actors;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
