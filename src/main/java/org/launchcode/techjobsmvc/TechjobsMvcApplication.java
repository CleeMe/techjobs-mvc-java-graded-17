package org.launchcode.techjobsmvc;

import org.launchcode.techjobsmvc.models.JobData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechjobsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechjobsMvcApplication.class, args);
		JobData.loadData();
	}

}
