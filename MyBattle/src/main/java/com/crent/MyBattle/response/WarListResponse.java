package com.crent.MyBattle.response;

import java.util.List;

public class WarListResponse extends ErrorResponse{
	
	private List<WarResponse> warList;

	public List<WarResponse> getWarList() {
		return warList;
	}

	public void setWarList(List<WarResponse> warList) {
		this.warList = warList;
	}
	
	

}
