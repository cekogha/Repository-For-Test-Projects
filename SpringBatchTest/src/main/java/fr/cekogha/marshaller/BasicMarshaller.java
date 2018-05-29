package fr.cekogha.marshaller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import fr.cekogha.model.User;

public class BasicMarshaller {

	private final static Logger log = LoggerFactory.getLogger(BasicMarshaller.class);
	private ObjectMapper objMapper;

	public BasicMarshaller(){
		objMapper = new ObjectMapper();
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public DBObject convertJsonToDBObject(String userString){
		return (DBObject) JSON.parse(userString);
	}

	public User getUser(String userString) throws IOException{
		log.debug(userString);
//		return objMapper.readValue(userString, User.class);
		return objMapper.readerFor(User.class)
				.readValue(objMapper.readTree(userString));
	}

	/*
	public List<User> getAllUsers(List<String> usersList){
		try {
			return objMapper.readValue(usersList.toString(), new TypeReference<List<User>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.warn(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String convertUserToString(User user) throws JsonProcessingException{
		return objMapper.writeValueAsString(user);
	}

	public List<String> convertUserToStringList(List<User> usersList){
		List<String> users = new ArrayList<String>();
		//		for(User user : usersList){ users.add(objMapper.writeValueAsString(user)); } // java 1.7
		usersList.forEach(user -> {
			try {
				users.add(objMapper.writeValueAsString(user));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				log.warn(e.getMessage());
				e.printStackTrace();
			}
		});
		return users;
	}
	 */
}
