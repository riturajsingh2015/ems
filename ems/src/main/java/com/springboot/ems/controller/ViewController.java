package com.springboot.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.ems.entity.Employee;
import com.springboot.ems.service.EmployeeService;

@Controller
public class ViewController {

    private EmployeeService employeeService;

    public ViewController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


    /// Get route for employees
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		//add all the employees to the model with the key = employees
        model.addAttribute("employees", employeeService.getAllEmployees());
        //sent the model for rendering to employees.html
		return "employees";
	}
	
    // create a new employee using this route 
	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		
		// create Employee object to hold Employee form data
		Employee employee = new Employee(); // this eventually helps in creating a form with empty fields
		model.addAttribute("employee", employee);
		return "create_Employee";
		
	}
	// to handle submit - POST request from the create new employee form
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees"; // redirect to @GetMapping("/employees") route
	}
	
    // to update an existing employee using this route 
	@GetMapping("/employees/edit/{id}")  
	public String editEmployeeForm(@PathVariable Long id, Model model) {
        // this eventually helps in 'loading' the form with details of an existing employee having a specific id
		model.addAttribute("employee", employeeService.getEmployeeById(id)); 
		return "edit_Employee";
	}

    // to handle submit - POST request from the update employee form
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee) {
		
		// get Employee from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// save updated Employee object
		employeeService.updateEmployeeById(existingEmployee, id);
		return "redirect:/employees";		
	}
	
	// handler method to handle delete Employee request
	
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

    
    

    // http://localhost:8080/static_employees_view  <--- Outputs the static data page
    @GetMapping("/static_employees_view")
    public String staticEmployeesView() {
        return "staticEmployees";
    }

}
