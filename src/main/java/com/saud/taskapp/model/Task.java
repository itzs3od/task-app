package com.saud.taskapp.model;

import java.io.Serializable;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Task implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	private String name;
	private String priority;
	
	public Task() {}
	
	public Task(long id, String name, String priority) {
		this.id = id;
		this.name = name;
		this.priority = priority;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		return "Task{"+
				"id=" + id + " - " +
				"name=" + name + " - " +
				"priority=" + priority + " - " +
				"}";
	}

}
