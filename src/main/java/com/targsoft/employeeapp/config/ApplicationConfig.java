package com.targsoft.employeeapp.config;

import com.targsoft.employeeapp.application.EmployeeApplication;
import com.targsoft.employeeapp.application.EmployeeCategoryApplication;
import com.targsoft.employeeapp.application.util.converter.EmployeeCategoryDomainConverter;
import com.targsoft.employeeapp.application.util.converter.EmployeeDomainConverter;
import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.repository.EmployeeCategoryRepository;
import com.targsoft.employeeapp.repository.EmployeeRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;
import com.targsoft.employeeapp.service.category.EmployeeCategoryService;
import com.targsoft.employeeapp.service.employee.EmployeeService;
import com.targsoft.employeeapp.service.util.converter.EmployeeCategoryEntityConverter;
import com.targsoft.employeeapp.service.util.converter.EmployeeEntityConverter;
import com.targsoft.employeeapp.service.util.converter.EntityTwoWayConverter;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public EmployeeCategoryApplication employeeCategoryApplication(final EmployeeCategoryService employeeCategoryService,
                                                                   final EmployeeCategoryDomainConverter converter) {
        return new EmployeeCategoryApplication(employeeCategoryService, converter);
    }

    @Bean
    public EmployeeApplication employeeApplication(final EmployeeService employeeService,
                                                   final EmployeeCategoryService employeeCategoryService,
                                                   final EmployeeDomainConverter employeeDomainConverter) {
        return new EmployeeApplication(employeeService, employeeCategoryService, employeeDomainConverter);
    }

    @Bean
    public EmployeeCategoryService employeeCategoryService(final EmployeeCategoryRepository employeeCategoryRepository,
                                                           final EmployeeCategoryEntityConverter employeeCategoryEntityConverter) {
        return new EmployeeCategoryService(employeeCategoryRepository, employeeCategoryEntityConverter);
    }

    @Bean
    public EmployeeService employeeService(final EmployeeRepository employeeRepository,
                                           final EmployeeEntityConverter employeeEntityConverter) {
        return new EmployeeService(employeeRepository, employeeEntityConverter);
    }

    @Bean
    public EmployeeDomainConverter employeeDomainConverter(final EmployeeCategoryDomainConverter employeeCategoryDomainConverter) {
        return new EmployeeDomainConverter(employeeCategoryDomainConverter);
    }

    @Bean
    public EmployeeCategoryDomainConverter employeeCategoryDomainConverter() {
        return new EmployeeCategoryDomainConverter();
    }

    @Bean
    public EmployeeCategoryEntityConverter employeeEntityTwoWayConverter() {
        return new EmployeeCategoryEntityConverter();
    }

    @Bean
    public EmployeeEntityConverter employeeEntityConverter() {
        return new EmployeeEntityConverter();
    }
}
