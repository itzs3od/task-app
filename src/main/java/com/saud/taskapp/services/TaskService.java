package com.saud.taskapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saud.taskapp.exception.UserNotFoundException;
import com.saud.taskapp.model.Task;
import com.saud.taskapp.repo.TaskRepo;

@Service
public class TaskService {
	private final TaskRepo taskRepo;
	
	@Autowired
	public TaskService (TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}

	public List<Task> findAllTasks(){
		return taskRepo.findAll();
	}
	
	public Task updateTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Task findTaskById(Long id) {
		return taskRepo.findTaskById(id).orElseThrow(()-> new UserNotFoundException("User by id " + id + " was not found "));
	}
	
	public void deleteTask(Long id) {
		taskRepo.deleteById(id);
	}
	
}
