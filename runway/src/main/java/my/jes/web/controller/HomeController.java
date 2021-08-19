package my.jes.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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



	@RequestMapping(value = "/selectAllMemberList")
	public List<MemberVO> selectAllMemberList(){
		System.out.println("MemberController allMem() " + new Date());
		
		return memberService.selectAllMemberList();
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
