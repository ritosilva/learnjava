package pt.ulisboa.tecnico.learnjava.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import pt.ulisboa.tecnico.learnjava.bank.exception.InvalidWithdrawException;
import pt.ulisboa.tecnico.learnjava.bank.exception.NegativeAmmountException;

public class SalaryAccountWithdrawMethodTest {
	SalaryAccount account;

	@Before
	public void setUp() {
		account = new SalaryAccount("António", 1000, 1000);
	}

	@Test
	public void balanceIsNegativeButAboveSalary() throws NegativeAmmountException, InvalidWithdrawException {
		account.withdraw(1500);

		assertEquals(-500, account.getBalance());
	}

	@Test
	public void balanceIsNegativeAndBellowSalary() throws NegativeAmmountException {
		try {
			account.withdraw(2500);
			fail();
		} catch (InvalidWithdrawException e) {
			assertEquals(1000, account.getBalance());
		}
	}

}
