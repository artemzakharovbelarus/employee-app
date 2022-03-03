package com.targsoft.employeeapp.domain;

import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.exception.InvalidDomainException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;

public class EmployeeCategory {

    private final Optional<EmployeeCategoryId> id;
    private final String name;

    public EmployeeCategory(final Optional<EmployeeCategoryId> id,
                            final String name) {
        this.id = id;
        this.name = name;

        validate();
    }

    public Optional<EmployeeCategoryId> getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EmployeeCategory that = (EmployeeCategory) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EmployeeCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    private void validate() {
        if (StringUtils.isBlank(name)) {
            throw new InvalidDomainException("EmployeeCategory name can't be null or empty in {0}", this);
        }
    }
}
