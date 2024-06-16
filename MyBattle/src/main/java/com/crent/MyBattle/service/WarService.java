package com.crent.MyBattle.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crent.MyBattle.beans.ErrorCodes;
import com.crent.MyBattle.entity.King;
import com.crent.MyBattle.entity.Wars;
import com.crent.MyBattle.repository.KingRepository;
import com.crent.MyBattle.repository.WarRepository;
import com.crent.MyBattle.request.WarRequest;
import com.crent.MyBattle.response.ErrorResponse;
import com.crent.MyBattle.response.WarDetailsResponse;
import com.crent.MyBattle.response.WarListResponse;
import com.crent.MyBattle.response.WarResponse;




@Service
public class WarService {
	
	@Autowired
	WarRepository warRepository;
	
	@Autowired
	KingRepository kingRepository;
	
	
	
	public ErrorResponse getWarList() {
		WarListResponse warListResponse = new WarListResponse();
		List<Wars> warList = warRepository.findAll();
		if(warList == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(ErrorCodes.NO_BATTLE_LIST_CODE);
			errorResponse.setErrorMsg(ErrorCodes.NO_BATTLE_LIST_MSG);
			return errorResponse;
		}
		List<WarResponse> warResponseList = new ArrayList<>();
		for(Wars wars : warList) {
			WarResponse warResponse= new WarResponse();
			warResponse.setBattleId(wars.getWarId());
			warResponse.setBattleName(wars.getWarName());
			warResponse.setLocaion(wars.getLocation());
			warResponse.setAttackerSize(wars.getAttacker_size());
			warResponse.setDefenderSize(wars.getDefender_size());
			warResponse.setYear(wars.getYear());
			warResponse.setRegion(wars.getSite());
			warResponseList.add(warResponse);
		}
		
		warListResponse.setWarList(warResponseList); 
		warListResponse.setErrorCode(ErrorCodes.SUCCESS_CODE);
		warListResponse.setErrorMsg(ErrorCodes.SUCCESS_MSG);
		return warListResponse;
	}
	
	public ErrorResponse feedWarDetails() throws IOException {
		ErrorResponse errorResponse = new ErrorResponse();
		try {
			String line="";
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/BattleList.csv"));  //
			int count = 0;
			while((line = br.readLine()) != null) {
				
				String [] data = line.split("\"");   //
				if(data.length==1 && count >1) {
					line = line + " ,";
					String [] finalData = line.split(",");
					Wars wars= new  Wars();
					wars.setWarName(finalData[0]);
					
					if(!finalData[1].equals("")) {
						wars.setYear(Integer.parseInt(finalData[1]));
					}
					
					if(!finalData[3].equals("")) {
						King attackerkingMaster = kingRepository.findByKingName(finalData[3]);
						if(attackerkingMaster==null) {
							King kingMaster =new King();
							kingMaster.setKingName(finalData[3]);
							if(finalData[13].equals("win")) {
								kingMaster.setTotalWinning(1);
								kingMaster.setTotallosing(0);
							}
							kingRepository.save(kingMaster);
							King attackerkingMaster1 = kingRepository.findByKingName(finalData[3]);
							wars.setAttacker_kingId(attackerkingMaster1.getKingId());
						}else {
							if(finalData[13].equals("win")) {
								kingRepository.updateKingDetails(finalData[3], 1, 0);
							}
							else {
								kingRepository.updateKingDetails(finalData[3], 0, 1);	
							}
							wars.setAttacker_kingId(attackerkingMaster.getKingId());
						}
					}
					if(!finalData[4].equals("")) {
						King defenderkingMaster = kingRepository.findByKingName(finalData[4]);
						if(defenderkingMaster==null) {
							King kingMaster1 =new King();
							kingMaster1.setKingName(finalData[4]); 
							if(finalData[13].equals("win")) {
								kingMaster1.setTotalWinning(0);
								kingMaster1.setTotallosing(1);
							}
							kingRepository.save(kingMaster1);
							King defenderkingMaster1 = kingRepository.findByKingName(finalData[4]);
							wars.setDefender_kingId(defenderkingMaster1.getKingId());
						}else {
							if(finalData[13].equals("win")) {
								kingRepository.updateKingDetails(finalData[4], 0, 1);
							}
							else {
								kingRepository.updateKingDetails(finalData[4], 1, 0);	
							}
							wars.setDefender_kingId(defenderkingMaster.getKingId());
						}
					}
					if(!finalData[5].equals(""))
						wars.setAttacker_1(finalData[5]);
						
						if(!finalData[6].equals(""))
						wars.setAttacker_2(finalData[6]);
						
						if(!finalData[7].equals(""))
						wars.setAttacker_3(finalData[7]);
						
						if(!finalData[8].equals(""))
						wars.setAttacker_4(finalData[8]);
						
						if(!finalData[9].equals(""))
						wars.setDefender_1(finalData[9]);
						
						if(!finalData[10].equals(""))
						wars.setDefender_1(finalData[10]);
						
						if(!finalData[11].equals(""))
						wars.setDefender_1(finalData[11]);
						
						if(!finalData[12].equals(""))
						wars.setDefender_1(finalData[12]);
						
						if(!finalData[13].equals(""))
						wars.setAttacker_result(finalData[13]);
						
						if(!finalData[14].equals(""))
						wars.setWarType(finalData[14]);
						
						if(!finalData[15].equals(""))
						wars.setDeath(Integer.parseInt( finalData[15]));
						
						if(!finalData[16].equals(""))
						wars.setCapture(Integer.parseInt( finalData[16]));
						
						if(!finalData[17].equals(""))
						wars.setAttacker_size(Integer.parseInt( finalData[17]));
						
						if(!finalData[18].equals(""))
						wars.setDefender_size(Integer.parseInt( finalData[18]));
						
						if(!finalData[19].equals(""))
						wars.setAttackCommander(finalData[19]);
						
						if(!finalData[20].equals(""))
						wars.setDefendCommander(finalData[20]);
						
						if(!finalData[21].equals(""))
						wars.setSummer(Integer.parseInt( finalData[21]));
						
						if(!finalData[22].equals(""))
						wars.setLocation(finalData[22]);
						
						if(!finalData[23].equals(""))
						wars.setSite(finalData[23]);
						
						if(!finalData[24].equals(""))
						wars.setExtras(finalData[24]);
						
						warRepository.save(wars);
				}
				count++;
				errorResponse.setErrorCode(ErrorCodes.SUCCESS_CODE);
				errorResponse.setErrorMsg(ErrorCodes.SUCCESS_MSG);
			}
			
		} catch(FileNotFoundException e) {
			errorResponse.setErrorCode(ErrorCodes.FILE_NOT_FOUND_CODE);
			errorResponse.setErrorMsg(ErrorCodes.FILE_NOT_FOUND_MSG);
			e.printStackTrace();
		}
		return errorResponse;
	}
	
