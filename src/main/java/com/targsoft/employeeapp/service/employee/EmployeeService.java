package com.targsoft.employeeapp.service.employee;

import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.repository.EmployeeRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeEntity;
import com.targsoft.employeeapp.service.util.converter.EmployeeEntityConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;
    private final EmployeeEntityConverter employeeEntityConverter;

    public EmployeeService(final EmployeeRepository employeeRepository,
                           final EmployeeEntityConverter employeeEntityConverter) {
        this.employeeRepository = employeeRepository;
        this.employeeEntityConverter = employeeEntityConverter;
    }

    public void delete(final EmployeeId id) {
        LOGGER.debug("Employee delete started for id: {}", id);

        employeeRepository.deleteById(id.getValue());
    }

    public Employee save(final Employee employee) {
        return processUpsert(employee);
    }

    public Employee update(final Employee employee) {
        LOGGER.debug("Employee update started for id: {}", employee.getId());

        return processUpsert(employee);
    }

    public List<Employee> findAll() {
        LOGGER.debug("Finding all employees started");

        final List<Employee> employees = employeeRepository.findAll()
                                                           .stream()
                                                           .map(employeeEntityConverter::convertBack)
                                                           .collect(Collectors.toList());

        LOGGER.trace("Found employees detailed printing: {}", employees);

        return employees;
    }

    public Employee find(final EmployeeId id) {
        LOGGER.debug("Employee finding started for id: {}", id);

        final Employee employee = employeeRepository.findById(id.getValue())
                                                    .map(employeeEntityConverter::convertBack)
                                                    .orElseThrow(EmployeeServiceException.supplier("Can't find Employee with id: {0}", id));

        LOGGER.debug("Employee found with id: {}", employee.getId());
        LOGGER.trace("Found employee detailed printing: {}", employee);

        return employee;
    }

    private Employee processUpsert(final Employee employee) {
        LOGGER.debug("Employee upsert started for id: {}", employee.getId());
        LOGGER.trace("Employee parameter: {}", employee);

        final EmployeeEntity employeeEntity = employeeEntityConverter.convert(employee);
        final EmployeeEntity upsertedEmployeeEntity = employeeRepository.save(employeeEntity);
        final Employee upsertedEmployee = employeeEntityConverter.convertBack(upsertedEmployeeEntity);

        LOGGER.debug("Employee upsert finished for id: {}", upsertedEmployee.getId());
        LOGGER.trace("Upserted employee detailed printing: {}", upsertedEmployee);

        return upsertedEmployee;
    }
}
