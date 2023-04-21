package com.team.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MusicUsers {
	private int userNo;
	private String userId;
	private String userPw;
	private String userPwChk;
	private String name;
	private String gender;
	private Number old;
	private int enabled;
	private LocalDateTime regDate;
	private LocalDateTime updDate;
}
