package Tubet_DPBO.Warung_API.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Tubet_DPBO.Warung_API.models.Product;
import Tubet_DPBO.Warung_API.models.Store;
import Tubet_DPBO.Warung_API.models.User;
import Tubet_DPBO.Warung_API.repos.StoreRepo;
import Tubet_DPBO.Warung_API.repos.UserRepo;

/**
 * StoreController
 */
@RestController
@RequestMapping("/api/stores")
public class StoreController {

	private final StoreRepo storeRepo;
	private final UserRepo userRepo;

	public StoreController(StoreRepo storeRepo, UserRepo userRepo) {
		this.storeRepo = storeRepo;
		this.userRepo = userRepo;
	}

	// Membuat store - hanya untuk seller
	@PostMapping
	public ResponseEntity<?> createStore(@RequestParam String userId, @RequestBody Store store) {
		User user = userRepo.getById(userId);
		if (user == null || !user.isSeller()) {
			return new ResponseEntity<>("Only sellers can create stores", HttpStatus.FORBIDDEN);
		}

		store.setOwner(user);
		store.setId(UUID.randomUUID().toString());
		storeRepo.put(store);
		return new ResponseEntity<>(store, HttpStatus.CREATED);
	}

	// Mendapatkan detail store (informasi + owner + produk)
	@GetMapping("/{id}")
	public ResponseEntity<?> getStoreDetail(@PathVariable String id) {
		Store store = storeRepo.getById(id);
		if (store == null) {
			return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(store, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAllStores() {
		List<Store> allStores = storeRepo.getAll();

		// Buat list yang hanya menyertakan store tanpa produk
		List<Store> storesWithoutProducts = allStores.stream().map(store -> new Store(
				store.getId(),
				store.getStoreName(),
				store.getStoreDescription(),
				store.getStorePicture(),
				store.getStoreAddress(),
				store.getStorePhoneNumber(),
				store.getOwner(),
				new ArrayList<>() // produk dikosongkan
		)).collect(Collectors.toList());

		return new ResponseEntity<>(storesWithoutProducts, HttpStatus.OK);
	}

	// Tambah produk ke store
	@PostMapping("/{storeId}/products")
	public ResponseEntity<?> addProduct(@PathVariable String storeId, @RequestBody Product product) {
		Store store = storeRepo.getById(storeId);
		if (store == null) {
			return new ResponseEntity<>("Store not found", HttpStatus.NOT_FOUND);
		}

		product.setId(UUID.randomUUID().toString());
		store.getProducts().add(product);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
}
