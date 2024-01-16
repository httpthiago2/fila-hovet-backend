package com.thiagogonzalez.filahovet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.thiagogonzalez.filahovet.domain")
@EnableJpaRepositories("com.thiagogonzalez.filahovet.repositories")
public class FilaHovetApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilaHovetApplication.class, args);
	}

}
