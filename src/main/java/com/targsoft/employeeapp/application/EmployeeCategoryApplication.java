package com.targsoft.employeeapp.application;

import com.targsoft.employeeapp.controller.dto.EmployeeCategoryDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeCategoryApplication {

    private final EmployeeCategoryService employeeCategoryService;

    public EmployeeCategoryApplication(final EmployeeCategoryService employeeCategoryService) {
        this.employeeCategoryService = employeeCategoryService;
    }

    public EmployeeCategoryView save(final EmployeeCategoryDto categoryDto) {
        final EmployeeCategory category = constructEmployeeCategory(categoryDto);
        return constructEmployeeCategoryView(employeeCategoryService.save(category));
    }

    public EmployeeCategoryView update(final EmployeeCategoryDto categoryDto) {
        final EmployeeCategory category = constructEmployeeCategory(categoryDto);
        return constructEmployeeCategoryView(employeeCategoryService.update(category));
    }

    public List<EmployeeCategoryView> findAll() {
        return employeeCategoryService.findAll()
                                      .stream()
                                      .map(this::constructEmployeeCategoryView)
                                      .collect(Collectors.toList());
    }

    public EmployeeCategoryView find(final EmployeeCategoryId id) {
        return constructEmployeeCategoryView(employeeCategoryService.find(id));
    }

    private EmployeeCategory constructEmployeeCategory(final EmployeeCategoryDto categoryDto) {
        final Optional<EmployeeCategoryId> id = Optional.ofNullable(categoryDto.getId())
                                                        .map(EmployeeCategoryId::new);
        return new EmployeeCategory(id, categoryDto.getName());
    }

    private EmployeeCategoryView constructEmployeeCategoryView(final EmployeeCategory domain) {
        final Long id = domain.getId().get().getValue();
        return new EmployeeCategoryView(id, domain.getName());
    }
}
