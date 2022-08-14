package com.springboot.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ems.ResourceNotFoundException;
import com.springboot.ems.entity.Employee;
import com.springboot.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    EmployeeRepository employeeRepository;


    // Not Mandatory to autowire this but you may if you want
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Employee", "Id", id)
        );
        
    }

    @Override
    public Employee updateEmployeeById(Employee employee, long id) {
        
        Employee existingEmployee= employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "Id", id)
            );
        
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());

            employeeRepository.save(existingEmployee);

            return existingEmployee;
        
    }

    @Override
    public void deleteEmployeeById(long id) {
        //before deleting check if the employee with the id exists if it doesnot then exception is thrown
        employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "Id", id)
            );
        // if employee with the id exists then delete that employee 
        employeeRepository.deleteById(id);
        
    }
    
}
