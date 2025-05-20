package com.example.satya.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.satya.service.IPersonService;
import com.example.satya.util.VOConversion;
import com.example.satya.vo.CreatePersonRequest;
import com.example.satya.vo.CreatePersonResponse;
import com.example.satya.vo.GetPersonRequest;
import com.example.satya.vo.GetPersonResponse;
import com.example.satya.vo.Person;

@Configuration
@Endpoint
public class PersonalInformationEndpoint {

	private static final Logger logger = LogManager.getLogger();

	@Autowired
	private IPersonService personService;

	@PayloadRoot(namespace = "http://vo.satya.example.com", localPart = "GetPersonRequest")
	@ResponsePayload
	public GetPersonResponse getPersonBiography(@RequestPayload GetPersonRequest getPersonRequest) {
		logger.info("Entered getPersonBiography id = ");
		GetPersonResponse getPersonResponse = null;
		String personId = getPersonRequest.getPersonId();
		logger.info("*******************************************************************" + personId);

		if (personId != null && !personId.isBlank() && !personId.isEmpty()) {
			com.example.satya.db.vo.Person personObject = new com.example.satya.db.vo.Person();
			personObject.setPersonId(personId);
			personObject = personService.getPerson(personObject);
			if (personObject == null) {
				GetPersonResponse personResponse = new GetPersonResponse();
				personResponse.setPerson(new Person());
			} else {
				getPersonResponse = new GetPersonResponse();
				Person person = VOConversion.convertDBVoToWSVo(personObject);
				getPersonResponse.setPerson(person);
			}

		}
		logger.info("Exited getPersonBiography person = " + getPersonResponse);
		return getPersonResponse;
	}

	@PayloadRoot(namespace = "http://vo.satya.example.com", localPart = "CreatePersonRequest")
	@ResponsePayload
	public CreatePersonResponse createPerson(@RequestPayload CreatePersonRequest createPersonRequest) {
		logger.info("Entered createPerson id = " + createPersonRequest);
		CreatePersonResponse createPersonResponse = null;
		Person person = createPersonRequest.getPerson();
		if (person != null) {
			com.example.satya.db.vo.Person personObject = VOConversion.convertWSVoToDBVo(person);
			System.out.println("Person object after conversion ============================================ " + personObject);
			createPersonResponse = new CreatePersonResponse();
			personObject = personService.createPerson(personObject);
			createPersonResponse.setPersonId(personObject.getPersonId());
		}
		logger.info("Exited createPerson person = " + createPersonResponse);
		return createPersonResponse;
	}

}
