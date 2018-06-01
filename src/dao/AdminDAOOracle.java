package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Review;
import vo.Users;

public class AdminDAOOracle implements AdminDAO {

	public List<Review> selectGoodRank() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectGoodRankSQL = " select RANK()OVER (ORDER BY good desc), user_id, good" + " from review";
		List<Review> list = new ArrayList<>();
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectGoodRankSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Review(rs.getString("user_id"), rs.getInt("good")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public List<Users> selectUserConut() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectUserCountSQL = " select COUNT(type) from users";
		List<Users> list = new ArrayList<>();
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectUserCountSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Users(rs.getString("type")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return list;
	}
}
