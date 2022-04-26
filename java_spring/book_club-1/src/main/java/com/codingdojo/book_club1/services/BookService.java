package com.codingdojo.book_club1.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.book_club1.models.Book;
import com.codingdojo.book_club1.repository.BookRepository;

@Service
public class BookService {
// CRUD
	@Autowired
	private BookRepository bookRepo;

// READ ALL
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
// READ ONE 
	public Book findBook(long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
// CREATE
	public Book create(Book b) {
	return bookRepo.save(b);
	}
// UPDATE
	public Book update(Book b) {
		return bookRepo.save(b);
	}
// DELETE 
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}