package com.api.api.presentation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.entities.Employee;
import com.api.api.services.EmployeeServices;

@RequestMapping(path = "api/employees")
@RestController
@CrossOrigin
public class EmployeesController {
    private final EmployeeServices employeeServices;

    public EmployeesController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }
    @GetMapping
    public Iterable<Employee> GetAllEmployees(){
       return employeeServices.GetAllEmployees();
    }
    @GetMapping(path = "{id}")
    //employees/2
    public Employee GetOneEmployee(@PathVariable(name = "id") int id){
        return employeeServices.GetOneEmployeeById(id);
    }

    @PostMapping
    public Employee CreateOneEmployee(@RequestBody Employee employee){
       return employeeServices.CreateOneEmployee(employee);
    }
    @PutMapping
    public Employee UpdateOneEmployee(@PathVariable(name = "id") int id,@RequestBody Employee employee){
        var emp = employeeServices.UpdateOneEmployee(employee, id);
        return emp;
    }
    @DeleteMapping
    public void DeleteOneEmployeeById(@PathVariable(name = "id") int id){
        employeeServices.DeleteOneEmployeeById(id);
        return;
    } 
}
