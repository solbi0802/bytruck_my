package service;

import java.util.List;

import dao.EventDAO;
import dao.EventDAOOracle;
import vo.Event;

public class EventService {
	private EventDAO dao = new EventDAOOracle();
	public List<Event>findEvent(int no) throws Exception{
		return dao.selectEvent(no);
	}
}
