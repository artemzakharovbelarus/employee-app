package com.targsoft.employeeapp.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDto {

    private final Long id;
    private final String name;
    private final Long categoryId;

    @JsonCreator
    public EmployeeDto(final @JsonProperty("id") Long id,
                       final @JsonProperty("name") String name,
                       final @JsonProperty("category-id") Long categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
