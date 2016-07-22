package pt.ulisboa.tecnico.learnjava.bank;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class CheckingAccount extends Account {

	public CheckingAccount(String ownerName, int balance) {
		super(ownerName, balance);
	}

	@Override
	protected String getNextAccountId() {
		counter++;
		return "CK" + Integer.toString(counter);
	}

	@Override
	public void withdraw(int ammount) throws NegativeAmmountException, InvalidWithdrawException {
		if (getBalance() - ammount < 0) {
			throw new InvalidWithdrawException();
		}

		super.withdraw(ammount);
	}

}
