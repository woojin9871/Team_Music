package com.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistController {
	
	@GetMapping("/artist/artist")
	public String main() {
		
		return "/artist/artist";
	}
}
