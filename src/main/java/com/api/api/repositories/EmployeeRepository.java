package com.api.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.api.api.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    
}
