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
    public Result selectAll(Employee employee) {
        List<Employee> data = employeeService.selectAll(employee);
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
    public Result selectPage(Employee employee,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize){

        PageInfo<Employee> pageInfo = employeeService.selectPage(employee, pageNum, pageSize);
        return Result.success(pageInfo);
    }

    @PostMapping("/insert")
    public Result insertEmployee(@RequestBody Employee employee){
        // 建议判断一下插入是否成功
        boolean success = employeeService.insertEmployee(employee) > 0;
        if (success) {
            return Result.success(employee);  // 或者返回 "新增成功"
        } else {
            return Result.error("500", "新增失败");
        }
    }

    @PutMapping("/edit")
    public Result editEmployee(@RequestBody Employee employee){
        // 建议判断一下插入是否成功
        boolean success = employeeService.updateEmployee(employee) > 0;
        if (success) {
            return Result.success(employee);  // 或者返回 "新增成功"
        } else {
            return Result.error("500", "新增失败");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteEmployee(@PathVariable Integer id) {
        boolean success = employeeService.removeById(id);  // 一行搞定！
        return success ? Result.success("删除成功") : Result.error("500", "删除失败");
    }

}
