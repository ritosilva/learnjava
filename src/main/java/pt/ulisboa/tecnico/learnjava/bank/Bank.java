package pt.ulisboa.tecnico.learnjava.bank;

public class Bank {
	int nextAccountNumber = 0;
	Account[] accounts;

	public Bank(int numMaxAccounts) {
		accounts = new Account[numMaxAccounts];
	}

	public int createAccount(String ownerName) {
		Account account = new Account(ownerName);
		accounts[nextAccountNumber] = account;
		nextAccountNumber = nextAccountNumber + 1;
		return nextAccountNumber - 1;
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

	public static void main(String[] args) {
		Bank cgd = new Bank(1_000_000);

		cgd.createAccount("António");
		cgd.createAccount("Manuel");

		Account account = cgd.getAccount(cgd.getAccountNumberByOwnerName("Manuel"));

		account.deposit(100);

		System.out.println("The number of accounts is " + cgd.getNumberOfAccounts());
		System.out.println("The balance for account owner " + account.getOwnerName() + " is " + account.getBalance());

		cgd.deleteAccount("António");

		account = cgd.getAccount(cgd.getAccountNumberByOwnerName("Manuel"));

		System.out.println("The number of accounts is " + cgd.getNumberOfAccounts());
		System.out.println("The balance for account owner " + account.getOwnerName() + " is " + account.getBalance());
		System.out.println("The account number for Manuel is " + cgd.getAccountNumberByOwnerName("Manuel"));
	}

}
