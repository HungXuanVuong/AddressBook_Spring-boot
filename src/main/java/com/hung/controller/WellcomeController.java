package com.hung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellcomeController {

	@RequestMapping("/")
	public String wellcome(Model model){
		model.addAttribute("message", "Wellcome to spring boot");
		return "wellcome";
	}
}
