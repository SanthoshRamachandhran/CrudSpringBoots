package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;
	@Autowired
	AddressRepository addressRepository;

	public EmployeeEntity saveData(EmployeeEntity entity) {
		EmployeeEntity obj = new EmployeeEntity();
		obj.setId(entity.getId());
		obj.setName(entity.getName());
		EmployeeEntity model = repo.save(obj);
		saveAddress(model, entity.listAddress);
		model.setListAddress(addressRepository.findAllByemployeeEntity(model));
		return model;
	}

	private void saveAddress(EmployeeEntity model, List<AddressEntity> listAddress) {
		addressRepository.deleteByemployeeEntity(model);
		List<AddressEntity> update = listAddress.stream().map(address -> {
			address.setEmployeeEntity(model);
			return address;
		}).toList();
		addressRepository.saveAllAndFlush(update);
	}

	public List<EmployeeEntity> getData() {
		// TODO Auto-generated method stub
		List<EmployeeEntity> obj = new ArrayList<>();
		repo.findAll().forEach(reperence -> obj.add(reperence));
		return obj;
	}

	public EmployeeEntity update(int id, EmployeeEntity employee) {
		employee.setId(id);
		Optional<EmployeeEntity> value = repo.findById(id);

		if (!value.isPresent()) {
			throw new EntityNotFoundException("Employee Not Founded" + id);
		}
		EmployeeEntity exiest = value.get();

//		if (employee.getName() == null) {
//			employee.setName(exiest.getName());
//		}
		// onal<EmployeeEntity>obj=repo.findById(id);
//
//		if(!obj.isPresent()) {
//			throw new EntityNotFoundException("Data is"+id+"not founded");
//		}
//		EmployeeEntity entity=obj.get();
//		
//		if(employee.getName()==null) {
//			employee.setName(entity.getName());
//		}
//		if(employee.getAddress()==null) {
//			employee.setAddress(entity.getAddress());
//		}
//		if(obj.isPresent()) {
//			EmployeeEntity model =obj.get();
//			model.setName(employee.getName());
//			model.setAddress(employee.getAddress());
//			
//			repo.save(model);
//		}
//		
		return repo.save(employee);
	}

}
