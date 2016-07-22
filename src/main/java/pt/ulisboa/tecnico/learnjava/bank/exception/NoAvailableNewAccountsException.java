package pt.ulisboa.tecnico.learnjava.bank.exception;

public class NoAvailableNewAccountsException extends Exception {
	private static final long serialVersionUID = 1L;

	private int size;

	public NoAvailableNewAccountsException(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

}
