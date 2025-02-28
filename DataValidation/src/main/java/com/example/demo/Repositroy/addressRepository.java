package com.example.demo.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.AddressEntity;
@Repository
public interface addressRepository extends JpaRepository<AddressEntity, Long>{

}
