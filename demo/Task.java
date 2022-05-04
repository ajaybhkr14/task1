package com.example.demo;


public class Task {

	String status;
	String description;
	
	public Task(String description) {
		this.status="SUBMITTED";
		this.description =description;
	}
	
@Override
public String toString() {
	return "Task [status=" + status + ", description=" + description + "]";
}

}
