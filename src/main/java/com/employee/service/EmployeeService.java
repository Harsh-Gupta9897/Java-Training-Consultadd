package com.employee.service;

import com.employee.repository.EmployeeRepository;
import com.employee.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
// import org.springframework.http.ResponseEntity;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Map<String,String> saveEmployee(Employee employee){
        if(employeeRepository.existsById(employee.getId())){
            HashMap<String, String> map = new HashMap<>();
            map.put("message", "Id already exists");
            map.put("status","Failure");
            return map;
        }
        else{
            employeeRepository.save(employee);
            HashMap<String, String> map = new HashMap<>();
            map.put("message", "EmployeeObject created Successfully");
            map.put("status", "Success");
            return map;
             
        }
    }

    public List<Employee> getAllEmployeeByCity(String city ){
        return employeeRepository.findAllByCity(city);
    }
    public List<Employee> getAllEmployeeByCityAndAge(String city ,int Age){
        return employeeRepository.getByCityAndAge(city, Age);
    }
}
