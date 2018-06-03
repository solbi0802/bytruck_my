package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sql.MyConnection;
import vo.Board;

public class BoardDAOOracle implements BoardDAO {

	@Override
	public void insertboard(Board board) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertSQL = "insert into board(no, type, title, detail, posted) values(board_no_seq.nextval, 0, ?, ?, sysdate)";
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getDetail());
			pstmt.executeUpdate();
		}finally {
			MyConnection.close(pstmt, con);			
		}
	}

	@Override
	public int selectCount() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectCountSQL = "SELECT COUNT(*) totalcnt" 
								+ " FROM board" 
							     + " WHERE type= 0";
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectCountSQL);
			rs = pstmt.executeQuery();
			rs.next();
			int totalCount = rs.getInt("totalcnt");
			return totalCount;
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
	}

	@Override
public List<Board> getBoardList(int page) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<Board>();
		
		try {
			
		con = MyConnection.getConnection();
		
		String sql = "SELECT b.*\r\n" + 
				"FROM   (SELECT  rownum r, a.*\r\n" + 
				"        FROM (select *\r\n" + 
				"              from board\r\n" + 
				"             )a\r\n" + 
				"        WHERE type = 0\r\n" + 
				"        order by no desc\r\n" + 
				"        )b\r\n" + 
				"where r >=? and r <= ?"; //지금 이 문장은 10개만 불러온다. 다음 페이지에도 뿌릴려면 
			
		pstmt = con.prepareStatement(sql);
		int cntPerpage=10;
		int endRow=cntPerpage * page;
		int startRow = endRow - cntPerpage + 1;
		
		pstmt.setInt(1, startRow);
		pstmt.setInt(2, endRow);		
		rs = pstmt.executeQuery();	
		System.out.println("execute");
		while(rs.next()) {
			Board bl = new Board();
			bl.setNo(rs.getInt("no"));
			bl.setType(rs.getInt("type"));
			bl.setTitle(rs.getString("title"));
			bl.setDetail(rs.getString("detail"));
			bl.setUser_id(rs.getString("user_id"));
			bl.setViews(rs.getInt("views"));
			bl.setPosted(rs.getString("posted"));
			list.add(bl);	
			System.out.println(bl.getNo());
		}
		}catch(Exception e) {
			e.getMessage();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
		return list;
	}
	
	@Override
	public Board selectDetail(int boardNo,int btype) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board b = null;
		String selectDetailSQL = "SELECT no, type, title, detail, posted"
								+" FROM board"
								+" WHERE no = ? and type=?";
		try {
			con = sql.MyConnection.getConnection();
			pstmt = con.prepareStatement(selectDetailSQL);
			pstmt.setInt(1,boardNo);
			pstmt.setInt(2, btype);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = boardNo;
				int t = btype;
				String title = rs.getString("title");
				String detail = rs.getString("detail");
				String pdate = rs.getString("posted");
				b = new Board(no, t, title, detail, pdate);
			}
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return b;
	}
	public static void main(String[] args) {
		BoardDAOOracle test = new BoardDAOOracle();
		int boardNo = 3; int btype= 0;
		try {
			Board b = test.selectDetail(boardNo, btype);
			System.out.println("공지사항 게시판: " +b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteBoard(int boardNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//System.out.println(boardNum);
		try {
			con = sql.MyConnection.getConnection();
			String sql = "delete from board\r\n" + 
					"where no = ? and type = 0";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			pstmt.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, con);
		}		
	}
}