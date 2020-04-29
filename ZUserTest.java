import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZUserTest {
	private User c;

	
	@Before
	public void setUp() throws Exception {
		c = new User("Test Guy","password");	
	}

	@Test
	public void testUser() {
		String userN;
		userN = "Test Guy";

		assertEquals(c.getUserName(),userN);		
		
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
		passW = "password";

		c.setPassword(passW);
		assertEquals(c.getPassword(),passW);
	}

}
