package service;

import java.util.List;

import dao.ReviewDAO;
import dao.ReviewDAOOracle;
import vo.Review;

public class ReviewService {
	ReviewDAO dao = new ReviewDAOOracle();
	public List<Review> findGoodRank() {
		return dao.selectGoodRank();
	}
}
