package Tubet_DPBO.Warung_API.repos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Tubet_DPBO.Warung_API.models.Product;

/**
 * ProductRepo
 */
@Repository
public class ProductRepo implements RepoInterface<Product> {
	private Map<String, Product> database = new HashMap<>();
	private long idCounter = 1;

	public ProductRepo() {
		testData();
	}

	@Override
	public Product put(Product product) {
		String id = String.valueOf(idCounter++);
		database.put(id, product);
		return product;
	}

	@Override
	public List<Product> getAll() {
		return List.copyOf(database.values());
	}

	public Product getById(String id) {
		return database.get(id);
	}

	@Override
	public Product patch(String id, Object object) {
		if (database.containsKey(id)) {
			Product product = (Product) object;
			product.setId(id);
			database.put(id, product);
			return product;
		}
		return null;
	}

	public boolean delete(String id) {
		return database.remove(id) != null;
	}

	public void testData() {

		ArrayList<String> imageUrls = new ArrayList<>(List.of(
				"https://example.com/images/product1.jpg",
				"https://example.com/images/product2.jpg"));

		ArrayList<String> categories = new ArrayList<>(List.of("Electronics", "Gadgets"));

		Product a1 = new Product(
				"P001",
				"Sample Product",
				"This is a sample product for testing purposes.",
				49.99,
				new ArrayList<>(List.of(
						"https://example.com/images/product1.jpg",
						"https://example.com/images/product2.jpg")),
				new ArrayList<>(List.of("Electronics", "Gadgets")),
				100,
				4);

		Product a2 = new Product(
				"P002",
				"Sample Product",
				"This is a sample product for testing purposes.",
				49.99,
				new ArrayList<>(List.of(
						"https://example.com/images/product1.jpg",
						"https://example.com/images/product2.jpg")),
				new ArrayList<>(List.of("Electronics", "Gadgets")),
				100,
				4);

		Product a3 = new Product(
				"P003",
				"Sample Product",
				"This is a sample product for testing purposes.",
				49.99,
				new ArrayList<>(List.of(
						"https://example.com/images/product1.jpg",
						"https://example.com/images/product2.jpg")),
				new ArrayList<>(List.of("Electronics", "Gadgets")),
				100,
				4);

		put(a1);
		put(a2);
		put(a3);
	}

}
