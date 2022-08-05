package com.training.mytraining.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.MapKeyColumn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.mytraining.dtos.training.TrainingRequest;
import com.training.mytraining.model.CategoryModel;
import com.training.mytraining.model.ExerciseModel;
import com.training.mytraining.model.ParameterModel;
import com.training.mytraining.model.TrainingModel;
import com.training.mytraining.repository.ExerciseRepository;
import com.training.mytraining.repository.TrainingRepository;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestTrainingMapper {

  @Mock
  ExerciseRepository exerciseRepository;

  @Mock
  TrainingRepository trainingRepository;

  @InjectMocks
  TrainingMapper trainingMapper;

  List<ExerciseModel> exercises = new ArrayList<ExerciseModel>();
  List<CategoryModel> categories = new ArrayList<CategoryModel>();
  TrainingModel mytraining;
  TrainingRequest request = new TrainingRequest("Meu treino", LocalDate.of(2022, 7, 4), LocalDate.of(2022, 8, 4), exercises.stream().map(ex->ex.getId()).collect(Collectors.toList()));

  @BeforeAll
  void start(){
  CategoryModel category = new CategoryModel(0L, "Peito");
  CategoryModel category2 = new CategoryModel(0L, "Braço");
  categories.add(category);
  categories.add(category2);
  ParameterModel parameterModel = new ParameterModel(0L, 4, 5, LocalTime.of(0,1,0,0), new BigDecimal(5) , 5);
  exercises.add(new ExerciseModel(1L, "Flexão", "dafjsa", "dfjasdl ffd ", categories, parameterModel));
  exercises.add(new ExerciseModel(2L, "Flexão inclinada", "dafjsa", "dfjasdl ffd ", categories, parameterModel));
  mytraining = new TrainingModel(0L, "Meu treino", LocalDate.of(2022, 7, 4), LocalDate.of(2022, 8, 4),exercises);
  }

  @Test
  public void TestToModelTrainingMapper () throws Exception{
    Mockito.when(exerciseRepository.findByIdOrElseThrow(request.getExercisesId())).thenReturn(exercises);
    var training2 = trainingMapper.toTrainingModel(request);
    assertEquals(training2.getClass(), TrainingModel.class);
    assertEquals(training2.getExercises(), mytraining.getExercises());
  }
}
