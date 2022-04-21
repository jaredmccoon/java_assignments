package com.codingdojo.dojos_and_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojos_and_ninjas.models.Dojo;
import com.codingdojo.dojos_and_ninjas.models.Ninja;
import com.codingdojo.dojos_and_ninjas.services.DojoService;
import com.codingdojo.dojos_and_ninjas.services.NinjaService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}



//  RENDER CREATE DOJO PAGE
	@RequestMapping("/")
	public String index(@ModelAttribute("newDojo") Dojo dojo) {
		return "index.jsp";
	}

//	POST METHOD FOR CREATING DOJO
	@PostMapping("/create/dojo")
	public String create(@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}

//  RENDER TABLE PAGE
	@RequestMapping("/dojo/{id}")
	public String showDojoAndNinjas(@PathVariable("id") Long dojoId, Model model) {
		Dojo dojo = dojoService.findDojo(dojoId);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("dojos", allDojos);
		return "createNinja.jsp";
	}
	
	@PostMapping("/create/ninja")
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("dojos", allDojos);
			return "createNinja.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninjas/new";
		}
	}
}
