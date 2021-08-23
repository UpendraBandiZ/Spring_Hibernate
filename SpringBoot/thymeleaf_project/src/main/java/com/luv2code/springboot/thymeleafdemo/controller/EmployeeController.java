package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService)
    {
        employeeService=theEmployeeService;
    }



    @GetMapping("/list")
    public String listEmployee(Model model)

    { List<Employee> theEmployees=employeeService.findAll();
        model.addAttribute("employees",theEmployees);
        return "list_employees";
    }


    @GetMapping("/showFormForAdd")
    public String showFormFOrAdd(Model model)
    {
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
  @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model model)
  {
      Employee employee=employeeService.findById(theId);
      model.addAttribute("employee",employee);
      return "employee/employee-form";
  }

    @PostMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/employee/list";

    }

}
