package com.training.mytraining.mappers;

import java.util.List;

import com.training.mytraining.dtos.category.CategoryResponse;
import com.training.mytraining.model.CategoryModel;

public class CategoryMapper {
  
  public CategoryResponse toCategoryResponse (CategoryModel categoryModel){
    return CategoryResponse.builder().id(categoryModel.getId())
      .name(categoryModel.getNameCategory()).build();
  }
  public List<CategoryResponse> toCategoryResponse (List<CategoryModel> categories){
    return categories.stream().map(category->toCategoryResponse(category)).toList();
  }
}
