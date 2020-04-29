import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class ZStockMarketTest {
	private StockMarket sm;
	private Stock s;
	private User u;
	private Manager m;	
	private Client c;
	private PremiumClient p;	
	private Auditor a;	
	
	
	@Before
	public void setUp() throws Exception {
		sm = new StockMarket();
		s = new Stock("oxo",1,5);
		u = new User("u1","password");
		c = new Client("c1","password",1);		
		p = new PremiumClient("p1","password",1);		
		a = new Auditor("a1","password");
		m = new Manager("m1","password");
		
	}

	@Test
	public void testStockMarket() {
		String userN;
		userN = "u1";

		assertEquals(u.getUserName(),userN);			
		
	}

	@Test
	public void testAddStock() {
		sm.addStock(s);
		assertEquals(s.getStockCode(),"oxo");

	}

	@Test
	public void testRegisterUserUser() {
		
		sm.registerUser(u);
		assertEquals(u.getUserName(),"u1");		
		
	}

	@Test
	public void testRegisterUserManager() {
		
		sm.registerUser(m);
		assertEquals(m.getUserName(),"m1");	

	}

	@Test
	public void testRegisterUserClient() {
		
		sm.registerUser(c);
		assertEquals(c.getUserName(),"c1");	
	}

	@Test
	public void testRegisterUserPremiumClient() {
		sm.registerUser(p);
		assertEquals(p.getUserName(),"p1");	
	}

	@Test
	public void testRegisterUserAuditor() {
		sm.registerUser(a);
		assertEquals(a.getUserName(),"a1");			

	}

	@Test
	public void testLogin() throws IncorrectPasswordException, IncorrectUserTypeException, MustBePositiveException, InsufficientFundsException, UserDoesNotExistException {
		sm.registerUser(c);
		sm.login("c1", "password");
		PrintStream capture = null;
		System.setOut(capture);
		assertNotEquals(capture,"");
	}

	@Test (expected = UserDoesNotExistException.class)
	public void testWrongUserLogin() throws IncorrectPasswordException, IncorrectUserTypeException, MustBePositiveException, InsufficientFundsException, UserDoesNotExistException {
		sm.registerUser(c);
		
		sm.login("d1","password");
		
	}

	@Test (expected = IncorrectPasswordException.class)
	public void testWrongPasswordLogin() throws IncorrectPasswordException, IncorrectUserTypeException, MustBePositiveException, InsufficientFundsException, UserDoesNotExistException {
		sm.registerUser(c);
		
		sm.login("c1","wrongPassword");
		
	}	
	
	
	
}
