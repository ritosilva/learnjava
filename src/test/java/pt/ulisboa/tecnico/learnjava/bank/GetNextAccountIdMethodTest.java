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
	public void createCheckingAccount() {
		account = new CheckingAccount("António", 1000);

		assertTrue(account.getAccountId().startsWith("CK"));
	}

	@Test
	public void createSavingsAccount() {
		account = new SavingsAccount("António", 1000, 100);

		assertTrue(account.getAccountId().startsWith("SV"));
	}

	@Test
	public void createSalaryAccount() {
		account = new SalaryAccount("António", 1000, 1500);

		assertTrue(account.getAccountId().startsWith("SL"));
	}

}
