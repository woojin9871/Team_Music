package com.team.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.domain.Music;

@Mapper
public interface MusicMapper {

	public List<Music> list() throws Exception;

	public List<Music> selectMusicByGenre(String genre);	
}
