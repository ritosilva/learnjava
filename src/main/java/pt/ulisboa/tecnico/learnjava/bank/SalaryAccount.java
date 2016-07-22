package pt.ulisboa.tecnico.learnjava.bank;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class SalaryAccount extends Account {
	private final int salary;

	public SalaryAccount(String ownerName, int balance, int salary) {
		super(ownerName, balance);
		this.salary = salary;
	}

	@Override
	public void withdraw(int ammount) throws NegativeAmmountException, InvalidWithdrawException {
		if (ammount < 0) {
			throw new NegativeAmmountException(ammount);
		}

		if (getBalance() - ammount < -salary) {
			throw new InvalidWithdrawException();
		} else {
			setBalance(getBalance() - ammount);
		}
	}

}
