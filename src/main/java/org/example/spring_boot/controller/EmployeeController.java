package org.example.spring_boot.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.spring_boot.common.Result;
import org.example.spring_boot.entity.Employee;
import org.example.spring_boot.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/selectOne")
    public Result selectOne(@RequestParam Integer id){
        Employee employee = employeeService.selectByID(id);
        return Result.success(employee);
    }

    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo<Employee> pageInfo = employeeService.selectPage(pageNum, pageSize);
        return Result.success(pageInfo);
    }


}
