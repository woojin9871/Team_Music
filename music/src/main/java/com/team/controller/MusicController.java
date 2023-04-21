package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.team.domain.Music;
import com.team.service.MusicService;

@Controller
public class MusicController {

	@Autowired
	private MusicService service;
	
	@GetMapping("/genre/genre")
	public String music(Model model) throws Exception {
		
		List<Music> musicList = service.music();
		
		model.addAttribute("musicList", musicList);
		
		return "/genre/genre";
	}
}
