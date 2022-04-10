package com.targsoft.employeeapp.application.util.converter;

import com.targsoft.employeeapp.controller.dto.EmployeeCategoryDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;

import java.util.Optional;

public class EmployeeCategoryDomainConverter implements DomainConverter<EmployeeCategory, EmployeeCategoryDto, EmployeeCategoryView> {

    @Override
    public EmployeeCategory convert(EmployeeCategoryDto categoryDto) {
        final Optional<EmployeeCategoryId> id = Optional.ofNullable(categoryDto.getId())
                                                        .map(EmployeeCategoryId::new);
        return new EmployeeCategory(id, categoryDto.getName());
    }

    @Override
    public EmployeeCategoryView convertToView(EmployeeCategory domain) {
        final Long id = domain.getId()
                              .map(EmployeeCategoryId::getValue)
                              .orElse(null);
        return new EmployeeCategoryView(id, domain.getName());
    }
}
