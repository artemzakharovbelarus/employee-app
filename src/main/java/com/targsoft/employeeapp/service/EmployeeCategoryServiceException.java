package com.targsoft.employeeapp.service;

import java.text.MessageFormat;
import java.util.function.Supplier;

public class EmployeeCategoryServiceException extends RuntimeException {

    public EmployeeCategoryServiceException(final String templateMessage, final Object... params) {
        super(MessageFormat.format(templateMessage, params));
    }

    public static Supplier<EmployeeCategoryServiceException> supplier(final String templateMessage, final Object... params) {
        return () -> new EmployeeCategoryServiceException(templateMessage, params);
    }
}
