package com.codingdojo.FruityLoops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.FruityLoops.models.Item;

@Controller
public class ItemController {
	@RequestMapping("/")
	public String index(Model model) {
		ArrayList<Item> fruitsArrayList = new ArrayList<Item>();
		fruitsArrayList.add(new Item("kiwi", 1.5));
		fruitsArrayList.add(new Item("Mango", 2.0));
		fruitsArrayList.add(new Item("Bayas de Goyi", 4.0));
		fruitsArrayList.add(new Item("Guayava", 75));
		
		model.addAttribute("fruits",fruitsArrayList);
		return "index.jsp";
	}
}