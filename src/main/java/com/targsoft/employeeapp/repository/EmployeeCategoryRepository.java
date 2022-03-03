package com.targsoft.employeeapp.repository;

import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategoryEntity, Long> { }