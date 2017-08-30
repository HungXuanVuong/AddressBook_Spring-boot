package com.hung.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WellcomeController {

	@RequestMapping("/")
	public String wellcome(){
		return "Well come to spring boot";
	}
}
