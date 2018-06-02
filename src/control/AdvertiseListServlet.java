package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AdvertiseService;
import vo.Advertise;
import vo.Event;

/**
 * Servlet implementation class AdvertiseListServlet
 */
public class AdvertiseListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdvertiseService service = new AdvertiseService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvertiseListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Advertise> advertise = service.findAllAd();
			request.setAttribute("advertise", advertise);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd;
		String forwardURL = "admin/ad_board.jsp";
		rd = request.getRequestDispatcher(forwardURL);
		rd.forward(request, response);
	}
}
