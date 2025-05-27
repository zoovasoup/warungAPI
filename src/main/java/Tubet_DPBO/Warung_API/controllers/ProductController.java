package Tubet_DPBO.Warung_API.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tubet_DPBO.Warung_API.models.Product;
import Tubet_DPBO.Warung_API.repos.ProductRepo;

/**
 * ProductController
 */
@RestController
@RequestMapping("api/products")
public class ProductController {
	private final ProductRepo productRepo;

	public ProductController(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(Product product) {
		Product created = productRepo.put(product);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<Product> getAllProduct() {
		return productRepo.getAll();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable String id, Product product) {
		Product updated = productRepo.patch(id, product);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
		boolean product = productRepo.delete(id);
		if (productRepo.delete(id)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
