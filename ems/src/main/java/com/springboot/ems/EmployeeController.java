package com.springboot.ems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
        // GET HTTP Method
    // http://localhost:8080/employee

    // @GetMapping("/default_employee")
    // public Employee default_getEmployee(){
    //     return new Employee("Rituraj", "Singh");
    // }

    // @GetMapping("/default_employees")
    // public List<Employee> default_getEmployees(){
    //     List<Employee> employees= new ArrayList<>();
    //     employees.add(new Employee("Yudvir", "Singh")); 
    //     employees.add(new Employee("Surinder Paul", "Singh"));
    //     employees.add(new Employee("Jagjeet", "Kaur"));
    //     return employees;
    // }

    // //Path variable
    // @GetMapping("/custom_employee/{firstName}&{lastName}")
    // public Employee custom_getEmployee(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){        
    //     return new Employee(firstName, lastName);
    // }

    // //Reqeust param or Query params
    // //localhost:8080//custom_employee_query?firstName=Rituraj&lastName=Singh
    // @GetMapping("/custom_employee_query")
    // public Employee custom_getEmployee_query(@RequestParam(name="firstName") String firstName,@RequestParam(name="lastName") String lastName){        
    //     return new Employee(firstName, lastName);
    // }

    
}
