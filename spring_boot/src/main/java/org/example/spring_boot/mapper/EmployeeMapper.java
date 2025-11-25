package org.example.spring_boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.spring_boot.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
}
