package com.training.mytraining.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import com.training.mytraining.exceptions.ExerciseNotFoundException;
import com.training.mytraining.model.CategoryModel;
import com.training.mytraining.model.ExerciseModel;
import com.training.mytraining.model.ParameterModel;
import com.training.mytraining.repository.CategoryRepository;
import com.training.mytraining.repository.ExerciseRepository;
import com.training.mytraining.repository.ParameterRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestExerciseRepository {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ExerciseRepository exerciseRepository;

  @Autowired
  private ParameterRepository parameterRepository;
  
  @BeforeAll
  void start(){
    List<CategoryModel> categories = new ArrayList<>();
    categories.add(categoryRepository.save(new CategoryModel(0L, "Peito")));
    categories.add(categoryRepository.save(new CategoryModel(0L, "Braço")));
    ParameterModel parameterModel = parameterRepository.save(new ParameterModel(0L, 4, 5, LocalTime.of(0,1,0,0), new BigDecimal(5) , 5));
    var ex = exerciseRepository.save(new ExerciseModel(0L, "Flexão", "dafjsa", "dfjasdl ffd ", categories, parameterModel));
  }

  @Test
  public void TestFindByIdOrElseThrow(){
    List<Long> idsFalses = new ArrayList<>();
    idsFalses.add(5L);
    List<Long> ids = new ArrayList<Long>();
    exerciseRepository.findAll().forEach(ex->ids.add(ex.getId()));
    JpaObjectRetrievalFailureException thrown = Assertions.assertThrows(JpaObjectRetrievalFailureException.class, 
      ()->{
        exerciseRepository.findByIdOrElseThrow(idsFalses);
            }, "Exercise not found"
    );
    assertEquals(new JpaObjectRetrievalFailureException(new ExerciseNotFoundException()).getMessage(), thrown.getMessage());
    assertEquals(ids.get(0), exerciseRepository.findByIdOrElseThrow(ids).get(0).getId());
   
  }
}
