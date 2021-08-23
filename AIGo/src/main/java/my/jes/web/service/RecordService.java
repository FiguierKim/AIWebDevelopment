package my.jes.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import my.jes.web.dao.RecordDAO;
import my.jes.web.vo.RecordVO;

@Service
@Transactional
public class RecordService {
	
	@Autowired
	RecordDAO recordDAO;
	
	public List<RecordVO> selectAllRecords() {
		return recordDAO.selectAllRecords();
	}

	public void insertRecord(RecordVO vo) {
		recordDAO.insertRecord(vo);
	}

	public List<RecordVO> selectRecord(String recordNO)  {	
		
		return recordDAO.selectRecord(recordNO);
	}
	

}
