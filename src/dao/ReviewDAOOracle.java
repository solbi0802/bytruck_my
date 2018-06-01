package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Profit;
import vo.Review;

public class ReviewDAOOracle implements ReviewDAO {

	@Override
	public List<Review> selectGoodRank() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectGoodRankSQL = " select RANK()OVER (ORDER BY good desc), user_id, good" 
								+" from review";
		List<Review> list = new ArrayList<>();
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectGoodRankSQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Review(
						rs.getString("user_id"),
						rs.getInt("good")
						));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ReviewDAOOracle test = new ReviewDAOOracle();
		try {
			List<Review> list = test.selectGoodRank();
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
