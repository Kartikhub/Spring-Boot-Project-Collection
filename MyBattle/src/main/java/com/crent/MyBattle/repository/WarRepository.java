package com.crent.MyBattle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crent.MyBattle.entity.Wars;

@Repository
public interface WarRepository extends JpaRepository<Wars, Integer>{
	
	List<Wars> findAll();
	Wars findByWarIdAndWarName(Integer warId, String warname);  //

}
