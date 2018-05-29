package fr.cekogha.services;
 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBObject;

import fr.cekogha.marshaller.BasicMarshaller;
import fr.cekogha.model.User;

public class BasicBusinessServices {

	private static final Logger log = LoggerFactory.getLogger(BasicBusinessServices.class);

	private BasicMarshaller marshaller;
	private MongoTemplate mongoTemplate;
	private String usersCollection;
	
	public void saveUser(DBObject user){
		DBObject dboUser = (DBObject) mongoTemplate.getConverter().convertToMongoType(user);
		mongoTemplate.save(dboUser, usersCollection);
	}
	
	public void saveUser(User user){
		System.out.println(user);
		mongoTemplate.insert(user, usersCollection);
	}
	
	public void saveUsers(List<User> usersList){
		usersList.forEach(user -> mongoTemplate.save(user, usersCollection));
	}

	public List<User> getListUsers(){
		return null;
		
	}
	
	public BasicMarshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(BasicMarshaller marshaller) {
		this.marshaller = marshaller;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public String getUsersCollection() {
		return usersCollection;
	}

	public void setUsersCollection(String usersCollection) {
		this.usersCollection = usersCollection;
	}

//	public UserConverter getConverter() {
//		return converter;
//	}
//
//	public void setConverter(UserConverter converter) {
//		this.converter = converter;
//	}
}
