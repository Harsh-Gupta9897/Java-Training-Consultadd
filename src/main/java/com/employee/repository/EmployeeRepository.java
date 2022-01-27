package com.employee.repository;
import  com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,String>{
       List<Employee> findAllByCity(String city);

       @Query(value = "Select e from Employee e where e.city = :city and e.age = :age" ,nativeQuery = true)
       List<Employee> getByCityAndAge(String city, int age);
    
}
