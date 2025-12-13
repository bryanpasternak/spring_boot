package org.example.spring_boot.controller;

import jakarta.annotation.Resource;
import org.example.spring_boot.common.Result;
import org.example.spring_boot.entity.Employee;
import org.example.spring_boot.exception.CustomException;
import org.example.spring_boot.mapper.EmployeeMapper;
import org.example.spring_boot.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/hello")
    public Result hello() throws CustomException {
        throw new CustomException("400","禁止访问");
    }

    @GetMapping("/error")
    public Result error(){
        throw new CustomException("400","禁止访问");
    }

    @PostMapping("/loginPage")
    public Result login(@RequestBody Employee employee){

        Employee dbemployee = employeeService.login(employee);
        return Result.success(dbemployee);
    }

    @PostMapping("/registerPage")
    public Result register(@RequestBody Employee employee){
        employeeService.register(employee);
        return Result.success();
    }
}
