package com.root.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.app.board.BoardDTO;
import com.root.app.board.BoardService;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList() throws Exception {
		return qnaDAO.getList();
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	@Override
	public int add(QnaDTO boardDTO) throws Exception {
		int result = qnaDAO.add(boardDTO);
		boardDTO.setBoardRef(boardDTO.getBoardNum());
		result = qnaDAO.refUpdate(boardDTO);
		return result;
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parentDTO = (QnaDTO)qnaDAO.getDetail(qnaDTO);
		qnaDTO.setBoardRef(parentDTO.getBoardRef());
		int result = qnaDAO.add(qnaDTO);
		result = qnaDAO.refUpdate(qnaDTO);
		result = qnaDAO.stepUpdate(parentDTO);
		qnaDTO.setBoardStep(parentDTO.getBoardStep());
		result = qnaDAO.stepUpdate2(qnaDTO);
		qnaDTO.setBoardDepth(parentDTO.getBoardDepth());
		result = qnaDAO.depthUpdate(qnaDTO);
		
		return result;
	}

}
