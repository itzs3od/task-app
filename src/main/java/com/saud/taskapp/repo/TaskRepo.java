package com.saud.taskapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saud.taskapp.model.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {

	//void deleteTaskById(Long id);

	Optional<Task> findTaskById(Long id);
	

}
