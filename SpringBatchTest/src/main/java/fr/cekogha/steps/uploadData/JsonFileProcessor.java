package fr.cekogha.steps.uploadData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemProcessor;

import fr.cekogha.marshaller.BasicMarshaller;
import fr.cekogha.model.User;

public class JsonFileProcessor implements ItemProcessor<String, User>{
	
	private static final Logger log = LoggerFactory.getLogger(JsonFileProcessor.class);
	
	private BasicMarshaller marshaller;
	
	@BeforeStep
	public void before(){
		log.info("DEBUT PROCESSOR STEP... [1/2]");
		}
	
	public User process(String userString) throws Exception {
		// TODO Auto-generated method stub
		return marshaller.getUser(userString);
	}

	@AfterStep
	public void after(){
		log.info("FIN PROCESSOR STEP... [2/2] ");
		}
	
	public BasicMarshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(BasicMarshaller marshaller) {
		this.marshaller = marshaller;
	}

}
