package service;

import java.util.List;

import dao.AdminDAO;
import dao.AdminDAOOracle;
import vo.Review;
import vo.Users;

public class AdminService {
	AdminDAO dao = new AdminDAOOracle();
	public List<Review> findGoodRank() throws Exception {
		return dao.selectGoodRank();
	}
	
	public List<Users> findUserCount() throws Exception{
		return dao.selectUserConut();
	}
	
	
}
