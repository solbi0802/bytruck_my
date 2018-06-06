package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Advertisement;
import vo.Board;

public class AdvertiseDAOOracle implements AdvertiseDAO {

	@Override
	public List<Advertisement> selectAllAd() throws Exception {
		List<Advertisement> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectAllSQL = "select no, title, user_id " + " from advertisement" + " order by no desc";
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectAllSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Advertisement(rs.getInt("no"), rs.getString("title"), rs.getString("user_id")));
			}
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return list;
	}

	public static void main(String[] args) {
		AdvertiseDAOOracle test = new AdvertiseDAOOracle();
		try {
			List<Advertisement> list = test.selectAllAd();
			System.out.println(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Advertisement selectDetail(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Advertisement ad = new Advertisement();
		String selectDetailSQL = "SELECT no, title, user_id, detail"
								+" FROM advertisement"
								+" WHERE no = ?"
								+" ORDER BY no desc";
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectDetailSQL);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title");
				String id = rs.getString("user_id");
				String detail = rs.getString("detail");
				ad = new Advertisement(no, title, id, detail);
			}
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return ad;
	}
}
