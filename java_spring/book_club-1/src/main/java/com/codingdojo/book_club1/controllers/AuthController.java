package com.codingdojo.book_club1.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.book_club1.models.LoginUser;
import com.codingdojo.book_club1.models.User;
import com.codingdojo.book_club1.services.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userServ;

//	RENDER LOGIN / REG PAGE
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
	
//	REGISTER NEW USER
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
							BindingResult result,
							Model model,
							HttpSession sesh) {
		
//		execute the Service to Register FIRST!
		userServ.register(newUser, result);
		
//		then check for errors
		if (result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
		} else {
			sesh.setAttribute("user_id", newUser.getId());
			return "redirect:/books";
		}
	}
	
//	LOGIN USER
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
						BindingResult res,
						Model model,
						HttpSession sesh) {
		
		User user = userServ.login(newLogin, res);
		
		if (res.hasErrors()) {
	        model.addAttribute("newUser", new User());
			return "index.jsp";
		} else {
			sesh.setAttribute("user_id", user.getId());
			return "redirect:/books";
		}
		
		
	}
	
//	HOME ROUTE
	@RequestMapping("/home")
	public String home(HttpSession s, Model m) {
//		retrieve the user from session
		Long userId = (Long) s.getAttribute("user_id");
//		check if userId is null
		if (userId == null) {
			return "redirect:/";
		} else {
//			go to the db to retrieve the user using the id from session
			User thisUser = userServ.findOne(userId);
			m.addAttribute("thisUser", thisUser);			
//			m.addAttribute("thisUser", thisUser.getUserName());			
			return "home.jsp";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
}