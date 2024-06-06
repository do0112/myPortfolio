package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.web.dto.MemberDTO;
import com.example.web.entity.Member;
import com.example.web.entity.MemberCart;
import com.example.web.message.Message;
import com.example.web.service.CartService;
import com.example.web.service.KakaoService;
import com.example.web.service.MemberCartService;
import com.example.web.service.MemberService;
import com.example.web.service.NaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	@Autowired
	private MemberCartService memberCartService;
	@Autowired
	private CartService cartService;
	@Autowired
	private KakaoService kakaoService;
	@Autowired
	private NaverService naverService;
	static String loginUser;
	
	@GetMapping("/member/login")
	public String login(Model model){
		model.addAttribute("kakaoUrl",kakaoService.getKakaoLogin());
		model.addAttribute("naverUrl",naverService.getNaverLogin());
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public String loginOk(RedirectAttributes re,@RequestParam String id,@RequestParam String pw, Model model) {
		
		Member member = service.userLogin(id,pw);
		
		if(member != null) {
			loginUser = member.getUserId();
			re.addAttribute("loginMember", member.getUserId());
			return "redirect:/";
		}else {
			model.addAttribute("message", new Message("아이디 또는 비밀번호를 확인하세요!","/member/login"));
		}
		return "layouts/message";
	}
	
	
	
	@GetMapping("/member/logout")
	public String logout(Model model) {
		model.addAttribute("message", Message.builder().message("로그아웃 되었습니다!").uri("/").build());
		loginUser = null;
		model.addAttribute("loginMember", loginUser);
		
		return "layouts/message";
	}
	
	@GetMapping("/member/join")
	public String join(Model model) {
		model.addAttribute("member", new Member());
		return "member/join";
	}
	@PostMapping("/member/join")
	public String joinOk(Member member,Model model) {
		service.memberJoin(member);
		MemberCart memberCart = new MemberCart(member.getUserId());
		memberCartService.memberCartInsert(memberCart);
		model.addAttribute("message", new Message("가입 성공!","/member/login"));
		
		return "layouts/message";
	}
	
	@GetMapping("/member/searchMemberId")
	public String searchMemberId() {
		return "member/searchMemberId";
	}
	
	@PostMapping("/member/searchMemberId")
	public String searchMemberIdOk(@RequestParam String uName,@RequestParam String uPhone, Model model) {
		String userid = service.searchId(uName,uPhone);
		if(userid != null) {
			model.addAttribute("username", uName);
			model.addAttribute("userid", userid);
			return "member/searchMemberIdOk";
		}else {
			model.addAttribute("message", Message.builder().message("이름 또는 휴대폰번호를 확인하세요!").uri("/member/searchMemberId").build());
		}
		return "layouts/message";
	}
	
	@GetMapping("/member/searchMemberPw")
	public String searchMemberPw() {
		return "member/searchMemberPw";
	}
	
	@PostMapping("/member/searchMemberPw")
	public String searchMemberPwOk(@RequestParam String uId,Model model) {
		Member member = service.idCheck(uId);
		if(member != null) {
			String email = member.getMail();
			model.addAttribute("email", email);
			model.addAttribute("uId", uId);
			return "member/MemberCertification";
		}else {
			model.addAttribute("message", Message.builder().message("회원정보를 찾을 수 없습니다!").uri("/member/searchMemberPw").build());
		}
		return "layouts/message";
	}
	
	@PostMapping("/member/memberCertification")
	public String memberCertificationOk(@RequestParam() String userId,@RequestParam() String mail,Model model) {
		
		//이메일 보내기
		log.info("email : {}", mail);
		log.info("userid : {}",userId);
		model.addAttribute("uId", userId);
		return "member/memberCertificationConfirm";
	}
	
	@PostMapping("/member/memberCertificationConfirm")
	public String memberPwReset(@RequestParam() String str,@RequestParam() String userId,Model model) {
		if(str.equals("환영합니다!")) {
			log.info("환영합니다 : {}",userId);
			model.addAttribute("uId",userId);
			return "member/memberPwReset";
		}else {
			model.addAttribute("message", Message.builder().message("인증문자가 다릅니다!").uri("/member/searchMemberPw").build());
		}
		return "layouts/message";
	}
	
	@PostMapping("/member/memberPwReset")
	public String searchMemberOk(@RequestParam() String userId,@RequestParam String newPw,Model model) {
		service.passwordReset(newPw, userId);
		model.addAttribute("message", Message.builder().message("비밀번호가 변경되었습니다!").uri("/member/login").build()); 
		return "layouts/message";
	}
	
	@GetMapping("/member/myPage")
	public String myPage(Model model) {
		if(loginUser == null) {
			model.addAttribute("message", Message.builder().message("로그인 후 사용하세요!").uri("/member/login").build()); 
		}else {
			model.addAttribute("loginMember", loginUser);
			return "member/myPage";
		}
		return "layouts/message";
	}
	
	
	@GetMapping("/member/myInfo")
	public String myInfo(Model model) {
		model.addAttribute("loginMember", loginUser);
		return "member/myInfo";
	}
	
	@PostMapping("/member/myInfo")
	public String myInfoPro(@RequestParam String userPw,Model model) {
		Member member = service.idCheck(loginUser);
		
		if((member.getUserPw()).equals(userPw)) {
			model.addAttribute("loginMember", loginUser);
			model.addAttribute("member",member);
			
			return "member/myInfoView";
		}else {
			model.addAttribute("message", Message.builder().message("비밀번호를 확인하세요!").uri("/member/myInfo").build()); 
		}
		model.addAttribute("loginMember", loginUser);
		return "layouts/message";
	}
	
	@GetMapping("/member/myInfoUpdate")
	public String myInfoUpdate(Model model) {
		model.addAttribute("loginMember", loginUser);
		model.addAttribute("memberDTO",new MemberDTO());
		return "member/myInfoUpdate";
	}
	

	@PostMapping("/member/myInfoUpdate")
	public String myInfoViewOk(MemberDTO memberDTO,Model model) {
		service.memberUpdate(memberDTO,loginUser);
		model.addAttribute("message", Message.builder().message("개인정보가 수정되었습니다!").uri("/member/myPage").build()); 
		model.addAttribute("loginMember", loginUser);
		return "layouts/message";
	}
	
	@GetMapping("/member/pwReset")
	public String pwReset(Model model) {
		model.addAttribute("loginMember", loginUser);
		return "member/myInfoPwReset";
	}
	
	@PostMapping("/member/pwReset")
	public String pwResetOk(@RequestParam String infoPw,@RequestParam String infoNewPw,Model model) {
		Member member = service.idCheck(loginUser);
		if(member.getUserPw().equals(infoPw)) {
			service.passwordReset(infoNewPw, member.getUserId());
			model.addAttribute("message", Message.builder().message("비밀번호가 변경되었습니다!").uri("/member/login").build());             
		}else {
			model.addAttribute("message", Message.builder().message("비밀번호를 다시 확인하세요!").uri("/member/myPage").build()); 
		}
		model.addAttribute("loginMember", loginUser);
		return "layouts/message";
	}
	
	@GetMapping("/member/memberDel")
	public String memberDel(Model model) {
		model.addAttribute("loginMember", loginUser);
		return "member/memberDel";
	}
	
	
	@PostMapping("/member/memberDel")
	public String memberDelete(@RequestParam String memberPw,Model model) {
		Member member = service.idCheck(loginUser);
		if(member.getUserPw().equals(memberPw)) {
			service.memberDel(loginUser);
			Long userNum = memberCartService.findUserNum(loginUser);
			cartService.cartAllDel(userNum);
			memberCartService.memberCartDel(userNum);
			loginUser = null;
			model.addAttribute("message", Message.builder().message("그동안 이용해 주셔서 감사합니다! 꼭 또 만나요ㅠㅠ").uri("/").build());
		}else {
			model.addAttribute("message", Message.builder().message("비밀번호를 다시 확인해주세요!").uri("/member/memberDel").build());
		}
		return "layouts/message";
	}
	
	
	
	@GetMapping("/kakao/login")
	public String kakao(String code) {
		log.info("code:{}",code);
		loginUser = kakaoService.getKakaoInfo(code);
		MemberCart memberCart = new MemberCart(loginUser);
		memberCartService.memberCartInsert(memberCart);
		
		return "redirect:/"; 
	}
	
	@GetMapping("/naver/login")
	public String naver(String code) {
		log.info("code:{}",code);
		loginUser = naverService.getNaverInfo(code);
		MemberCart memberCart = new MemberCart(loginUser);
		memberCartService.memberCartInsert(memberCart);
		
		return "redirect:/"; 
	}
	
	
}
