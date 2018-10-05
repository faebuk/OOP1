
public class Journal {
	private long articleNumber;
	private String title;
	private String publisher;
	private int pages;
	
	public Journal(long articleNumber, String title, String publisher, int pages) {
		this.articleNumber = articleNumber;
		this.title = title;
		this.publisher = publisher;
		this.pages = pages;
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
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
}
