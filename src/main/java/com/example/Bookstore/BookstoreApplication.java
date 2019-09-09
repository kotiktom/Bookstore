package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner studentDemo(CategoryRepository crepository, BookRepository repository) {
		return (args) -> {
			
			crepository.save(new Category("Science"));
			crepository.save(new Category("Classics"));
			crepository.save(new Category("Entertainment"));
			
			repository.save(new Book("Michael Jackson", "How to yell really loud","123423423423", 22.60, crepository.findByName("Science").get(0)));
			repository.save(new Book("Linus Torvalds", "How to make people hate servers","124124123", 23.00, crepository.findByName("Entertainment").get(0)));
			repository.save(new Book("Kimi Räikkönen", "Ice ice baby", "12312344123", 50.32, crepository.findByName("Classics").get(0)));
			repository.save(new Book("Dude Jeesus", "How to yeet on romans", "12312344123", 50.32, crepository.findByName("Classics").get(0)));
			repository.save(new Book("Chris Brown", "She had it coming", "12312344123", 50.32, crepository.findByName("Classics").get(0)));
			
		};
	}
}
