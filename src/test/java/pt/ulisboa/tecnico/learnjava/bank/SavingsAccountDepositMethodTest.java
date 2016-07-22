package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidAccountDepositException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class SavingsAccountDepositMethodTest {
	SavingsAccount savings;

	@Before
	public void setUp() {
		savings = new SavingsAccount("António", 1000, 100);
	}

	@Test
	public void depositMultiple() throws NegativeAmmountException, InvalidAccountDepositException {
		savings.deposit(200);

		assertEquals(1200, savings.getBalance());
		assertEquals(2, savings.getPoints());
	}

	@Test
	public void depositDifferentMultiple() throws NegativeAmmountException, InvalidAccountDepositException {
		try {
			savings.deposit(250);
			fail();
		} catch (InvalidAccountDepositException e) {
			assertEquals(250, e.getValue());
			assertEquals(1000, savings.getBalance());
			assertEquals(0, savings.getPoints());
		}
	}

	@Test
	public void depositMultipleTwice() throws NegativeAmmountException, InvalidAccountDepositException {
		savings.deposit(200);
		savings.deposit(500);

		assertEquals(1700, savings.getBalance());
		assertEquals(7, savings.getPoints());
	}

	@After
	public void tearDown() {
		savings = null;
	}
}
