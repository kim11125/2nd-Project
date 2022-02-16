package project.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberGrade {

	USER("ROLE_USER", "회원"),
	ADMIN("ROLE_ADMIN", "관리자");
	
	final String role;
	final String title;
}
