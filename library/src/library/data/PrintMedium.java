package library.data;

public class PrintMedium extends DataObject{
	private int pages;
	
	public PrintMedium(long ean, String title, int pages) {
		super(ean, title);
		this.pages = pages;
	}

	public int getPages() {
		return pages;
	}
	
	@Override
	public String toString() {
		return super.toString() + " Pages:" + pages;
	}
}
