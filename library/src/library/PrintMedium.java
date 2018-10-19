package library;

public abstract class PrintMedium extends DataObject {
	private int pages;
	
	public PrintMedium(long articleNumber, String title, int pages) {
		super(articleNumber, title);
		
		this.pages = pages;
	}
		
	public int getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return "PrintMedium [pages=" + pages + ", getArticleNumber()=" + getArticleNumber() + ", getTitle()="
				+ getTitle() + "]";
	}
}
