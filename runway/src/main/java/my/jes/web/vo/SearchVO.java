package my.jes.web.vo;

import java.util.Date;

import my.jes.web.util.MyException;

public class SearchVO {

	private int calorie, distance, long_x, la_y, score;
	private String route_img, record_id;
	private Date date;
	
	public SearchVO(int calorie, int distance, int long_x, int la_y, int score, String route_img, String record_id,
			Date date) {
		super();
		this.calorie = calorie;
		this.distance = distance;
		this.long_x = long_x;
		this.la_y = la_y;
		this.score = score;
		this.route_img = route_img;
		this.record_id = record_id;
		this.date = date;
	}

	public int getCalorie() {
		return calorie;
	}
	
	public void setCalorie(int calorie) throws MyException{
		this.calorie = calorie;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) throws MyException{
		this.distance = distance;
	}
	
	public int getLong_x() {
		return long_x;
	}
	
	public void setLong_x(int long_x) throws MyException{
		this.long_x = long_x;
	}
	
	public int getLa_y() {
		return la_y;
	}
	
	public void setLa_y(int la_y) throws MyException{
		this.la_y = la_y;
	}
	public String getRoute_img() {
		return route_img;
	}
	
	public void setRoute_img(String route_img) throws MyException{
		this.route_img = route_img;
	}
	
	public String getRecord_id() {
		return record_id;
	}
	
	public void setRecord_id(String record_id) throws MyException{
		this.record_id = record_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) throws MyException{
		this.score = score;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) throws MyException{
		this.date = date;
	}

	@Override
	public String toString() {
		return "SearchVO [calorie=" + calorie + ", distance=" + distance + ", long_x=" + long_x + ", la_y=" + la_y
				+ ", score=" + score + ", route_img=" + route_img + ", record_id=" + record_id + ", date=" + date + "]";
	}
	
}
