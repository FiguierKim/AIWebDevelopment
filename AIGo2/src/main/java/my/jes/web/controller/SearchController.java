package my.jes.web.controller;


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
			@ModelAttribute("distance") long distance, HttpServletRequest request,HttpServletResponse response){		
		System.out.println("mapservice result: "+ mapService.local3(startX, startY, distance));
		return mapService.local3(startX, startY, distance);
	}
}

