package com.team.domain;

import java.util.Date;

import lombok.Data;


// @Alias("Board")   // 생략하면, 클래스명으로 별칭을 설정한다
@Data
public class MusicBoard {
	
	private int musicNo;
	private String songName;
	private String artist;
	private String content;
	private String writer;
	private Date regDate;	
}
