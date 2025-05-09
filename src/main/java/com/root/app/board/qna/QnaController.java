package com.root.app.board.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

import com.root.app.board.BoardDTO;
import com.root.app.websocket.ChatHandler;
import com.root.app.websocket.WebSocketCollection;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private ChatHandler chatHandler;
	
	@GetMapping("list")
	public String getList(Model model) throws Exception {
		
		model.addAttribute("list", qnaService.getList());
		
		return "board/list";
	}
	
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		
		model.addAttribute("dto", qnaService.getDetail(boardDTO));
		
		return "board/detail";
	}
	
	@GetMapping("add")
	public String add(Authentication authentication) throws Exception {
		if(authentication == null) {
			return "user/login";
		}
		return "board/add";
	}
	
	@PostMapping("add")
	public String add(QnaDTO boardDTO, Authentication authentication) throws Exception {
		
		boardDTO.setUsername(authentication.getName());
		qnaService.add(boardDTO);
		
		return "redirect:./list";
	}
	
	@GetMapping("reply")
	public String reply(Authentication authentication, @ModelAttribute BoardDTO boardDTO) throws Exception {
		if(authentication == null) {
			return "user/login";
		}
		return "board/add";
	}
	
	@PostMapping("reply")
	public String reply(QnaDTO boardDTO, Authentication authentication) throws Exception {
//		WebSocketMessage<?> message = new TextMessage(boardDTO.getUsername());
		String receiver = boardDTO.getUsername();
		
		boardDTO.setUsername(authentication.getName());
		qnaService.reply(boardDTO);
		
//		chatHandler.handleMessage(null, message);
		WebSocketCollection.USERS.get(receiver).sendMessage(new TextMessage("답글 달림"));
		
		return "redirect:./list";
	} 

}
