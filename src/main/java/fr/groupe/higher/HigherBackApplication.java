package fr.groupe.higher;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Transactional
@PropertySource("classpath:application.properties")
public class HigherBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HigherBackApplication.class, args);
	}
}
