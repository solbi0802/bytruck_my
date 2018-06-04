package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Foodtruck;
import vo.Foodtruck_Location;

public class FoodtruckDAOOracle implements FoodtruckDAO {

	@Override
	public List<Foodtruck_Location> selectAll() throws Exception {

		return null;
	}

	@Override
	public List<Foodtruck_Location> selectByType(String type) throws Exception {
		List<Foodtruck_Location> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = sql.MyConnection.getConnection();
			String selectByTypeSQL = "SELECT title, imgpath" + " FROM Foodtruck_Location" + " WHERE foodtype = ?";
			pstmt = con.prepareStatement(selectByTypeSQL);
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new Foodtruck_Location(rs.getString("title"), rs.getString("imgpath")));
			}
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public void insertfoodtruck(Foodtruck_Location fc) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertSQL = "insert into foodtruck_location(no, user_id, title, opendate, detail, poweryn, foodtype, imgpath) "
				+ "values(foodtruck_no_seq.nextval, 'EJ', ?, to_char(to_date(?, 'yyyy-mm-dd')), ?, ?, ?, ?)";
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, fc.getTitle());
			pstmt.setString(2, fc.getOpendate());
			pstmt.setString(3, fc.getDetail());
			pstmt.setString(4, fc.getPoweryn());
			pstmt.setString(5, fc.getFoodtype());
			pstmt.setString(6, fc.getImgpath());

			pstmt.executeUpdate();
		} finally {
			MyConnection.close(pstmt, con);
		}
	}

	@Override
	public void insert(Foodtruck ft) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = sql.MyConnection.getConnection();
			String insertSQL = "INSERT INTO foodtruck(user_id, bussiness_name, menu_name, price, menu_type, detail) VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, ft.getUser_id());
			pstmt.setString(2, ft.getBussiness_name());
			pstmt.setString(3, ft.getMenu_name());
			pstmt.setInt(4, ft.getPrice());
			pstmt.setInt(5, ft.getMenu_type());
			pstmt.setString(6, ft.getDetail());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == 1) {
				throw new Exception("이미 사용중인 아이디입니다");
			} else {
				throw e;
			}
		} finally {
			sql.MyConnection.close(pstmt, con);
		}
	}

	public static void main(String[] args) {
		FoodtruckDAOOracle test = new FoodtruckDAOOracle();
		String type = "drink";
		try {
			List<Foodtruck_Location> list = test.selectByType(type);
			for (Foodtruck_Location f : list) {
				System.out.println(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Foodtruck_Location selectDetail(int fNum) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Foodtruck_Location f = new Foodtruck_Location();
		try {
			con = sql.MyConnection.getConnection();
			String selectByTypeSQL = "SELECT *" 
									+ " FROM Foodtruck_Location" 
									+ " WHERE no = ?";
			pstmt = con.prepareStatement(selectByTypeSQL);
			pstmt.setInt(1, fNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				f = new Foodtruck_Location(
						rs.getInt("no"), 
						rs.getString("user_id"), 
						rs.getString("title"),
						rs.getString("opendate"), 
						rs.getString("detail"), 
						rs.getString("poweryn"),
						rs.getString("foodtype"), 
						rs.getString("imgpath"));
			}
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return f;
	}
}
