package service;

import java.util.List;

import dao.BoardDAO;
import dao.BoardDAOOracle;
import vo.Board;

public class BoardService {
	private BoardDAO dao = new BoardDAOOracle();
	public void write(Board board) throws Exception{
		dao.insertboard(board);
	}
	
	public int findCount() throws Exception{
		return dao.selectCount();
	}
	
	public List<Board> findAll(int page) throws Exception{
		return dao.selectAll(page);
	}
	
	public Board findDetail(int boardNo, int btype) throws Exception {
		return dao.selectDetail(boardNo, btype);
	}
	
	public void addWrite(Board board) throws Exception{
		dao.insertboard(board);
	};
	
	public void Delete(int boardNum) throws Exception{
		dao.deleteBoard(boardNum);
	};
	
	public void modify(Board board) throws Exception{
		dao.updateboard(board);
	}
}
