package pt.ulisboa.tecnico.learnjava.bank;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidAccountDepositException;
import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class SavingsAccount extends Account {
	private final int base;
	private int points = 0;

	@Override
	protected String getNextAccountId() {
		counter++;
		return AccountType.SAVINGS.getPrefix() + Integer.toString(counter);
	}

	public SavingsAccount(String ownerName, int balance, int base) {
		super(ownerName, balance);
		this.base = base;
	}

	@Override
	public void deposit(int ammount) throws InvalidAccountDepositException, NegativeAmmountException {
		if (ammount % base != 0) {
			throw new InvalidAccountDepositException(ammount);
		}
		super.deposit(ammount);
		points = points + ammount / base;
	}

	@Override
	public void withdraw(int ammount) throws NegativeAmmountException, InvalidWithdrawException {
		if (ammount != getBalance()) {
			throw new InvalidWithdrawException();
		}

		super.withdraw(ammount);
	}

	public int getPoints() {
		return points;
	}

}
