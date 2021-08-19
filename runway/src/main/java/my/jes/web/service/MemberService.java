package my.jes.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.jes.web.dao.MemberDAO;
import my.jes.web.vo.MemberVO;

@Service
@Transactional
public class MemberService {

	@Autowired
	MemberDAO memberDAO;

	
	public List<MemberVO> selectAllMemberList() {
		return memberDAO.selectAllMemberList(); 
	}

}
