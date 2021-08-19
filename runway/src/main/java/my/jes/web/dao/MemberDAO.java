package my.jes.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import my.jes.web.vo.MemberVO;

@Mapper
@Repository
public interface MemberDAO {

	public List<MemberVO> selectAllMemberList();
}
