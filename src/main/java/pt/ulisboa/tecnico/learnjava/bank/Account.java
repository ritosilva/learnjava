package pt.ulisboa.tecnico.learnjava.bank;

public class Account {
	private String ownerName;
	private int balance;

	public Account() {
		this(null, 0);
	}

	public Account(String ownerName) {
		this(ownerName, 0);
	}

	public Account(String ownerName, int balance) {
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int ammount) throws NegativeAmmountException {
		if (ammount < 0) {
			throw new NegativeAmmountException(ammount);
		}

		balance = balance + ammount;
	}

	public void withdraw(int ammount) {
		if (balance - ammount >= 0) {
			balance = balance - ammount;
		}
	}

}
