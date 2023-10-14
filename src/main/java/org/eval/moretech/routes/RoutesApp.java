package org.eval.moretech.routes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RoutesApp {

	public static void main(String[] args) {
		SpringApplication.run(RoutesApp.class, args);
	}

}
