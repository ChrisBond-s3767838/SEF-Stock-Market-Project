import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ZStockTest {

	private Stock s;
	
	@Before
	public void setUp() throws Exception {
		s = new Stock("oxo",1,5);
	
	}
	
	
	@Test
	public void testStockConstructor() {
		Integer a = 5;
		assertEquals(a,s.getStockPrice());
	}

	
	@Test
	public void testGetStockCode() {
		String a = "oxo";
		assertEquals(a,s.getStockCode());
	}

	//Positive Test
	@Test
	public void testSetStockCode() {
		String a = "omo";
		s.setStockCode(a);
		assertEquals(s.getStockCode(),"omo");
	}
	
	
	
	//Negative Test - setting a negative value
	@Test (expected = PriceRulesViolatedException.class)
	public void testSetNegativeValueStockPrice() throws PriceRulesViolatedException {
		Integer a = -1;
		s.modifyStockPrice(a);
	}	
	
	//add test for setting something beyond +-5 cents
	@Test (expected = PriceRulesViolatedException.class)
	public void testSetBeyondThesholdValueStockPrice() throws PriceRulesViolatedException {
		Integer a = 20;
		s.modifyStockPrice(a);
	}		
	
	//test modify stock price works
	@Test 
	public void testModifyStockPrice() throws PriceRulesViolatedException {
		Integer a = 9;
		s.modifyStockPrice(a);
		assertEquals(s.getStockPrice(),a);		
	}		
	
	
	
	@Test
	public void testGetStockVolume() {
		Integer a = 1;
		assertEquals(s.getStockVolume(),a);
	}

	@Test
	public void testSetStockVolume() throws VolumeTooLowException {
		Integer a = 2;
		s.setStockVolume(a);
		assertEquals(s.getStockVolume(),a);
	}

	@Test
	public void testGetStockPrice() {
		Integer a = 5;
		assertEquals(s.getStockPrice(),a);		
	}

	@Test
	public void testIntialiseStockPrice() throws PriceRulesViolatedException {
		Integer a = 10;
		s.initialiseStockPrice(a);
		assertEquals(s.getStockPrice(),a);
	}
	
	@Test
	public void testMinStockVolume() throws MustBePositiveException {
		Integer a = 10;
		s.setMinStockVolume(a);
		assertEquals(s.getStockVolume(),a);
	}
	
	
	//Set a negative value and check an error is thrown
	@Test (expected = MustBePositiveException.class)
	public void setMinStockVolumeTest() throws MustBePositiveException {
		Integer a = -1;
		s.setMinStockVolume(a);
	}


	//set the minimum stock price to a negative value
	@Test (expected = MustBePositiveException.class)
	public void setMinStockPriceTest() throws MustBePositiveException {
		Integer a = -1;
		s.setMinStockPrice(a);
	}	
	
	
	@Test (expected = MustBePositiveException.class)
	public void setPriceThresholdTest() throws MustBePositiveException {
		Integer a = -1;
		s.setPriceThreshold(a);
	}	
	
	@Test (expected = VolumeTooLowException.class)
	public void testStockVolumeTooLow() throws VolumeTooLowException {
		Integer a = -1;
		s.setStockVolume(a);
	}	
	
	@Test (expected = PriceRulesViolatedException.class)
	public void testIntialPriceBelowMinimum() throws PriceRulesViolatedException {
		Integer a = -1;
		s.initialiseStockPrice(a);
	}	
	
	//setPriceThreshold
	@Test 
	public void testPriceThresholdCorrect() throws MustBePositiveException {
		Integer a = 1;
		s.setPriceThreshold(a);
		
	}		

	//setMinStockPrice
	@Test 
	public void testSetMinStockPrice() throws MustBePositiveException {
		Integer a = 1;
		s.setMinStockPrice(a);
		
	}		
}
