package my.jes.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import my.jes.web.vo.MemberVo;

@Mapper
@Repository
public interface MemberDao {

	public List<MemberVo> allMember();
	
	public MemberVo login(MemberVo m);
	
	public void memberInsert(MemberVo m);
	
	public MemberVo getCal(MemberVo m);
	
	public int checkId(MemberVo m);
	
}