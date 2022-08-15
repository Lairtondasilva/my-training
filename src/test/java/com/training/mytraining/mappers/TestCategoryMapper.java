package com.training.mytraining.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.training.mytraining.dtos.category.CategoryRequest;
import com.training.mytraining.dtos.category.CategoryResponse;
import com.training.mytraining.model.CategoryModel;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestCategoryMapper {

  @InjectMocks
  CategoryMapper categoryMapper;

private CategoryModel categoryModel = new CategoryModel(1L, "Braço");
private List<CategoryModel> listCategory = new ArrayList<CategoryModel>();
private CategoryRequest request = new CategoryRequest("Braço");

@Test
public void testToCategoryResponse ()throws Exception {
  var response = categoryMapper.toCategoryResponse(categoryModel);
  assertEquals(CategoryResponse.class, response.getClass());
  assertEquals(1L, response.getId());
  assertEquals("Braço", response.getName());
}

@Test
public void testCategoryResponse2() throws Exception {
  listCategory.add(categoryModel);
  var response = categoryMapper.toCategoryResponse(listCategory);
  assertEquals(1L, response.get(0).getId());
  assertEquals(CategoryResponse.class, response.get(0).getClass());
  assertEquals("Braço", response.get(0).getName());
}

@Test
public void testToModel(){
  var category =  categoryMapper.toModel(request);
  assertEquals(CategoryModel.class, category.getClass());
}
  
}
