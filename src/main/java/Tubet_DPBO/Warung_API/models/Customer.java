package Tubet_DPBO.Warung_API.models;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
	private ArrayList<CartItem> cart;

	public Customer(Name name, String email, String password, String username, String phoneNumber, Date dateOfBirth,
			boolean seller, ArrayList<CartItem> cart) {
		super(name, email, password, username, phoneNumber, dateOfBirth, seller);
		this.cart = cart;
	}

	public Customer(Name name, String email, String password, String username,
			String phoneNumber, java.util.Date dateOfBirth, boolean seller) {
		super(name, email, password, username, phoneNumber, dateOfBirth, seller);
		this.cart = new ArrayList<>();
	}

	public ArrayList<CartItem> getCart() {
		return cart;
	}

	public void setCart(ArrayList<CartItem> cart) {
		this.cart = cart;
	}

	public void addToCart(CartItem item) {
		this.cart.add(item);
	}

	public void clearCart() {
		this.cart.clear();
	}
}
