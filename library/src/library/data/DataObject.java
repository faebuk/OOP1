package library.data;

public abstract class DataObject {
	final private long articleNumber;
	final private String title;

	public DataObject(long ean, String title) {
		this.title = title;
		this.articleNumber = ean;
	}

	public long getArticleNumber() {
		return articleNumber;
	}
	
	public String getTitle() {
		return title;
	}
}
