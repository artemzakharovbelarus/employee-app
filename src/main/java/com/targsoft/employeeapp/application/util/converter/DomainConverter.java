package com.targsoft.employeeapp.application.util.converter;

public interface DomainConverter<D, DTO, V> {

    D convert(DTO dto);
    V convertToView(D domain);
}
