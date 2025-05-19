package com.example.satya.ws;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.satya.vo.Address;
import com.example.satya.vo.CreatePersonRequest;
import com.example.satya.vo.CreatePersonResponse;
import com.example.satya.vo.GetPersonRequest;
import com.example.satya.vo.GetPersonResponse;
import com.example.satya.vo.Person;

@Endpoint
public class PersonalInformationEndpoint {

	@PayloadRoot(namespace = "http://vo.satya.example.com", localPart = "GetPersonRequest")
	@ResponsePayload
	public GetPersonResponse getPersonBiography(@RequestPayload GetPersonRequest getPersonRequest) {
		Person person = new Person();
		String personId = getPersonRequest.getPersonId();
		System.out.println("*************************** fetching record for id ****************************************"
				+ personId);
		System.out.println("Inside payload root");
		person.setPersonId("84hfur839399");
		person.setFirstName("Satyananda");
		person.setLastName("Sahu");
		Address address = new Address();
		address.setAddressId("923843298");
		person.getAddress().add(address);
		GetPersonResponse personResponse = new GetPersonResponse();
		personResponse.setPerson(person);
		return personResponse;
	}

	@PayloadRoot(namespace = "http://vo.satya.example.com", localPart = "CreatePersonRequest")
	@ResponsePayload
	public CreatePersonResponse createPerson(@RequestPayload CreatePersonRequest createPersonRequest) {
		// String personId = createPersonRequest.getPerson();
		System.out.println("******************************************************************* Person Created"
				+ createPersonRequest.getPerson().getPersonId());
		System.out.println("******************************************************************* Person Created"
				+ createPersonRequest.getPerson().getAddress().get(0).getAddressId());
		System.out.println("Inside payload root");
		CreatePersonResponse personResponse = new CreatePersonResponse();
		personResponse.setPersonId("84hfur839399");
		return personResponse;
	}

}
