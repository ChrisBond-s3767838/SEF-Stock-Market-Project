import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ZPremiumClientTest {
	private PremiumClient c;

	@Before
	public void setUp() throws Exception {
		c = new PremiumClient("Test Guy","password",1);
	}


	@Test
	public void testPremiumClient() {
		String userN;
		userN = "Test Guy";

		assertEquals(c.getUserName(),userN);
	}

}
