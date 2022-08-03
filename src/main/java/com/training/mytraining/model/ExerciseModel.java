package com.training.mytraining.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "tb_exercises")
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
public class ExerciseModel {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "exercise_name")
  private String execiseName;

  @Column(name = "img_video_url")
  private String imgVideoUrl;

  @Column(name = "observations")
  private String observations;

  @ManyToMany
  @JoinTable(name = "tb_exercises_categories", joinColumns = 
  @JoinColumn(name="exercise_id", referencedColumnName = "id"),
  inverseJoinColumns = @JoinColumn(name="categoria_id", referencedColumnName = "id"))
  private List<CategoryModel> categorias;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "parameter_id", referencedColumnName = "id")
  private ParameterModel ParameterModel;
}
