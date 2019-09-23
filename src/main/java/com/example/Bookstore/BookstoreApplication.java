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
			
			User user1 = new User("user", "user1@outlook.com" , "C7CDE2FCF51F5448B414BDCB473CBD29C9B6A8A7A5C01470208BACAF84FC2AD7", "USER");
			User user2 = new User("admin", "user2@outlook.com", "FE02F102634DF0669CEB26B8A39837A59A041EC1C345802AF5B11BA8EB0CFF83", "ADMIN");
			
			
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
