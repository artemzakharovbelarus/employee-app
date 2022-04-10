package com.targsoft.employeeapp.service.category;

import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.repository.EmployeeCategoryRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;
import com.targsoft.employeeapp.service.util.converter.EmployeeCategoryEntityConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCategoryService.class);

    private final EmployeeCategoryRepository employeeCategoryRepository;
    private final EmployeeCategoryEntityConverter employeeCategoryEntityConverter;

    public EmployeeCategoryService(final EmployeeCategoryRepository employeeCategoryRepository,
                                   final EmployeeCategoryEntityConverter employeeCategoryEntityConverter) {
        this.employeeCategoryRepository = employeeCategoryRepository;
        this.employeeCategoryEntityConverter = employeeCategoryEntityConverter;
    }

    public void delete(final EmployeeCategoryId id) {
        LOGGER.debug("Employee category delete started for id: {}", id);

        employeeCategoryRepository.deleteById(id.getValue());
    }

    public EmployeeCategory save(final EmployeeCategory category) {
        return processUpsert(category);
    }

    public EmployeeCategory update(final EmployeeCategory category) {
        LOGGER.debug("Employee category update started for id: {}", category.getId());

        return processUpsert(category);
    }

    public List<EmployeeCategory> findAll() {
        LOGGER.debug("Finding all employee categories started");

        final List<EmployeeCategory> categories = employeeCategoryRepository.findAll()
                                                                            .stream()
                                                                            .map(employeeCategoryEntityConverter::convertBack)
                                                                            .collect(Collectors.toList());

        LOGGER.trace("Found employee categories detailed printing: {}", categories);

        return categories;
    }

    public EmployeeCategory find(final EmployeeCategoryId id) {
        LOGGER.debug("Employee category finding started for id: {}", id);

        final EmployeeCategory category = employeeCategoryRepository.findById(id.getValue())
                                                                    .map(employeeCategoryEntityConverter::convertBack)
                                                                    .orElseThrow(EmployeeCategoryServiceException.supplier("Can't find Employee category with id: {0}", id));

        LOGGER.debug("Employee category was found, id: {}", category.getId());
        LOGGER.trace("Found employee category detailed printing: {}", category);

        return category;
    }

    private EmployeeCategory processUpsert(final EmployeeCategory category) {
        LOGGER.debug("Employee category upsert started for id: {}", category.getId());
        LOGGER.trace("Employee category parameter: {}", category);

        final EmployeeCategoryEntity categoryEntity = employeeCategoryEntityConverter.convert(category);
        final EmployeeCategoryEntity upsertedCategoryEntity = employeeCategoryRepository.save(categoryEntity);
        final EmployeeCategory upsertedCategory = employeeCategoryEntityConverter.convertBack(upsertedCategoryEntity);

        LOGGER.debug("Employee category upsert finished for id: {}", upsertedCategory.getId());
        LOGGER.trace("Upserted employee category detailed printing: {}", upsertedCategory);

        return upsertedCategory;
    }
}
