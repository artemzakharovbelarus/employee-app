package com.targsoft.employeeapp.service.util.converter;

import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.repository.entity.EmployeeEntity;

import java.util.Optional;

public class EmployeeEntityConverter implements EntityTwoWayConverter<EmployeeEntity, Employee> {

    @Override
    public EmployeeEntity convert(Employee domain) {
        final Long id = domain.getId()
                              .map(EmployeeId::getValue)
                              .orElse(null);
        return new EmployeeEntity(id, domain.getName(), domain.getCategoryId().getValue());
    }

    @Override
    public Employee convertBack(EmployeeEntity entity) {
        final Optional<EmployeeId> id = Optional.of(new EmployeeId(entity.getId()));
        final EmployeeCategoryId categoryId = new EmployeeCategoryId(entity.getCategoryId());
        return new Employee(id, entity.getName(), categoryId);
    }
}
