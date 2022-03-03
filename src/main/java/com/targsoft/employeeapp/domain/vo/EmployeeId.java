package com.targsoft.employeeapp.domain.vo;

import com.targsoft.employeeapp.exception.TypedIdException;

public class EmployeeId {

    private final Long id;

    public EmployeeId(final Long id) {
        this.id = id;

        validate();
    }

    public Long getValue() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeeId{" +
                "id=" + id +
                '}';
    }

    private void validate() {
        if (id == null) {
            throw new TypedIdException("Id can't be null in {0}", this);
        }
    }
}
