package fr.cekogha.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import fr.cekogha.model.User;

@Component
public class UserConverter implements Converter<User, DBObject>{

//	@Override
	public DBObject convert(User user) {
		// TODO Auto-generated method stub
		DBObject u = new BasicDBObject();
//		u.put("name", user.getName());
//		u.put("school", user.getSchool());
//		u.put("grade", user.getGrade());
//		u.put("fees", user.getFees());
		return u;
	}

}