	public ErrorResponse getWarDetails(WarRequest warRequest) {
		WarDetailsResponse warDetailsResponse = new WarDetailsResponse();
		Wars wars = warRepository.findByWarIdAndWarName(warRequest.getWarId() , warRequest.getWarName());
		if(wars == null) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setErrorCode(ErrorCodes.INVALID_REQUEST_ERROR_CODE);
			errorResponse.setErrorMsg(ErrorCodes.INVALID_REQUEST_ERROR_MSG);
			return errorResponse;
		}
		King attackerkingMaster = kingRepository.findByKingId(wars.getAttacker_kingId());
		King defenderkingMaster = kingRepository.findByKingId(wars.getDefender_kingId());
		warDetailsResponse = setWarDetailsResponse(wars ,attackerkingMaster ,defenderkingMaster  );
		warDetailsResponse.setErrorCode(ErrorCodes.SUCCESS_CODE);
		warDetailsResponse.setErrorMsg(ErrorCodes.SUCCESS_MSG);
		return warDetailsResponse;
	}

	private WarDetailsResponse setWarDetailsResponse(Wars wars, King attackerkingMaster, King defenderkingMaster) {   //
		WarDetailsResponse warDetailsResponseValue = new WarDetailsResponse();
		warDetailsResponseValue.setAttacker1(wars.getAttacker_1());
		warDetailsResponseValue.setAttacker2(wars.getAttacker_2());
		warDetailsResponseValue.setAttacker3(wars.getAttacker_3());
		warDetailsResponseValue.setAttacker4(wars.getAttacker_4());
		warDetailsResponseValue.setAttackerCommander(wars.getAttackCommander());
		warDetailsResponseValue.setAttackerKing(attackerkingMaster.getKingName());
		warDetailsResponseValue.setAttackerOutcome(wars.getAttacker_result());
		warDetailsResponseValue.setAttackerSize(wars.getAttacker_size());
		warDetailsResponseValue.setBattleId(wars.getWarId());
		warDetailsResponseValue.setBattleName(wars.getWarName());
		warDetailsResponseValue.setBattleType(wars.getWarType());
		warDetailsResponseValue.setDefender1(wars.getDefender_1());
		warDetailsResponseValue.setDefender2(wars.getDefender_2());
		warDetailsResponseValue.setDefender3(wars.getDefender_3());
		warDetailsResponseValue.setDefender4(wars.getDefender_4());
		warDetailsResponseValue.setDefenderCommander(wars.getDefendCommander());
		warDetailsResponseValue.setDefenderKing(defenderkingMaster.getKingName());
		warDetailsResponseValue.setDefenderSize(wars.getDefender_size());
		warDetailsResponseValue.setLocaion(wars.getLocation());
		warDetailsResponseValue.setMajorCapture(wars.getCapture());
		warDetailsResponseValue.setMajorDeath(wars.getDeath());
		warDetailsResponseValue.setNote(wars.getExtras());
		warDetailsResponseValue.setRegion(wars.getSite());
		warDetailsResponseValue.setSummer(wars.getSummer());
		warDetailsResponseValue.setYear(wars.getYear());
		return warDetailsResponseValue;
	}
	
}
