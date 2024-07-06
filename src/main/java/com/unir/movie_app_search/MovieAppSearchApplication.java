package com.unir.movie_app_search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MovieAppSearchApplication {


	public static void main(String[] args) {
		// Obtenemos perfil de ejecucion de variable de entorno. Si no hay, perfil default.
		String profile = System.getenv("PROFILE");
		System.setProperty("spring.profiles.active", profile != null ? profile : "default");

		log.debug("Waiting fo Internal Interface to start...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SpringApplication.run(MovieAppSearchApplication.class, args);
	}

}
