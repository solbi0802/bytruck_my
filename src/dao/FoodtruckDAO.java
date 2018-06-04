package dao;

import java.util.List;

import vo.Foodtruck;
import vo.Foodtruck_Location;

public interface FoodtruckDAO {
	public void insertfoodtruck(Foodtruck_Location fc) throws Exception; //푸드트럭 글쓰기 등록
	void insert(Foodtruck ft) throws Exception;
	public List<Foodtruck_Location> selectAll() throws Exception;
	public List<Foodtruck_Location> selectByType(String type) throws Exception;
	public Foodtruck_Location selectDetail(int fNum) throws Exception;
}
