package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.DataEntity;
import com.example.demo.Repositroy.DataRepository;

@Service
public class DataService {
	@Autowired
	DataRepository repo;

	public DataEntity saveData(DataEntity entity) {
		DataEntity obj = new DataEntity();
		obj.setName(entity.getName());
		obj.setAddname(entity.getAddname());
		return repo.save(obj);
	}

	public List<DataEntity> getData() {
		List<DataEntity> obj = new ArrayList<>();
		repo.findAll().forEach(x -> obj.add(x));
		return obj;
	}

	public Optional<DataEntity> getForId(Long id) {
		Optional<DataEntity>obj=repo.findById(id);
		
		return obj;
	}

	public Optional<DataEntity> deleteForId(Long id) {
		// TODO Auto-generated method stub
		Optional<DataEntity>obj=repo.findById(id);
		if(obj.isPresent()) {
			repo.deleteById(id);
		}
		return obj;
	}

	public Optional<DataEntity> update(Long id, DataEntity entity) {
		Optional<DataEntity>obj=repo.findById(id);
		
		if(obj.isPresent()) {
			DataEntity model=obj.get();
			model.setName(entity.getName());
			model.setAddname(entity.getAddname());
			repo.save(model);
		}
		return obj;
	}
	
}
