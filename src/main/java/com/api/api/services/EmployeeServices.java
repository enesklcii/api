package com.api.api.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.entities.Employee;
import com.api.api.repositories.EmployeeRepository;

@Service


public class EmployeeServices {
    @Autowired
    public final EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Iterable<Employee> GetAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee GetOneEmployeeById(int id){
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee CreateOneEmployee(Employee employee){
       return employeeRepository.save(employee);
    }
    public Employee UpdateOneEmployee(Employee employee,int id){
        var emp =GetOneEmployeeById(id);
        if(emp !=null){
            employee.setFirstName(emp.getFirstName());
            employee.setLastName(emp.getLastName());
            employee.setSalary(emp.getSalary());
            return employeeRepository.save(emp);
        }return null;

    }
    public void DeleteOneEmployeeById(int id){
        employeeRepository.deleteById(id);
        return;
    }
}
