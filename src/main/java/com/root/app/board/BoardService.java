package com.root.app.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.root.app.board.qna.QnaDTO;

@Service
public interface BoardService {
	
	public List<BoardDTO> getList() throws Exception;
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	public int add(BoardDTO boardDTO) throws Exception;
	int add(QnaDTO boardDTO) throws Exception;

}
