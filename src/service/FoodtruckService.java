package service;

import java.util.List;

import dao.FoodtruckDAO;
import dao.FoodtruckDAOOracle;
import vo.Foodtruck;
import vo.Foodtruck_Location;

public class FoodtruckService {
	private FoodtruckDAO dao = new FoodtruckDAOOracle();

	public void signup(Foodtruck ft) throws Exception {
		dao.insert(ft);
	}

	public void foodtruckwrite(Foodtruck_Location fc) throws Exception{ //푸드트럭 글쓰기 등록
		dao.insertfoodtruck(fc);
	}
	
	public List<Foodtruck_Location> findByType(String type) throws Exception{
		List<Foodtruck_Location> list = dao.selectByType(type);
		if(list.size() == 0) {
			throw new Exception("아직 푸드트럭이 등록되지 않았습니다.");
		}
		return list;
	}
}
