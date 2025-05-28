package Tubet_DPBO.Warung_API.models;

public class CartItem {
	private Product product;
	private int quantity;
	private double totalPrice;

	public CartItem() {
	}

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public double getTotalPrice() {
		return product.getPrice() * quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
