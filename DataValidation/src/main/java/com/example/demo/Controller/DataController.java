package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.DataEntity;
import com.example.demo.Service.DataService;

@RestController
public class DataController {
	@Autowired
	DataService service;

	@PostMapping("/post")
	public DataEntity Datasave(@RequestBody DataEntity entity) {
		return service.saveData(entity);
	}

	@GetMapping("/get")
	public List<DataEntity> DataGet() {
		return service.getData();
	}

	@GetMapping("/id/{id}")
	public Optional<DataEntity> FindBy(@PathVariable("id") Long id) {
		Optional<DataEntity> obj = service.getForId(id);
		return obj;
	}

	@DeleteMapping("/delete/{id}")
	public Optional<DataEntity> DeleteBy(@PathVariable("id") Long id) {
		Optional<DataEntity> obj = service.deleteForId(id);
		return obj;
	}
	@PutMapping("/put/{id}")
	public Optional<DataEntity>update(@PathVariable("id") Long id,@RequestBody DataEntity entity){
		return service.update(id,entity);
	}

}
