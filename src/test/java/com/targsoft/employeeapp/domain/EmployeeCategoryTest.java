package com.targsoft.employeeapp.domain;

import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.exception.InvalidDomainException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmployeeCategoryTest {

    @Test
    public void constructEmployeeCategory() {
        //given
        new EmployeeCategory(Optional.of(new EmployeeCategoryId(12L)), "Category");
        //then nothing
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeCategoryWithEmptyNameAndThrowInvalidDomainException() {
        //given
        new EmployeeCategory(Optional.of(new EmployeeCategoryId(12L)), "");
        //expected InvalidDomainException
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeCategoryWithNullNameAndThrowInvalidDomainException() {
        //given
        new EmployeeCategory(Optional.of(new EmployeeCategoryId(12L)), null);
        //expected InvalidDomainException
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeCategoryWithSpaceNameAndThrowInvalidDomainException() {
        //given
        new EmployeeCategory(Optional.of(new EmployeeCategoryId(12L)), "  ");
        //expected InvalidDomainException
    }

    @Test
    public void getIdReturnsSameValueAsPassedToConstructor() {
        //given
        final Optional<EmployeeCategoryId> expected = Optional.of(new EmployeeCategoryId(12L));
        final Optional<EmployeeCategoryId> actual = new EmployeeCategory(expected, "Cetagory").getId();
        //then
        assertEquals(expected, actual);
    }
}