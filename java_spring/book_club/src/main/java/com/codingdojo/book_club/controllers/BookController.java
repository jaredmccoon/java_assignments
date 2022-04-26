package com.codingdojo.book_club.controllers;

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

import com.codingdojo.book_club.models.Book;
import com.codingdojo.book_club.models.User;
import com.codingdojo.book_club.services.BookService;
import com.codingdojo.book_club.services.UserService;

@Controller
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
			return "home.jsp";
		}
	}
// show one
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookServ.findBook(id);
		model.addAttribute("oneBook", oneBook);
		return "show.jsp";
	}
// render create page
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("book") Book book,
							Model model, HttpSession sesh) {
//		Book somenewbook = new Book(); 
//		model.addAttribute("book", somenewbook);
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
			return "newbook.jsp";
		
			
		}
	}
// create post method
	@PostMapping("/books")
	public String create(
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result, 
			Model model, HttpSession s) {
		
//		System.out.println(result);
		
		if (result.hasErrors()) {
//			grab the user again to send over again if there are errors
			Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);
			model.addAttribute("thisLoggedInUser", thisLoggedInUser);
			
			List<Book> alldabooks = bookServ.allBooks();
			model.addAttribute("alldabooks", alldabooks);
			
//			passes all the libraries to select from
            return "/newbook.jsp";
        } else {
//        	Alternative way:
        	Long userId = (Long) s.getAttribute("user_id");
			User thisLoggedInUser = userService.findOne(userId);

//			intercept the book
//			set the author
			book.setUser(thisLoggedInUser);

        	
//        	book.getAuthor()
//        	book.setLibrary(null)
        	bookServ.createBook(book);
            return "redirect:/books";
        }
	}
// render edit page
   @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookServ.findBook(id);
//	        book.getAuthor()
        model.addAttribute("book", book);
        return "edit.jsp";
    }
// render update method
   @PutMapping("/books/{id}")
   public String update(
   			@Valid @ModelAttribute("book") Book book, 
   			BindingResult result) {
       if (result.hasErrors()) {
           return "/books/edit.jsp";
       } else {
       	bookServ.updateBook(book);
           return "redirect:/books";
       }
   }
// delete
	@DeleteMapping("/books/{id}/delete")
	public String delete(@PathVariable("id") Long id){
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
}
