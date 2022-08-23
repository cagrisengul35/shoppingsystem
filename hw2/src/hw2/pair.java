package hw2;

public class pair {
	private product product;
	private int amount;
	
	public pair(product product, int amount) {
		this.setPairProduct(product);
		this.setPairAmount(amount);
	}
	
	
	public product getPairProduct() {
		return product;
	}

	public void setPairProduct(product product) {
		this.product = product;
	}

	public int getPairAmount() {
		return amount;
	}

	public void setPairAmount(int amount) {
		this.amount = amount;
	}
}
