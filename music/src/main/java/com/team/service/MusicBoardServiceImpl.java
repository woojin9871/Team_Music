package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.domain.MusicBoard;
import com.team.mapper.MusicBoardMapper;

@Service			// 컨테이너의 빈으로 등록, 비즈니스 로직을 처리하는 서비스로 구분
public class MusicBoardServiceImpl implements MusicBoardService {
	
	@Autowired
	private MusicBoardMapper mapper;

	@Override
	public List<MusicBoard> list() throws Exception {
		// 처리 로직
		return mapper.list();
	}

	@Override
	public MusicBoard read(int musicNo) throws Exception {
		
		return mapper.read(musicNo);
	}

	@Override
	public int insert(MusicBoard music) throws Exception {
		
		return mapper.insert(music);
	}

	@Override
	public int update(MusicBoard music) throws Exception {
		
		return mapper.update(music);
	}

	@Override
	public int delete(int musicNo) throws Exception {
		
		return mapper.delete(musicNo);
	}


}
