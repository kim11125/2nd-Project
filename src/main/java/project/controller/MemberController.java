package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import project.domain.dto.MemberDto;
import project.service.MemberService;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService service;
	
	//회원가입페이지 이동
	@GetMapping("/reg")
	public String regPage() {
		return "/member/reg";
	}
	
	//회원가입
	@PostMapping("/reg")
	public String reg(MemberDto dto) {
		return service.reg(dto);
	}
	
	//로그인페이지
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
}
