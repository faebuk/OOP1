package library.admin;

public abstract class LendingException extends Exception {
    private String message;

    public String getMessage() {
	return this.message;
    }
}
