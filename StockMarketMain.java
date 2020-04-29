
public class StockMarketMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		StockMarket sm = new StockMarket();
		
		//Create a stock arraylist, with some hardcoded values first, then reference another class later
		
		
		
		//Hardcoded Values
		Stock oxo = new Stock("OXO",10000,250);
		Stock ria = new Stock("Ria",10000,340);
		Stock nibc = new Stock("NIBC",10000,290);
		Stock vienta = new Stock("Vienta",10000,170);
		Stock bht = new Stock("BHT",10000,260);
		Stock cones = new Stock("Cones",10000,470);	
	
		sm.addStock(oxo);
		sm.addStock(ria);
		sm.addStock(nibc);
		sm.addStock(vienta);
		sm.addStock(bht);		
		sm.addStock(cones);	
	
		
		//Hardcoded register user
		Manager mgr = new Manager("John", "password");
		Client client1 = new Client("Tim", "password",2000);
		Client client2 = new Client("Audrey", "password",1000);
		PremiumClient moneyman = new PremiumClient("Richy","password",100000);
		Auditor auditor = new Auditor("Evey", "password");
		
		sm.registerUser(mgr);
		sm.registerUser(client1);
		sm.registerUser(client2);
		sm.registerUser(moneyman);
		sm.registerUser(auditor);

		moneyman.addStock("OXO", 100);
		moneyman.addStock("BHT", 1000);
		client1.addStock("OXO", 100);
		
		
		sm.entryScreen();
		
	}

	
	
	
}
