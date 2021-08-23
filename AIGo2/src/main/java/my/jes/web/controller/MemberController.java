package my.jes.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.ContactService;
import my.jes.web.service.MemberService;
import my.jes.web.vo.ContactVo;
import my.jes.web.vo.MemberVo;

@RestController
public class MemberController {

	@Autowired
	MemberService ms;

	@Autowired
	ContactService cs;
	
	//ID중복체크
	@RequestMapping(value="checkId.jes",method = {RequestMethod.POST })
	public int checkId(MemberVo m) {
		
		int result = ms.checkId(m);
		
		return result;
	}

	// 로그인
	@PostMapping("login.jes")
	public MemberVo login(@ModelAttribute("info") MemberVo m, HttpSession session, HttpServletResponse response) {

		MemberVo mv = ms.login(m);

		if (mv != null && mv.getId().equals("")) {
			session.setAttribute("member", mv);
		}

		return mv;

	}

	// 로그아웃
	@RequestMapping(value = "logout.jes", method = { RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		session.invalidate();
		return "";
	}

	// 회원가입
	@RequestMapping(value = "memberInsert.jes", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String memberInsert(MemberVo m, HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			ms.memberInsert(m);
			return m.getName() + "님 회원가입 되셨습니다.";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	// 회원조회
	@RequestMapping(value = "allMember.jes")
	public List<MemberVo> allMem() {
		return ms.allMember();
	}

	// 칼로리계산 기본정보 가져오기
	@GetMapping("getCal.jes")
	public MemberVo getCal(MemberVo m, HttpSession session) throws Exception {
		MemberVo mv = ms.getCal(m);
		return mv;
	}

	// 문의내용 저장
	@RequestMapping(value = "insertContact.jes", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String insertContact(ContactVo c, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			cs.insertContact(c);
			return "complete";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

}
