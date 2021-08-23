package my.jes.web.service;

import java.net.URLEncoder;
import java.util.ArrayList;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import my.jes.web.util.TMapRequestor;

@Service
public class MapService {
	
	public String local2(String param1, String param2, String param3, String param4) {
		//WGS84GEO
		String param = "&startX="+ param1 +"&startY="+param2+"&endX="+param3+"&endY="+param4+"&reqCoordType=KATECH&resCoordType=EPSG3857&startName="+URLEncoder.encode("출발지")+"&endName="+URLEncoder.encode("도착지");
		String urlString="https://apis.openapi.sk.com/tmap/routes/pedestrian?version=1&format=json&callback=result"+param;
		return TMapRequestor.request(urlString);

	}

	
	public double[][] haversine(double startX, double startY, long distance) {
		double[][] katech = coordConvertKATECH(startX, startY);
		startX = katech[0][0];
		startY = katech[0][1];
		
		
		double[][] list = new double[][] {
			{Math.round((startX + distance)*1000000)/1000000, Math.round(startY*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(30*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(30*Math.PI/180))*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(60*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(60*Math.PI/180))*1000000)/1000000},
			{Math.round(startX*1000000)/1000000, Math.round((startY+distance)*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(120*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(120*Math.PI/180))*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(150*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(150*Math.PI/180))*1000000)/1000000},
			{Math.round((startX - distance)*1000000)/1000000 , Math.round(startY*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(210*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(210*Math.PI/180))*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(240*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(240*Math.PI/180))*1000000)/1000000},
			{Math.round(startX*1000000)/1000000 , Math.round((startY-distance)*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(300*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(300*Math.PI/180))*1000000)/1000000},
			{Math.round((startX + distance*Math.cos(330*Math.PI/180))*1000000)/1000000, Math.round((startY + distance*Math.sin(330*Math.PI/180))*1000000)/1000000},
			{startX, startY}
		};

		return list;
	}
	
	public String local3(double startX, double startY, long distance){		
		double[][] list = haversine(startX, startY, (long) (distance/2/2));
		
        double finalDistance= (double) 0;
        
        String m ="";
        String data;
        int r=0;
        
		ArrayList<String> arraylist = new ArrayList<String>();
		ArrayList<String> arraylist1 = new ArrayList<String>();
		ArrayList<String> arraylist2 = new ArrayList<String>();
		
		for (int i=0;i<12;i++) {
			data = local2(Double.toString(list[12][0]), Double.toString(list[12][1]), Double.toString(list[i][0]), Double.toString(list[i][1]));
			if(data!=null) { 
				arraylist.add(data);
				arraylist1.add(Double.toString(list[i][0]));
				arraylist2.add(Double.toString(list[i][1]));
			}
		}	
			
		for (int j=0;j<arraylist.size();j++) {
			double totalDistance = objParser(arraylist.get(j));

			if(Math.abs(distance*1000-finalDistance)>Math.abs(distance*1000-totalDistance)) {
				finalDistance = totalDistance;
				m = arraylist.get(j);
				r = j;
			}
		}
		return m;
	}
	
	public Long objParser(String obj1) {
		
		JSONParser parser = new JSONParser(); 
		JSONObject obj;
		try {
			obj = (JSONObject)parser.parse(obj1);
			JSONArray arr = (JSONArray) obj.get("features");
			JSONObject obj2 = (JSONObject) arr.get(0);
			JSONObject obj3 = (JSONObject) obj2.get("properties");
			Long totalDistance = (Long) obj3.get("totalDistance");
			
			return totalDistance;
		} catch (ParseException e) {
			return (long) 0;
		}		
		
	}
	
	public double[][] coordConvertKATECH(double lon, double lat) {
		JSONParser parser = new JSONParser(); 
		String result = TMapRequestor.coordConvert(lon, lat);
		JSONObject obj;
		try {
			obj = (JSONObject)parser.parse(result);
			JSONObject obj2 = (JSONObject) obj.get("coordinate");
			double[][] list = new double[][] {
				{Double.parseDouble((String) obj2.get("lon")),Double.parseDouble((String) obj2.get("lat"))}
			};
			return list;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
