package com.targsoft.employeeapp.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee_categories")
public class EmployeeCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    protected EmployeeCategoryEntity() { }

    public EmployeeCategoryEntity(final Long id,
                                  final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
