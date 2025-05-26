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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
		return userRepo.findAll();
	}
}
