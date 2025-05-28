package Tubet_DPBO.Warung_API.services;

import Tubet_DPBO.Warung_API.repos.UserRepo;

/**
 * UserService
 */
public class UserService {
	public final UserRepo userRepo;

	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

}
