package com.codingdojo.book_club.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.book_club.models.Book;
import com.codingdojo.book_club.models.User;
import com.codingdojo.book_club.services.BookService;
import com.codingdojo.book_club.services.UserService;

public class BookController {
	@Autowired
	private BookService bookServ;
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
			List<Book> alldabooks = bookServ.allBooks();
			model.addAttribute("alldabooks", alldabooks);
			return "/books/index.jsp";
		}
	}
		
		
// show one
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookServ.findBook(id);
//		System.out.println(oneBook.getTitle());
		model.addAttribute("oneBook", oneBook);
		return "/books/show.jsp";
	}
// render create page
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("book") Book book,
							Model model, HttpSession sesh) {
		
//		Route Guard - check if user us in session
		Long userId = (Long) sesh.getAttribute("user_id");
//		check if userId is null
		if (userId == null) {
			return "redirect:/";
		} else {
	//	    pass in the logged in user
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
	
	//		passes all the books
			List<Book> alldabooks = bookServ.allBooks();
			model.addAttribute("alldabooks", alldabooks);
			return "/books/new.jsp";
		
			
		}
	}
// create post method
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result, 
			@RequestParam("unicorn") String unicorn,
			Model model, HttpSession s) {
		
		System.out.println(unicorn);
//		System.out.println(result);
		
		if (result.hasErrors()) {
//			grab the user again to send over again if there are errors
			Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
			
			List<Book> alldabooks = bookServ.allBooks();
			model.addAttribute("alldabooks", alldabooks);
            return "/books/new.jsp";
        } else {
//        	Alternative way:
        	Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);

//			intercept the book
//			set the author
			book.setAuthor(thisLoggedInUser);

        	
//        	book.getAuthor()
//        	book.setLibrary(null)
        	bookServ.createBook(book);
            return "redirect:/books";
        }
	}
// render edit page
// render update method
// delete
}
