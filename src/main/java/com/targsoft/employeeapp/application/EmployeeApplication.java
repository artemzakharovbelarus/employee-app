package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.service.employee.EmployeeService;

import java.util.List;

public class EmployeeApplication {

    private final EmployeeService employeeService;

    public EmployeeApplication(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    public Employee find(final EmployeeId id) {
        return employeeService.find(id);
    }
}
