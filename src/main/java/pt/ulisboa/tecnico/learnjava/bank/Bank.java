package pt.ulisboa.tecnico.learnjava.bank;

import java.util.HashSet;
import java.util.Set;

import pt.ulisboa.tecnico.learnjava.bank.Account.AccountType;
import pt.ulisboa.tecnico.learnjava.bank.exception.DuplicateAccountOwnerException;
import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidAccountDepositException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;
import pt.ulisboa.tecnico.learnjava.bank.exception.UnknownAccountTypeException;

public class Bank {
	Set<Account> accounts = null;

	public Bank() {
		accounts = new HashSet<Account>();
	}

	public Account createAccount(AccountType type, String ownerName, int value)
			throws DuplicateAccountOwnerException, UnknownAccountTypeException {
		checkUniqueOwnerName(ownerName);

		Account account;
		switch (type) {
		case CHECKING:
			account = new CheckingAccount(ownerName, 0);
			break;
		case SAVINGS:
			account = new SavingsAccount(ownerName, 0, value);
			break;
		case SALARY:
			account = new SalaryAccount(ownerName, 0, value);
			break;
		default:
			throw new UnknownAccountTypeException();
		}
		accounts.add(account);

		return account;
	}

	public void checkUniqueOwnerName(String ownerName) throws DuplicateAccountOwnerException {
		Account account = getAccountByOwnerName(ownerName);
		if (account != null) {
			throw new DuplicateAccountOwnerException(ownerName);
		}
	}

	public Account getAccountByOwnerName(String ownerName) {
		for (Account account : accounts) {
			if (account.getOwnerName().equals(ownerName)) {
				return account;
			}
		}
		return null;
	}

	public void deleteAccount(String ownerName) {
		Account account = getAccountByOwnerName(ownerName);
		if (account != null) {
			accounts.remove(account);
		}
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}

	public static void main(String[] args)
			throws DuplicateAccountOwnerException, InvalidAccountDepositException, UnknownAccountTypeException {
		Bank cgd = new Bank();

		Account account = cgd.createAccount(AccountType.CHECKING, "António", 0);

		try {
			account.deposit(-100);
		} catch (NegativeAmmountException e) {
			System.out.println("You cannot deposit a negative value: " + e.getValue());
		}

		System.out.println("The number of accounts is " + cgd.getNumberOfAccounts());
		System.out.println("The balance for account owner " + account.getOwnerName() + " is " + account.getBalance());
	}

}
