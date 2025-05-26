package Tubet_DPBO.Warung_API.models;

import java.util.Date;

/**
 * User
 */
public class User {

	private String id;
	private Name name;
	private String email;
	private String password;
	private String username;
	private String phoneNumber;
	private Date dateOfBirth;
	private boolean seller;
	private Address address;

	public User(Name name, String email, String password, String username, String phoneNumber, Date dateOfBirth,
			boolean seller) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.seller = seller;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public boolean isSeller() {
		return seller;
	}

	public String getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

}
