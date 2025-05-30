package Tubet_DPBO.Warung_API.repos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Tubet_DPBO.Warung_API.models.Name;
import Tubet_DPBO.Warung_API.models.User;

/**
 * UserRepo
 */
@Repository
public class UserRepo implements RepoInterface<User> {

	private Map<String, User> database = new HashMap<>();
	private long idCounter = 1;

	public UserRepo() {
	}

	@Override
	public User put(User user) {
		String id = String.valueOf(idCounter++);
		database.put(id, user);
		return user;
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(database.values());
	}

	@Override
	public User getById(String id) {
		return database.get(id);
	}

	@Override
	public Object patch(String id, Object object) {
		User user = (User) object;
		if (database.containsKey(id)) {
			user.setId(id);
			database.put(id, user);
			return user;
		}
		return null;
	}

	@Override
	public boolean delete(String id) {
		return database.remove(id) != null;
	}

}
