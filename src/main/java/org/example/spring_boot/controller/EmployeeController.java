package org.example.spring_boot.controller;

import jakarta.annotation.Resource;
import org.example.spring_boot.common.Result;
import org.example.spring_boot.entity.Employee;
import org.example.spring_boot.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @GetMapping("/selectAll")
    public Result selectAll(){
        List<Employee> data = employeeService.selectAll();
        return Result.success(data);  // 用Result包装
    }

    @GetMapping("/selectByID/{id}")
    public Result selectByID(@PathVariable Integer id){
        Employee employee = employeeService.selectByID(id);
        return Result.success(employee);
    }


}
