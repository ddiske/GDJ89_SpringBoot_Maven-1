package com.root.app.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {
	
	public List<BoardDTO> getList() throws Exception;
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	public int add(BoardDTO boardDTO) throws Exception;

}
