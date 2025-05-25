package Tubet_DPBO.Warung_API.models;

/**
 * Address
 */
public class Address {

	private String street;
	private String city;
	private String province;
	private String zipCode;

	public Address(String street, String city, String province, String zipCode) {
		this.street = street;
		this.city = city;
		this.province = province;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getZipCode() {
		return zipCode;
	}
}
