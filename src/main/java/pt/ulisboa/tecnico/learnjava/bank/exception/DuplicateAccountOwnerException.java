package pt.ulisboa.tecnico.learnjava.bank.exception;

public class DuplicateAccountOwnerException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String name;

	public DuplicateAccountOwnerException(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
