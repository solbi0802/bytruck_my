package service;

import java.util.List;

import dao.AdvertiseDAO;
import dao.AdvertiseDAOOracle;
import vo.Advertise;

public class AdvertiseService {
	private AdvertiseDAO dao = new AdvertiseDAOOracle();
	public List<Advertise> findAllAd() throws Exception {
		return dao.selectAllAd();
	}
	public Advertise findDetail(int no) throws Exception {
		return dao.selectDetail(no);
	}
}
