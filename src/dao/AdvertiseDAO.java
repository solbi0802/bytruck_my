package dao;

import java.util.List;

import vo.Advertise;

public interface AdvertiseDAO {
	public List<Advertise> selectAllAd() throws Exception;
}
