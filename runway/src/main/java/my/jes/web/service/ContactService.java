package my.jes.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.jes.web.dao.ContactDAO;
import my.jes.web.vo.ContactVO;


@Service
public class ContactService {

	@Autowired
	ContactDAO contactDAO;

	public void insertContact(ContactVO c) throws Exception {
		contactDAO.insertContact(c);
	}

}
