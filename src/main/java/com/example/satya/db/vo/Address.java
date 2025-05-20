package com.example.satya.db.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Address")
public class Address //implements Serializable 
{
	
	@Id
	@UserId
	@Column(name = "AddressId")
	private String addressId;
	
	@Column(name = "AddressLine1")
	private String addressLine1;
	
	@Column(name = "AddressLine2")
	private String addressLine2;
	
	@Column(name = "PinZipcode")
	private String pinZipcode;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "DistrictCounty")
	private String districtCounty;
	
	@Column(name = "AddressType")
	private String addressType;
	
	@Column(name = "State")
	private String State;
	
	@ManyToOne
	@JoinColumn(name = "PersonId")
	private Person Person;
	
	@Transient
	private String personId;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPinZipcode() {
		return pinZipcode;
	}

	public void setPinZipcode(String pinZipcode) {
		this.pinZipcode = pinZipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrictCounty() {
		return districtCounty;
	}

	public void setDistrictCounty(String districtCounty) {
		this.districtCounty = districtCounty;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Person getPerson() {
		return Person;
	}

	public void setPerson(Person person) {
		Person = person;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
/*
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [addressId=");
		builder.append(addressId);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", pinZipcode=");
		builder.append(pinZipcode);
		builder.append(", country=");
		builder.append(country);
		builder.append(", city=");
		builder.append(city);
		builder.append(", districtCounty=");
		builder.append(districtCounty);
		builder.append(", addressType=");
		builder.append(addressType);
		builder.append(", State=");
		builder.append(State);
		builder.append(", Person=");
		builder.append(Person);
		builder.append(", personId=");
		builder.append(personId);
		builder.append("]");
		return builder.toString();
	}
*/
}
