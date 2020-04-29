import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ZClientTest {
	private Client c;

	@Before
	public void setUp() throws Exception {
		c = new Client("Test Guy","password",1);
		c.addStock("oxo", 1, 5);
	}

	@Test
	public void testClient() {
		String userN;
		userN = "Test Guy";

		assertEquals(c.getUserName(),userN);
	
	}

	@Test
	public void testAddFunds() throws MustBePositiveException {
		Integer funds;
		funds = 2;
		c.addFunds(1);
		assertEquals(c.getFunds(),funds);		
	}
	
	@Test (expected = MustBePositiveException.class)
	public void testAddNegativeFunds() throws MustBePositiveException {
		c.addFunds(-1);	
	}	

	@Test
	public void testGetFunds() {
		Integer funds;
		funds = 1;
		assertEquals(c.getFunds(),funds);
	}

	@Test
	public void testWithdrawFunds() throws MustBePositiveException, InsufficientFundsException {
		Integer funds;
		funds = 0;
		c.withdrawFunds(1);
		assertEquals(c.getFunds(),funds);
	}

	@Test (expected = MustBePositiveException.class)
	public void testNegativeWithdrawFunds() throws MustBePositiveException, InsufficientFundsException {
		c.withdrawFunds(-1);
		
	}	
	
	@Test (expected = InsufficientFundsException.class)
	public void testOverdrawnWithdrawFunds() throws MustBePositiveException, InsufficientFundsException {
		c.withdrawFunds(5);
		
	}		
	
	
	@Test
	public void testAddStock() throws Exception {
		c.addStock("oxo", 1, 100);
		assertEquals(c.getStock().size(),2);		
	}

	@Test
	public void testGetStock() {
		assertEquals(c.getStock().size(),1);
	}

	@Test
	public void testPrintAllStocks() {
		PrintStream capture = null;
		System.setOut(capture);
		
		assertNotEquals(capture,"");
	}

	@Test
	public void testSufficientStocks() {
		assertTrue(c.sufficientStocks(1));
	}
	
	@Test
	public void testInsufficientStocks() {
		assertTrue(c.sufficientStocks(2));
	}	

	@Test
	public void testRemoveStock() {
		c.removeStock("oxo");		
		assertEquals(c.getStock().size(),0);
	}

	@Test
	public void testUser() {
		String userN;
		userN = "Test Guy";
		assertEquals(((User)c).getUserName(),userN);		
		
	}

	@Test
	public void testGetUserName() {
		String userN;
		userN = "Test Guy";
		assertEquals(c.getUserName(),userN);		
	}

	@Test
	public void testSetUserName() {
		String userN;
		userN = "Test2";
		c.setUserName(userN);
		
		assertEquals(c.getUserName(),userN);		
		
	}

	@Test
	public void testGetPassword() {
		String passW;
		passW = "password";		
		assertEquals(c.getPassword(),passW);			
	}

	
	
	@Test
	public void testSetPassword() {
		String passW;
		passW = "Test2";
		c.setPassword(passW);
		
		assertEquals(c.getPassword(),passW);	
	}

}
