package project.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import project.domain.dto.MemberDto;
import project.domain.entity.MemberEntityRepository;
import project.service.MemberService;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private final MemberEntityRepository repository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public String reg(MemberDto dto) {
		dto.setPw(passwordEncoder.encode(dto.getPw()));
		repository.save(dto.toEntity());
		return "redirect:/";
	}

}
