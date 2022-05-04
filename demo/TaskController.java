package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskController {
	@Autowired
	TaskService taskService ;
	
	@PostMapping("/task")
	public ResponseEntity<String> addTask (@RequestParam("description") String description)  {
			String response = taskService.addTask(description);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@GetMapping("/tasks")
	public ResponseEntity<String> getAllTasks ()  {
			String response = taskService.getAllTasks();
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@PutMapping("/task")
	public ResponseEntity<String> updateTask (@RequestParam("id") String id ,@RequestParam("description") String description)  {
			String response = taskService.updateTask(id,description);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@DeleteMapping("/task")
	public ResponseEntity<String> deleteTask (@RequestParam("id") String id )  {
			String response = taskService.deleteTask(id);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	@PutMapping("/task/mark_complete")
	public ResponseEntity<String> markCompleteTask (@RequestParam("id") String id )  {
			String response = taskService.markCompleteTask(id);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
}
