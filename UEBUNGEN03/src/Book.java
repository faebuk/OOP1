
public class Book {
	private Writer writer;
	private long articleNumber;
	private String title;
	private int pages;

	public Book(long articleNumber, String title, Writer writer, int pages) {
		this.writer = writer;
		this.articleNumber = articleNumber;
		this.title = title;
		this.pages = pages;
	}
	
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
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
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
}
