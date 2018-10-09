package phonebook.exceptions;

public class AbonatException extends Exception {

	private static final long serialVersionUID = -9184894811364433533L;
	private String description;
	public AbonatException(String description) {
		super(description);
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}

}
