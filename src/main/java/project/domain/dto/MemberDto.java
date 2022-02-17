package project.domain.dto;

import lombok.Data;
import project.domain.entity.member.MemberEntity;

@Data
public class MemberDto {
	
	private String userId;
	private String pw;
	private String name;
	
	public MemberEntity toEntity() {
		return MemberEntity.builder()
				.userId(userId).pw(pw).name(name)
				.build();
	}
}
