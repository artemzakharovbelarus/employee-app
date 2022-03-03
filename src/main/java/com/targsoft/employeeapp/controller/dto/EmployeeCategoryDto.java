package com.targsoft.employeeapp.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EmployeeCategoryDto {

    private final Long id;
    private final String name;

    @JsonCreator
    public EmployeeCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EmployeeCategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
