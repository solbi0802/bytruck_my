package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EventService;
import vo.Event;

/**
 * Servlet implementation class EventListServlet
 */
public class EventListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EventService service = new EventService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Event> event = service.findEvent();
			request.setAttribute("event", event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd;
		String forwardURL = "/admin/admin_calendar.jsp";
		rd = request.getRequestDispatcher(forwardURL);
		rd.forward(request, response);
	}
}
