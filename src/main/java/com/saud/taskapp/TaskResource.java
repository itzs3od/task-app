package com.saud.taskapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saud.taskapp.model.Task;
import com.saud.taskapp.services.TaskService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/task")
public class TaskResource {

	@Autowired
	private final TaskService taskService;
	
	public TaskResource(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Task>> getAllTasks(){
		List<Task> tasks = taskService.findAllTasks();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Task> getTaskByID(@PathVariable("id") Long id){
		Task task = taskService.findTaskById(id);
		return new ResponseEntity<>(task, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		Task newTask = taskService.addTask(task);
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		Task updateTask = taskService.updateTask(task);
		return new ResponseEntity<>(updateTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Long id){
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
