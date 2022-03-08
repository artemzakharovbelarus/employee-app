package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.controller.dto.EmployeeDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.controller.view.EmployeeView;
import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;
import com.targsoft.employeeapp.service.employee.EmployeeService;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeApplication {

    private final EmployeeService employeeService;
    private final EmployeeCategoryService employeeCategoryService;

    public EmployeeApplication(final EmployeeService employeeService,
                               final EmployeeCategoryService employeeCategoryService) {
        this.employeeService = employeeService;
        this.employeeCategoryService = employeeCategoryService;
    }

    public void delete(final EmployeeId id) {
        employeeService.delete(id);
    }

    public EmployeeView save(final EmployeeDto employeeDto) {
        final Employee employeeForSave = constructEmployee(employeeDto);
        final Employee savedEmployee = employeeService.save(employeeForSave);

        return performFullEmployeeView(savedEmployee);
    }

    public EmployeeView update(final EmployeeDto employeeDto) {
        final Employee employeeForUpdate = constructEmployee(employeeDto);
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
        return constructEmployeeView(employee, category);
    }

    private Employee constructEmployee(final EmployeeDto dto) {
        final Optional<EmployeeId> id = Optional.ofNullable(dto.getId())
                                                .map(EmployeeId::new);
        return new Employee(id, dto.getName(), new EmployeeCategoryId(dto.getCategoryId()));
    }

    private EmployeeView constructEmployeeView(final Employee employee,
                                               final EmployeeCategory category) {
        final Long id = employee.getId()
                                .get()
                                .getValue();
        return new EmployeeView(id, employee.getName(), constructEmployeeCategoryView(category) );
    }

    private EmployeeCategoryView constructEmployeeCategoryView(final EmployeeCategory category) {
        final Long id = category.getId()
                                .get()
                                .getValue();
        return new EmployeeCategoryView(id, category.getName());
    }
}
