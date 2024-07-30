package com.example.demo;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Builder.Default;
import lombok.Data;

@Data
public class Session {
	@Id
	@Default
	private final String key = UUID.randomUUID().toString();
	private String city;
}
