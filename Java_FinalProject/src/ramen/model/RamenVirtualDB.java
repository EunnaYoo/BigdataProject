package ramen.model;

import java.util.ArrayList;
import model.domain.dto.Ramen;
import net.sf.json.JSONArray;

public class RamenVirtualDB {
	
	private static RamenVirtualDB instance = new RamenVirtualDB();
	private ArrayList<Ramen> ramenList = new ArrayList<Ramen>();
	
	private RamenVirtualDB() {
		
		ramenList.add(new Ramen("신라면", 3000, "3분"));
		ramenList.add(new Ramen("진라면", 3000, "3분"));
		ramenList.add(new Ramen("안성탕면", 3000, "3분"));
		ramenList.add(new Ramen("불닭볶음면", 2000, "3분"));
		ramenList.add(new Ramen("팔도비빔면", 2000, "3분"));
		ramenList.add(new Ramen("짜파게티", 2000, "3분"));
	}
	
	public static RamenVirtualDB getInstance() {
		return instance;
	}
	
	public ArrayList<Ramen> getramenList() {
		return ramenList;
	}
	
	public void insertList(Ramen ramen) {
		ramenList.add(ramen);
	}
	
	public JSONArray getjson() {
		JSONArray jsonArray = JSONArray.fromObject(ramenList);
		return jsonArray;
	}
}


