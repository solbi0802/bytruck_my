package vo;

public class Advertisement {
	private String user_id;
	private int no;
	private String title;
	private String detail;
	
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Advertisement(int no, String title, String user_id, String detail) {
		super();
		this.user_id = user_id;
		this.no = no;
		this.title = title;
		this.detail = detail;
	}
	
	
	public Advertisement(int no, String title, String user_id) {
		super();
		this.user_id = user_id;
		this.no = no;
		this.title = title;
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

	@Override
	public String toString() {
		return "Advertise [user_id=" + user_id + ", no=" + no + ", title=" + title + ", detail=" + detail + "]";
	}
}
