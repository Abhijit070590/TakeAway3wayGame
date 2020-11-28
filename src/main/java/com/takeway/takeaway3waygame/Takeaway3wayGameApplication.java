package com.takeway.takeaway3waygame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Takeaway3wayGameApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Takeaway3wayGameApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8080"));
		app.run(args);
	}


}
