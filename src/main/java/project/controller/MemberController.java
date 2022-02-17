package project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	@GetMapping("/loginPage")
	public String login() {
		return "/member/login";
	}
	
	//로그아웃페이지
	@GetMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/";
	}

	
}
