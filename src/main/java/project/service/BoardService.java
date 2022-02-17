package project.service;

import java.security.Principal;

import project.domain.dto.BoardDto;

public interface BoardService {

	String boardwrite(BoardDto dto, Principal principal);

}
