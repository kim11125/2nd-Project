package project.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import project.domain.entity.MemberEntity;

public class MyUserDetails extends User{

	//principal로 접근 가능하게 할 것들
	private String name;
	
	
	public MyUserDetails(MemberEntity entity) {
		super(
				entity.getUserId(),			//username(아이디)
				entity.getPw(),				//password
				entity.getGradeSet().stream()
						.map(grade -> new SimpleGrantedAuthority(grade.getRole()))
						.collect(Collectors.toSet())
				);
		
	}

}
