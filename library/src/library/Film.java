package library;

import java.util.Arrays;

public final class Film extends Item {
	final private Actor[] actors = new Actor[3];
	final private String publisher;
	final private int length;
	
	public Film(long articleNumber, String title, String publisher, int length) {
		super(articleNumber, title);
		this.publisher = publisher;
		this.length = length;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(actors);
		result = prime * result + length;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
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
		Film other = (Film) obj;
		if (!Arrays.equals(actors, other.actors))
			return false;
		if (length != other.length)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		return true;
	}
	public Actor[] getActors() {
		return actors;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public int getLength() {
		return length;
	}
	
	public void addActor(Actor actor, int i) {
		this.actors[i] = actor;		
	}	
}
