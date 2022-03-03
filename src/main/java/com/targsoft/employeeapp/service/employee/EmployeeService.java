package com.targsoft.employeeapp.service.employee;

import com.targsoft.employeeapp.domain.Employee;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.repository.EmployeeRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeService(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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
                                                           .map(this::constructEmployee)
                                                           .collect(Collectors.toList());

        LOGGER.trace("Found employees detailed printing: {}", employees);

        return employees;
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

    private Employee processUpsert(final Employee employee) {
        LOGGER.debug("Employee upsert started for id: {}", employee.getId());
        LOGGER.trace("Employee parameter: {}", employee);

        final EmployeeEntity employeeEntity = constructEmployeeEntity(employee);
        final Employee upsertedEmployee = constructEmployee(employeeRepository.save(employeeEntity));

        LOGGER.debug("Employee upsert finished for id: {}", upsertedEmployee.getId());
        LOGGER.trace("Upserted employee detailed printing: {}", upsertedEmployee);

        return upsertedEmployee;
    }

    private EmployeeEntity constructEmployeeEntity(final Employee domain) {
        final Long id = domain.getId()
                              .map(EmployeeId::getValue)
                              .orElse(null);
        return new EmployeeEntity(id, domain.getName(), domain.getCategoryId().getValue());
    }

    private Employee constructEmployee(final EmployeeEntity entity) {
        final Optional<EmployeeId> id = Optional.of(new EmployeeId(entity.getId()));
        final EmployeeCategoryId categoryId = new EmployeeCategoryId(entity.getCategoryId());
        return new Employee(id, entity.getName(), categoryId);
    }
}
