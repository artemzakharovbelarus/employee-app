package com.targsoft.employeeapp.domain;

import com.targsoft.employeeapp.domain.vo.EmployeeCategoryId;
import com.targsoft.employeeapp.domain.vo.EmployeeId;
import com.targsoft.employeeapp.exception.InvalidDomainException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    @Test
    public void constructValidEmployee() {
        //given
        new Employee(Optional.of(new EmployeeId(12L)), "Artem", new EmployeeCategoryId(12L));
        //expected InvalidDomainException
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeWithEmptyNameAndThrowInvalidDomainException() {
        //given
        new Employee(Optional.of(new EmployeeId(12L)), "", new EmployeeCategoryId(12L));
        //expected InvalidDomainException
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeWithNullNameAndThrowInvalidDomainException() {
        //given
        new Employee(Optional.of(new EmployeeId(12L)), null, new EmployeeCategoryId(12L));
        //expected InvalidDomainException
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeWithSpaceNameAndThrowInvalidDomainException() {
        //given
        new Employee(Optional.of(new EmployeeId(12L)), "     ", new EmployeeCategoryId(12L));
        //expected InvalidDomainException
    }

    @Test(expected = InvalidDomainException.class)
    public void constructEmployeeWithNullCategoryIdAndThrowInvalidDomainException() {
        //given
        new Employee(Optional.of(new EmployeeId(12L)), "Artem", null);
        //expected InvalidDomainException
    }

    @Test
    public void getIdReturnsTheSameValueAsWasPassedToConstructor() {
        //given
        final Optional<EmployeeId> expected = Optional.of(new EmployeeId(12L));
        //when
        final Optional<EmployeeId> actual = new Employee(expected, "Artem", new EmployeeCategoryId(12L)).getId();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getNameReturnsTheSameValueAsWasPassedToConstructor() {
        //given
        final String expected = "Artem";
        //when
        final String actual = new Employee(Optional.of(new EmployeeId(12L)), expected, new EmployeeCategoryId(12L)).getName();
        //then
        assertEquals(expected, actual);
    }

    @Test
    public void getCategoryIdReturnsTheSameValueAsWasPassedToConstructor() {
        //given
        final EmployeeCategoryId expected = new EmployeeCategoryId(12L);
        //when
        final EmployeeCategoryId actual = new Employee(Optional.of(new EmployeeId(12L)), "Artem", expected).getCategoryId();
        //then
        assertEquals(expected, actual);
    }
}