package com.codingdojo.book_club.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.book_club.models.Book;
import com.codingdojo.book_club.repositories.BookRepo;

@Service
public class BookService {
	
//	CRUD
	@Autowired
	private BookRepo bookRepo;

//	READ ALL
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
//	CREATE 
	public Book createBook(Book b) {
//		b.setAuthor(null);
		return bookRepo.save(b);
	}
	
//	READ ONE
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public Book updateBook(Book b) {
		return bookRepo.save(b);
	}
//	public Book updateBookWithLib(Book b, Library l) {
//		b.setLibrary(l);
//		return bookRepo.save(b);
//	}
	
//	DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
}
