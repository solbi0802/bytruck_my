package dao;

import java.util.List;

import vo.Advertise;

public interface AdvertiseDAO {
	public List<Advertise> selectAllAd() throws Exception;
	public Advertise selectDetail(int no) throws Exception;
}
