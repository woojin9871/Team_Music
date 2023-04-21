package com.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GenerationController {
	
	@GetMapping("/generation/generation")
	public String main() {
		
		return "/generation/generation";
	}
}
