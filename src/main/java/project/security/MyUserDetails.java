package project.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import project.domain.entity.member.MemberEntity;

@Data
public class MyUserDetails extends User{

	//principal로 접근 가능하게 할 것들
	private Long mno;
	private String name;
	
	public MyUserDetails(MemberEntity entity) {
		super(
				entity.getUserId(),			//username(아이디)
				entity.getPw(),				//password
				entity.getGradeSet().stream()
						.map(grade -> new SimpleGrantedAuthority(grade.getRole()))
						.collect(Collectors.toSet())
				);
		name = entity.getName();
	}

}
