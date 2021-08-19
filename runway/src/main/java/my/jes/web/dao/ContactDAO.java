package my.jes.web.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.jes.web.vo.ContactVO;

@Repository
public class ContactDAO {

	@Autowired
	SqlSession sqlSession;

	public void insertContact(ContactVO c) {
		sqlSession.insert("mapper.member.insertContact", c);
	}


}
