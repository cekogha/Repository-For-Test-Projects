package fr.cekogha.app;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "job-test.xml" })
public class AppTest {

	@Autowired
	JobLauncherTestUtils jobLauncherTest;
	
	@Test
	public void testMain() {
		JobExecution jobExecution = jobLauncherTest.launchStep("");
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}

}
