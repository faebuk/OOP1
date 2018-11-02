package library.data;

public  class Film extends DataObject{
	private  String publisher;
	private  int length;
	private  Actor[] actors;

	public Film(long ean, String title, String publisher, int length) {
		super(ean, title);
		this.publisher = publisher;
		this.length = length;
		actors = new Actor[3];
	}
	
	public Film(long ean, String title, String publisher, Actor[] actors, int length) {
		this(ean, title, publisher, length);
		this.actors = actors;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getLength() {
		return length;
	}

	public Actor[] getActors() {
		return actors;
	}

	public void addActor(Actor actor, int i) {
		actors[i] = actor;
	}

	@Override
	public String toString() {
		return "Film: " + super.toString() + " " + publisher.toString();
	}
}
