package com.targsoft.employeeapp.controller;

import com.targsoft.employeeapp.service.category.EmployeeCategoryServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseAppController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseAppController.class);

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleIllegalArgumentException(final IllegalArgumentException e) {
        LOGGER.debug("IllegalArgumentException was handled, message: {}", e.getMessage());
        LOGGER.trace("IllegalArgumentException was handled", e);
        return new ResponseEntity<>("Input parameters were invalid", HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({EmployeeCategoryServiceException.class})
    public ResponseEntity<String> handleEmployeeCategoryServiceException(final EmployeeCategoryServiceException e) {
        LOGGER.debug("EmployeeCategoryServiceException was handled, message: {}", e.getMessage());
        LOGGER.trace("EmployeeCategoryServiceException was handled", e);
        return new ResponseEntity<>("There is no employee category with such id", HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRuntimeException(final RuntimeException e) {
        LOGGER.debug("RuntimeException was handled, message: {}", e.getMessage());
        LOGGER.trace("RuntimeException was handled", e);
        return new ResponseEntity<>("Unexpected exception on server", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
