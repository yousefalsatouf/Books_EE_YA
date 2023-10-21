package be.isl.books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BooksApplication {
	private static final Logger logger = LoggerFactory.getLogger("info");

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);


		try {
			logger.info("APP is running on http://localhost:8080");
		} catch (Exception e) {
			logger.error("An error occurred: {}", e.getMessage(), e);
		}
	}

}