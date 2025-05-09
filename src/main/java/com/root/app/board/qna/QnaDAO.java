package com.root.app.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.root.app.board.BoardDAO;

@Mapper
public interface QnaDAO extends BoardDAO {
	
	public int refUpdate(QnaDTO qnaDTO) throws Exception;
	public int stepUpdate(QnaDTO qnaDTO) throws Exception;
	public int stepUpdate2(QnaDTO qnaDTO) throws Exception;
	public int depthUpdate(QnaDTO qnaDTO) throws Exception;

}
