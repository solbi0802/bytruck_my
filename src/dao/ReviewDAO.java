package dao;

import java.util.List;

import vo.Review;

public interface ReviewDAO {
	public List<Review> selectGoodRank();
}
