package project.service;

import java.security.Principal;

import org.springframework.ui.Model;

import project.domain.dto.BoardDto;

public interface BoardService {

//	String board(BoardDto dto, Model model);

	String boardwrite(BoardDto dto, Principal principal);

}
