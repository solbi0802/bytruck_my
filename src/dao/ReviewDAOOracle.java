package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Board;
import vo.Foodtruck_Location;
import vo.Profit;
import vo.Review;

public class ReviewDAOOracle implements ReviewDAO {

	@Override
	public Review selectDetail(int rnum) throws Exception {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Review r = new Review();
	    try {
	         String selectDetailSQL = "SELECT *" 
	                           + " FROM review" 
	                           + " WHERE no = ?"
	                           +" ORDER BY no desc";
	         con = sql.MyConnection.getConnection();
	         pstmt = con.prepareStatement(selectDetailSQL);
	         pstmt.setInt(1, rnum);
	         rs = pstmt.executeQuery();
	         if (rs.next()) {
	        		int no = rnum;
	        		String id = rs.getString("user_id");
	        		String tdate = rs.getString("trip_date");
					String title = rs.getString("title");
					String detail = rs.getString("detail");
					String pdate = rs.getString("posted");
					int views = rs.getInt("views");
					int good = rs.getInt("good");
					r = new Review(no, id, tdate, title, detail, pdate, views, good);
	        	 
	         }
	      } finally {
	         MyConnection.close(rs, pstmt, con);
	      }
	      return r;
	}
	
	public static void main(String[] args) {
		ReviewDAOOracle test = new ReviewDAOOracle();
		try {
			Review r = test.selectDetail(5);
			System.out.println(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
