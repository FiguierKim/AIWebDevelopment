package my.jes.web.service;

import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import my.jes.web.util.TMapRequestor;

@Service
public class MapService {
	
	public String local2(String param1, String param2, String param3, String param4) throws Exception {
		String param = "&startX="+ param1 +"&startY="+param2+"&endX="+param3+"&endY="+param4+"&reqCoordType=WGS84GEO&resCoordType=EPSG3857&startName="+URLEncoder.encode("출발지")+"&endName="+URLEncoder.encode("도착지");
		String urlString="https://apis.openapi.sk.com/tmap/routes/pedestrian?version=1&format=json&callback=result"+param;
		return TMapRequestor.request(urlString);
	}
	

	
	public double[][] haversine(double startX, double startY, double distance) {
		double radius = 6371;
		double r = distance/radius;
		double[][] list = new double[][] {
			{startX + r, startY},
			{startX + r*Math.cos(30*Math.PI/180), startY + r*Math.sin(30*Math.PI/180)},
			{startX + r*Math.cos(60*Math.PI/180), startY + r*Math.sin(60*Math.PI/180)},
			{startX, startY + r},
			{startX + r*Math.cos(120*Math.PI/180), startY + r*Math.sin(120*Math.PI/180)},
			{startX + r*Math.cos(150*Math.PI/180), startY + r*Math.sin(150*Math.PI/180)},
			{startX - r , startY},
			{startX + r*Math.cos(210*Math.PI/180), startY + r*Math.sin(210*Math.PI/180)},
			{startX + r*Math.cos(240*Math.PI/180), startY + r*Math.sin(240*Math.PI/180)},
			{startX , startY -r},
			{startX + r*Math.cos(300*Math.PI/180), startY + r*Math.sin(300*Math.PI/180)},
			{startX + r*Math.cos(330*Math.PI/180), startY + r*Math.sin(330*Math.PI/180)}
			
		};
		return list;
	}

}
