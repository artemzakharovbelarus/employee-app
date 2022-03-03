package com.targsoft.employeeapp.service.employee;

import java.text.MessageFormat;
import java.util.function.Supplier;

public class EmployeeServiceException extends RuntimeException {

    public EmployeeServiceException(final String templateMessage, final Object... params) {
        super(MessageFormat.format(templateMessage, params));
    }

    public static Supplier<EmployeeServiceException> supplier(final String templateMessage, final Object... params) {
        return () -> new EmployeeServiceException(templateMessage, params);
    }
}
