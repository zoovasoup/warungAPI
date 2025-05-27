package Tubet_DPBO.Warung_API.repos;

import java.util.List;

import Tubet_DPBO.Warung_API.models.Product;

/**
 * RepoInterface
 */
public interface RepoInterface<T> {

	T put(T object);

	Object patch(String id, Object object);

	Object getById(String id);

	List<T> getAll();

	boolean delete(String id);

}
