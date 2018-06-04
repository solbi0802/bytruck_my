package dao;

import vo.Review;

public interface ReviewDAO {
	public Review selectDetail (int rnum) throws Exception;
}
