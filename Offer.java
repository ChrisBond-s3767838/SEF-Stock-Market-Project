
public class Offer{
	private Integer offerPrice;
	private Integer offerQuantity;
	private Client client;
		
		
		public Offer(Integer offerPrice, Integer offerQty, Client client) {
			this.offerPrice = offerPrice;
			this.offerQuantity = offerQty;
			this.client = client;
		}
		
		public Client getClient() {
			return client;
		}
		
		public void adjustOfferPrice(Integer newOffer) {
			this.setPrice(newOffer);
		}	
		
		
		

		public Integer getPrice() {
			return offerPrice;
		}

		public void setPrice(Integer offerPrice) {
			this.offerPrice = offerPrice;
		}

		public Integer getQuantity() {
			return offerQuantity;
		}

		public void setQuantity(Integer quantity) {
			this.offerQuantity = quantity;
		}
		
		public void setClient(Client client) {
			this.client = client;
		}
		
		
		
}
