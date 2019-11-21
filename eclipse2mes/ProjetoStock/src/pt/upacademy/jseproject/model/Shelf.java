package pt.upacademy.jseproject.model;


public class Shelf extends Entity {
	
	private int productId = 0;
	private int cap = 0;
	private int pal = 0;

	

	public Shelf (int cap, int productId, int pal) {
	    this.cap = cap;
	    this.productId = productId;
	    this.pal = pal;

	
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public int getCap() {
		return cap;
	}



	public void setCap(int cap) {
		this.cap = cap;
	}



	public int getPal() {
		return pal;
	}



	public void setPal(int pal) {
		this.pal = pal;
	}



	@Override
	public String toString() {
		return "ID do produto = " + productId + "; Capacidade = " + cap + "; Preço de aluguer = " + pal + "";
	}



	
}
