package com.employee.controller;

import com.employee.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
// import com.employee.repository.EmployeeRepository;
// import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
public class EmployeeController {
    // controller ->service(business logic) -> repository
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/addEmployee")
    public Map<String, String> addEmployees(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

}
