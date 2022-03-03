package com.targsoft.employeeapp.domain;

import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.exception.InvalidDomainException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;

public class Employee {

    private final Optional<EmployeeId> id;
    private final String name;
    private final EmployeeCategoryId categoryId;

    public Employee(final Optional<EmployeeId> id,
                    final String name,
                    final EmployeeCategoryId categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;

        validate();
    }

    public Optional<EmployeeId> getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmployeeCategoryId getCategoryId() {
        return categoryId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(categoryId, employee.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }

    private void validate() {
        if (StringUtils.isBlank(name)) {
            throw new InvalidDomainException("Employee name can't be null or empty in {0}", this);
        }
        if (categoryId == null) {
            throw new InvalidDomainException("Employee categoryId can't be null in {0}", this);
        }
    }
}
