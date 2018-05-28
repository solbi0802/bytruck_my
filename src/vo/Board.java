package vo;

import java.util.Date;

public class Board {
	private int no;
	private int type;
	private String title;
	private String detail;
	private Date posted;
	private String user_id;
	private int views;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(int no, int type, String title, String detail, Date posted) {
		super();
		this.no = no;
		this.type = type;
		this.title = title;
		this.detail = detail;
		this.posted = posted;
	}
	
	public Board(int no, String title, Date posted, int views) {
		super();
		this.no = no;
		this.title = title;
		this.posted = posted;
		this.views = views;
	}	
	public Board(int no, int type, String title, Date posted, int views) {
		super();
		this.no = no;
		this.type = type;
		this.title = title;
		this.posted = posted;
		this.views = views;
	}
	
	public Board(int no, int type, String title, String detail, Date posted, String user_id, int views) {
		super();
		this.no = no;
		this.type = type;
		this.title = title;
		this.detail = detail;
		this.posted = posted;
		this.user_id = user_id;
		this.views = views;
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

	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}
	
	@Override
	public String toString() {
		return "Board [no=" + no + ", type=" + type + ", title=" + title + ", detail=" + detail + ", posted=" + posted
				+ ", user_id=" + user_id + ", views=" + views + "]";
	}

}
