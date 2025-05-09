package com.root.app.board;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	
	private Long boardNum;
	private String boardTitle;
	private String boardContents;
	private Date boardDate;
	private Long boardHit;
	private String username;
	private List<BoardFileDTO> fileDTOs;

}
