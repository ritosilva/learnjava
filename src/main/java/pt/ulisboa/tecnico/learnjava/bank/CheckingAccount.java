package pt.ulisboa.tecnico.learnjava.bank;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class CheckingAccount extends Account {

	@Override
	public void withdraw(int ammount) throws NegativeAmmountException, InvalidWithdrawException {
		if (ammount < 0) {
			throw new NegativeAmmountException(ammount);
		}

		if (getBalance() - ammount < 0) {
			throw new InvalidWithdrawException();
		} else {
			setBalance(getBalance() - ammount);
		}
	}

}
