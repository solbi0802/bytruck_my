package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Board;

/**
 * Servlet implementation class BoardListServlet
 */
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService service = new BoardService();   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		int intPage=1;
		if(page != null) {
			intPage = Integer.parseInt(page);
		}
		try {
			/*//게시물 총목록수
			int totalCount = service.findCount();
			
			//총페이지수계산			
			int totalPage = 0;
			int cntPerPage=3;//1페이지별 3건씩 보여준다
			totalPage = (int)Math.ceil((double)totalCount/ cntPerPage);               
			
			//페이지그룹에서 쓰일 시작페이지값, 끝페이지값계산
			int cntPerPageGroup=3; //페이지그룹별 3페이지씩 보여준다
			//int startPage = intPage/cntPerPageGroup*cntPerPageGroup+1;
			int startPage = (int)Math.floor((double)(intPage)/(cntPerPageGroup+1))*cntPerPageGroup+1;
			int endPage = startPage+cntPerPageGroup-1;
			if(endPage > totalPage) {
				endPage = totalPage;
			}	*/
			List<Board> list = service.findAll(intPage);
			request.setAttribute("boardlist", list);
			/*List<Board> list = service.findAll(intPage);
			vo.PageBean<Board> pb = new vo.PageBean<>();
			pb.setCurrentPage(intPage);//현재페이지
			pb.setTotalPage(totalPage); //총페이지
			pb.setList(list); //목록
			pb.setStartPage(startPage); //시작페이지
			pb.setEndPage(endPage); //끝페이지
			request.setAttribute("pagebean", pb);*/
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", e.getMessage());
		}
		RequestDispatcher rd;
		String forwardURL = "brand/notice.jsp";
		rd = request.getRequestDispatcher(forwardURL);
		rd.forward(request, response);
		
	}

}
