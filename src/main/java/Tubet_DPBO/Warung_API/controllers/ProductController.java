package Tubet_DPBO.Warung_API.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/all")
	public List<Product> getAllProduct() {
		return productRepo.getAll();
	}

}
