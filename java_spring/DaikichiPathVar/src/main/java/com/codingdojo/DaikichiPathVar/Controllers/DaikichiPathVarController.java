package com.codingdojo.DaikichiPathVar.Controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiPathVarController {

	@RequestMapping("/daikichi/travel/{place}")
	public String showPlace(@PathVariable("place") String place) {
			return "Congratulations! You will soon travel to " + place;
	}
	
	@RequestMapping("/daikichi/lotto/{num}")
	public String showText(@PathVariable("num") String num) {
		int temp = Integer.parseInt(num);
		if(temp%2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
	
}
