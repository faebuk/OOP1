package library.data;

public  class Journal extends PrintMedium {
	private  String publisher;
	
	public Journal(long ean, String title, String publisher, int pages) {
		super(ean, title, pages);
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public String toString() {
		return "Journal: " + super.toString() + ", Publisher "+ publisher;
	}
}
