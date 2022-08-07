package com.jon.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jon.crud.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
