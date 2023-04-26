package com.team.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.domain.Music;
import com.team.mapper.MusicMapper;

@Service
public class MusicServiceImpl implements MusicService {

	@Autowired MusicMapper mapper;

	@Override
	public List<Music> list() throws Exception {
		return mapper.list();
	}
}
