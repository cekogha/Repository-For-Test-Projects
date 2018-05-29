package fr.cekogha.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class User {
	
	public ObjectId _id;
	public String name;
	public String school;
	public String grade;
	public String fees;

	@JsonCreator
	public User(
			@JsonProperty("_id") CustomObjectId id,
			@JsonProperty("name") String name,
			@JsonProperty("school") String school,
			@JsonProperty("grade") String grade,
			@JsonProperty("fees") String fees){
		
		this._id = new ObjectId(id.getOid());
		this.name = name;
		this.school = school;
		this.grade = grade;
		this.fees = fees;
	}	

	public String toString(){
		return "User = {\n"
				+ "_id : ObjectId('" + _id.toHexString() +"'),\n"
				+ "'name' : " + name +",\n"
				+ "'school' : " + school +",\n"
				+ "'grade' : " + grade +",\n"
				+ "'fees' : " + fees +"\n"
				+ "}";
	}
}
