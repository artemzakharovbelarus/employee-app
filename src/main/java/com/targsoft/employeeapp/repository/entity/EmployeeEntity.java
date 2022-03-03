package com.targsoft.employeeapp.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_category_id", referencedColumnName = "id")
    private EmployeeCategoryEntity category;

    protected EmployeeEntity() { }

    public EmployeeEntity(final Long id,
                          final String name,
                          final EmployeeCategoryEntity category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EmployeeCategoryEntity getCategory() {
        return category;
    }
}
