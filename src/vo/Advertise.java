package vo;

import java.util.Date;

public class Advertise {
	private String user_id;
	private int no;
	private int type;
	private Date start_date;
	private Date end_date;
	private String title;
	private String detail;
	
	public Advertise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertise(String user_id, int no, int type, Date start_date, Date end_date, String title, String detail) {
		super();
		this.user_id = user_id;
		this.no = no;
		this.type = type;
		this.start_date = start_date;
		this.end_date = end_date;
		this.title = title;
		this.detail = detail;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
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

	public Advertise(int no, String title, String user_id) {
		super();
		this.user_id = user_id;
		this.no = no;
		this.title = title;
	}

	@Override
	public String toString() {
		return "Advertise [user_id=" + user_id + ", no=" + no + ", type=" + type + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", title=" + title + ", detail=" + detail + "]";
	}	
	
}
