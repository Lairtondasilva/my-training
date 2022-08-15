package com.training.mytraining.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.training.mytraining.dtos.category.CategoryRequest;
import com.training.mytraining.dtos.category.CategoryResponse;
import com.training.mytraining.model.CategoryModel;

@Component
public class CategoryMapper {
  
  public CategoryResponse toCategoryResponse (CategoryModel categoryModel){
    return CategoryResponse.builder().id(categoryModel.getId())
      .name(categoryModel.getNameCategory()).build();
  }
  public List<CategoryResponse> toCategoryResponse (List<CategoryModel> categories){
    return categories.stream().map(category->toCategoryResponse(category)).toList();
  }

  public CategoryModel toModel(CategoryRequest request){
    return CategoryModel.builder().nameCategory(request.getName()).build();
  }

}
