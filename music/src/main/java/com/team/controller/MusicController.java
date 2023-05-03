package com.team.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.team.domain.Music;
import com.team.mapper.MusicMapper;
import com.team.service.MusicService;

@Controller
public class MusicController {

	@Autowired
	private MusicService service;
	
	@Autowired
	private MusicMapper mapper;
	
	@GetMapping("/music/music")
	public String music(Model model) throws Exception {
		
		List<Music> musicList = service.list();
		
		model.addAttribute("musicList", musicList);
		
		return "/music/music";
	}
	
	@GetMapping("/music/genre/{genre}")
	public String getMusicByGenre(@PathVariable("genre") String genre, Model model) {
	    List<Music> musicList = mapper.selectMusicByGenre(genre);
	    model.addAttribute("musicList", musicList);
	    return "music/musicByGenre :: musicByGenreContainer";
	}
}
