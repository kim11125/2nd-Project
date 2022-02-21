package project.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import project.domain.dto.BoardDto;
import project.service.BoardService;

@RequiredArgsConstructor
@Controller
public class BoardController {

	private final BoardService service;
	
	//게시판 페이지 이동
	@GetMapping("/board")
	public String board(BoardDto dto, Model model) {
		//return service.board(dto, model);
		return "/board/boardlist";
	}
	
	//게시판 글쓰기 페이지 이동
	@GetMapping("/boardwrite")
	public String boardwrite() {
		return "/board/boardwrite";
	}
	
	@PostMapping("/boardwrite")
	public String boardwrite(BoardDto dto, Principal principal) {
		return service.boardwrite(dto, principal);
	}
	
	
}
