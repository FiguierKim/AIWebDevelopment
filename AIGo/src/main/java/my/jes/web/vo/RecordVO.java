package my.jes.web.vo;

import java.util.Date;

import my.jes.web.util.MyException;

public class RecordVO {
	
	private String R_id;
	private String id;
	private String route;
	private String calorie;
	private String distance;
	private String memo;
	private Date date;
	
	
	public RecordVO() {
		super();
	}


	public RecordVO(String id, String route, String calorie, String distance, String memo) throws Exception {
		super();
		setId(id);
		setRoute(route);
		setCalorie(calorie);
		setDistance(distance);
		setMemo(memo);
		setDate(null);
	}
	
	public RecordVO(String r_id, String id, String route, String calorie, String distance, String memo, Date date) throws Exception {
		super();
		setId(id);
		setRoute(route);
		setCalorie(calorie);
		setDistance(distance);
		setMemo(memo);
		setDate(date);
	}



	public String getR_id() {
		return R_id;
	}


	public void setR_id(String r_id) throws Exception {
		
		if (id != null) {
			this.R_id = r_id;
		} else {
			throw new Exception("R_id가 입력되지 않았습니다");
		}
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) throws Exception {
		if (id != null) {
			this.id = id;
		} else {
			throw new Exception("id가 입력되지 않았습니다");
		}
	}


	public String getRoute() {
		return route;
	}


	public void setRoute(String route) throws Exception {
		if (id != null) {
			this.route = route;
		} else {
			throw new Exception("route가 입력되지 않았습니다");
		}
		
	}


	public String getCalorie() {
		return calorie;
	}


	public void setCalorie(String calorie) throws Exception {
		
		if (id != null) {
			this.calorie = calorie;
		} else {
			throw new Exception("calorie가 입력되지 않았습니다");
		}
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) throws Exception {
		
		if (id != null) {
			this.distance = distance;
		} else {
			throw new Exception("distance가 입력되지 않았습니다");
		}
		
	}
	
	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) throws Exception {
		
		if (id != null) {
			this.memo = memo;
		} else {
			throw new Exception("memo가 입력되지 않았습니다");
		}
		
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) throws Exception {
		
		if (id != null) {
			this.date = date;
		} else {
			this.date = new Date();
		}
	}
	

}
