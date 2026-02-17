package com.example.optionaldemo.repository;

import com.example.optionaldemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // to use our query we can use  @Query annotation and write our query in it
    @Query("Select e from Employee e where e.id= 166")
    Employee getEmployeeById();
}
