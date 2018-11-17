package library.admin;

public class NoAvailableItemsException extends LendingException {
    public NoAvailableItemsException() {
	super();
    }

    public NoAvailableItemsException(long[] ids) {
	super();
    }
}
