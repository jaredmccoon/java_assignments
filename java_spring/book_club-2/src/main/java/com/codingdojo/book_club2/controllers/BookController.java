package com.codingdojo.book_club2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.book_club2.models.Book;
import com.codingdojo.book_club2.models.User;
import com.codingdojo.book_club2.services.BookService;
import com.codingdojo.book_club2.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	// GET BOOKS
	@GetMapping("/books")
	public String getBooks(Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("user_id");
			List<Book> allBooks = bookService.allBooks();
			model.addAttribute("allBooks", allBooks);
			User oneUser = userService.findOne(userId);
			model.addAttribute("oneUser", oneUser);
		return "books.jsp";
	}
	// GET CREATE
	@GetMapping("/books/new")
	public String getCreate(@ModelAttribute("book") Book book) {
		return "create.jsp";
	}
	// GET ONEBOOK
	@GetMapping("/books/{id}")
	public String getOnebook(@PathVariable("id") Long id, Model model, HttpSession session) {
			Long userId = (Long) session.getAttribute("user_id");
			Book oneBook = bookService.findBook(id);
			model.addAttribute("oneBook", oneBook);
			model.addAttribute("userId", userId);
		return "onebook.jsp";
	}
	// POST CREATE
	@PostMapping("/books/create")
	public String postCreate(
			@Valid @ModelAttribute("book") Book book, HttpSession session) {
			Long userId = (Long) session.getAttribute("user_id");
			User currentUser = userService.findOne(userId);
			book.setUser(currentUser);
			bookService.create(book);
		return "redirect:/books";
	}
	// GET EDIT
	@GetMapping("/books/{id}/edit")
	public String getEdit(
			@PathVariable("id") Long id, Model model) {
			Book book = bookService.findBook(id);
			model.addAttribute("book", book);
		return "edit.jsp";
	}
	// POST EDIT
	@PutMapping("/books/{id}")
	public String postEdit(
			@Valid @ModelAttribute("book") Book book,
			@PathVariable("id") Long id) {
			Book ogbook = bookService.findBook(id);
			User originalUser = ogbook.getUser();
			book.setUser(originalUser);
			bookService.update(book);
		return "redirect:/books";
	}
}
