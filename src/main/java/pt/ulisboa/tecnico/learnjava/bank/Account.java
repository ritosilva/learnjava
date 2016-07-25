package pt.ulisboa.tecnico.learnjava.bank;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidAccountDepositException;
import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public abstract class Account {
	public enum AccountType {
		CHECKING("CK"), SAVINGS("SV"), SALARY("SL");

		private final String prefix;

		AccountType(String prefix) {
			this.prefix = prefix;
		}

		public String getPrefix() {
			return prefix;
		}
	}

	protected static int counter = 0;

	protected abstract String getNextAccountId();

	private String accountId;
	private String ownerName;
	private int balance;

	public Account() {
		this(null, 0);
	}

	public Account(String ownerName) {
		this(ownerName, 0);
	}

	public Account(String ownerName, int balance) {
		this.accountId = getNextAccountId();
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountId() {
		return accountId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int ammount) throws NegativeAmmountException, InvalidAccountDepositException {
		if (ammount < 0) {
			throw new NegativeAmmountException(ammount);
		}

		balance = balance + ammount;
	}

	public void withdraw(int ammount) throws NegativeAmmountException, InvalidWithdrawException {
		if (ammount < 0) {
			throw new NegativeAmmountException(ammount);
		}

		balance = balance - ammount;
	}

}
