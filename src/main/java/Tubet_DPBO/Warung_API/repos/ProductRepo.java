package Tubet_DPBO.Warung_API.repos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Tubet_DPBO.Warung_API.models.Product;

/**
 * ProductRepo
 */
@Repository
public class ProductRepo {
	private Map<String, Product> database = new HashMap<>();
	private long idCounter = 1;

	public Product save(Product product) {
		String id = String.valueOf(idCounter++);
		product.setId(id);
		database.put(id, product);
		return product;
	}

	public List<Product> findAll() {
		testData();
		return List.copyOf(database.values());
	}

	public Product findById(String id) {
		return database.get(id);
	}

	public Product update(String id, Product product) {
		if (database.containsKey(id)) {
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

		Product a1 = new Product(
				"P001",
				"Sample Product",
				"This is a sample product for testing purposes.",
				49.99,
				new String[] {
						"https://example.com/images/product1.jpg",
						"https://example.com/images/product2.jpg"
				},
				new String[] { "Electronics", "Gadgets" },
				100,
				4);

		Product a2 = new Product(
				"P002",
				"Sample Product",
				"This is a sample product for testing purposes.",
				49.99,
				new String[] {
						"https://example.com/images/product1.jpg",
						"https://example.com/images/product2.jpg"
				},
				new String[] { "Electronics", "Gadgets" },
				100,
				4);

		database.put("1", a1);
		database.put("2", a2);
	}

}
