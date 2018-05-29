package fr.cekogha.marshaller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.cekogha.model.CustomObjectId;
import fr.cekogha.model.User;

//import junit.framework.Assert;
import org.junit.Assert;

public class BasicMarshallerTest {

	String userString ="";
	List<String> userList = new ArrayList<String>();
	
	@Before
	public void setUp() throws Exception {
		File inputFile = new File(getClass().getClassLoader().getResource("userFromUserCollectionForTest.json").toURI());
		BufferedReader br = new BufferedReader(new FileReader(inputFile));

		String jsonLine = "";
		while((jsonLine = br.readLine()) != null){
			userString = jsonLine;
			userList.add(jsonLine);
		}
	}

	@Test
	public void testGetUser() throws IOException {
		BasicMarshaller bm = new BasicMarshaller();
		User user = bm.getUser(userString);
		CustomObjectId _id = new CustomObjectId();
		_id.setOid("58307d010a2c7789e2746253");
//		User userTest = new User(_id, "Simon","Brexit School", "2nd", "1003.01");

//		Assert.assertEquals(userTest.name, user.name);
//		Assert.assertEquals(userTest.fees, user.fees);
//		Assert.assertEquals(userTest.grade, user.grade);
//		Assert.assertEquals(userTest.school, user.school);
		
	}

}
