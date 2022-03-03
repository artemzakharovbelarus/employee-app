package com.targsoft.employeeapp.exception;

import java.text.MessageFormat;

public class InvalidDomainException extends RuntimeException {

    public InvalidDomainException(final String templateMessage, final Object... params) {
        super(MessageFormat.format(templateMessage, params));
    }
}
