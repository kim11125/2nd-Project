package project.service.impl;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	
	//게시판리스트
//	@Override
//	public String board(BoardDto dto, Model model) {
//		List<BoardDto> result = repository.findAll().stream()
//										.map(BoardDto :: new)
//										.collect(Collectors.toList());
//		model.addAttribute("list", result);
//		
//		return "/board/boardlist";
//	}
	
	//게시글 작성처리
	@Override
	public String boardwrite(BoardDto dto, Principal principal) {
		
		BoardEntity result = BoardEntity.builder()
								.title(dto.getTitle())
								.content(dto.getContent())
								.member(memberEntityRepository.findByUserId(principal.getName()).get())
								.build();
		
		repository.save(result);
		return "redirect:/board";
}

}
