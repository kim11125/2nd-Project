package project.domain.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDto {
	
	private Long bno;
	private String title;
	private String content;
	private String member;
	private LocalDateTime createdDate;
	
//	public BoardDto(BoardEntity entity) {
//		this.bno = entity.getBno();
//		this.title = entity.getTitle();
//		this.content = entity.getContent();
//		this.member = entity.getMember().getName();
//		this.createdDate = entity.getCreatedDate();
//	}
	
	
}
