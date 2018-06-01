package vo;

import java.util.Date;

public class Review {
	private int no;
	private String user_id;
	private String location;
	private Date trip_date;
	private String title;
	private String detail;
	private int publicyn;
	private Date posted;
	private int views;
	private int good;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int no, String user_id, String location, Date trip_date, String title, String detail, int publicyn,
			Date posted, int views, int good) {
		super();
		this.no = no;
		this.user_id = user_id;
		this.location = location;
		this.trip_date = trip_date;
		this.title = title;
		this.detail = detail;
		this.publicyn = publicyn;
		this.posted = posted;
		this.views = views;
		this.good = good;
	}
	
	public Review(String user_id, int good) {
		this.user_id = user_id;
		this.good = good;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getTrip_date() {
		return trip_date;
	}

	public void setTrip_date(Date trip_date) {
		this.trip_date = trip_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPublicyn() {
		return publicyn;
	}

	public void setPublicyn(int publicyn) {
		this.publicyn = publicyn;
	}

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	@Override
	public String toString() {
		return "Review [no=" + no + ", user_id=" + user_id + ", location=" + location + ", trip_date=" + trip_date
				+ ", title=" + title + ", detail=" + detail + ", publicyn=" + publicyn + ", posted=" + posted
				+ ", views=" + views + ", good=" + good + "]";
	}	
}
