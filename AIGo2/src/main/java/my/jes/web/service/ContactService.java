package my.jes.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.jes.web.dao.ContactDao;
import my.jes.web.vo.ContactVo;


@Service
@Transactional
public class ContactService {

	@Autowired
	ContactDao dao;

	public void insertContact(ContactVo c) throws Exception {
		dao.insertContact(c);
	}

}
