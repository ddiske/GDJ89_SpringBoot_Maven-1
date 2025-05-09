package com.root.app.board.qna;

import com.root.app.board.BoardDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaDTO extends BoardDTO {
	
	private Long boardRef;
	private Long boardStep;
	private Long boardDepth;

}
