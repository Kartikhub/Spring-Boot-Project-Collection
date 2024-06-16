package com.crent.MyBattle.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="wardetails")
public class Wars {
	@Id
	@GeneratedValue
	private Integer warId;
	private Integer attacker_kingId;
	private Integer defender_kingId;
	private String warName;
	private Integer year;
	private String attacker;
	private String defender;
	private String attacker_1;
	private String attacker_2;
	private String attacker_3;
	private String attacker_4;
	private String defender_1;
	public Integer getWarId() {
		return warId;
	}
	public void setWarId(Integer warId) {
		this.warId = warId;
	}
	public Integer getAttacker_kingId() {
		return attacker_kingId;
	}
	public void setAttacker_kingId(Integer attacker_kingId) {
		this.attacker_kingId = attacker_kingId;
	}
	public Integer getDefender_kingId() {
		return defender_kingId;
	}
	public void setDefender_kingId(Integer defender_kingId) {
		this.defender_kingId = defender_kingId;
	}
	public String getWarName() {
		return warName;
	}
	public void setWarName(String warName) {
		this.warName = warName;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getAttacker() {
		return attacker;
	}
	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}
	public String getDefender() {
		return defender;
	}
	public void setDefender(String defender) {
		this.defender = defender;
	}
	public String getAttacker_1() {
		return attacker_1;
	}
	public void setAttacker_1(String attacker_1) {
		this.attacker_1 = attacker_1;
	}
	public String getAttacker_2() {
		return attacker_2;
	}
	public void setAttacker_2(String attacker_2) {
		this.attacker_2 = attacker_2;
	}
	public String getAttacker_3() {
		return attacker_3;
	}
	public void setAttacker_3(String attacker_3) {
		this.attacker_3 = attacker_3;
	}
	public String getAttacker_4() {
		return attacker_4;
	}
	public void setAttacker_4(String attacker_4) {
		this.attacker_4 = attacker_4;
	}
	public String getDefender_1() {
		return defender_1;
	}
	public void setDefender_1(String defender_1) {
		this.defender_1 = defender_1;
	}
	public Integer getDefender_size() {
		return defender_size;
	}
	public void setDefender_size(Integer defender_size) {
		this.defender_size = defender_size;
	}
	private String defender_2;
	private String defender_3;
	private String defender_4;
	private String attacker_result;
	private String warType;
	private Integer death;
	private Integer capture;
	private Integer attacker_size;
	private Integer defender_size;
	private String attackCommander;
	private String defendCommander;
	private Integer summer;
	private String location;
	private String site;
	private String extras;
	public String getDefender_2() {
		return defender_2;
	}
	public void setDefender_2(String defender_2) {
		this.defender_2 = defender_2;
	}
	public String getDefender_3() {
		return defender_3;
	}
	public void setDefender_3(String defender_3) {
		this.defender_3 = defender_3;
	}
	public String getDefender_4() {
		return defender_4;
	}
	public void setDefender_4(String defender_4) {
		this.defender_4 = defender_4;
	}
	public String getAttacker_result() {
		return attacker_result;
	}
	public void setAttacker_result(String attacker_result) {
		this.attacker_result = attacker_result;
	}
	public String getWarType() {
		return warType;
	}
	public void setWarType(String warType) {
		this.warType = warType;
	}
	public Integer getDeath() {
		return death;
	}
	public void setDeath(Integer death) {
		this.death = death;
	}
	public Integer getCapture() {
		return capture;
	}
	public void setCapture(Integer capture) {
		this.capture = capture;
	}
	public Integer getAttacker_size() {
		return attacker_size;
	}
	public void setAttacker_size(Integer attacker_size) {
		this.attacker_size = attacker_size;
	}
	public String getAttackCommander() {
		return attackCommander;
	}
	public void setAttackCommander(String attackCommander) {
		this.attackCommander = attackCommander;
	}
	public String getDefendCommander() {
		return defendCommander;
	}
	public void setDefendCommander(String defendCommander) {
		this.defendCommander = defendCommander;
	}
	public Integer getSummer() {
		return summer;
	}
	public void setSummer(Integer summer) {
		this.summer = summer;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	} 

	

}
