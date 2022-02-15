package project.domain.dto;

import lombok.Data;
import project.domain.entity.MemberEntity;

@Data
public class MemberDto {
	
	private String userId;
	private String pw;
	
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.userId(userId).pw(pw)
				.build();
	}
}
