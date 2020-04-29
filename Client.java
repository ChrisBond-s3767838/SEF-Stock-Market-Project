import java.util.ArrayList;

public class Client extends User{
	Integer funds;
	private ArrayList<Stk> ownedStock = new ArrayList<Stk>();	
	
	public Client(String userName, String password,Integer intialFunds) {
		super(userName,password);
		this.funds = intialFunds;
	}
	
	public void addFunds(Integer funds) throws MustBePositiveException {
		if (BasicCheck.notNegative(funds)) {
			this.funds = this.funds + funds;
		}
		else {
			throw new MustBePositiveException();
		}
	}
	
	public Integer getFunds() {
		return funds;
	}
	
	//check enough funds
	private boolean sufficientFunds(Integer funds) {
		
		return BasicCheck.notNegative(this.funds - funds);		
		
	}	
	
	
	//check enough funds
	public void withdrawFunds(Integer funds) throws MustBePositiveException, InsufficientFundsException {
		if (BasicCheck.notNegative(funds)) {
			if (sufficientFunds(funds)) {
				this.funds = this.funds - funds;				
			}
			else {
				throw new InsufficientFundsException();
			}	
		}
		else {
			throw new MustBePositiveException();
		}		
		
	}
	
	public void addStock(String stockCode,Integer volume) throws Exception {
		Stk interimStock = new Stk(stockCode,volume);		
		
		ownedStock.add(interimStock);
	}
	
	//allows the caller to view any attribute they want
	public ArrayList<Stk> getStock() {
		return ownedStock;
	}
	
	public void printAllStocks() {
		// loop through the stocks
		for (int i = 0; i <  ownedStock.size(); i++) {
			String stockCode;
			Integer stockVolume;
			
			stockCode = ownedStock.get(i).getStockCode();
			stockVolume = ownedStock.get(i).getStockVolume();
			System.out.println("Stock Code: " + stockCode);
			System.out.println("Volume: " + stockVolume);			
		}
		
		
	}
	
	

//	private void reduceStockVolume(Stock interimStock, Integer reducedStocks) {
//		
//	}

	//check enough stocks
	public boolean sufficientStocks(Integer reducedStocks) {
		
		return BasicCheck.notNegative(this.funds - funds);		
	}	
	
	
	
//	public void addStockVolume(Stock interimStock, Integer additionalStocks) {
//		
//	}
	
	
	
	public void removeStock(String stock) {
		for (int i=0; i < ownedStock.size(); i++) {
			String stockCode;
			stockCode = ownedStock.get(i).getStockCode();
			
			if(stockCode == stock) {
				ownedStock.remove(i);
			}
		}
	}
}
