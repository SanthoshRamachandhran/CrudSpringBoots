package com.example.demo.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.AddressEntity;
import com.example.demo.Entity.DataEntity;
@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long>{

	void save(AddressEntity obj);

}
