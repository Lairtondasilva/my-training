package com.training.mytraining.exceptions;

import javax.persistence.EntityNotFoundException;

public class ExerciseNotFoundException extends EntityNotFoundException{

  public ExerciseNotFoundException() {
    super("Exercise not found!");
  }

  public ExerciseNotFoundException(String message) {
    super(message);
  }
    
}
