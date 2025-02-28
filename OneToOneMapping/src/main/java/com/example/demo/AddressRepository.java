package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

	List<AddressEntity> findAllByemployeeEntity(EmployeeEntity model);

	@Transactional
	@Modifying
	void deleteByemployeeEntity(EmployeeEntity model);

}
