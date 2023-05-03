     package com.team.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.domain.MusicBoard;
import com.team.service.MusicBoardService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MusicBoardController {
	
	@Autowired
	private MusicBoardService service;
	
	@GetMapping("/musicBoard/list")
	public String list(Model model) throws Exception {
		List<MusicBoard> musicBoardList = service.list();
		
		model.addAttribute("musicBoardList", musicBoardList);
		log.info("musicBoardList : " + musicBoardList);
		
		return "/musicBoard/list";	
	}

	@GetMapping("/musicBoard/insert")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String insertForm(Principal principal, Model model) {
		
		String userId = principal.getName();
		log.info("userId  :" + userId);
		
		model.addAttribute("userId",userId);
		
		return "/musicBoard/insert";
	}
	
	@PostMapping("/musicBoard/insert")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String insert(MusicBoard music) throws Exception {
		// @RequestParam("파라미터명") 타입 매개변수명
		// : 요청 파라미터를 매개변수로 가져온다
		//   * 요청 파라미터명과 매개변수명이 일치하면 생략가능
		
		int result = service.insert(music);
		
		return "redirect:/musicBoard/list";		// 게시글 쓰기 처리 후, 게시글 목록으로 리다이렉트
	}
	
	@GetMapping("/musicBoard/read")
	public String readWarning() {
		
		return "/musicBoard/warning";
	}

	@GetMapping(path = "/musicBoard/read", params = "musicNo")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String read(Model model, int musicNo, Principal principal) throws Exception {
		// 게시글 번호로 게시글 정보를 조회
		log.info("음악 추천 리스트 조회...");
		log.info("musicNo : " + musicNo);
		
		MusicBoard music = service.read(musicNo);
		
		String loginUserId = principal.getName();
		String musicBoardUserId = music.getWriter();
		
		boolean writer = false;
		if( loginUserId.equals(musicBoardUserId)) {
			writer = true;
		}
		
		model.addAttribute("writer", writer);
		model.addAttribute("musicNo", musicNo);
		model.addAttribute("music", music);
		return "/musicBoard/read";
	}
	
	
	@GetMapping("/musicBoard/update")
	public String updateWarning() {
		
		return "/musicBoard/warning";
	}

	@GetMapping(path = "/musicBoard/update", params = "musicNo")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String updateForm(Model model, int musicNo, Principal principal) throws Exception {
		// 게시글 번호로 게시글 정보를 조회
		log.info("음악 추천 리스트 조회(수정화면)...");
		log.info("musicNo : " + musicNo);
		
		MusicBoard music = service.read(musicNo);
		
		String loginUserId = principal.getName();
		String musicBoardUserId = music.getWriter();
		
		boolean writer = false;
		if( loginUserId.equals(musicBoardUserId)) {
			writer = true;
		}
		
		model.addAttribute("writer", writer);
		model.addAttribute("musicNo", musicNo);
		model.addAttribute("music", music);
		
		return "/musicBoard/update";
	}

	@PutMapping("/musicBoard/update")
	public String update(HttpServletRequest request) throws Exception {
		// HttpServletRequest
		// - 클라이언트의 요청과 관련한 기능을 사용할 수 있는 요청객체
		// - getParameter("파라미터명")   : 요청 파라미터의 값을 가져온다	
		//   * 파라미터명 
		//   - form요청 (input 태그의 name 속성 지정한 파라미터명)
		//   - URL의 쿼리스트링의 파라미터 localhost:8080/~~~?title=제목&writer=작성자&content=내용
		String writer = request.getParameter("writer");
		String songName = request.getParameter("songName");
		String artist = request.getParameter("artist");
		String content = request.getParameter("content");
		int musicNo = Integer.parseInt( request.getParameter("musicNo") );
		
		MusicBoard music = new MusicBoard();
		music.setMusicNo(musicNo);
		music.setWriter(writer);
		music.setSongName(songName);
		music.setArtist(artist);
		music.setContent(content);
		
		int result = service.update(music);
		
		log.info("songName : " + songName);
		log.info("writer : " + writer);
		log.info("artist : " + artist);
		log.info("content : " + content);
		log.info("musicNo : " + musicNo);
		return "redirect:/musicBoard/read?musicNo=" + musicNo;
	}

	@PostMapping("/musicBoard/update")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String updatePost(MusicBoard music, Principal principal) throws Exception {
		// 요청 파라미터명과 일치하는 변수명을 가지고 있는 객체를 사용하여 여러 파라미터를 가져올 수 있다.
		int musicNo = music.getMusicNo();
		String writer = music.getWriter();
		String songName = music.getSongName();
		String artist = music.getArtist();
		String content = music.getContent();
		
		String loginUserId = principal.getName();
		if( !writer.equals(loginUserId) ) {
			return "redirect:/musicBoard/update?musicNo=" + musicNo;
		}
		
		int result = service.update(music);
		
		log.info("writer : " + writer);
		log.info("songName : " + songName);
		log.info("artist : " + artist);
		log.info("content : " + content);
		log.info("musicNo : " + musicNo);
		return "redirect:/musicBoard/read?musicNo=" + musicNo;
	}

	@DeleteMapping("/musicBoard/delete")
	public String delete(int musicNo) throws Exception {
		// 게시글 번호로 게시글 삭제
		log.info("musicNo : " + musicNo);
		
		int result = service.delete(musicNo);
		
		return "redirect:/musicBoard/list";
	}

	@PostMapping("/musicBoard/delete")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String deletePost(int musicNo, Principal principal) throws Exception {
		// 게시글 번호로 게시글 삭제
		log.info("musicNo : " + musicNo);
		MusicBoard music = service.read(musicNo);
		String loginUserId = principal.getName();
		String musicBoardUserId = music.getWriter();
		
		if( !musicBoardUserId.equals(loginUserId) ) {
			return "redirect:/musicBoard/read?musicNo=" + musicNo;
		}
		
		int result = service.delete(musicNo);
		
		return "redirect:/musicBoard/list";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
