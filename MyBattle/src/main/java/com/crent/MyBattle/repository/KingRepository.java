package com.crent.MyBattle.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crent.MyBattle.entity.King;

@Repository
public interface KingRepository extends JpaRepository<King, Integer> {
	King findByKingId(Integer kingId);
	King findByKingName(String kingName);
	
	@Transactional
	@Modifying
	@Query("update King set totalWinning = totalWinning + ?2 ,totallosing = totallosing + 1  where kingName=?1")
	void updateKingDetails(String uniqueNum , Integer totalWinning, Integer totalLosing);
}
