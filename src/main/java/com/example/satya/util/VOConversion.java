package com.example.satya.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.example.satya.db.vo.Address;
import com.example.satya.db.vo.Person;

public class VOConversion {

	public static com.example.satya.vo.Person convertDBVoToWSVo(Person person) {

		com.example.satya.vo.Person per = new com.example.satya.vo.Person();
		per.setAge(person.getAge());
		per.setFirstName(person.getFirstName());
		per.setLastName(person.getLastName());
		per.setMiddleName(person.getMiddleName());
		per.setGender(person.getGender());
		per.setPersonId(person.getPersonId());

		if (person.getAddress() != null && !person.getAddress().isEmpty()) {
			for (Iterator<Address> iterator = person.getAddress().iterator(); iterator.hasNext();) {
				Address address = iterator.next();
				com.example.satya.vo.Address addr = new com.example.satya.vo.Address();
				addr.setAddressId(address.getAddressId());
				// addr.setPersonId(address.getPerson().getPersonId());
				addr.setAddressLine1(address.getAddressLine1());
				addr.setAddressLine2(address.getAddressLine2());
				addr.setAddressType(address.getAddressType());
				addr.setCity(address.getCity());
				addr.setCountry(address.getCountry());
				addr.setDistrictCounty(address.getDistrictCounty());
				addr.setPinZipcode(address.getPinZipcode());
				addr.setState(address.getState());
				per.getAddress().add(addr);

			}
		}

		return per;
	}

	public static Person convertWSVoToDBVo(com.example.satya.vo.Person person) {
		Person per = new Person();
		per.setAge(person.getAge());
		per.setFirstName(person.getFirstName());
		per.setLastName(person.getLastName());
		per.setMiddleName(person.getMiddleName());
		per.setGender(person.getGender());
		//per.setPersonId(person.getPersonId());

		if (person.getAddress() != null && !person.getAddress().isEmpty()) {
			Set<Address> addressSet = new HashSet<Address>();
			for (Iterator<com.example.satya.vo.Address> iterator = person.getAddress().iterator(); iterator
					.hasNext();) {
				com.example.satya.vo.Address address = iterator.next();
				Address addr = new Address();
				//addr.setAddressId(address.getAddressId());
				//addr.setPersonId(person.getPersonId());
				addr.setAddressLine1(address.getAddressLine1());
				addr.setAddressLine2(address.getAddressLine2());
				addr.setAddressType(address.getAddressType());
				addr.setCity(address.getCity());
				addr.setCountry(address.getCountry());
				addr.setDistrictCounty(address.getDistrictCounty());
				addr.setPinZipcode(address.getPinZipcode());
				addr.setState(address.getState());
				//addr.setPerson(per);
				addressSet.add(addr);
			}
			per.setAddress(addressSet);
		}
		return per;
	}
}
