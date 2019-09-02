package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of students");
			repository.save(new Book("John Johnson", "Java for beginners",  (long) 123515131, 15.50));
			repository.save(new Book("Pete Maukkaunen", "How to use Java",  (long) 312535, 11.50));
			repository.save(new Book("Juha Petterinen", "Guides to Java",  (long) 643757, 10.50));
			repository.save(new Book("Jaakko Jokela", "Intresting youtube videos", (long) 732235, 25.50));
			
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
