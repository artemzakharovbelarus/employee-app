package com.targsoft.employeeapp.service.util.converter;

public interface EntityConverter<E, D> {

    E convert(D domain);
}
