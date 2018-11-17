package library.admin;

import library.data.Item;

public class ItemNotAvailableException extends LendingException {
    public ItemNotAvailableException() {
	super();
    }

    public ItemNotAvailableException(Item item) {

    }
}
