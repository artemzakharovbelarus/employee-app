package com.targsoft.employeeapp.service.category;

import com.targsoft.employeeapp.domain.EmployeeCategory;
import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.repository.EmployeeCategoryRepository;
import com.targsoft.employeeapp.repository.entity.EmployeeCategoryEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeCategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCategoryService.class);

    private final EmployeeCategoryRepository employeeCategoryRepository;

    public EmployeeCategoryService(final EmployeeCategoryRepository employeeCategoryRepository) {
        this.employeeCategoryRepository = employeeCategoryRepository;
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
                                                                            .map(this::constructEmployeeCategory)
                                                                            .collect(Collectors.toList());

        LOGGER.trace("Found employee categories detailed printing: {}", categories);

        return categories;
    }

    public EmployeeCategory find(final EmployeeCategoryId id) {
        LOGGER.debug("Employee category finding started for id: {}", id);

        final EmployeeCategory category = employeeCategoryRepository.findById(id.getValue())
                                                                    .map(this::constructEmployeeCategory)
                                                                    .orElseThrow(EmployeeCategoryServiceException.supplier("Can't find Employee category with id: {0}", id));

        LOGGER.debug("Employee category was found, id: {}", category.getId());
        LOGGER.trace("Found employee category detailed printing: {}", category);

        return category;
    }

    private EmployeeCategory processUpsert(final EmployeeCategory category) {
        LOGGER.debug("Employee category upsert started for id: {}", category.getId());
        LOGGER.trace("Employee category parameter: {}", category);

        final EmployeeCategoryEntity categoryEntity = constructEmployeeCategoryEntity(category);
        final EmployeeCategory upsertedCategory = constructEmployeeCategory(employeeCategoryRepository.save(categoryEntity));

        LOGGER.debug("Employee category upsert finished for id: {}", upsertedCategory.getId());
        LOGGER.trace("Upserted employee category detailed printing: {}", upsertedCategory);

        return upsertedCategory;
    }

    private EmployeeCategoryEntity constructEmployeeCategoryEntity(final EmployeeCategory domain) {
        final Long id = domain.getId()
                              .map(EmployeeCategoryId::getValue)
                              .orElse(null);
        return new EmployeeCategoryEntity(id, domain.getName());
    }

    private EmployeeCategory constructEmployeeCategory(final EmployeeCategoryEntity entity) {
        final Optional<EmployeeCategoryId> id = Optional.of(new EmployeeCategoryId(entity.getId()));
        return new EmployeeCategory(id, entity.getName());
    }
}
