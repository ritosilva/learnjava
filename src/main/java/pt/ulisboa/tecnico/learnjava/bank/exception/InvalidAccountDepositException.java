package pt.ulisboa.tecnico.learnjava.bank.exception;

public class InvalidAccountDepositException extends Exception {
	private static final long serialVersionUID = 1L;

	private final int value;

	public InvalidAccountDepositException(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
