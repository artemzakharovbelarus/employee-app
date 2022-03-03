package com.targsoft.employeeapp.config;

import com.targsoft.employeeapp.application.EmployeeApplication;
import com.targsoft.employeeapp.repository.EmployeeCategoryRepository;
import com.targsoft.employeeapp.repository.EmployeeRepository;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;
import com.targsoft.employeeapp.service.employee.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public EmployeeApplication employeeApplication(final EmployeeService employeeService,
                                                   final EmployeeCategoryService employeeCategoryService) {
        return new EmployeeApplication(employeeService, employeeCategoryService);
    }

    @Bean
    public EmployeeCategoryService employeeCategoryService(final EmployeeCategoryRepository employeeCategoryRepository) {
        return new EmployeeCategoryService(employeeCategoryRepository);
    }

    @Bean
    public EmployeeService employeeService(final EmployeeRepository employeeRepository) {
        return new EmployeeService(employeeRepository);
    }
}
