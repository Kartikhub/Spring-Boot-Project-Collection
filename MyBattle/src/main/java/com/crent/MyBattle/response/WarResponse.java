package com.crent.MyBattle.response;

public class WarResponse {
	private Integer battleId;
	private String battleName;
	private Integer year;
	private Integer attackerSize;
	private Integer defenderSize;
	private String locaion;
	private String region;
	public Integer getBattleId() {
		return battleId;
	}
	public void setBattleId(Integer battleId) {
		this.battleId = battleId;
	}
	public String getBattleName() {
		return battleName;
	}
	public void setBattleName(String battleName) {
		this.battleName = battleName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getAttackerSize() {
		return attackerSize;
	}
	public void setAttackerSize(Integer attackerSize) {
		this.attackerSize = attackerSize;
	}
	public Integer getDefenderSize() {
		return defenderSize;
	}
	public void setDefenderSize(Integer defenderSize) {
		this.defenderSize = defenderSize;
	}
	public String getLocaion() {
		return locaion;
	}
	public void setLocaion(String locaion) {
		this.locaion = locaion;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	

}
