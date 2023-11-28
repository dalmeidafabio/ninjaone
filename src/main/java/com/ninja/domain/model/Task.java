package com.ninja.domain.model;

import org.springframework.beans.BeanUtils;

import com.ninja.api.v1.model.TaskModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	public TaskModel toTaskModel() {
		TaskModel taskModel = new TaskModel();
		BeanUtils.copyProperties(this, taskModel);
		return taskModel;
	}

}
