package Tubet_DPBO.Warung_API.repos;

import org.springframework.stereotype.Repository;

import Tubet_DPBO.Warung_API.models.Name;
import Tubet_DPBO.Warung_API.models.Product;
import Tubet_DPBO.Warung_API.models.Store;
import Tubet_DPBO.Warung_API.models.User;

import java.util.*;

/**
 * StoreRepo
 */
@Repository
public class StoreRepo implements RepoInterface<Store> {

	private Map<String, Store> storeDatabase = new HashMap<>();
	private UserRepo userRepo;
	private long idCounter = 1;

	public StoreRepo(UserRepo userRepo) {
		this.userRepo = userRepo;

		testData();
	}

	@Override
	public Store put(Store store) {
		String id = String.valueOf(idCounter++);
		store.setId(id);
		storeDatabase.put(id, store);
		return store;
	}

	@Override
	public List<Store> getAll() {
		return new ArrayList<>(storeDatabase.values());
	}

	@Override
	public Store getById(String id) {
		return storeDatabase.get(id);
	}

	@Override
	public Object patch(String id, Object object) {
		Store store = (Store) object;
		if (storeDatabase.containsKey(id)) {
			store.setId(id); // pastikan ID tetap sama
			storeDatabase.put(id, store);
			return store;
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		return storeDatabase.remove(id) != null;
	}

	// Optional method: jika kamu mau cari berdasarkan user
	public Store getByOwnerId(String ownerId) {
		return storeDatabase.values()
				.stream()
				.filter(s -> s.getOwner() != null && s.getOwner().getId().equals(ownerId))
				.findFirst()
				.orElse(null);
	}

	private void testData() {
		User existingSeller = userRepo.getAll()
				.stream()
				.filter(User::isSeller)
				.findFirst()
				.orElse(null);

		if (existingSeller == null) {
			System.out.println("Tidak ada seller di UserRepo. Tidak bisa buat store dummy.");
			return;
		}

		ArrayList<Product> products1 = new ArrayList<>();
		products1.add(new Product("P001", "Indomie", "Mie goreng instan", 3000.0,
				new String[] {}, new String[] { "Makanan" }, 50, 5));
		products1.add(new Product("P002", "Teh Botol", "Minuman teh manis", 4000.0,
				new String[] {}, new String[] { "Minuman" }, 20, 4));

		ArrayList<Product> products2 = new ArrayList<>();
		products2.add(new Product("P003", "Sabun Lifebuoy", "Sabun mandi antiseptik", 6000.0,
				new String[] {}, new String[] { "Kesehatan" }, 15, 5));

		Store store1 = new Store(
				String.valueOf(idCounter),
				"Warung Maju Jaya",
				"Sembako dan jajanan",
				"https://example.com/pic1.jpg",
				"Jl. Melati No.1",
				"08123456789",
				existingSeller,
				products1);
		idCounter++;
		storeDatabase.put(store1.getId(), store1);

		Store store2 = new Store(
				String.valueOf(idCounter),
				"Toko Sehat",
				"Menjual produk kesehatan",
				"https://example.com/pic2.jpg",
				"Jl. Sehat No.2",
				"08987654321",
				existingSeller,
				products2);
		idCounter++;
		storeDatabase.put(store2.getId(), store2);
	}
}
