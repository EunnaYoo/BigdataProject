package controller;

import java.util.ArrayList;

import model.domain.dto.Ramen;
import ramen.exception.NotExistException;
import ramen.service.RamenService;
import ramen.view.EndView;
import ramen.view.FailView;

public class AdminController {
	
	private static AdminController instance = new AdminController();
	private RamenService service = RamenService.getInstance();
	
	public AdminController(){}
	public static AdminController getInstance() {
		return instance;
	}
	
	// 전체 라면 검색
	public void ramenListView() {

		ArrayList<Ramen> ramenList = service.getAllList();

		if (ramenList.size() != 0) {
			EndView.ramenListView(ramenList);
		}
	}

	// 특정 라면 검색
	public void oneRamenView(String ramenName) {

		Ramen ramen = service.getRamenName(ramenName);

		if (ramen != null) {
			EndView.ramenView(ramen);
		} else {
			EndView.messageView("--------- 선택하신 라면이 존재하지 않습니다. --------");
		}
	}
	
	// 라면 리스트 추가
	public void insertRamen(Ramen newramen) {
		service.listInsert(newramen);
	}
	
	// 라면 가격 수정
	public void updateRamenPrice(String ramenName) {
		try {
			service.listUpdatePrice(ramenName);
			EndView.messageView("수정 되었습니다.");
		} catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	// 특정 프로젝트 삭제
	public void deleteRamen(String ramenName) {
		try {
			service.listDelete(ramenName);
			EndView.messageView("삭제 되었습니다.");
		} catch(NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
}















