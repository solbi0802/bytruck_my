package vo;

import java.sql.Date;

public class Event {
	private int no;
	private String user_id;
	private String title;
	private String detail;
	private Date event_date;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int no, String user_id, String title, String detail, Date event_date) {
		super();
		this.no = no;
		this.user_id = user_id;
		this.title = title;
		this.detail = detail;
		this.event_date = event_date;
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

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	@Override
	public String toString() {
		return "Event [no=" + no + ", user_id=" + user_id + ", title=" + title + ", detail=" + detail + ", event_date="
				+ event_date + "]";
	}
}
