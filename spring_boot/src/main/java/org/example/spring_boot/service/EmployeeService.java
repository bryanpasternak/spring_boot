package org.example.spring_boot.service;
import jakarta.annotation.Resource;
import org.example.spring_boot.entity.Employee;
import org.example.spring_boot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> selectAll() {
        return employeeMapper.selectAll();  // 直接调用Mapper
    }


}
