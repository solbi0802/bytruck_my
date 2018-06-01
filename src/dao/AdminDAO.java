package dao;

import java.util.List;

import vo.Review;
import vo.Users;

public interface AdminDAO {
	public List<Review> selectGoodRank() throws Exception;
	public List<Users>selectUserConut() throws Exception;
}
