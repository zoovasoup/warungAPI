package Tubet_DPBO.Warung_API.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tubet_DPBO.Warung_API.models.User;
import Tubet_DPBO.Warung_API.repos.UserRepo;
import Tubet_DPBO.Warung_API.utils.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
	private final UserRepo userRepo;

	public UserController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepo.getAll();
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User created = userRepo.put(user);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	// READ by ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) {
		User user = userRepo.getById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// UPDATE
	@PatchMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
		User updated = (User) userRepo.patch(id, user);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		boolean deleted = userRepo.delete(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
