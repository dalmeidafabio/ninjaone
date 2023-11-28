package com.ninja.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ninja.domain.exception.TaskNotFoundException;
import com.ninja.domain.model.Task;
import com.ninja.domain.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional
	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	@Transactional
	public void delete(Long taskId) {
			this.findOrFail(taskId);
			taskRepository.deleteById(taskId);
			taskRepository.flush();
	}
	
	public Task findOrFail(Long taskId) {
		return taskRepository.findById(taskId)
				.orElseThrow(() -> new TaskNotFoundException(taskId));
	}		
		
}
