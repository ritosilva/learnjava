package pt.ulisboa.tecnico.learnjava.bank;

public class Bank {
	int nextAccountNumber = 0;
	Account[] accounts;

	public Bank(int numMaxAccounts) {
		accounts = new Account[numMaxAccounts];
	}

	public int createAccount(String ownerName) throws DuplicateAccountOwnerException {
		Account account = getAccountByOwnerName(ownerName);

		if (account != null) {
			throw new DuplicateAccountOwnerException(ownerName);
		}

		account = new Account(ownerName);
		accounts[nextAccountNumber] = account;
		nextAccountNumber = nextAccountNumber + 1;
		return nextAccountNumber - 1;
	}

	public Account getAccountByOwnerName(String ownerName) {
		Account account = null;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accounts[i].getOwnerName().equals(ownerName)) {
				account = accounts[i];
			}
		}
		return account;
	}

	public void deleteAccount(String ownerName) {
		int accountNumber = getAccountNumberByOwnerName(ownerName);
		if (accountNumber != -1) {
			accounts[accountNumber] = null;
		}
	}

	public int getAccountNumberByOwnerName(String ownerName) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accounts[i].getOwnerName().equals(ownerName)) {
				return i;
			}
		}
		return -1;
	}

	public Account getAccount(int accountNumber) {
		return accounts[accountNumber];
	}

	public int getNumberOfAccounts() {
		int numberOfAccounts = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				numberOfAccounts++;
			}
		}
		return numberOfAccounts;
	}

	public static void main(String[] args) throws DuplicateAccountOwnerException {
		Bank cgd = new Bank(1_000_000);

		cgd.createAccount("António");

		Account account = cgd.getAccount(cgd.getAccountNumberByOwnerName("António"));

		try {
			account.deposit(-100);
		} catch (NegativeAmmountException e) {
			System.out.println("You cannot deposit a negative value: " + e.getValue());
		}

		System.out.println("The number of accounts is " + cgd.getNumberOfAccounts());
		System.out.println("The balance for account owner " + account.getOwnerName() + " is " + account.getBalance());
	}

}
