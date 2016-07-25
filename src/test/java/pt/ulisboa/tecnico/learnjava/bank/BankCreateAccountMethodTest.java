package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.Account.AccountType;
import pt.ulisboa.tecnico.learnjava.bank.exception.DuplicateAccountOwnerException;
import pt.ulisboa.tecnico.learnjava.bank.exception.UnknownAccountTypeException;

public class BankCreateAccountMethodTest {
	private static final String OWNER_NAME_ONE = "Owner Name One";
	private static final String OWNER_NAME_TWO = "Owner Name Two";

	Bank bank;

	@Before
	public void setUp() throws DuplicateAccountOwnerException, UnknownAccountTypeException {
		bank = new Bank();
		bank.createAccount(AccountType.CHECKING, OWNER_NAME_ONE, 0);
	}

	@Test
	public void createCheckingAccount() throws DuplicateAccountOwnerException, UnknownAccountTypeException {
		Account account = bank.createAccount(AccountType.CHECKING, OWNER_NAME_TWO, 0);

		assertEquals(2, bank.getNumberOfAccounts());
		assertEquals(OWNER_NAME_TWO, account.getOwnerName());
		assertEquals(AccountType.CHECKING.getPrefix(), account.getAccountId().substring(0, 2));
	}

	@Test
	public void createSavingsAccount() throws DuplicateAccountOwnerException, UnknownAccountTypeException {
		Account account = bank.createAccount(AccountType.SAVINGS, OWNER_NAME_TWO, 100);

		assertEquals(2, bank.getNumberOfAccounts());
		assertEquals(OWNER_NAME_TWO, account.getOwnerName());
		assertEquals(account, bank.getAccountByOwnerName(OWNER_NAME_TWO));
		assertEquals(AccountType.SAVINGS.getPrefix(), account.getAccountId().substring(0, 2));
	}

	@Test
	public void createSalaryAccount() throws DuplicateAccountOwnerException, UnknownAccountTypeException {
		Account account = bank.createAccount(AccountType.SALARY, OWNER_NAME_TWO, 100);

		assertEquals(2, bank.getNumberOfAccounts());
		assertEquals(OWNER_NAME_TWO, account.getOwnerName());
		assertEquals(account, bank.getAccountByOwnerName(OWNER_NAME_TWO));
		assertEquals(AccountType.SALARY.getPrefix(), account.getAccountId().substring(0, 2));
	}

	@Test
	public void createTwoAccountsSameOwnerName() throws UnknownAccountTypeException {
		try {
			bank.createAccount(AccountType.CHECKING, OWNER_NAME_ONE, 0);
			fail();
		} catch (DuplicateAccountOwnerException e) {
			assertEquals(1, bank.getNumberOfAccounts());
		}
	}

	@After
	public void tearDown() {
		bank = null;
	}

}
