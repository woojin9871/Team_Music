package com.team.service;

import java.util.List;

import com.team.domain.MusicBoard;

public interface MusicBoardService {

	// 게시글 목록
	public List<MusicBoard> list() throws Exception;
	
	// 게시글 조회
	public MusicBoard read(int musicNo) throws Exception;
	
	// 게시글 등록
	public int insert(MusicBoard music) throws Exception;
	
	// 게시글 수정
	public int update(MusicBoard music) throws Exception;
	
	// 게시글 삭제
	public int delete(int musicNo) throws Exception;
	
}
