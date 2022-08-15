package com.training.mytraining.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.BDDMockito.Then;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.mytraining.dtos.category.CategoryResponse;
import com.training.mytraining.dtos.exercises.ExerciseRequest;
import com.training.mytraining.dtos.exercises.ExerciseResponse;
import com.training.mytraining.dtos.parameters.ParametersResponse;
import com.training.mytraining.model.CategoryModel;
import com.training.mytraining.model.ExerciseModel;
import com.training.mytraining.model.ParameterModel;
import com.training.mytraining.repository.CategoryRepository;
import com.training.mytraining.repository.ParameterRepository;

@ExtendWith(MockitoExtension.class)
public class TestExerciseMapper {
  @Mock
  private CategoryRepository categoryRepository;
  @Mock
  private ParameterRepository parameterRepository;
  @Mock
  private ParameterMapper parameterMapper;

  @Mock
  private CategoryMapper categoryMapper;

  @InjectMocks
  private ExerciseMapper exerciseMapper;

  private List<CategoryModel> categories;
  private List<CategoryResponse> categoriesResponse = new ArrayList<>();
  private CategoryResponse categoryResponse = new CategoryResponse(1L, "braço");
  private CategoryResponse categoryResponse2 = new CategoryResponse (2L,"Costas");
  private ParameterModel parameterModel = new ParameterModel(1L
  , 3, null, LocalTime.of(0, 0, 30), new BigDecimal(5), 30);
  private ExerciseModel exerciseModel = new ExerciseModel(1L, "Flexão", null, "djfladskjfadslfja",categories, parameterModel);
  private List<Long> categoriesIds = new ArrayList<>();

  @Test
  public void testToExerciseResponse (){
    categoriesResponse.add(categoryResponse);
    categoriesResponse.add(categoryResponse2);
    Mockito.when(categoryMapper.toCategoryResponse(categories)).thenReturn(categoriesResponse);
    Mockito.when(parameterMapper.toParametersResponse(parameterModel)).thenReturn(new ParametersResponse(1L, 4, 12, null, null, 30));
    var response = exerciseMapper.toExerciseResponse(this.exerciseModel);
    verify(categoryMapper, times(1)).toCategoryResponse(categories);
    verify(parameterMapper).toParametersResponse(parameterModel);
    assertEquals(ExerciseResponse.class, response.getClass());
    assertEquals("Flexão", response.getName());
  }

  @Test
  public void testToExerciseModel (){
    categoriesIds.add(1L);
    categoriesIds.add(2L);
    Mockito.when(categoryRepository.findAllByIdOrELseThrow(categoriesIds)).thenReturn(List.of(new CategoryModel(1L, "Braço")));
    Mockito.when(parameterRepository.findByIdOrElseThrow(1L)).thenReturn(new ParameterModel());
    var response = exerciseMapper.toExerciseModel(new ExerciseRequest("Supino","dsafkjadslkfjadsl","Cuidado com os ombros",categoriesIds, 1L ));
    assertEquals(ExerciseModel.class, response.getClass());
  }

}
