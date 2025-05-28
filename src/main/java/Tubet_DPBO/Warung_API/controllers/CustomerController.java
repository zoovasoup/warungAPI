package Tubet_DPBO.Warung_API.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Tubet_DPBO.Warung_API.models.*;
import Tubet_DPBO.Warung_API.repos.UserRepo;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final UserRepo userRepo;

	public CustomerController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	// Mendapatkan data customer
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomer(@PathVariable String id) {
		User user = userRepo.getById(id);
		if (user instanceof Customer customer) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
	}

	// Mendapatkan isi cart customer
	@GetMapping("/{id}/cart")
	public ResponseEntity<?> getCart(@PathVariable String id) {
		User user = userRepo.getById(id);
		if (user instanceof Customer customer) {
			return new ResponseEntity<>(customer.getCart(), HttpStatus.OK);
		}
		return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
	}

	// Menambahkan produk ke cart
	@PostMapping("/{id}/cart")
	public ResponseEntity<?> addToCart(@PathVariable String id, @RequestBody CartItem item) {
		User user = userRepo.getById(id);
		if (!(user instanceof Customer customer)) {
			return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
		}

		if (item.getProduct() == null || item.getQuantity() <= 0) {
			return new ResponseEntity<>("Invalid product or quantity", HttpStatus.BAD_REQUEST);
		}

		customer.addToCart(item);
		return new ResponseEntity<>(item, HttpStatus.CREATED);
	}

	// Mengosongkan cart
	@DeleteMapping("/{id}/cart")
	public ResponseEntity<?> clearCart(@PathVariable String id) {
		User user = userRepo.getById(id);
		if (!(user instanceof Customer customer)) {
			return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
		}

		customer.clearCart();
		return new ResponseEntity<>("Cart cleared", HttpStatus.OK);
	}
}
