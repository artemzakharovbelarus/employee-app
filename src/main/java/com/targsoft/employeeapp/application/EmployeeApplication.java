package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.application.util.converter.EmployeeDomainConverter;
import com.targsoft.employeeapp.controller.dto.EmployeeDto;
import com.targsoft.employeeapp.controller.view.EmployeeView;
import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;
import com.targsoft.employeeapp.service.employee.EmployeeService;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeApplication {

    private final EmployeeService employeeService;
    private final EmployeeCategoryService employeeCategoryService;
    private final EmployeeDomainConverter employeeDomainConverter;

    public EmployeeApplication(final EmployeeService employeeService,
                               final EmployeeCategoryService employeeCategoryService,
                               final EmployeeDomainConverter employeeDomainConverter) {
        this.employeeService = employeeService;
        this.employeeCategoryService = employeeCategoryService;
        this.employeeDomainConverter = employeeDomainConverter;
    }

    public void delete(final EmployeeId id) {
        employeeService.delete(id);
    }

    public EmployeeView save(final EmployeeDto employeeDto) {
        final Employee employeeForSave = employeeDomainConverter.convert(employeeDto);
        final Employee savedEmployee = employeeService.save(employeeForSave);

        return performFullEmployeeView(savedEmployee);
    }

    public EmployeeView update(final EmployeeDto employeeDto) {
        final Employee employeeForUpdate = employeeDomainConverter.convert(employeeDto);
        final Employee updatedEmployee = employeeService.update(employeeForUpdate);

        return performFullEmployeeView(updatedEmployee);
    }

    @Cacheable("employees-cache")
    public List<EmployeeView> findAll() {
        return employeeService.findAll()
                              .stream()
                              .map(this::performFullEmployeeView)
                              .collect(Collectors.toList());
    }

    public EmployeeView find(final EmployeeId id) {
        return performFullEmployeeView(employeeService.find(id));
    }

    private EmployeeView performFullEmployeeView(final Employee employee) {
        final EmployeeCategory category = employeeCategoryService.find(employee.getCategoryId());
        return employeeDomainConverter.convertToView(employee, category);
    }
}
