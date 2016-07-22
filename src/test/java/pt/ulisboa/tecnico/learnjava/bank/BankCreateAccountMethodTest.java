package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.exception.DuplicateAccountOwnerException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NoAvailableNewAccountsException;

public class BankCreateAccountMethodTest {
	private static final String OWNER_NAME_ONE = "Owner Name One";
	private static final String OWNER_NAME_TWO = "Owner Name Two";
	private static final String OWNER_NAME_THREE = "Owner Name Three";
	private static final String OWNER_NAME_FOUR = "Owner Name Four";

	Bank bank;

	@Before
	public void setUp() throws DuplicateAccountOwnerException, NoAvailableNewAccountsException {
		bank = new Bank(3);
		bank.createAccount(OWNER_NAME_ONE);
	}

	@Test
	public void createAccount() throws DuplicateAccountOwnerException, NoAvailableNewAccountsException {
		bank.createAccount(OWNER_NAME_TWO);
		Account account = bank.getAccount(bank.getAccountNumberByOwnerName(OWNER_NAME_TWO));

		assertEquals(2, bank.getNumberOfAccounts());
		assertEquals(OWNER_NAME_TWO, account.getOwnerName());
	}

	@Test
	public void createTwoAccountsSameOwnerName() throws NoAvailableNewAccountsException {
		try {
			bank.createAccount(OWNER_NAME_ONE);
			fail();
		} catch (DuplicateAccountOwnerException e) {
			assertEquals(1, bank.getNumberOfAccounts());
		}
	}

	@Test
	public void createMoreAccountsThanCapacity()
			throws DuplicateAccountOwnerException, NoAvailableNewAccountsException {
		bank.createAccount(OWNER_NAME_TWO);
		bank.createAccount(OWNER_NAME_THREE);

		try {
			bank.createAccount(OWNER_NAME_FOUR);
			fail();
		} catch (NoAvailableNewAccountsException e) {
			assertEquals(3, bank.getNumberOfAccounts());
			assertEquals(e.getSize(), bank.getNumberOfAccounts());
			assertNotNull(bank.getAccountByOwnerName(OWNER_NAME_ONE));
			assertNotNull(bank.getAccountByOwnerName(OWNER_NAME_TWO));
			assertNotNull(bank.getAccountByOwnerName(OWNER_NAME_THREE));
			assertNull(bank.getAccountByOwnerName(OWNER_NAME_FOUR));
		}
	}

	@After
	public void tearDown() {
		bank = null;
	}

}
