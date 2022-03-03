package com.targsoft.employeeapp.repository;

import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCategoryRepository extends CrudRepository<EmployeeCategoryEntity, Long> {
    List<EmployeeCategoryEntity> findAllEmployees();
}