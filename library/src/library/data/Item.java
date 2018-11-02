package library.data;

public class Item {
	private long id;
	private State state;
	private DataObject object;
	
	private Lending lending;

	public Item(long id, DataObject object) {
		this.id = id;
		this.object = object;
		
		this.state = State.AVAILABLE;
	}
	
	public DataObject getDataObject() {
		return object;
	}

	public long getId() {
		return id;
	}
	
	public boolean isAvailable() {
		if(state == State.AVAILABLE) {
			return true;
		}
		
		return false;
	}

	public Lending getLending() {
		return lending;
	}

	public void setLending(Lending lending) {
		this.lending = lending;
	}

	public void setState(State state) {
		this.state = state;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lending == null) ? 0 : lending.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		if (lending == null) {
			if (other.lending != null)
				return false;
		} else if (!lending.equals(other.lending))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", state=" + state + ", lending=" + lending + "]";
	}
	
	
}
