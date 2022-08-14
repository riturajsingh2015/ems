package com.springboot.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ems.entity.Employee;
import com.springboot.ems.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

 
    @GetMapping
    public List<Employee> getAllTheEmployees(){
        return employeeService.getAllEmployees();
    }

    
    @PostMapping
    public ResponseEntity<Employee> saveAnEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeByTheId(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployeeByTheId(@PathVariable("id") long employeeId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee, employeeId), HttpStatus.OK);
    }

    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeByTheId(@PathVariable("id") long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
    }
    






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
