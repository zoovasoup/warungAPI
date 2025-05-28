package Tubet_DPBO.Warung_API.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Product
 */
public class Product {

	private String id;
	private String title;
	private String description;
	private double price;
	private List<String> pictures;
	private List<String> categories;
	private int stock;
	private int rating;

	public Product(String id, String title, String description, double price,
			ArrayList<String> pictures, ArrayList<String> categories, int stock, int rating) {
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

	public void addPicture(String picture) {
		if (this.pictures == null) {
			this.pictures = new ArrayList<>();
		}
		this.pictures.add(picture);
	}

	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public void addCategory(String category) {
		if (this.categories == null) {
			this.categories = new ArrayList<>();
		}
		this.categories.add(category);
	}

	public String getTitle() {
		return title;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public List<String> getCategories() {
		return categories;
	}

}
