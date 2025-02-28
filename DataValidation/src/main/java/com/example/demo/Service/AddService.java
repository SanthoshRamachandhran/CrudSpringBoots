package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.AddressEntity;
import com.example.demo.Repositroy.DataRepository;
import com.example.demo.Repositroy.addressRepository;

@Service
public class AddService {
	@Autowired
	DataRepository repo;
	@Autowired
	addressRepository add;

	public AddressEntity saveAdd(AddressEntity entity) {
		AddressEntity obj = new AddressEntity();
		obj.setAddname(entity.getAddname());
		repo.save(obj);
		return obj;
	}

	public List<AddressEntity> getdata() {
		 List<AddressEntity>obj=new ArrayList<>();
		add.findAll().forEach(x->obj.add(x));
		return obj;
	}

}
