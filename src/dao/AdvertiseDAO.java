package dao;

import java.util.List;

import vo.Advertisement;

public interface AdvertiseDAO {
	public List<Advertisement> selectAllAd() throws Exception;
	public Advertisement selectDetail(int no) throws Exception;
}
