package com.example.Bookstore.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByTitle(String string);
	
	List<Book> findByAuthor(String string);
	
	List<Book> deleteByAuthor(String string);

	
}