package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This is an unused module for testing the login controller. It will be removed.
 */

@Controller
@RequestMapping("/loginold")
public class TempLoginController {
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("text", "Temporary Login Page");

		return "login";
	}
}
