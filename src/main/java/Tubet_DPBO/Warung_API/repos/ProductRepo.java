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

}
