package com.codingdojo.book_club1.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.book_club1.models.Book;
import com.codingdojo.book_club1.models.User;
import com.codingdojo.book_club1.services.BookService;
import com.codingdojo.book_club1.services.UserService;

@Controller
public class BookController {
	@Autowired
//	call service classes through import to 
	private BookService bookService;
	@Autowired 
	private UserService userService;
	
// show all
	@GetMapping("/books")
	public String index(Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
//		check if userID is null
		if (userId == null) {
			return "redirect:/";
		} else {			
			// grab all the books from the book service
			List<Book> allbooks = bookService.allBooks();
			// pass all the books to the JSP page
			model.addAttribute("allbooks", allbooks);
			
			// grab the user from userService by calling the function findOne and pass in the user id from session
			User oneUser = userService.findOne(userId);
			// pass the user to the JSP page
			model.addAttribute("oneUser", oneUser);
			return "home.jsp";
		}
	}
// show one
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookService.findBook(id);
		model.addAttribute("oneBook", oneBook);
		
		return "show.jsp";
	}
// render create book page
	@GetMapping("/books/new")
	public String createBookPage(@ModelAttribute("book") Book book, 
														Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		// check if userId is null
		if (userId == null) {
			return "redirect:/";
		} else {
			// pass in the logged in user
			User currentUser = userService.findOne(userId);
			model.addAttribute("currentUser", currentUser);
		}
			// passes all the books
			List<Book> allbooks = bookService.allBooks();
			model.addAttribute("allbooks", allbooks);
			return "create.jsp";
	}
// create post method
	@PostMapping("/books/create")
	public String createBookPost(
					@Valid @ModelAttribute("book") Book book,
					BindingResult result,
					Model model, HttpSession s) {
		if (result.hasErrors()) {
//			grab the user again to send over again if there are errors
			Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
			
			List<Book> allbooks = bookService.allBooks();
			model.addAttribute("allbooks", allbooks);
			
//			passes all the libraries to select from
            return "/create.jsp";
		} else {
//        	Alternative way:
        	Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);

//			intercept the book
//			set the author
			book.setUser(thisLoggedInUser);

        	
//        	book.getAuthor()
//        	book.setLibrary(null)
        	bookService.create(book);
            return "redirect:/books";
        }
	}



// render edit page
	@RequestMapping("/books/{id}/edit")
		public String edit(@PathVariable("id") Long id, Model model) {
			Book book = bookService.findBook(id);
			model.addAttribute("book",book);
			return "edit.jsp";
		}
// UPDATE
	@PutMapping("/books/{id}")
	public String update(
					@Valid @ModelAttribute("book") Book book,
					BindingResult result, @PathVariable("id") Long id) {
			if (result.hasErrors()) {
				return "edit.jsp";	
			} else {
				// 1. intercept the book object
				Book ogBook = bookService.findBook(id);
				// 2. grab this books user
				User originalUser = ogBook.getUser();
				// set the books "user" as the original user 
				book.setUser(originalUser);
			
					bookService.update(book);
						return "redirect:/books";
			}
	}
// DELETE
	@DeleteMapping("/books/{id}/delete")
	public String delete(@PathVariable("id") Long id){
		bookService.delete(id);
		return "redirect:/books";
	}
}
