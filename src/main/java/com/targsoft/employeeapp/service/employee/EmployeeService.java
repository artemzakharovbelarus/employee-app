package com.targsoft.employeeapp.service.employee;

import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.repository.EmployeeRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee find(final EmployeeId id) {
        LOGGER.debug("Employee finding started for id: {}", id);

        final Employee employee = employeeRepository.findById(id.getValue())
                                                    .map(this::constructEmployee)
                                                    .orElseThrow(EmployeeServiceException.supplier("Can't find Employee with id: {0}", id));

        LOGGER.debug("Employee found with id: {}", employee.getId());
        LOGGER.trace("Found employee detailed printing: {}", employee);

        return employee;
    }

    private Employee constructEmployee(final EmployeeEntity entity) {
        final Optional<EmployeeId> id = Optional.of(new EmployeeId(entity.getId()));
        final EmployeeCategoryId categoryId = new EmployeeCategoryId(entity.getCategoryId());
        return new Employee(id, entity.getName(), categoryId);
    }
}
