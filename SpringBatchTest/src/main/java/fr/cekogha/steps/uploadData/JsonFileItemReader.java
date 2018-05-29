package fr.cekogha.steps.uploadData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.annotation.AfterRead;
import org.springframework.batch.core.annotation.BeforeRead;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class JsonFileItemReader implements ItemReader<String>{

	private final static Logger log = LoggerFactory.getLogger(JsonFileItemReader.class); 

	private String inputDataFile;
	private List<String> dataList = new ArrayList<String>();

	@BeforeStep
	private void beforeStep(){
		if( dataList.isEmpty() ){
			try{
				log.info("Fetching data form flat file... [1/2] ");
				File inputFile = new File(inputDataFile);
				BufferedReader br = new BufferedReader(new FileReader(inputFile));

				String jsonLine = "";
				while((jsonLine = br.readLine()) != null){
					dataList.add(jsonLine);
				}

			}catch(Exception exception){
				log.warn(exception.getMessage());
			}	
			log.info("Fetching data form flat file... [2/2] ");	
		}
	}
	
	@BeforeRead
	public void before(){
		log.info("DEBUT READ STEP... [1/2]");
		}
	
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub

		if( !dataList.isEmpty() ){
			String userString = dataList.get(0);
			dataList.remove(0);
			return userString;
		}		
		return null;
	}


	@AfterRead
	public void after(){
		log.info("FIN READER STEP... [2/2] ");
		}
	
	public String getInputDataFile() {
		return inputDataFile;
	}

	public void setInputDataFile(String inputDataFile) {
		this.inputDataFile = inputDataFile;
	}

}
