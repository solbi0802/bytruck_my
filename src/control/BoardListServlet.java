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
			/*//�Խù� �Ѹ�ϼ�
			int totalCount = service.findCount();
			
			//�������������			
			int totalPage = 0;
			int cntPerPage=3;//1�������� 3�Ǿ� �����ش�
			totalPage = (int)Math.ceil((double)totalCount/ cntPerPage);               
			
			//�������׷쿡�� ���� ������������, �������������
			int cntPerPageGroup=3; //�������׷캰 3�������� �����ش�
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
			pb.setCurrentPage(intPage);//����������
			pb.setTotalPage(totalPage); //��������
			pb.setList(list); //���
			pb.setStartPage(startPage); //����������
			pb.setEndPage(endPage); //��������
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
