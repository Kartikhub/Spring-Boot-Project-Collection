package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.util.ReflectionUtils;

public class AccountCascadeMongoEventListener extends AbstractMongoEventListener<Account> {
	@Autowired  
	private MongoOperations mongoOperations;
	  private Account deletedAccount;
	  public @Override void onBeforeSave(BeforeSaveEvent<Account> event) {
	    final Object source = event.getSource();
	    ReflectionUtils.doWithFields(source.getClass(), new CascadeSaveCallback(source, mongoOperations));
	  }
}