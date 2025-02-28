package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/post")
	public EmployeeEntity save(@RequestBody EmployeeEntity entity) {
		return service.saveData(entity);
	}
	@GetMapping("/get")
	public List<EmployeeEntity> get() {
		return service.getData();
	}
	@PutMapping("/put/{id}")
	public EmployeeEntity update(@PathVariable("id") int id,@RequestBody EmployeeEntity entity){
	EmployeeEntity obj=service.update(id,entity);
		return obj;
	}
	
}
