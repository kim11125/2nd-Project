package project.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import project.domain.dto.MemberDto;
import project.domain.entity.MemberEntity;
import project.domain.entity.MemberEntityRepository;
import project.security.MemberGrade;
import project.service.MemberService;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberEntityRepository repository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public String reg(MemberDto dto) {
		
		MemberEntity entity;
		
		dto.setPw(passwordEncoder.encode(dto.getPw()));
		
		entity = dto.toEntity();
		if(dto.getUserId().contains("admin")) {
			entity.addRole(MemberGrade.USER);
			entity.addRole(MemberGrade.ADMIN);
			System.out.println("관리자");
		}else {
			entity.addRole(MemberGrade.USER);
			System.out.println("일반");
		}
		
		repository.save(entity);
		
		return "redirect:/";
	}

}
