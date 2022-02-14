package project.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
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
	
}
