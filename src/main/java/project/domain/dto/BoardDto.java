package project.domain.dto;

import lombok.Data;

@Data
public class BoardDto {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	
}