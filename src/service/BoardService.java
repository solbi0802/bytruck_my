package service;

import java.util.List;

import dao.BoardDAO;
import dao.BoardDAOOracle;
import vo.Board;

public class BoardService {
	private BoardDAO dao = new BoardDAOOracle();
	
	public int findCount() throws Exception{
		return dao.selectCount();
	}
	public List<Board> findAll(int page) throws Exception{
		return dao.selectAll(page);
	}
	public void write(Board board)  throws Exception{
		dao.insertBoard(board);
	}
	public Board findDetail(int boardNo) throws Exception {
		return dao.selectDetail(boardNo);
	}
}
