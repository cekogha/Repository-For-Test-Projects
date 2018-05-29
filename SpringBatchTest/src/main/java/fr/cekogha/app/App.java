package fr.cekogha.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		String[] springConfig  = 
			{	
					"spring/batch/jobs/job.xml" 
			};

		ApplicationContext context = 
				new ClassPathXmlApplicationContext(springConfig);

		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean(args[0]);
		Map<String, JobParameter> mapParameters = new HashMap<String, JobParameter>();
		mapParameters.put("parameters.input.data", new JobParameter(args[1]));
		//		JobParameters jobParameters = new JobParametersBuilder()
		//				.addParameter("parameters.input.data", new JobParameter(args[1])).toJobParameters();
		JobParameters jobParameters = new JobParameters(mapParameters);

		try {

			JobExecution execution = jobLauncher.run(job, jobParameters);
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
