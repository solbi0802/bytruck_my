package service;

import java.util.List;

import dao.AdvertiseDAO;
import dao.AdvertiseDAOOracle;
import vo.Advertisement;

public class AdvertiseService {
	private AdvertiseDAO dao = new AdvertiseDAOOracle();
	public List<Advertisement> findAllAd() throws Exception {
		return dao.selectAllAd();
	}
	public Advertisement findDetail(int no) throws Exception {
		return dao.selectDetail(no);
	}
}
