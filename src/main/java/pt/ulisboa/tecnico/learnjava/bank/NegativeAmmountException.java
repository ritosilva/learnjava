package pt.ulisboa.tecnico.learnjava.bank;

public class NegativeAmmountException extends Exception {
	private static final long serialVersionUID = 1L;

	private int value;

	public NegativeAmmountException(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
