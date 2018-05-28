package dao;

import java.util.List;
import vo.Board;

public interface BoardDAO {
	public List<Board> selectAll(int page) throws Exception;
	void insertBoard(Board board) throws Exception;
	int selectCount() throws Exception;
	public Board selectDetail(int boardNo) throws Exception;
}
