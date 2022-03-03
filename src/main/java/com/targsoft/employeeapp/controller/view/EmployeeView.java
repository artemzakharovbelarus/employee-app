package com.targsoft.employeeapp.controller.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeView {

    private final Long id;
    private final String name;
    private final EmployeeCategoryView categoryView;

    public EmployeeView(final Long id,
                        final String name,
                        final EmployeeCategoryView categoryView) {
        this.id = id;
        this.name = name;
        this.categoryView = categoryView;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("category")
    public EmployeeCategoryView getCategoryView() {
        return categoryView;
    }

    @Override
    public String toString() {
        return "EmployeeView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryView=" + categoryView +
                '}';
    }
}
