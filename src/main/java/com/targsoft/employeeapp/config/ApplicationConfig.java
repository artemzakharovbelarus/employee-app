package com.targsoft.employeeapp.config;

import com.targsoft.employeeapp.application.EmployeeApplication;
import com.targsoft.employeeapp.application.EmployeeCategoryApplication;
import com.targsoft.employeeapp.repository.EmployeeCategoryRepository;
import com.targsoft.employeeapp.repository.EmployeeRepository;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;
import com.targsoft.employeeapp.service.employee.EmployeeService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.targsoft.employeeapp.repository")
@EntityScan("com.targsoft.employeeapp.repository.entity")
@EnableCaching
public class ApplicationConfig {

    @Bean
    public EmployeeCategoryApplication employeeCategoryApplication(final EmployeeCategoryService employeeCategoryService) {
        return new EmployeeCategoryApplication(employeeCategoryService);
    }

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
