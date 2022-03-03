package com.targsoft.employeeapp.controller;

import com.targsoft.employeeapp.application.EmployeeApplication;
import com.targsoft.employeeapp.controller.dto.EmployeeDto;
import com.targsoft.employeeapp.controller.view.EmployeeView;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeApplication employeeApplication;

    public EmployeeController(final EmployeeApplication employeeApplication) {
        this.employeeApplication = employeeApplication;
    }

    @PostMapping("/save")
    public EmployeeView save(final @RequestBody EmployeeDto employeeDto) {
        LOGGER.debug("Calling save started");
        LOGGER.trace("EmployeeDto parameter: {}", employeeDto);

        final EmployeeView savedEmployeeView = employeeApplication.save(employeeDto);

        LOGGER.debug("Calling save successfully ended for employee, id: {}", savedEmployeeView.getId());
        LOGGER.trace("Saved employee view detailed printing: {}", savedEmployeeView);

        return savedEmployeeView;
    }

    @PutMapping("/update")
    public EmployeeView update(final @RequestBody EmployeeDto employeeDto) {
        LOGGER.debug("Calling update started for employee with id: {}", employeeDto.getId());
        LOGGER.trace("EmployeeDto parameter: {}", employeeDto);

        final EmployeeView updatedEmployeeView = employeeApplication.update(employeeDto);

        LOGGER.debug("Calling update successfully ended for employee with id: {}", updatedEmployeeView.getId());
        LOGGER.trace("Updated employee view detailed printing: {}", updatedEmployeeView);

        return updatedEmployeeView;
    }

    @GetMapping("/all")
    public List<EmployeeView> getAllEmployees() {
        LOGGER.debug("Calling getAllEmployees started");
        final List<EmployeeView> employeeViews = employeeApplication.findAll();
        LOGGER.trace("Employee views detailed printing: {}", employeeViews);

        return employeeViews;
    }

    @GetMapping("/{id}")
    public EmployeeView getEmployee(final @PathVariable Long id) {
        LOGGER.debug("Calling getEmployee started for id: {}", id);

        final EmployeeView employeeView = employeeApplication.find(new EmployeeId(id));

        LOGGER.debug("Calling getEmployee successfully ended for id: {}", id);
        LOGGER.trace("Employee view detailed printing: {}", employeeView);

        return employeeView;
    }
}
