package com.targsoft.employeeapp.service.util.converter;

import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;

import java.util.Optional;

public class EmployeeCategoryEntityConverter implements EntityTwoWayConverter<EmployeeCategoryEntity, EmployeeCategory> {

    @Override
    public EmployeeCategoryEntity convert(EmployeeCategory domain) {
        final Long id = domain.getId()
                              .map(EmployeeCategoryId::getValue)
                              .orElse(null);
        return new EmployeeCategoryEntity(id, domain.getName());
    }

    @Override
    public EmployeeCategory convertBack(EmployeeCategoryEntity entity) {
        final Optional<EmployeeCategoryId> id = Optional.of(new EmployeeCategoryId(entity.getId()));
        return new EmployeeCategory(id, entity.getName());
    }
}
