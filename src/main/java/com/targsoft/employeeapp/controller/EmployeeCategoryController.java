package com.targsoft.employeeapp.controller;

import com.targsoft.employeeapp.application.EmployeeCategoryApplication;
import com.targsoft.employeeapp.controller.dto.EmployeeCategoryDto;
import com.targsoft.employeeapp.controller.view.EmployeeCategoryView;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/employee-category")
public class EmployeeCategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCategoryController.class);

    private final EmployeeCategoryApplication employeeCategoryApplication;

    public EmployeeCategoryController(final EmployeeCategoryApplication employeeCategoryApplication) {
        this.employeeCategoryApplication = employeeCategoryApplication;
    }

    @PostMapping("/save")
    public EmployeeCategoryView save(final @RequestBody EmployeeCategoryDto categoryDto) {
        LOGGER.debug("Calling save started");
        LOGGER.trace("EmployeeCategoryDto parameter: {}", categoryDto);

        final EmployeeCategoryView savedEmployeeView = employeeCategoryApplication.save(categoryDto);

        LOGGER.debug("Calling save successfully ended for employee category, id: {}", savedEmployeeView.getId());
        LOGGER.trace("Saved employee category view detailed printing: {}", savedEmployeeView);

        return savedEmployeeView;
    }

    @PutMapping("/update")
    public EmployeeCategoryView update(final @RequestBody EmployeeCategoryDto categoryDto) {
        LOGGER.debug("Calling update started for employee category with id: {}", categoryDto.getId());
        LOGGER.trace("EmployeeCategoryDto parameter: {}", categoryDto);

        final EmployeeCategoryView updatedEmployeeView = employeeCategoryApplication.update(categoryDto);

        LOGGER.debug("Calling updated successfully ended for employee category, id: {}", updatedEmployeeView.getId());
        LOGGER.trace("Updated employee category view detailed printing: {}", updatedEmployeeView);

        return updatedEmployeeView;
    }

    @GetMapping("/all")
    public List<EmployeeCategoryView> getAllEmployeeCategories() {
        LOGGER.debug("Calling getAllEmployeeCategories started");
        final List<EmployeeCategoryView> employeeCategoryViews = employeeCategoryApplication.findAll();
        LOGGER.trace("Employee category views detailed printing: {}", employeeCategoryViews);

        return employeeCategoryViews;
    }

    @GetMapping("/{id}")
    public EmployeeCategoryView getEmployeeCategory(final @PathVariable Long id) {
        LOGGER.debug("Calling getEmployeeCategory started for id: {}", id);

        final EmployeeCategoryView employeeCategoryView = employeeCategoryApplication.find(new EmployeeCategoryId(id));

        LOGGER.debug("Calling getEmployeeCategory successfully ended for id: {}", id);
        LOGGER.trace("Employee category view detailed printing: {}", employeeCategoryView);

        return employeeCategoryView;
    }
}
