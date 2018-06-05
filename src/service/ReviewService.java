package service;

import dao.ReviewDAO;
import dao.ReviewDAOOracle;
import vo.Review;

public class ReviewService {
	ReviewDAO dao = new ReviewDAOOracle();
	public Review findDetail(int bnum) throws Exception {
		return dao.selectDetail(bnum);
	}
}
