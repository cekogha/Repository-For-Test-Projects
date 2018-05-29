package fr.cekogha.steps.uploadData;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.AfterWrite;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.batch.item.ItemWriter;
import org.springframework.data.mongodb.core.MongoTemplate;

import fr.cekogha.model.User;

public class JsonFileItemWriter implements ItemWriter<User>{

	private static final Logger log = LoggerFactory.getLogger(JsonFileItemWriter.class);
	
	private MongoTemplate mongoTemplate;
	private String usersCollection;
	
	@BeforeWrite
	public void before(){
		log.info("DEBUT WRITER STEP... [1/2]");
		}
	
	public void write(List<? extends User> usersList) throws Exception {
		// TODO Auto-generated method stub
		((List<User>) usersList).forEach(
				user -> mongoTemplate.save(user, usersCollection));
		log.info("insertion user done...");
	}

	@AfterWrite
	public void after(){
		log.info("FIN WRITER STEP... [2/2] ");
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

}
