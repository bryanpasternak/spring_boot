package org.example.spring_boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.spring_boot.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll(Employee employee);

    @Select("select * from employee where id = #{id}")
    Employee selectByID(Integer id);

    int insertEmployee(Employee employee);

    int updateEmployee(Employee employee);

    boolean deleteEmployee(Integer id);

    Employee selectByUsername(String username);
}
