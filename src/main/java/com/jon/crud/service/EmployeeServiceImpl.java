package com.jon.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jon.crud.Entity.Employee;
import com.jon.crud.dao.EmployeeRepository;
import com.jon.crud.rest.EmployeeRestController;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl( EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return this.employeeRepository.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		// TODO Auto-generated method stub
		Employee employee = null;
		
		Optional<Employee> result = this.employeeRepository.findById(employeeId);
		if (result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Could not find Employee with id: "+ employeeId);
		}
		return employee;
	}

	@Override
	
	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	
	public void deleteById(int employeeId) {
		this.employeeRepository.deleteById(employeeId);

	}

}
