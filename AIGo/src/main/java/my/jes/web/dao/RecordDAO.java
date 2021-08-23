package my.jes.web.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.jes.web.vo.RecordVO;

@Mapper
@Repository
public class RecordDAO {
	
	@Autowired
	SqlSession sqlSession2;
	
	
	//ArrayList<RecordVO> recordList=  new ArrayList<RecordVO>();
	
	public List<RecordVO> selectAllRecords() {
		List<RecordVO> recordList = sqlSession2.selectList("mapper.record.selectAllRecords");
		return recordList;
	}

	public void insertRecord(RecordVO vo) {
		sqlSession2.insert("mapper.record.insertRecord", vo);
		
	}

	public List<RecordVO> selectRecord(String recordNO)  {
		List<RecordVO> recordList = sqlSession2.selectList("mapper.record.selectRecord", recordNO);
		return recordList;
		
	}

}
