package com.training.mytraining.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import com.training.mytraining.exceptions.CategoryNotFoundException;
import com.training.mytraining.model.CategoryModel;
import com.training.mytraining.repository.CategoryRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCategoryRepository {

  @Autowired
  private CategoryRepository categoryRepository;

  @BeforeAll
  void start (){
    categoryRepository.save(new CategoryModel(0L, "Braço"));
    categoryRepository.save(new CategoryModel(0L, "Peito"));
  }

  @Test
  public void testFindByIdOrElseThrow(){

    var response = categoryRepository.findAllByIdOrELseThrow(List.of(1L,2L));
    JpaObjectRetrievalFailureException thrown = Assertions.assertThrows(JpaObjectRetrievalFailureException.class,
    ()->{

      categoryRepository.findAllByIdOrELseThrow(List.of(1L,3L));

    });

    assertEquals("Braço", response.get(0).getNameCategory());
    assertEquals(new JpaObjectRetrievalFailureException(new CategoryNotFoundException(3L)).getMessage(), thrown.getMessage());
  }
}
