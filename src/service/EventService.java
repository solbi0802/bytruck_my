package service;

import java.util.List;

import dao.EventDAO;
import dao.EventDAOOracle;
import vo.Event;

public class EventService {
	private EventDAO dao = new EventDAOOracle();
	
	public void eventwrite(Event ev) throws Exception {
		dao.insertevent(ev);
	}

	public List<Event> findAll() throws Exception {
		return dao.selectAll();
	}
	public List<Event>findEvent() throws Exception{
		return dao.selectEvent();
	}
}
