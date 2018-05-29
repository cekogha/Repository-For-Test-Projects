package fr.cekogha.services;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

public class BasicBusinessServicesTest {

	String userString = "";
	
	@Before
	public void setUp() throws Exception {
		File inputFile = new File(getClass().getClassLoader().getResource("userFromUserCollectionForTest.json").toURI());
		BufferedReader br = new BufferedReader(new FileReader(inputFile));

		String jsonLine = "";
		while((jsonLine = br.readLine()) != null){
			userString = jsonLine;
		}
	}

	@Test
	public void testSaveUserUser() {
	}

}
