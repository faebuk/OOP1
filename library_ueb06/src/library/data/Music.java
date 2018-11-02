package library.data;

public final class Music extends DataObject{
	final private String bandName;
	final private int length;
	
	public Music(long articleNumber, String title, String bandName, int length) {
		super(articleNumber, title);
		this.bandName = bandName;
		this.length = length;
	}
	
	public String getBandName() {
		return bandName;
	}
		
	
	@Override
	public String toString() {
		return "Music [bandName=" + bandName + ", length=" + length + ", getArticleNumber()=" + getArticleNumber()
				+ ", getTitle()=" + getTitle() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bandName == null) ? 0 : bandName.hashCode());
		result = prime * result + length;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (bandName == null) {
			if (other.bandName != null)
				return false;
		} else if (!bandName.equals(other.bandName))
			return false;
		if (length != other.length)
			return false;
		return true;
	}

	public int getLength() {
		return length;
	}
		
}
