package project.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import project.domain.entity.MemberEntity;
import project.domain.entity.MemberEntityRepository;

public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	MemberEntityRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<MemberEntity> result = repository.findByUserId(username);
		
		//회원정보 유무 확인
		if(result.isEmpty()) {
			throw new UsernameNotFoundException("회원정보없음");
		}
		
		//회원정보 존재시
		MemberEntity entity = result.get();
		
		//인증정보 UserDetails로 리턴
		return new MyUserDetails(entity);
	}


}
