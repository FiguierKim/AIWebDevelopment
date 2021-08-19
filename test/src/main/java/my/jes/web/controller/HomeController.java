package my.jes.web.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.MemberService;
import my.jes.web.vo.MemberVO;

@RestController
public class HomeController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/allMember")
	public List<MemberVO> allMem(){
		System.out.println("MemberController allMem() " + new Date());
		
		return service.allmember();
	}

}
