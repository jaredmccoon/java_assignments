package com.codingdojo.OmikujiForm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @PostMapping("/post")
    public String post(
    		@RequestParam(value="number") Integer number,
    		@RequestParam(value="city") String city,
    		@RequestParam(value="person") String person,
    		@RequestParam(value="hobby") String hobby,
    		@RequestParam(value="thing") String thing,
    		@RequestParam(value="something") String something, HttpSession session) {
    	
    	session.setAttribute("number", number);
    	session.setAttribute("city", city);
    	session.setAttribute("person", person);
    	session.setAttribute("hobby", hobby);
    	session.setAttribute("thing", thing);
    	session.setAttribute("something", something);
    	
    	return "redirect:/show";
    }

    @GetMapping("/show")
    public String fortune(HttpSession session, Model model) {
    	Integer number = (Integer) session.getAttribute("number");
    	String city = (String) session.getAttribute("city");
    	String person = (String) session.getAttribute("person");
    	String hobby = (String) session.getAttribute("hobby");
    	String thing = (String) session.getAttribute("thing");
    	String something = (String) session.getAttribute("something");
    	
    	model.addAttribute("number", number);
    	model.addAttribute("city", city);
    	model.addAttribute("person", person);
    	model.addAttribute("hobby", hobby);
    	model.addAttribute("thing", thing);
    	model.addAttribute("something", something);
    	
    	return "show.jsp";
    }
    
    @GetMapping("/reset")
    public String reset(HttpSession session) {
    	session.invalidate();
    	return "index.jsp";
    }
    
}