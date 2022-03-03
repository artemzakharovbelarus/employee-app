package com.targsoft.employeeapp.service;

import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.repository.EmployeeCategoryRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeCategoryService {

    private final EmployeeCategoryRepository employeeCategoryRepository;

    public EmployeeCategoryService(final EmployeeCategoryRepository employeeCategoryRepository) {
        this.employeeCategoryRepository = employeeCategoryRepository;
    }

    public void delete(final EmployeeCategoryId id) {
        employeeCategoryRepository.deleteById(id.getValue());
    }

    public EmployeeCategory update(final EmployeeCategory category) {
        return processUpsert(category);
    }

    public EmployeeCategory save(final EmployeeCategory category) {
        return processUpsert(category);
    }

    public List<EmployeeCategory> findAll() {
        return employeeCategoryRepository.findAllEmployees()
                                         .stream()
                                         .map(this::constructEmployeeCategory)
                                         .collect(Collectors.toList());
    }

    public Optional<EmployeeCategory> find(final EmployeeCategoryId id) {
        return employeeCategoryRepository.findById(id.getValue())
                                         .map(this::constructEmployeeCategory);
    }

    private EmployeeCategory processUpsert(final EmployeeCategory category) {
        final EmployeeCategoryEntity savingEntity = constructEmployeeCategoryEntity(category);
        return constructEmployeeCategory(employeeCategoryRepository.save(savingEntity));
    }

    private EmployeeCategoryEntity constructEmployeeCategoryEntity(final EmployeeCategory domain) {
        final Long id = domain.getId()
                              .map(EmployeeCategoryId::getValue)
                              .orElse(null);
        return new EmployeeCategoryEntity(id, domain.getName());
    }

    private EmployeeCategory constructEmployeeCategory(final EmployeeCategoryEntity entity) {
        final Optional<EmployeeCategoryId> id = Optional.of(new EmployeeCategoryId(entity.getId()));
        return new EmployeeCategory(id, entity.getName());
    }
}
