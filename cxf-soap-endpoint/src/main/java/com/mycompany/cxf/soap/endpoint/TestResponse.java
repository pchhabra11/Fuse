package com.mycompany.cxf.soap.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mycompany.cxf.soap.model.Person;

public class TestResponse {

	private Logger logger = Logger.getLogger(this.getClass());
	Map<Integer,Person> personMap = new HashMap<Integer,Person>();
	
	public Person getPerson(String id) {
		logger.info("!!!!!!!!!!!!!!!!!!!--------------------!!!!!!!!!!!!!!!!!!!");
		logger.info("Within getPerson with id: "+id);
		int idd = Integer.parseInt(id);
		if(personMap.containsKey(idd)){
			Person p = personMap.get(idd);
			return p;
		}
		else {
			logger.info("INSIDE ELSE");
			for (Integer key: personMap.keySet()) {
				logger.info("INSIDE LOOP......................................................");
				logger.info("key : " + key);
				logger.info("value : " + personMap.get(key));
			}
			logger.info("ID DID NOT EXIST");
			return null;
		}
		
		

	}
	
	public String putPerson(Person person) {
		
		logger.info("putPerson object:" + person);
		logger.info("Person's id : "+ person.getId());
		if(personMap.containsKey(person.getId())){
			return "Person already exists, choose different id";
		}
		else{
		int key = person.getId();
		personMap.put(key, person);
		return "Person added successfully";
		}
	}
	
public String deletePerson(String id) {
		int idd = Integer.parseInt(id);
		logger.info("Inside Delete Method");
		if(personMap.containsKey(idd)){
			personMap.remove(idd);
			return "Deleted Successfully";
		}
		else{
		return "Please Enter Valid Id";
		}
	}

}
