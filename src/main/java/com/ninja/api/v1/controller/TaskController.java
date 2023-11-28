package com.ninja.api.v1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ninja.api.v1.model.TaskModel;
import com.ninja.api.v1.model.input.TaskInput;
import com.ninja.domain.model.Task;
import com.ninja.domain.repository.TaskRepository;
import com.ninja.domain.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<TaskModel> findAll() {
		List<TaskModel> taskModelList = new ArrayList();
		List<Task> taskList = taskRepository.findAll();
		
		taskList.stream().forEach(task -> taskModelList.add(task.toTaskModel()));
		return taskModelList;
	}
	
	@GetMapping("{taskId}")
	public TaskModel findById(@PathVariable Long taskId) {
		return taskService.findOrFail(taskId).toTaskModel();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TaskModel include(@RequestBody @Valid TaskInput taskInput) {
		Task task = new Task();
		BeanUtils.copyProperties(taskInput, task);
		
		task = taskService.save(task);
		return task.toTaskModel();
	}	
	
	@PutMapping("{taskId}")
	public TaskModel update(@PathVariable Long taskId, @RequestBody @Valid TaskInput taskInput) {
		Task task = taskService.findOrFail(taskId);
		BeanUtils.copyProperties(taskInput, task);
		return taskService.save(task).toTaskModel();
	}	
	
	@DeleteMapping("{longId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> delete(@PathVariable Long longId) {
		taskService.delete(longId);
		return ResponseEntity.noContent().build();
	}	
	
	
}
