package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@Configuration
public class MongoConfiguration {
//  static final String REPOSITORY_PACKAGE = "dev.mflash.guides.mongo.repository";
  @Bean
  public AccountCascadeMongoEventListener cascadeMongoEventListener() {
    return new AccountCascadeMongoEventListener();
  }
  
}
