package com.crent.MyBattle.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crent.MyBattle.request.WarRequest;
import com.crent.MyBattle.response.ErrorResponse;
import com.crent.MyBattle.service.WarService;


@RestController
public class WarController {
	@Autowired
	WarService warService;
	
	@GetMapping(value = "/getWarList")
	public ErrorResponse getWarList() {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse = warService.getWarList();
		return errorResponse;
	}
	
	@GetMapping(value = "/feedWarList")
	public ErrorResponse feedWarList() throws IOException {
		ErrorResponse errorResponse;
		try {
			errorResponse = new ErrorResponse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		errorResponse = warService.feedWarDetails() ;
		return errorResponse;
	}
	
	@PostMapping(value = "/getWarDetails")
	public ErrorResponse getBattleDetails(@RequestBody WarRequest warRequest) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse = warService.getWarDetails(warRequest) ;
		return errorResponse;
	}
}
