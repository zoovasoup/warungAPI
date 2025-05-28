package Tubet_DPBO.Warung_API.models;

import java.util.ArrayList;

/**
 * Store
 */
public class Store {

	private String id;
	private String storeName;
	private String storeDescription;
	private String storePicture;
	private String storeAddress;
	private String storePhoneNumber;
	private User owner;
	private ArrayList<Product> products;

	public Store() {
		this.products = new ArrayList<>();
	};

	public Store(String id, String storeName, String storeDescription, String storePicture,
			String storeAddress, String storePhoneNumber, User owner, ArrayList<Product> products) {
		this.id = id;
		this.storeName = storeName;
		this.storeDescription = storeDescription;
		this.storePicture = storePicture;
		this.storeAddress = storeAddress;
		this.storePhoneNumber = storePhoneNumber;
		this.owner = owner;
		this.products = products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public User getOwner() {
		return owner;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", storeName=" + storeName + ", storeDescription=" + storeDescription
				+ ", storeAddress=" + storeAddress + ", storePhoneNumber=" + storePhoneNumber + "]";
	}

	public String getId() {
		return id;
	}

	public String getStoreName() {
		return storeName;
	}

	public String getStoreDescription() {
		return storeDescription;
	}

	public String getStorePicture() {
		return storePicture;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public String getStorePhoneNumber() {
		return storePhoneNumber;
	}
}
