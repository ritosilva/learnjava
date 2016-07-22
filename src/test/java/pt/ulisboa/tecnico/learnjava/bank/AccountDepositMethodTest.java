package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidAccountDepositException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class AccountDepositMethodTest {
	Account account;

	@Before
	public void setUp() {
		account = new Account();
	}

	@Test
	public void testSingleDeposit() throws NegativeAmmountException, InvalidAccountDepositException {
		account.deposit(600);
		assertEquals(600, account.getBalance());
	}

	@Test
	public void testMultipleDeposit() throws NegativeAmmountException, InvalidAccountDepositException {
		account.deposit(600);
		account.deposit(500);
		assertEquals(1100, account.getBalance());
	}

	@Test
	public void testNegativeDeposit() throws NegativeAmmountException, InvalidAccountDepositException {
		account.deposit(600);

		try {
			account.deposit(-100);
		} catch (NegativeAmmountException nae) {
			assertEquals(-100, nae.getValue());
			assertEquals(600, account.getBalance());
		}
	}

	@After
	public void tearDown() {
		account = null;
	}

}
