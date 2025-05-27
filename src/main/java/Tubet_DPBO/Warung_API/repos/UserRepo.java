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
public class UserRepo {

	private Map<String, User> database = new HashMap<>();
	private long idCounter = 1;

	public void testData() {
		Name name = new Name("John", "Doe");
		Date date = new Date(10, 4, 2002);
		User test = new User(name, "email", "password", "username", "phoneNumber", date, false);
		database.put("1", test);
		database.put("2", test);
	}

	public User save(User user) {
		String id = String.valueOf(idCounter++);
		user.setId(id);
		database.put(id, user);
		return user;
	}

	public List<User> findAll() {

		Name name = new Name("John", "Doe");
		Name name2 = new Name("mantap", "soul");
		Date date = new Date(10, 4, 2002);
		User test = new User(name, "email", "password", "username", "phoneNumber", date, false);
		User test2 = new User(name2, "email", "password", "username", "phoneNumber", date, false);

		save(test);
		save(test);
		save(test);
		update("1", test2);
		return new ArrayList<>(database.values());
	}

	public User findById(String id) {
		return database.get(id);
	}

	public User update(String id, User user) {
		if (database.containsKey(id)) {
			user.setId(id);
			database.put(id, user);
			return user;
		}
		return null;
	}

	public boolean delete(String id) {
		return database.remove(id) != null;
	}

}
