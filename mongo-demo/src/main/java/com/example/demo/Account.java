package com.example.demo;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Builder.Default;
import lombok.Data;
import lombok.Singular;

@Data
public class Account {
	@Id
	@Default
	private final String key = UUID.randomUUID().toString();
	@DBRef
	@Cascade
	private User user;
	@DBRef
	@Singular
	@Cascade
	private Set<Session> sessions;
}