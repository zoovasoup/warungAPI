package Tubet_DPBO.Warung_API.models;

/**
 * Product
 */
public class Product {

	private String id;
	private String title;
	private String description;
	private double price;
	private String[] pictures;
	private String[] categories;
	private int stock;
	private int rating;

	public Product(String id, String title, String description, double price,
			String[] pictures, String[] categories, int stock, int rating) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pictures = pictures;
		this.categories = categories;
		this.stock = stock;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String gettitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getPictures() {
		return pictures;
	}

	public void setPictures(String[] pictures) {
		this.pictures = pictures;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
