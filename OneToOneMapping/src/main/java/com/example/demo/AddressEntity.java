package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//i am Entity
//i am santhosh
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
	//this is for address Entity 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="address")
	private String address;
	@Column(name="state")
	private String state;
	
	@JsonIgnore
	@ManyToOne(targetEntity = EmployeeEntity.class)
	@JoinColumn(name = "empid",referencedColumnName = "id")
	private EmployeeEntity employeeEntity;

}
