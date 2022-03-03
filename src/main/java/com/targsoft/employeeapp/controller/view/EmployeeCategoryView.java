package com.targsoft.employeeapp.controller.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeCategoryView {

    private final Long id;
    private final String name;

    public EmployeeCategoryView(final Long id,
                                final String name) {
        this.id = id;
        this.name = name;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EmployeeCategoryView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
