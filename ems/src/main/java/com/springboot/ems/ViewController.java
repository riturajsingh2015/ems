package com.springboot.ems;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ViewController {
    
    private EmployeeService employeeService;

    public ViewController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    

    //http://localhost:8080/static_employees_view
    @GetMapping("/static_employees_view")
    public String staticEmployeesView(){
        return "staticEmployees";
    }
     //http://localhost:8080//database_employees_view
    @GetMapping("/database_employees_view")
    public String databaseEmployeesView(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "databaseEmployees";
    }
    

}
