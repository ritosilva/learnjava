package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GetNextAccountIdMethodTest {
	Account account;

	@Before
	public void setUp() {
		account = null;
	}

	@Test
	public void createAccount() {
		account = new Account("António", 1000);

		assertTrue(account.getAccountId().startsWith("A"));
	}

	@Test
	public void createSavingsAccount() {
		account = new SavingsAccount("António", 1000, 100);

		assertTrue(account.getAccountId().startsWith("S"));
	}

}
