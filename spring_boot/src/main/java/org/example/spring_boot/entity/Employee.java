package org.example.spring_boot.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private Long id;

    private String name;
    private String email;
    private String department;
    private BigDecimal salary;  // 对应数据库的DECIMAL类型，精度计算更准确
    private LocalDate hireDate; // Java 8的日期类型，对应数据库的DATE

    // 空构造方法
    public Employee() {
    }

    // getter和setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
}
