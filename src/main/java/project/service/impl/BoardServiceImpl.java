package project.service.impl;

import java.security.Principal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import project.domain.dto.BoardDto;
import project.domain.entity.board.BoardEntity;
import project.domain.entity.board.BoardEntityRepository;
import project.domain.entity.member.MemberEntityRepository;
import project.service.BoardService;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardEntityRepository repository;
	private final MemberEntityRepository memberEntityRepository;
	
	//게시글 작성처리
	@Override
	public String boardwrite(BoardDto dto, Principal principal) {
		
//		BoardEntity result = BoardEntity.builder()
//								.title(dto.getTitle())
//								.content(dto.getContent())
//								.member(memberEntityRepository.findByUserId(principal.getName()).get())
//								.build();
//		
//		repository.save(result);
		return "redirect:/board";
}

}
