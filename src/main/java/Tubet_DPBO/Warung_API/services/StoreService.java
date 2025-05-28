package Tubet_DPBO.Warung_API.services;

import Tubet_DPBO.Warung_API.repos.StoreRepo;

/**
 * StoreService
 */
public class StoreService {
	public final StoreRepo storeRepo;

	public StoreService(StoreRepo storeRepo) {
		this.storeRepo = storeRepo;
	}

}
