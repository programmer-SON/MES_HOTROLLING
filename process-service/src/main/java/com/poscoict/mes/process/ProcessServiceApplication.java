package com.poscoict.mes.process;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProcessServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessServiceApplication.class, args);
	}

}
