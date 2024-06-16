package com.crent.MyBattle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "king")  //
public class King {
	@Id
	@GeneratedValue
	private Integer kingId;
	private String kingName;
	private Integer totalWinning;
	private Integer totallosing;
	public Integer getKingId() {
		return kingId;
	}
	public void setKingId(Integer kingId) {
		this.kingId = kingId;
	}
	public String getKingName() {
		return kingName;
	}
	public void setKingName(String kingName) {
		this.kingName = kingName;
	}
	public Integer getTotalWinning() {
		return totalWinning;
	}
	public void setTotalWinning(Integer totalWinning) {
		this.totalWinning = totalWinning;
	}
	public Integer getTotallosing() {
		return totallosing;
	}
	public void setTotallosing(Integer totallosing) {
		this.totallosing = totallosing;
	}
	
	
	

}
