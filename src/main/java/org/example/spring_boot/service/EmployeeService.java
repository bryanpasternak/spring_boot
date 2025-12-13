package org.example.spring_boot.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.example.spring_boot.common.Result;
import org.example.spring_boot.entity.Employee;
import org.example.spring_boot.exception.CustomException;
import org.example.spring_boot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> selectAll(Employee employee) {
        return employeeMapper.selectAll(employee);  // 直接调用Mapper
    }

    public Employee selectByID(Integer id) {
        return employeeMapper.selectByID(id);
    }

    public PageInfo<Employee> selectPage(Employee employee, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Employee> list = employeeMapper.selectAll(employee);
        return  PageInfo.of(list);
    }

    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    public boolean removeById(Integer id) {
        return employeeMapper.deleteEmployee(id);
    }

    public Employee login(Employee employee) {
        String username = employee.getUsername();
        Employee dbemployee = employeeMapper.selectByUsername(username);
        if (dbemployee == null) {
            throw new CustomException("500", "账号不存在");
        }
        String password = employee.getPassword();
        if (!dbemployee.getPassword().equals(password)) {
            throw new CustomException("500","账号或密码错误");
        }
        return dbemployee;
    }

    public void register(Employee employee) {
        insertEmployee(employee);
    }
}
