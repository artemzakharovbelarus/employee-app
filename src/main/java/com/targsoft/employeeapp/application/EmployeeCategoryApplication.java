package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.application.util.converter.EmployeeCategoryDomainConverter;
import com.targsoft.employeeapp.controller.dto.EmployeeCategoryDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeCategoryApplication {

    private final EmployeeCategoryService employeeCategoryService;
    private final EmployeeCategoryDomainConverter employeeCategoryDomainConverter;

    public EmployeeCategoryApplication(final EmployeeCategoryService employeeCategoryService,
                                       final EmployeeCategoryDomainConverter employeeCategoryDomainConverter) {
        this.employeeCategoryService = employeeCategoryService;
        this.employeeCategoryDomainConverter = employeeCategoryDomainConverter;
    }

    public void delete(final EmployeeCategoryId id) {
        employeeCategoryService.delete(id);
    }

    public EmployeeCategoryView save(final EmployeeCategoryDto categoryDto) {
        final EmployeeCategory category = employeeCategoryDomainConverter.convert(categoryDto);
        return employeeCategoryDomainConverter.convertToView(employeeCategoryService.save(category));
    }

    public EmployeeCategoryView update(final EmployeeCategoryDto categoryDto) {
        final EmployeeCategory category = employeeCategoryDomainConverter.convert(categoryDto);
        return employeeCategoryDomainConverter.convertToView(employeeCategoryService.update(category));
    }

    public List<EmployeeCategoryView> findAll() {
        return employeeCategoryService.findAll()
                                      .stream()
                                      .map(employeeCategoryDomainConverter::convertToView)
                                      .collect(Collectors.toList());
    }

    public EmployeeCategoryView find(final EmployeeCategoryId id) {
        return employeeCategoryDomainConverter.convertToView(employeeCategoryService.find(id));
    }
}
