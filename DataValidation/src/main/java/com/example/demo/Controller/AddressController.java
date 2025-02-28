package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.AddressEntity;
import com.example.demo.Service.AddService;

@RestController
@RequestMapping("/.address")
public class AddressController {

	@Autowired
	AddService service;

	@PostMapping("/addpost")
	public AddressEntity saveData(@RequestBody AddressEntity entity) {
		return service.saveAdd(entity);
	}

	@GetMapping("/addget")
	public List<AddressEntity> getData() {
		return service.getdata();
	}

}
