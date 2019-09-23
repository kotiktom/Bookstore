package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository; 
		
	
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }
	
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String BookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
		}

	
	 @RequestMapping(value="/books", method= RequestMethod.GET)
	 public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
		
	 }
	 
	 @RequestMapping(value="/books/{id}", method= RequestMethod.GET)
	 public @ResponseBody Optional<Book> findBookListRest(@PathVariable("id") Long id) {
		return repository.findById(id);
		
	 }
	
	@RequestMapping(value = "/add")
	 @PreAuthorize("hasAuthority('ADMIN')")
	public String AddBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
		}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
		}
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
    	repository.deleteById(id);
        return "redirect:../booklist";
    	}
   
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("book", repository.findById(id));
    	model.addAttribute("categories", crepository.findAll());
    	return "addbook";
    }
    
  
}
    




