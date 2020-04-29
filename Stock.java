import java.lang.Math;
import java.util.ArrayList;

public class Stock extends Stk {
//This class provides the Stock Structure and constructor to allow stocks to be created

	private Integer stockPrice;
	//Hardcode these value in the first instance, later elevate to the StockMarketLevel
	private Integer minimumStockPrice = 5; 				//The minimum stock price is 5 cents
	private Integer priceThreshold = 5;					//The maximum allowable variance in bid price is 5 cents
	private ArrayList<Offer> buyQueue = new ArrayList<Offer>();
	private ArrayList<Offer> sellQueue = new ArrayList<Offer>();
	

	
	
	public Stock(String stockCode,Integer stockVolume,Integer stockValue) throws Exception {
		super(stockCode,stockVolume);
		this.initialiseStockPrice(stockValue);
		
	}

	
	public void addToBuyQueue(Offer stock) {
		this.buyQueue.add(stock);		
	}
	
	public void addToSellQueue(Offer stock) {
		this.sellQueue.add(stock);
	}

	public void removeFromBuyQueue(Offer stock) {
		this.buyQueue.remove(stock);		
	}
	
	public void removeFromSellQueue(Offer stock) {
		this.sellQueue.remove(stock);		
	}	
	
	
	public Integer getStockPrice() {
		return stockPrice;
	}
	
	// Used to set Stock Price first time
	public void initialiseStockPrice(Integer stockPrice) throws PriceRulesViolatedException {
		
		//Rule 1. New Price Can't be less than 5 cents
		if (stockPriceBelowMinimum(stockPrice)) {
			throw new PriceRulesViolatedException();
		}
		else {
			
			this.stockPrice = stockPrice;		
		}
	}
	
	
	
	//Used for any modification of Stock Price
	public void modifyStockPrice(Integer stockPrice) throws PriceRulesViolatedException {
		
		//Rule 1. New Price Can't be less than 5 cents
		//Rule 2. New Price Must be within 5 cents of current price
		if (stockPriceBelowMinimum(stockPrice) || stockPriceOutsideThreshold(stockPrice)) {
			throw new PriceRulesViolatedException();
		}
		else {
			
			this.stockPrice = stockPrice;
			
		}
		
	}


	//setters for rules, should be elevated at a later stage
	
	  
	  public void setMinStockPrice(Integer stockPrice) throws MustBePositiveException { 
		  if(BasicCheck.notNegative(stockPrice)) {
			  	this.minimumStockPrice = stockPrice; 
			  	} 
	  else { 
		  throw new	  MustBePositiveException(); 
		  } 
	  }
	  
	  public void setPriceThreshold(Integer priceThreshold) throws MustBePositiveException { 
		  if(BasicCheck.notNegative(priceThreshold)) {
			  	this.priceThreshold = priceThreshold; 
			  	} 
		  else { 
			  throw new	  MustBePositiveException(); 
			  } 
		  }
	  
	  private Boolean stockPriceOutsideThreshold(Integer newStockPrice) {
		Integer priceVariance;
		// work out what the difference between the new and old prices are
		priceVariance = Math.abs(newStockPrice-getStockPrice());
		
		// compare the variance with the maximum allowable variance
		return (priceVariance > priceThreshold);
				
	}
	
	private Boolean stockPriceBelowMinimum(Integer newStockPrice) {
		return (newStockPrice < minimumStockPrice);
	}
		
	
	public Offer getSellOffer(Integer i) {
		return sellQueue.get(i);
	}
	
	public Offer getBuyOffer(Integer i) {
		return buyQueue.get(i);
	}	
	
	

	public void printBuyQueue() {
		System.out.println("Buying:");
		for (int i = 0 ; i < buyQueue.size(); i++) {
			System.out.println(buyQueue.get(i).getClient() + " is offering " + buyQueue.get(i).getPrice() + " for " + buyQueue.get(i).getQuantity() + " stocks.");
		}
	}
	
	public void printSellQueue() {
		System.out.println("Selling:");		
		for (int i = 0 ; i < sellQueue.size(); i++) {
			System.out.println(sellQueue.get(i).getClient() + " is offering " + sellQueue.get(i).getPrice() + " for " + sellQueue.get(i).getQuantity() + " stocks.");
		}
	}	
	
		
	
}
