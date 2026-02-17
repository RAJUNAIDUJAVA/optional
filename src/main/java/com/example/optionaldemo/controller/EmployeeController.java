package com.example.optionaldemo.controller;

import com.example.optionaldemo.model.Employee;
import com.example.optionaldemo.repository.EmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/save")
    public String saveSomeRecordsinDb() {

        for(int i=0; i<10; i++){
            Employee employee = new Employee();
            employee.setId(i);
            employee.setName("Employee"+i);
            repository.save(employee);
        }
        return "Saved records in DB";
    }

    @GetMapping("/get")
    public String getEmployeeById(){
        Optional<Employee> employee= repository.getEmployeeById();
        return employee.map(e2 -> e2.getName()).orElse("No employee found with the given id");
    }


}
