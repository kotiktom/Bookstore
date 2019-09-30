package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Jpatest {

    @Autowired
    private BookRepository repository;
    
  
    @Test
    public void findBook() {
    	/* Simply search for a book which is created on application startup */
        List<Book> books = repository.findByAuthor("Johnson");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("John");
    }
   
@Test
public void createNewBook() {
	/* Create a new book and check that it is found within the repository */
	Book book = new Book("Mickey", "Mouse", "mm@mouse.com", 123456, new Category("BITE"));
	repository.save(book);
	assertThat(book.getAuthor()).isNotNull();
}  

@Test
public void deleteBook() {
	/* Fetch by author and make sure there is a book with Johnson as an author */
	List<Book> booksOne = repository.findByAuthor("Johnson");
	assertThat(booksOne).hasSize(1);
	
	/* Remove the book which has Johnson as author and check the repository again for the book. */
	repository.deleteByAuthor("Johnson");
    List<Book> booksTwo = repository.findByAuthor("Johnson");
    assertThat(booksTwo).hasSize(0);
  }  
}