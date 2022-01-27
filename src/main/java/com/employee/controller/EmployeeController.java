package com.employee.controller;

import com.employee.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/employee/{city}/")
    public List<Employee> getEmployeeByCity(@PathVariable("city") String city){
        return employeeService.getAllEmployeeByCity(city);
    }

    @GetMapping("/employee/{city}/{age}/")
    public List<Employee> getEmployeeByCityAndAge(@PathVariable("city") String city, @PathVariable("age") int age){
        return employeeService.getAllEmployeeByCityAndAge(city, age);
    }

}
