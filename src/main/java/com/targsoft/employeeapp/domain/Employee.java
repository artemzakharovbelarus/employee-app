package com.targsoft.employeeapp.domain;

import com.targsoft.employeeapp.domain.vo.EmployeeId;

import java.util.Objects;
import java.util.Optional;

public class Employee {

    private final Optional<EmployeeId> id;
    private final String name;
    private final EmployeeCategory category;

    public Employee(final Optional<EmployeeId> id,
                    final String name,
                    final EmployeeCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Optional<EmployeeId> getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmployeeCategory getCategory() {
        return category;
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
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(category, employee.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
