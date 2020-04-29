
public class Stk {
	private String stockCode;
	private Integer stockVolume;
	private Integer minimumStockVolume = 1;				//The minimum number of shares is 1
	
	public Stk(String stockCode,Integer stockVolume) {
		// TODO Auto-generated constructor stub
			this.stockCode = stockCode;
			this.stockVolume = stockVolume;
	}

	public String getStockCode() {
		return stockCode;
	}

	public Integer getStockVolume() {
		return stockVolume;
	}
	
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}	

	public void setStockVolume(Integer stockVolume) throws VolumeTooLowException{
		if(stockVolumeBelowMinimum(stockVolume)) {
			throw new VolumeTooLowException();
		}
		else {
			this.stockVolume = stockVolume;

		}
	}

	  public void setMinStockVolume(Integer stockVolume) throws	  MustBePositiveException { 
		  //Check that the value isn't negative
		  if(BasicCheck.notNegative(stockVolume) ) { 
			  this.stockVolume = stockVolume; 
			  } 
		  else
		  { 
			  throw new MustBePositiveException(); 
			  }
	  }

		private Boolean stockVolumeBelowMinimum(Integer newStockVolume) {
			return (newStockVolume < minimumStockVolume);
		}	
	
}
