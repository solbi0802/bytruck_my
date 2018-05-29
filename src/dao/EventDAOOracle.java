package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Event;

public class EventDAOOracle implements EventDAO{

	@Override
	public List<Event> selectEvent(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectAllSQL = "select * from event" 
							  +"where no = ?";
		List<Event>list = new ArrayList<>();
		
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectAllSQL);
			
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Event(
						 rs.getInt("no"),
						 rs.getString("userid"),
						 rs.getString("title"),
						 rs.getString("detail"),
						 rs.getDate("event_date")
						 ));
			}
			return list;
		}finally {
			MyConnection.close(rs, pstmt, con);			
		}
	}
}
