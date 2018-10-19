package library;

public abstract class DataObject {
	final private long articleNumber;
	final private String title;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (articleNumber ^ (articleNumber >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataObject other = (DataObject) obj;
		if (articleNumber != other.articleNumber)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public DataObject(long articleNumber, String title){
		this.articleNumber = articleNumber;
		this.title = title;
	}
	
	public long getArticleNumber() {
		return articleNumber;
	}
	public String getTitle() {
		return title;
	}
	
	
}
