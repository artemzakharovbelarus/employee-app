package com.targsoft.employeeapp.application.util.converter;

import com.targsoft.employeeapp.controller.dto.EmployeeDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.controller.view.EmployeeView;
import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;

import java.util.Optional;

public class EmployeeDomainConverter {

    private EmployeeCategoryDomainConverter employeeCategoryDomainConverter;

    public EmployeeDomainConverter(EmployeeCategoryDomainConverter employeeCategoryDomainConverter) {
        this.employeeCategoryDomainConverter = employeeCategoryDomainConverter;
    }

    public Employee convert(EmployeeDto dto) {
        final Optional<EmployeeId> id = Optional.ofNullable(dto.getId())
                                                .map(EmployeeId::new);
        return new Employee(id, dto.getName(), new EmployeeCategoryId(dto.getCategoryId()));
    }

    public EmployeeView convertToView(Employee employee, EmployeeCategory category) {
        final Long id = employee.getId()
                                .map(EmployeeId::getValue)
                                .orElse(null);
        return new EmployeeView(id, employee.getName(), employeeCategoryDomainConverter.convertToView(category));
    }
}
