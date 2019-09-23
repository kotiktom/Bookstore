package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner studentDemo(CategoryRepository crepository, BookRepository repository, UserRepository urepository) {
		return (args) -> {
			
			User user1 = new User("user","$2a$06$iWJkiUp6tTCfxItYgjfp3e5z2SgYd4GKky0JENTlJq97gCVkAkV0C", "USER", "USER");
			User user2 = new User("admin","$2a$10$8rP7/WkSlx8GgardAjs6VO9bRixzgi1NW5Ud6/lkfKetBYWUrbCpS", "ADMIN", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
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
