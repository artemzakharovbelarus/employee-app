package com.targsoft.employeeapp.service.util.converter;

public interface EntityTwoWayConverter<E, D> extends EntityConverter<E, D> {

    D convertBack(E entity);
}
