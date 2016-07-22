package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class CheckingAccountWithdrawMethodTest {
	CheckingAccount account;

	@Before
	public void setUp() {
		account = new CheckingAccount("António", 1000);
	}

	@Test
	public void testSingleWithdraw() throws NegativeAmmountException, InvalidWithdrawException {
		account.withdraw(500);
		assertEquals(500, account.getBalance());
	}

	@Test
	public void testMultipleWithdraw() throws NegativeAmmountException, InvalidWithdrawException {
		account.withdraw(500);
		account.withdraw(300);
		assertEquals(200, account.getBalance());
	}

	@Test
	public void testNegativeAmmount() throws InvalidWithdrawException {
		try {
			account.withdraw(-100);
			fail();
		} catch (NegativeAmmountException e) {
			assertEquals(1000, account.getBalance());
			assertEquals(-100, e.getValue());
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
