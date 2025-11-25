package org.example.spring_boot.controller;

import jakarta.annotation.Resource;
import org.example.spring_boot.common.Result;
import org.example.spring_boot.entity.Employee;
import org.example.spring_boot.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/selectAll")
    public List<Employee> selectAll(){
        //List<Employee> Employee = new ;

        return employeeService.selectAll();
    }


}
