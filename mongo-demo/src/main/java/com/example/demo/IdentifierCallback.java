package com.example.demo;

import java.lang.reflect.Field;

import org.springframework.data.annotation.Id;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;

public class IdentifierCallback implements FieldCallback {
	  private boolean idFound;
	  public @Override void doWith(final Field field) throws IllegalArgumentException {
	    ReflectionUtils.makeAccessible(field);
	    if (field.isAnnotationPresent(Id.class)) {
	      idFound = true;
	    }
	  }
	  public boolean isIdFound() {
	    return idFound;
	  }
	}