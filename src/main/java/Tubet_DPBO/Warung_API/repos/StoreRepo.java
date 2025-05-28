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

	public Store getByOwnerId(String ownerId) {
		return storeDatabase.values()
				.stream()
				.filter(s -> s.getOwner() != null && s.getOwner().getId().equals(ownerId))
				.findFirst()
				.orElse(null);
	}

}
