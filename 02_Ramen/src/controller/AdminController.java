package controller;

import java.util.ArrayList;

import log.Log4J;
import model.domain.dto.Ramen;
import net.sf.json.JSONArray;
import ramen.exception.NotExistException;
import ramen.service.RamenService;
import ramen.view.EndView;
import ramen.view.FailView;

public class AdminController {

	private static AdminController instance = new AdminController();
	private RamenService service = RamenService.getInstance();
	private Log4J log = Log4J.getInstance();

	public AdminController(){}
	public static AdminController getInstance() {
		return instance;
	}

	// 전체 라면 검색
	public void ramenListView() {

		ArrayList<Ramen> ramenList = service.getAllRamen();

		if (ramenList.size() != 0) {
			EndView.ramenListView(ramenList);
			log.info();
		} else {
			log.error();
		}
	}

	// 특정 라면 선택
	public void oneRamenView(String ramenName) {

		Ramen ramen = service.getRamenName(ramenName);
		
		EndView.selectRamenView("[ 라면을 선택해주십시오. ]");

		if (ramen != null) {
			EndView.ramenView(ramen);
			log.info();
		} else {
			EndView.messageView("--------- 선택하신 라면이 존재하지 않습니다. --------");
			log.error();
		}
	}

	// 라면 리스트 추가
	public void insertRamen(Ramen newramen) {
		service.ramenListInsert(newramen);
		EndView.insertMessageView(newramen.getName() + " 레시피가 추가되었습니다.");
		log.info();
	}

	// 라면 가격 수정
	public void updateRamenPrice(String ramenName) {
		try {
			service.listUpdatePrice(ramenName);
			EndView.messageView("가격이 수정 되었습니다.");
			log.info();
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// 특정 라면 삭제
	public void deleteRamen(String ramenName) {
		try {
			service.ramenListDelete(ramenName);
			EndView.messageView("삭제 되었습니다.");
			log.info();
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// 라면 데이터 JSON으로 가져오기
	public void JsonListView() {
		JSONArray ramenList = service.getAllJson();		
		if(ramenList.size() != 0) {
			EndView.ramenJsonView(ramenList);	
			log.info();
		} else {
			EndView.messageView("라면 리스트가 존재하지 않습니다.");
			log.error();
		}
	}
}


