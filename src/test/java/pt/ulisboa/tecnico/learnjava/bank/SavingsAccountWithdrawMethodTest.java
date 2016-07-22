package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class SavingsAccountWithdrawMethodTest {
	SavingsAccount account;

	@Before
	public void setUp() {
		account = new SavingsAccount("António", 1000, 100);
	}

	@Test
	public void withdrawPartialBalance() throws NegativeAmmountException, InvalidWithdrawException {
		try {
			account.withdraw(500);
			fail();
		} catch (InvalidWithdrawException e) {
			assertEquals(1000, account.getBalance());
		}
	}

	@Test
	public void testWithdrawBelowBalance() throws NegativeAmmountException {
		try {
			account.withdraw(1100);
			fail();
		} catch (InvalidWithdrawException e) {
			assertEquals(1000, account.getBalance());
		}
	}

	@After
	public void tearDown() {
		account = null;
	}

}
