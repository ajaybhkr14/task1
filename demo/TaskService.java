package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.ApiException;

@Service
public class TaskService {
	
	
	
	HashMap<String,Task> map =new HashMap<String,Task>();
	
	String addTask(String description) {
		for(Task task:map.values()) {
			if(task.description.equals(description)) {
			return "task with same description already present";
			}
		}
		
		Task task =new Task(description);
		String id ="task"+map.size();
		System.out.println(id);
		map.put(id,task);
		return "task added";
	}
	
	String getAllTasks() {
		if(map.isEmpty()) {
			return "list is empty";
		}
		
		return map.values().toString();
	}
	
	String updateTask(String id,String description) {
		
		if(map.containsKey(id)) {
			Task task=map.get(id);
			task.description=description;
			map.replace(id, task);
		}
		else {
			throw new ApiException("Not found,task not present in the list with id "+id);
		}
		
		return "task updated";
	}
	
	String deleteTask(String id ) {
		if(map.containsKey(id)) {
			map.remove(id);
		}
		else {
			throw new ApiException("Not found,task not present in the list with id "+id);
		}
		return "task removed";
	}
	
	String markCompleteTask(String id) {
		if(map.containsKey(id)) {
			Task task=map.get(id);
			task.status="COMPLETED";
			map.replace(id, task);
		}
		else {
			throw new ApiException("Not found,task not present in the list with id "+id);
		}
		
		return "task marked as completed";
		
	}
}
