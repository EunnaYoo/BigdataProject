package ramen.service;

import java.util.ArrayList;

import model.domain.dto.Ramen;
import model.domain.dto.Topping;
import net.sf.json.JSONArray;
import ramen.exception.NotExistException;
import ramen.model.RamenVirtualDB;
import ramen.model.ToppingVirtualDB;

public class RamenService {
	
	private static RamenService instance = new RamenService();
	private RamenVirtualDB ramenVirtualData = RamenVirtualDB.getInstance();
	private ToppingVirtualDB toppingVirtualData = ToppingVirtualDB.getInstance();
	
	private RamenService(){}
	public static RamenService getInstance() {
		return instance;
	}
		
	// 전체 라면 보여주기
	public ArrayList<Ramen> getAllList() {
		
		return ramenVirtualData.getramenList();
	}
	
	// 라면 검색
	public Ramen getRamenName(String RamenName) {

		ArrayList<Ramen> ramen = ramenVirtualData.getramenList();

		for (int i = 0; i < ramen.size(); i++) {
			if (ramen != null && ramen.get(i).getName().equals(RamenName)) {
				return ramen.get(i);
			}
		}
		return null;
	}
	
	// 라면 검색 예외처리
	public Ramen getRamenNameExcept(String RamenName) throws NotExistException {

		Ramen ramen = getRamenName(RamenName);

		if (ramen == null) {
			throw new NotExistException("--------- 선택하신 라면이 존재하지 않습니다. --------");
		}
		return ramen;
	}
	
	// 라면 리스트 추가
	public void listInsert(Ramen newramen) {
		ramenVirtualData.insertList(newramen);
	}
	
	// 라면 리스트 가격 수정
	public void listUpdatePrice(String ramenName) throws NotExistException {
		
		Ramen search = getRamenName(ramenName);
		
		if(search == null) {
			throw new NotExistException("-------- 수정 가능한 리스트가 존재하지 않습니다. --------");
		} else {
			search.setPrice(search.getPrice() - 500);
		}
	}
	
	// 라면 리스트 삭제
	public void listDelete(String ramenName) throws NotExistException {
		
		Ramen search = getRamenName(ramenName);
		ArrayList<Ramen> v = ramenVirtualData.getramenList();
		
		for(int i = 0; i < v.size(); i++) {
			
			if(search == null) {
				throw new NotExistException("-------- 삭제할 수 있는 리스트가 존재하지 않습니다. --------");
			} else if (v.get(i).getName() == ramenName) {
				v.remove(i);
			}
		}
	}
	
	// 전체 토핑 보여주기
	public ArrayList<Topping> getAllTopping() {

		return toppingVirtualData.getToppingList();
	}
	
	// 토핑 선택
	public Topping getToppingName(String ToppingName) {

		ArrayList<Topping> topping = toppingVirtualData.getToppingList();

		for (int i = 0; i < topping.size(); i++) {
			if (topping != null && topping.get(i).getName().equals(ToppingName)) {
				return topping.get(i);
			}
		}
		return null;
	}

	// 토핑 선택 예외처리
	public Ramen getToppingNameExcept(String ToppingName) throws NotExistException {

		Ramen topping = getRamenName(ToppingName);

		if (topping == null) {
			throw new NotExistException("--------- 선택하신 라면이 존재하지 않습니다. --------");
		}
		return topping;
	}
	
	// 계산 프로세스
	public int payProcess(String ramenName, String toppingName, int userMoney) throws NotExistException {
		
		Ramen ramen = getRamenName(ramenName);
		Topping topping = getToppingName(toppingName);
		
		int tot = ramen.getPrice() + topping.getPrice();
		
		if (ramenName == null) {
			throw new NotExistException("--------- 선택하신 라면이 존재하지 않습니다. --------");
		} else if (userMoney > tot) {
			return userMoney - tot;
		} else if(userMoney < tot) {
			return userMoney - tot;
		} else if(userMoney == tot) {
			return userMoney - tot;
		}
		return tot;
	}
	
	// 라면 데이터 json으로 가져오기
	public JSONArray getAllJson() {
		return ramenVirtualData.getjson();
	}
}

























