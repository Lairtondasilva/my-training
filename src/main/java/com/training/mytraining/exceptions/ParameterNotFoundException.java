package com.training.mytraining.exceptions;

import javax.persistence.EntityNotFoundException;

public class ParameterNotFoundException extends EntityNotFoundException{

  public ParameterNotFoundException(Long id) {
    super("Parameter with id ["+id+"] not found!");
  }

  public ParameterNotFoundException(String message) {
    super(message);
  }
  
}
