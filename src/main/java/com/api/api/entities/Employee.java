package com.api.api.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "employee_id")
     public int id;
     @Column(name = "first_name")
     public String FirstName;
     @Column(name = "last_name")
     public String LastName;
     @Column(name = "salary")
     public double Salary;

}
