package Tubet_DPBO.Warung_API.repos;

import Tubet_DPBO.Warung_API.models.*;
import java.util.*;

/**
 * TestData
 */
public class TestData {

	public void populateTestProducts(Map<String, Product> productMap) {
		List<Product> products = List.of(
				createProduct("P001"),
				createProduct("P002"),
				createProduct("P003"));

		for (Product p : products) {
			productMap.put(p.getId(), p);
		}
	}

	public void populateTestUsers(Map<String, User> userMap, long idCounterStart) {
		Name name1 = new Name("John", "Doe");
		Name name2 = new Name("Mantap", "Soul");

		Date birthDate = new Date(2002 - 1900, 4 - 1, 10); // Deprecated, tapi cukup untuk testing

		User user1 = new User(name1, "email1@example.com", "password", "john_doe", "08111111111", birthDate, true);
		user1.setId(String.valueOf(idCounterStart++));

		User user2 = new User(name2, "email2@example.com", "password", "mantap_soul", "08222222222", birthDate, true);
		user2.setId(String.valueOf(idCounterStart++));

		userMap.put(user1.getId(), user1);
		userMap.put(user2.getId(), user2);
	}

	public void populateTestStores(Map<String, Store> storeMap, User seller, long idCounterStart) {
		if (seller == null) {
			System.out.println("Tidak ada seller. Tidak bisa buat store dummy.");
			return;
		}

		List<Product> store1Products = List.of(
				new Product("P001", "Indomie", "Mie goreng instan", 3000.0, new ArrayList<>(),
						new ArrayList<>(List.of("Makanan")), 50, 5),
				new Product("P002", "Teh Botol", "Minuman teh manis", 4000.0, new ArrayList<>(),
						new ArrayList<>(List.of("Makanan")), 50, 5));

		List<Product> store2Products = List.of(
				new Product("P001", "Indomie", "Mie goreng instan", 3000.0, new ArrayList<>(),
						new ArrayList<>(List.of("Makanan")), 50, 5),
				new Product("P002", "Mie Sedap", "Mie goreng instan", 2500.0, new ArrayList<>(),
						new ArrayList<>(List.of("Makanan")), 50, 5),
				new Product("P003", "Teh Botol", "Minuman teh manis", 4000.0, new ArrayList<>(),
						new ArrayList<>(List.of("Makanan")), 50, 5));

		Store store1 = new Store(
				String.valueOf(idCounterStart++),
				"Warung Maju Jaya",
				"Sembako dan jajanan",
				"https://example.com/pic1.jpg",
				"Jl. Melati No.1",
				"08123456789",
				seller,
				new ArrayList<>(store1Products));

		Store store2 = new Store(
				String.valueOf(idCounterStart++),
				"Toko Sehat",
				"Menjual produk kesehatan",
				"https://example.com/pic2.jpg",
				"Jl. Sehat No.2",
				"08987654321",
				seller,
				new ArrayList<>(store2Products));

		storeMap.put(store1.getId(), store1);
		storeMap.put(store2.getId(), store2);
	}

	private Product createProduct(String id) {
		return new Product(
				id,
				"Sample Product " + id,
				"This is a sample product for testing purposes.",
				49.99,
				new ArrayList<>(List.of(
						"https://example.com/images/product1.jpg",
						"https://example.com/images/product2.jpg")),
				new ArrayList<>(List.of("Electronics", "Gadgets")),
				100,
				4);
	}
}
