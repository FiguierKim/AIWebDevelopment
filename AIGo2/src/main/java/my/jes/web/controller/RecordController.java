package my.jes.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.RecordService;
import my.jes.web.vo.RecordVO;

@RestController
public class RecordController {
	
	@Autowired
	RecordService recordService;
	
	@PostMapping("local4.jes")
	public String local4(@ModelAttribute("id") String id, HttpServletRequest request,HttpServletResponse response) {				
		
		try {
			List<RecordVO> record =  recordService.selectRecord(id);
			JSONArray jsonArray=new JSONArray();
			for(RecordVO vo:record) {					
				JSONObject o=new JSONObject();
				
				o.put("id", vo.getId());
				o.put("R_id", vo.getR_id());
				o.put("route", vo.getRoute());
				o.put("calorie", vo.getCalorie());
				o.put("distance", vo.getDistance());
				o.put("date", vo.getDate().toString());
				jsonArray.add(o);
			}
			return jsonArray.toJSONString();
		}catch(Exception e){
			return "recordService 에러";
		}
		
	}
	
	@RequestMapping(value = "local5.jes", method = {
			RequestMethod.POST }, produces = "application/text; charset=utf8")
	public String recordInsert(@RequestParam("id") String id, 
			@RequestParam("route") String route,
			@RequestParam("calorie") String calorie,
			@RequestParam("distance") String distance,
			@RequestParam("memo") String memo,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		RecordVO v = new RecordVO(id, route, calorie, distance, memo);
		System.out.println(v);

		try {
			recordService.insertRecord(v);
			return "sucess";
		} catch (Exception e) {
			return "error";
		}
		
	}
}	
