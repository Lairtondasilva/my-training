package com.training.mytraining.exceptions;

import javax.persistence.EntityNotFoundException;

public class CategoryNotFoundException extends EntityNotFoundException {

  public CategoryNotFoundException(Long id) {
    super("the category with id ["+id+"] not found");
  }

  public CategoryNotFoundException(String message) {
    super(message);
  }
  
}
