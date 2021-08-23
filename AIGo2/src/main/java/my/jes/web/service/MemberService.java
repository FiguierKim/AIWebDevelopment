package my.jes.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.jes.web.dao.MemberDao;
import my.jes.web.vo.MemberVo;

@Service
@Transactional
public class MemberService {

	@Autowired
	MemberDao dao;
	
	public List<MemberVo> allMember() {
		return dao.allMember();
	}
	
	public MemberVo login(MemberVo m) {
		return dao.login(m);
	}
	
	public void memberInsert(MemberVo m) throws Exception {
		dao.memberInsert(m);
	}
	
	public MemberVo getCal(MemberVo m) {
		return dao.getCal(m);
	}
	
	public int checkId(MemberVo m) {
		int result = dao.checkId(m);
		return result;
	}
	
}

