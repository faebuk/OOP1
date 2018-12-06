package library.admin;

public class InvalidLoginException extends Exception {

	private static final long serialVersionUID = -109503368938440632L;

	public InvalidLoginException(String message){
		super(message);
	}
}
