package my.jes.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import my.jes.web.service.MapService;

@RestController
public class SearchController {
	
	@Autowired
	MapService mapService;
	
	@PostMapping("local2.jes")
	public String local2(@ModelAttribute("startX") String startX, @ModelAttribute("startY") String startY, 
			@ModelAttribute("endX") String endX, @ModelAttribute("endY") String endY, HttpServletRequest request,HttpServletResponse response) {				
		try {
			return mapService.local2(startX, startY, endX, endY);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
		
	}
	//ArrayList<String>
	@PostMapping("local3.jes")
	public String local3(@ModelAttribute("startX") double startX, @ModelAttribute("startY") double startY, 
			@ModelAttribute("distance") double distance, HttpServletRequest request,HttpServletResponse response) {				
		double[][] list = mapService.haversine(startX, startY, distance);
		//String[] responseData = new String[12];
		ArrayList<String> responseData = new ArrayList<String>();
		for (int i=0;i<12;i++) {
			try {
				String data = mapService.local2(Double.toString(startX), Double.toString(startY), Double.toString(list[i][0]), Double.toString(list[i][1]));
				if(data!=null) { 
					responseData.add(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for(int i=0;i<responseData.size();i++) {
			System.out.println(responseData.get(i));
		}
		return responseData.get(0);
	}

}