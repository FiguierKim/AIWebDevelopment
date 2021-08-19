package my.jes.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.ContactService;
import my.jes.web.service.MemberService;
import my.jes.web.vo.ContactVO;
import my.jes.web.vo.MemberVO;

@RestController
public class HomeController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	ContactService contactService;

	// 회원탈퇴
	@RequestMapping(value = "memberDelete.jes", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		MemberVO m = (MemberVO) session.getAttribute("member");

		memberService.deleteMember(m);
		session.invalidate();
		return "";
	}

	// 로그아웃
	@RequestMapping(value = "logout.jes", method = { RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		session.invalidate();
		return "";
	}

//	// 로그인
//	@PostMapping("login.jes")
//	public MemberVO login(@ModelAttribute("info") MemberVO m, HttpServletRequest request,
//			HttpServletResponse response) {
//
//		try {
//
//			System.out.println(m);
//
//			String name = memberService.login(m);
//			if (name != null) {// ok HttpSession
//				HttpSession session = request.getSession();
//				session.setAttribute("member", m);
//				m.setName(name);
//			} else {
//				m = new MemberVO();
//			}
//		} catch (Exception e) {
//			m = new MemberVO();
//		}
//
//		return m;
//
//	}
	// 로그인
	@PostMapping("login.jes")
	public MemberVO login(@ModelAttribute("info") MemberVO m, HttpSession session, HttpServletResponse response) {

		MemberVO mem = memberService.login(m);

		if (mem != null && mem.getId().equals("")) {
			session.setAttribute("member", mem);
		}

		return mem;

	}

	// 회원가입
	@RequestMapping(value = "memberInsert.jes", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String memberInsert(@RequestParam("id") String id, @RequestParam("pw") String pw,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "age", required = false) int age,
			@RequestParam(value = "weight", required = false) float weight,
			@RequestParam(value = "height", required = false) float height,
			@RequestParam(value = "gender", required = false) String gender, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		MemberVO m = new MemberVO(id, pw, name, email, age, weight, height, gender);
		System.out.println(m);

		try {
			memberService.memberInsert(m);
			return name + "님 회원가입 되셨습니다.";
		} catch (Exception e) {
			return "오류가 발생하였습니다. 잠시 후 다시 시도해주세요.";
		}

	}

	// 칼로리계산 기본정보 가져오기
	@GetMapping("getCal.jes")
	public MemberVO getCal(MemberVO m, HttpSession session) throws Exception {

		MemberVO mem = memberService.getCal(m);

		return mem;
	}

	// Contact US 내용 db에 저장하기
	@RequestMapping(value = "insertContact.jes", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String insertContact(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "comment", required = false) String comment, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ContactVO c = new ContactVO(name, email, comment);
		System.out.println(c);

		try {
			contactService.insertContact(c);
			return name + "님 문의내용이 접수되었습니다.\n조속한 시일내에 답변드릴 수 있도록 하겠습니다.";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

}
