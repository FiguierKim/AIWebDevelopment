package my.jes.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import my.jes.web.vo.ContactVo;

@Mapper
@Repository
public interface ContactDao {

	public void insertContact(ContactVo c);

}
